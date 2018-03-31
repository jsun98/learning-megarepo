load featuresX.dat
load pricesY.dat

featuresX
pricesY

V = 3 * featuresX

save hello.mat V
save hello.txt V -ascii % save as text

clear

load hello.mat

V

A = [1 2; 3 4; 5 6];
A(3,2) % element at row 3 column 2
A(2,:) % all elements at row 2 (row vector)
A(:,2) % all elements at column 2 (vector)
A([1 3], :) % all elements in row 1, 3
A(:,2) = [10;11;12] % assign column 2 to be [10;11;12]

D = A
D = [D, [100;101;102]] % append another column vector to the right

A(:) % put all elements of A into a single vector


B = [10 11; 12 13; 14 15]
C = [A B] % concat B to the right of A
B = [A; B] % concat B under A

