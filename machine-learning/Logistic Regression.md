
# Logistic Regression
A binary classification algorithm (output between 0 - 1), called a 'regression' because of historical reasons

## Hypothesis
$$
h_\theta(x) = g(\theta^Tx)
$$
$h_\theta(x) \space means $ probability that y = 1 given x, or $h_\theta(x) = P(y = 1 | \space x ; \theta)$

### Sigmoid function / Logistic function
$$
g(z) = \frac{1}{1 + e^{-z}}
$$

<img src='./img/3.1.png' width = 400px />


## Decision Boundaries
Suppose we have $h_\theta(x) = g(\theta^Tx)$, and we determine that if $h_\theta(x) \ge$ 0.5, then y = 1. Since z = $\theta^Tx$, this is equivalent to $\theta^Tx \ge 0$. So the decision boundary equation is $\theta_0 + \theta_1x_1 + ... + \theta_nx_n \ge 0$ or $\theta_1x_1 + ... + \theta_nx_n \ge -\theta_0$

## Cost function
$$
J(\theta) = \frac{1}{m}\sum_{i=1}^m Cost(h_\theta(x), y)
$$
$$
Cost(h_\theta(x), y) = 
\begin{cases} 
      -log(h_\theta(x)) & if \space y = 1 \\
      -log(1 - h_\theta(x)) & if \space y = 0 \\
   \end{cases}
\
$$
More concisely: 
$$
Cost(h_\theta(x), y) = -y \times log(h_\theta(x)) - (1 - y) \times log(1 - h_\theta(x))
$$
Therefore:
$$
J(\theta) = -\frac{1}{m}\sum_{i=1}^m y \times log(h_\theta(x)) + (1 - y) \times log(1 - h_\theta(x))
$$

If our correct answer 'y' is 0, then the cost function will be 0 if our hypothesis function also outputs 0. If our hypothesis approaches 1, then the cost function will approach infinity.

If our correct answer 'y' is 1, then the cost function will be 0 if our hypothesis function outputs 1. If our hypothesis approaches 0, then the cost function will approach infinity.

<img src='./img/3.2.png' />
<img src='./img/3.3.png' />

## Gradient Descent for Logistic Regression
Goal: min($J(\theta)$)

algorithm:

repeat (simultaneous update) {

$\theta_j := \theta_j - \alpha\frac{\partial}{\partial\theta_j}\sum_{i=1}^m(h_\theta(x^{(i)}) - y^{(i)}) \times x_j^{(i)}$

}
