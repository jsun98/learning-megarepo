#!/bin/bash

testfile='./tmp/chmodtest.txt'

echo 'creating tmp file in ./tmp'
touch $testfile

echo 'permission of chmodtest.txt:'
ls -l $testfile

echo "executing: chmod 000 $testfile"
chmod 000 $testfile
ls -l $testfile

# letter format
echo "executing: chmod u=rwx,g=rx,o=r  $testfile"
chmod u=rwx,g=rx,o=r  $testfile 
ls -l $testfile


echo "executing: chmod 000 $testfile"
chmod 000 $testfile
ls -l $testfile

# numeric format
# "0 - no permission"
# "1 - execute"
# "2 - write"
# "3 - read"
# "sum up these to get the permission you want"
# "ex. 5 = rw" 

echo "executing: chmod 754 $testfile"
chmod 754 $testfile
ls -l $testfile

echo "delete $testfile"
rm -f $testfile 
