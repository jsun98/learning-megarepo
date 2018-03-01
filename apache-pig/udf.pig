-- Step 1: Register the jar file
REGISTER piggybank.jar

-- Step 2: define an alias
DEFINE MAXNUM org.apache.pig.piggybank.evaluation.math.MAX;

-- Step 3: do whatever you need
A = LOAD 'student_data' AS (name: chararray, gpa1: float, gpa2: double);
B = FOREACH A GENERATE name, MAXNUM(gpa1, gpa2);
DUMP B;
