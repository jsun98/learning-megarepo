
# Linear Algebra Review

## Matrix Vector Multiplication
An **m x n** matrix multiplied by an **n x 1** vector results in an m x 1 vector.
$$
    \begin{bmatrix}
    a & b \\
    c & d \\
    e & f \\
    \end{bmatrix}
     * 
    \begin{bmatrix}
    x \\
    y \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    a*x + b*y \\
    c*x + d*y \\
    e*x + f*y \\
    \end{bmatrix}
$$

## Matrix Matrix Multiplication
An m x n matrix multiplied by an n x o matrix results in an m x o matrix.

We multiply two matrices by breaking it into several vector multiplications and concatenating the result.

<div>
A =

   1   2
   3   4
   5   6

B =

   1   2
   2   3

mult_AB =

    5    8
   11   18
   17   28
</div>

$$
    \begin{bmatrix}
    a & b\\
    c & d \\
    e & f \\
    \end{bmatrix}
     * 
    \begin{bmatrix}
    x \\
    y \\
    \end{bmatrix}
    =
    \begin{bmatrix}
    a*x + b*y \\
    c*x + d*y \\
    e*x + f*y \\
    \end{bmatrix}
$$

## Matrix Multiplication Properties and Definitions
1. $A \times B \neq B \times A$ (not commutative)
2. $(A \times B) \times C = A \times (B \times C)$ (associative)
3. the **identity matrix** is a matrix with 1's on its diagonal and 0's everywhere else, when multiplied by a matrix of the same dimension, the result is the original matrix
4. The **inverse** of a matrix A is denoted $A^{-1}$. Multiplying by the inverse results in the identity matrix. A non square matrix does not have an inverse matrix.
5. The **transposition** of a matrix is like rotating the matrix 90° in clockwise direction and then reversing it. $A_{ij} = A_{ji}^T$
