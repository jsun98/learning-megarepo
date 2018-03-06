
# Overfitting

## definitions
`underfit` or `high bias`: the model doesn't fit the data

`overfit` or `high variance`: when there are too many input features, the model may fit the training data really well, but fail to generalize new examples

## Addressing overfitting
1. reduce the number of features
    - manually select which ones to keep
    - model selecting algorithm
2. regularization
    - keep all features, but reduce the magnitude/weight $\theta_i$ of the features
    - works well with many features

# Regularization
We can modify our cost function $J(\theta)$ to $J(\theta) + 1000\times\theta_i$, so that when minimizing the cost function, $\theta_i$ will be small. 

Small values for parameters $\theta_i$ lead to 'simpler' hypothesis and is less prone to overfitting

## Regularized Linear Regression

new cost function (linear regression): 
$$
J(\theta_0, \theta_1) = \frac{1}{2m}\sum_{i=1}^m\lbrack(h_\theta(x^{(i)}) - y^{(i)})^2 + \lambda\sum_{i=1}^n\theta_j^2\rbrack
$$

if $\lambda$, the **regularization parameter** is very large, our hypothesis will become $h_\theta(x) = \theta_0$, a flat line, resulting in a case of underfitting

repeat until convergence (update simultaneously) {

  $\theta_0 := \theta_0 - \alpha\frac{1}{m}\sum_{i=1}^m(h_\theta(x^{(i)}) - y^{(i)})_0$
  
  $\theta_j := \theta_j - \alpha\lbrack\frac{1}{m}\sum_{i=1}^m(h_\theta(x^{(i)}) - y^{(i)}) * x^{(i)}_j + \frac{\lambda}{m}\theta_j\rbrack$, for j = 1, 2,...,n

}

## Regularized Logistic Regression
repeat until convergence (update simultaneously) {

  $\theta_0 := \theta_0 - \alpha\frac{1}{m}\sum_{i=1}^m(h_\theta(x^{(i)}) - y^{(i)})_0$
  
  $\theta_j := \theta_j - \alpha\lbrack\frac{1}{m}\sum_{i=1}^m(h_\theta(x^{(i)}) - y^{(i)}) * x^{(i)}_j + \frac{\lambda}{m}\theta_j\rbrack$, for j = 1, 2,...,n

}

note: even though the algorithm looks cosmetically the same as linear regression, our hypothesis has changed to the sigmoid function!
