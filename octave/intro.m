1 + 1 % 2

1 == 2 % equal

1 ~= 2 % not equal

1 && 2 % AND

1 || 2 % OR
 
1 + 2; % semi-colon supresses output

a = pi
a


disp(a) % print a's value
disp(sprintf('2 decimals: %0.6f', a));

% matrix
A = [1,2; 3,4; 5,6]

size(A); % 1 by 2 matrix with value m by n of matrix A
size(A,1); % size of dimention 1 (row) - 3
size(A,2); % size of dimention 2 (column) - 2
length(A) % size of the longest dimension

V = [1,2,3] % 1 by 3 row vector 

V2 = [1;2;3] % 3 by 1 vector

V3 = 1:0.1:2 % 1 by 11 row vector, starts at 1, increments by 0.1, ends at 2

ones(2,3) % 2 by 3 matrix of 1's

2 * ones(2,3) % 2 by 3 matrix of 2's

zeros(1,3) % 1 by 3 matrix of 0's

rand(3,3) % 3 by 3 matrix of rand nums from the normal distribution (0-1)

randn(1,3) % values from the gaussian distribution

w = -6 + sqrt(10) * (randn(1,10000));
hist(w)

eye(4) % 4 by 4 identity matrix

help eye % documentation for the eye function


