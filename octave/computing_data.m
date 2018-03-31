A = [1 2; 3 4; 5 6]
B = [11 12; 13 14;15 16]

% element wise multiplication
A .* B

A .^ B

1 ./ A

V = [1; 2; 3]

1 ./ V

log(V)

exp(V)

abs(V)

-V % -1 * V

V + ones(length(V), 1) % same as V + 1

% transpose
A'

(A')'


a = [1 15 2 0.5]
val = max(a)
[val, ind] = max(a) % val and index

a < 3 % element wise comparison

find(a < 3)

A = magic(3)
rc = find(A >= 6) % indexes where elemetn >= 6

sum(A) % sum of elements in a
prod(A) % production of elements in a

floor(A)
ceil(A)

max(rand(3), rand(3)) % element wise max of elements in 2 matrices
max(A, [], 1) % column-wise maximum, 1 indicates dimension 1 (row)


max(A(:)) % shortcut to find the max element

