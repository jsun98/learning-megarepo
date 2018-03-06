
# Gradient Descent
## Introduction
have some $J(\theta_0, \theta_1)$, want $min_{\theta_0, \theta_1}J(\theta_0, \theta_1)$
## Outline
1. start with some $\theta_0, \theta_1$
2. keep changing $\theta_0, \theta_1$ to reduce J
3. hopefully we find the minimum

<img src=img/2.1.png width=500px>


## Gradient Descent Algorithm
repeat until convergence {
    $\theta_j := \theta_j - \alpha\frac{\partial}{\partial\theta_j}J(\theta_0, \theta_1)$
}, where $\alpha$ is the rate of descent, if $\alpha$ is too small, the algorithm will be too slow, if $\alpha$ is too large, the algorithm may overshoort the minimum 

even with constant $\alpha$, gradient descent will converge to a **local minimum**. As it approaches the minimum, the derivative will decreases, thus the magnitude of the update will be smaller automatically.

**must update $\theta_0, \theta_1$ simultaneously**:

temp0 := $\theta_0 - \alpha\frac{\partial}{\partial\theta_j}J(\theta_0, \theta_1)$

temp1 := $\theta_1 - \alpha\frac{\partial}{\partial\theta_j}J(\theta_0, \theta_1)$

$\theta_0$ := temp0

$\theta_1$ := temp1

## Drawbacks of Gradient Descent
Gradient descent can converge to a local optima that is not necessaily the global optima, but fortunately, it turns out that for all cost functions $J(θ_0,θ_1)$, there is only 1 local minimum - a bow shaped function (technical term: a **convex function**).
