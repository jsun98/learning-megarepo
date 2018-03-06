
# Linear Regression
## Definitions
- Supervised learning: we know what the outcome is, the traing set consists of an input and an expected output (labelled dataset)
    - classification: output is discrete
    - regression: output is non-discrete
- Unsupervised learning: we don't know what the outcome is. Draw inference from unlabelled input training set.
   
## Formulae
Hypothesis: $h_\theta(x) = \theta_0 + \theta_1x$, where $\theta_0, \theta_1$ are input parameters

Cost function: $J(\theta_0, \theta_1) = \frac{1}{2m}\sum_{i=1}^m(h_\theta(x^{(i)}) - y^{(i)})^2$, for m training examples, the cost function is the sum of the squared difference of $h_\theta(x)$ and y

$min(J(\theta_0, \theta_1))$: find $\theta_0, \theta_1$ such that $J(\theta_0, \theta_1)$ is minimized, therefore $h_\theta(x) = \theta_0 + \theta_1x$ results in a better fit through the dataset

<img src=img/1.1.png width=500px>
<img src=img/1.2.png width=1000px>
Following along any concentric circle results in the same cost function but different parameters

## Gradient Descent for Linear Regression
repeat until convergence (update simultaneously) {

  $\theta_0 := \theta_0 - \alpha\frac{1}{m}\sum_{i=1}^m(h_\theta(x^{(i)}) - y^{(i)})$
  
  $\theta_1 := \theta_1 - \alpha\frac{1}{m}\sum_{i=1}^m(h_\theta(x^{(i)}) - y^{(i)}) * x^{(i)}$

}
