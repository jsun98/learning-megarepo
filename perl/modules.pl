use warnings;
use strict;

# will throw warning since myModule.pl
# is not found in the @INC array, which
# is a list of default paths that perl
# interpreter tries to find modules
use "swag.pl";

# we can modify the @INC array

sub Begin {
	push @INC, 'my/own/dir';
}

# this tells perl to look for a file called
# myModule2.pm in the @INC array
use myModule2;

# :: are converted into file directories,
# the following looks for /dir/myModule3.pm
use dir::myModule3;

print "this is the INC array: \n";
print @INC + "\n";

