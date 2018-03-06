
# Multivariate Linear Regression

## Formulae
`hypothesis`: $h_\theta(x) = \theta_0x_0 + \theta_1x_1 + \theta_2x_2 + ... + \theta_nx_n$ for n training examples, where x is the input feature vector of dimension n, and $x_0$ = 1


$$
    x=
    \begin{bmatrix}
    x_0 \\
    x_1 \\
    ... \\
    x_n \\
    \end{bmatrix}
    \theta=
    \begin{bmatrix}
    \theta_0 \\
    \theta_1 \\
    ... \\
    \theta_n \\
    \end{bmatrix}
$$

$h_\theta(x) = \theta^Tx (matrix multiplication) = \theta_0x_0 + \theta_1x_1 + \theta_2x_2 + ... + \theta_nx_n$

## Gradient Descent for multiple variables
$J(\theta) = \frac{1}{2m}\sum_{i=1}^m(h_\theta(x^{(i)}) - y^{(i)})^2$

where $\theta$ is a n+1 dimensional vector and x is a n+1 dimensional vector with $x_0$ = 1

repeat (update $\theta_j$ for i=0,...,n simultaneously) {

$\theta_j := \theta_j - \alpha\frac{1}{m}\sum_{i=1}^m(h_\theta(x^{(i)}) - y^{(i)})x^{(i)}_j$
  
}

### Feature Scaling
make sure features ($x_i$) are on similar scales.

more specifically: **get every feature $x_i$ to be approximately -1 < $x_i$ < 1**

#### Mean Normalization
How to scale?

$x_i = \frac{feature - \mu_i}{max(feature) - min(feature)}$

where $\mu_i$ is the arithmatic mean of values of feature

## Learning Rate
Declare convergence if $J(\theta_i) - J(\theta_{i+1}) < \epsilon$, where $\epsilon$ is a very small number (ex. $10^{-3}$)

if $J(\theta)$ is increasing or decreasing then increase perioidically, use smaller $\alpha$

if $\alpha$ is sufficiently small, grandient descent can be slow to converge

