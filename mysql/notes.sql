-- These are my notes for beginning MySQL query language

-- create table
CREATE TABLE myTable (
	id INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY ( id ),
	title VARCHAR(100) NOT NULL,
	date DATE,
)

-- INSERT
INSERT INTO myTable ( field1, field2, ... , fieldN)
VALUES (val1, val2, ... , valN);

-- SELECT
SELECT ( field1, field2, ... , fieldN) from myTable
[WHERE][LIMIT][OFFSET]

-- UPDATE
UPDATE myTable 
SET field1 = newVal1, field2 = newVal2, ... , fieldN = newValN
[WHERE]

-- DELETE
DELETE from myTable 
[WHERE]

-- LIKE Clause
SELECT * FROM myTable
WHERE field1 LIKE '%sun' AND etc.

-- SORT
SELECT field1, field2,...fieldN table_name1, table_name2...
ORDER BY field1, [field2...] [ASC [DESC]]


