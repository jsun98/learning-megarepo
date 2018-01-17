use warnings;

sub helloWorld {
	print "Hello, world\n";
}

print "call helloWorld(): ", helloWorld(), "\n";

sub average {
	$argCount = scalar (@_);
	@args = @_;
	$sum = 0;

	foreach $arg (@_) {
		$sum += $arg;
	}

	$avg = $sum / $argCount;
	print "args are: @args\n";
	print "average: $avg\n";
}

average(1,2,3,4,5);
	
# passing in array or hashes
# subroutine definition
sub is_value_exists_in_array {
    # first argument: string value to be searched in array
    $value = $_[0];
    # second argument: reference to array to be searched in
    $arrayref = $_[1];
    # create the array by dereferencing
    @my_array = @$arrayref;

    $result = "does not exist in";
    foreach $element (@my_array) {
        if ($element eq $value) {
            $result = "exists in";
            last;
        }
    }
    # print result
    print "Value $value $result array [ @my_array ]\n";
}

# subroutine call
@foo = ('we', 'are', 5, 'happy', 'perl', 'programmers');
$foo_arrayref = \@foo;
print "We are calling the subroutine is_value_exists_in_array() now\n";
is_value_exists_in_array('hello', $foo_arrayref);
print "We are calling the subroutine is_value_exists_in_array() again\n";
is_value_exists_in_array('happy', $foo_arrayref);
