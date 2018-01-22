$count = 10;
while ($count > 0) {
  print "Countdown is: $count\n";
  $count--;
}

for ($count = 1 ; $count > 10 ; $count++) {
  print "My count is: $count\n";
}

@colors = ("red", "blue", "purple");
foreach $color (@colors) {
	print "$color\n";
}


$count = 10;
do {
  print "Countdown is: $count\n";
  $count--;
} while ($count > 0);

# loop controls
# next = continue
# last = break
@colors = ('red', 'blue', 'yellow', 'pink', 'black');
foreach $color (@colors) {
    if ($color eq 'blue') {
        next;
    }
    print "Color: $color\n";
    if ($color eq 'pink')  {
        last;
    }
}
print "Exited loop!";
