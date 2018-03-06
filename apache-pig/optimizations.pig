-- 1. use types
-- slow
A = load 'myfile' as (t, u, v);
B = foreach A generate t + u;

-- fast
A = load 'myfile' as (t: int, u: int, v);
B = foreach A generate t + u;

-- 2. project early and often
-- slow
A = load 'myfile' as (t, u, v);
B = load 'myotherfile' as (x, y, z);
C = join A by t, B by x;
D = group C by u;
E = foreach D generate group, COUNT($1);

-- fast
A = load 'myfile' as (t, u, v);
A1 = foreach A generate t, u;
B = load 'myotherfile' as (x, y, z);
B1 = foreach B generate x;
C = join A1 by t, B1 by x;
C1 = foreach C generate t, u;
D = group C1 by u;
E = foreach D generate group, COUNT($1);

-- 3. filter early and often

-- slow 
A = load 'myfile' as (t, u, v);
B = load 'myotherfile' as (x, y, z);
C = join A by t, B by x;
D = group C by u;
E = foreach D generate group, COUNT($1);
F = filter E by C.t == 1;

-- fast 
A = load 'myfile' as (t, u, v);
B = load 'myotherfile' as (x, y, z);
C = filter A by t == 1;
D = join C by t, B by x;
E = group D by u;
F = foreach E generate group, COUNT($1);

-- 4. reduce operator pipeline
-- easier to read but slow
A = load 'data' as (in: map[]);
B = foreach A generate in#k1 as k1, in#k2 as k2;
C = foreach B generate CONCAT(k1, k2);

-- harder to read but fast
A = load 'data' as (in: map[]);
B = foreach A generate CONCAT(in#k1, in#k2); 

-- 5. Drop Nulls Before a Join
A = load 'myfile' as (t, u, v);
B = load 'myotherfile' as (x, y, z);
A1 = filter A by t is not null;
B1 = filter B by x is not null;
C = join A1 by t, B1 by x;

-- 6. Join optimizations
-- 6.1 specify number of reducers (though it is often better to let pig determine)
A = LOAD 'myfile' AS (t, u, v);
B = GROUP A BY t PARALLEL 18;

-- 6.2 use LIMIT
A = load 'myfile' as (t, u, v);
B = order A by t;
C = limit B 500;

-- 6.3 prefer distinct over GROUP BY/GENERATE
-- slow
A = load 'myfile' as (t, u, v);
B = foreach A generate u;
C = group B by u;
D = foreach C generate group as uniquekey;
dump D; 

-- fast 
A = load 'myfile' as (t, u, v);
B = foreach A generate u;
C = distinct B;
dump C; 

-- 6.4 compress results of intermediate jobs
SET pig.tmpfilecompression true;
SET pig.tmpfilecompression.codec LZO;

-- 6.5 combine small input files
SET pig.maxCombinedSplitSize 123;
SET pig.splitCombination 123;


