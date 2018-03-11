# variables are declared when its name is used
age = 10;
print(age);

# multiple assginments: assigns a value to multiple variables
a = b = c = 100;
print(a);
print(b);
print(c);

d = e = f = 1, 2, "josh";

# Data types
# Number, String, List, Tuple, Dictionary
num = 1;
del num; # delete ref to a Number

string = "swag";
string2 = 'swag2';
print(string)
print(string[0]); # print complete string
print(string[1:3]); # print 2nd to 4th character (exclusive)
print(string[1:]); # print from 2nd to last character

# items in lists can be of different types
list1 = ['lmao', 2, 3, 9.22222, "haha"];
print(list1[0]);
print(list1[2:4]);
print(list1[3:]);
print(list1 * 2); # list repetition operator
print(list1 + list1); # list concatenation operator

# tuples are enclosed by parenthesises and cannot be updated
tuple1 = (1, 2, "joshu", 2.33);

# dict are like hashtables
dict1 = {"name": "josh", "age":19};
print(dict1["name"]);
print(dict1.keys());
print(dict1.values());

