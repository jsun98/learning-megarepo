use warnings;
$price = 500;
$price_scalarref = \$price;
@names = ('hello', 'world');
$names_arrayref = \@names;
%bank_accounts = ('John Boy' => 1345.56, 'Mary Sue' => 12023.11);
$bank_hashref = \%bank_accounts;

$price = 500;
$price_scalarref = \$price;
print "Price is $$price_scalarref\n";

@names = ('hello', 'world');
$names_arrayref = \@names;
print "The names list is @$names_arrayref\n";

%bank_accounts = ('John Boy' => 1345.56, 'Mary Sue' => 12023.11);
$bank_hashref = \%bank_accounts;

# create a new hash from the reference value
%my_new_bank_account = %$bank_hashref;
print "The balance for John Boy is $my_new_bank_account{'John Boy'}\n";


