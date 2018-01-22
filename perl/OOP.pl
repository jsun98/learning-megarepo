use strict;
package Person;

sub new {
	my $class = shift;
	my $self = {
		firstName => shift,
		lastName => shift,
		age => shift,
	};
	print "first name is $self->{firstName}\n";
	print "last name is $self->{lastName}\n";
	print "age is $self->{age}\n";
	bless $self, $class;
	return $self;
}

my $object = new Person("josh", "sun", 19);
print %$object, "\n";


