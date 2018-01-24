# Distributed System - Hadoop, HDFS and Pig
[Link to Yahoo Developer Network page](https://developer.yahoo.com/hadoop/tutorial/module1.html#intro)

## Introduction 

### Problem Scope
Hadoop is built to process "web-scale" data on the order of hundreds of **gigabytes** to **terabytes** or petabytes.

### Problems at large scale
- partial or total failure in network
- failure recovery
- resource limitation
	- processor time
	- memory
	- hard drive space
	- network bandwidth
- synchronization

### The Hadoop Approach

#### Data distribution
In a Hadoop cluster, data is distributed to all the nodes of the cluster as it is being loaded in. The `Hadoop Distributed File System (HDFS)` will split large data files into chunks which are managed by different nodes in the cluster.

`record-oriented`: input data is split across nodes according to application logic

`moving computation to the data`: which data operated on by a node is chosen based on its locality to the node: most data is read from the local disk straight into the CPU, alleviating strain on network bandwidth and preventing unnecessary network transfers.

`MapReduce`: a programming model that Hadoop processes must conform to. This limits communication between nodes, thereby saving bandwidth.

![alt text](https://farm3.static.flickr.com/2344/3529959486_8f36fb28c5_o.png)

By restricting the communication between nodes, Hadoop makes the distributed system much more reliable.
