
# General Machine Learning Techniques
[resource](http://www.statsoft.com/Textbook)

## Naive Bayesian Classification Algorithm
[source1](http://www.statsoft.com/textbook/naive-bayes-classifier)
[source2](http://software.ucv.ro/~cmihaescu/ro/teaching/AIR/docs/Lab4-NaiveBayes.pdf)

### Overview
The Naive Bayes Classifier technique is based on the so-called Bayesian theorem and is particularly suited when the dimensionality of the inputs is high. Despite its simplicity, Naive Bayes can often outperform more sophisticated classification methods.

*Naive Independence Assumption*: A Native Bayes algorithm assume that the presence of a particular feature in a class is **unrelated** to the presence of any other feature

$$
posterior = \frac{prior \times likelihood}{evidence}
$$

$$
P(C_k\vert x)=\frac{P(C_k)P(x\vert C_k)}{P(x)} 
$$
for k classifications, x $\in\ R^n$, for n input features



### Baye's Therorem
$$
P(A\vert B) = \frac{P(B\vert A)P(A)}{P(B)} 
$$

### Prior Probability
![](http://www.statsoft.com/textbook/graphics/NaiveBayesIntro1.gif)
$$
P(C_k) = \frac{}{}
$$

### Probability Model
$$
P(C_k | x) \\
= \frac{P(x | C_k)P(C_k)}{P(x)} \\
= \frac{P(x, C_k)}{P(x)} \\
= \frac{P(x_1 | x_2,...,x_n,C_k)P(x_2,...,x_n,C_k)}{P(x)} \\
= \frac{P(x_1 | x_2,...,x_n,C_k)P(x_2 | x_3,...,x_n,C_k)P(x_3,...,x_n,C_k)}{P(x)} \\
... \\
= \frac{P(C_k) \prod_1^i P(x_i | C_k)}{P(x)}
$$
