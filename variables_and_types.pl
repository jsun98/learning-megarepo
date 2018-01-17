use warnings;
# scalars 
$x = 5;
print "double quotes allows interpolation of x : $x\n";
print 'single quotes dont, x : $x\n', "\n";

# arrays
@myarray = (1, "swag", -36.477);
print "second element of array: $myarray[1]\n";
$secondElem = $myarray[1];
print "second element of array stored in scalar: $secondElem\n";
@myarray2 = (1..10);
print "print 2 from array2: $myarray2[1]\n";
print "size of array2: ", scalar @myarray2 , "\n";
print "index of last elem of array2: ", $#myarray2, "\n"; 

# array methods
@array3 = (1, "swag", 3);
# add to the end
push(@array3, "4");
# add to the beginning
unshift(@array3, "0");
# remove from back
pop(@array3);
# remove from beginning
shift(@array3);

# hashes
%hash1 = ('josh', 19, 'kevin', 3);
$val1 = $hash1{'josh'};
print "josh's age is: $val1 \n";
%hash2 = ('josh' => 19, 'kevin' => 3);
$val2 = $hash2{'josh'};
print "josh's age is: $val2 \n";

# hash methods
@hash1Keys = keys %hash1;
@hash1Vals = values %hash1;
print "hash1 vals: @hash1Vals\n";
print "hash1 keys: @hash1Keys\n";
print "size of hash1: ", scalar @hash1Keys, "\n";
# adding a pair:
$hash1{'swag'} = 99;
# deleting a pair:
delete $hash1{'josh'};
print keys %hash1, "\n";



