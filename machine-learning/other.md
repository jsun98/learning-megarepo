
# Machine learning notes

## Algorithms
`Linear Regression`:

`Logistic Regression`:

`Decision Tree`:

`Naive Bayes`:

`Random Forest`:

`Gradient Boosting algorithms`:

`Dimensionality Reduction Algorithms`: 

## Loss functions

|Loss|Function|Minimizer|Example usage|
|----|--------|---------|-------------|
|Squared|![squared loss function](http://i.imgur.com/LXWLynq.png "\ell(p,y)=\frac{1}{2}(p-y)^2")|Expectation (mean)|Regression<br>_Expected return on stock_|
|Quantile| <img src="http://i.imgur.com/naPtxt9.png" alt="\ell(p,y)=\tau(y-p)\mathbb{I}(y \ge p) +(1-\tau)(p-y)\mathbb{I}(y \leq p)" height="25"> |Median|Regression<br>_What is a typical price for a house?_|
|Logistic|![logistic loss function](http://i.imgur.com/E7WAZzw.png "\ell(p,y)=\log(1+\exp(-yp))")|Probability|Classification<br>_Probability of click on ad_|
|Hinge|![hinge loss function](http://i.imgur.com/Q7SU0Bu.png "\ell(p,y)=\max(0,1-yp)")|0-1 approximation|Classification<br>_Is the digit a 7?_|
|Poisson| |Counts [(Log Mean)](https://github.com/JohnLangford/vowpal_wabbit/blob/master/python/examples/poisson_regression.ipynb)|Regression<br>_Number of call events to call center_|
|Classic|Squared loss without<br> [importance weight aware updates](http://arxiv.org/abs/1011.1576)|Expectation (mean)|Regression<br>_squared loss often performs better than classic._|


## Stochastic gradient descent

## Model evaluation methods
### Residuals
The model is fit using all the data points and the prediction for each data point is compared with its actual output. The absolute value of each error is taken and the mean of those values is computed to arrive at the mean absolute residual error. Models with lower values of this measure are deemed to be better.

![](https://www.cs.cmu.edu/~schneide/tut5/img90.gif)
Approximating a one-dimensional data set with A90:9, L90:9, L10:9 metacodes. The residual error for each data point is the distance along a vertical line between it and the fitted line. The result is very large, large, and zero residual error, respectively.

drawback: it does not give an indication of how well the learner will do when it is asked to make new predictions for data it has not already seen.

### Cross Validation
Better than `residual`. Not all of the dataset is used, a subset is reserved to test the performance of the model after training.

The **holdout** method is the simplest kind of cross validation. The data set is separated into two sets, called the training set and the testing set. The function approximator fits a function using the training set only. Then the function approximator is asked to predict the output values for the data in the testing set (it has never seen these output values before). The errors it makes are accumulated as before to give the mean absolute test set error, which is used to evaluate the model. The advantage of this method is that it is usually preferable to the residual method and takes no longer to compute. However, its evaluation can have a high variance. The evaluation may depend heavily on which data points end up in the training set and which end up in the test set, and thus the evaluation may be significantly different depending on how the division is made.

**K-fold cross validation** is one way to improve over the holdout method. The data set is divided into k subsets, and the holdout method is repeated k times. Each time, one of the k subsets is used as the test set and the other k-1 subsets are put together to form a training set. Then the average error across all k trials is computed. The advantage of this method is that it matters less how the data gets divided. Every data point gets to be in a test set exactly once, and gets to be in a training set k-1 times. The variance of the resulting estimate is reduced as k is increased. The disadvantage of this method is that the training algorithm has to be rerun from scratch k times, which means it takes k times as much computation to make an evaluation. A variant of this method is to randomly divide the data into a test and training set k different times. The advantage of doing this is that you can independently choose how large each test set is and how many trials you average over.

**Leave-one-out cross validation** is K-fold cross validation taken to its logical extreme, with K equal to N, the number of data points in the set. That means that N separate times, the function approximator is trained on all the data except for one point and a prediction is made for that point. As before the average error is computed and used to evaluate the model. The evaluation given by leave-one-out cross validation error (LOO-XVE) is good, but at first pass it seems very expensive to compute. Fortunately, locally weighted learners can make LOO predictions just as easily as they make regular predictions. That means computing the LOO-XVE takes no more time than computing the residual error and it is a much better way to evaluate models. We will see shortly that Vizier relies heavily on LOO-XVE to choose its metacodes.

## Cluster Analysis 
[*A tutorial on Clustering Algorithms*](https://home.deib.polimi.it/matteucc/Clustering/tutorial_html/)

**Clustering** is the grouping of a particular set of objects based on their characteristics, aggregating them according to their similarities. An important problem in *unsupervised learning*, it deals with finding a structure in a collection of unlabeled data.

```
A cluster is therefore a collection of objects which are “similar” between them and are “dissimilar” to the objects belonging to other clusters.
```

Regarding emails, a clustering algorithm aims to recognize messages that deal with similar topic and aggregate them into one cluster, then identifying which clusters can be marked as spam.

## Clustering Algorithms
Clustering algorithms may be classified as listed below:
- Exclusive Clustering: a datum can only be in one cluster
- Overlapping Clustering: a datum may belong to two or more clusters with different degrees of membership
- Hierarchical Clustering: based on the union of 2 nearest clusters, beginning condition is that every datum is a cluster, after x iterations, we reach the final clusters wanted
- Probabilistic Clustering: based on probability distributions

4 Common Algorithms:
- K-means
- Fuzzy C-means
- Hierarchical clustering
- Mixture of Gaussians

## Locality Sensitive Hashing (LSH)
[](http://www.mit.edu/~andoni/LSH/)

## Other

### Dealing with noisy data
### Overfitting and Underfitting
`Overfitting`: Overfitting happens when a model learns the detail and noise in the training data to the extent that it negatively impacts the performance of the model on new data. This means that the noise or random fluctuations in the training data is picked up and learned as concepts by the model. The problem is that these concepts do not apply to new data and negatively impact the models ability to generalize.

`Underfitting`: Underfitting refers to a model that can neither model the training data nor generalize to new data.
### Online vs. Offline learning
**Offline**: systems which employ offline learning do not change their approximation of the target function when the initial training phase has been completed. Learn the whole dataset at once.

**Online**: a method of machine learning in which data becomes available in a sequential order and is used to update our best predictor for future data at each step.
