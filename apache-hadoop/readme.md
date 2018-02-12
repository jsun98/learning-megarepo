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

## Hadoop Distributed File System (HDFS)

Network File Systme (NFS): most ubiquitous, provides remote access to a single logical volume stored on a single machine. An NFS server makes a portion of its local file system visible to external clients. Downside: limited in storage space

HDFS is based on GFS (Google File System)

### Structure
A `cluster` is made up of a group of machines, each referred to as a `node`. The `NameNode` maintains metadata and mapping to of file blocks to their respective `DataNode`'s. A `DataNode` stores files in `blocks`.

A Cluster:

![](https://farm3.static.flickr.com/2050/3529146393_5c2e2c8065_o.png)

The default **block size** is 64MB, therefore HDFS expects large files. HDFS also expects files to be read **sequentially**, as supposed to random access in many NFS. 

> Because HDFS stores files as a set of large blocks across several machines, these files are **not part of the ordinary file system**. Typing ls on a machine running a DataNode daemon will display the contents of the ordinary Linux file system being used to host the Hadoop services -- but it will not include any of the files stored inside the HDFS. This is because HDFS runs in a separate **namespace**, isolated from the contents of your local files. The files inside HDFS (or more accurately: the blocks that make them up) are stored in a particular directory managed by the DataNode service, but the files will named only with block ids. You cannot interact with HDFS-stored files using ordinary Linux file modification tools (e.g., ls, cp, mv, etc). However, HDFS does come with its own utilities for file management, which act very similar to these familiar tools. A later section in this tutorial will introduce you to these commands and their operation.

### File Access
To open a file, a client contacts the `NameNode` and retrieves a list of locations for the blocks that comprise the file. These locations identify the DataNodes which hold each block.

### Fail Safe
> Of course, NameNode information must be preserved even if the NameNode machine fails; there are multiple redundant systems that allow the NameNode to preserve the file system's metadata even if the NameNode itself crashes irrecoverably. NameNode failure is more severe for the cluster than DataNode failure. While individual DataNodes may crash and the entire cluster will continue to operate, the loss of the NameNode will render the cluster inaccessible until it is manually restored. Fortunately, as the NameNode's involvement is relatively minimal, the odds of it failing are considerably lower than the odds of an arbitrary DataNode failing at any given point in time.

### Configuration
```xml
<configuration>
  <property>
    <name>fs.default.name</name>

    <value>hdfs://your.server.name.com:9000</value>
  </property>
  <property>
    <name>dfs.data.dir</name>

    <value>/home/username/hdfs/data</value>
  </property>
  <property>
    <name>dfs.name.dir</name>

    <value>/home/username/hdfs/name</value>
  </property>
</configuration>
```
Configurations are in a key value format. This information must be copied to all machines in the cluster under `conf/`.

`conf/hadoop-defaults.xml` is read-only, configurations should be over-written in `conf/hadoop-site.xml`

The three properties shown above are **required**.

`fs.default.name`: address of the `NameNode`, each `DataNode` must know this address.

`dfs.data.dir`: This is the path on the local file system in which the DataNode instance should store its data.

`dfs.name.dir`: This is the path on the local file system of the NameNode instance where the NameNode metadata is stored. It is only used by the NameNode instance to find its information, and does not exist on the DataNodes.

>Another configuration parameter, not listed above, is **dfs.replication**. This is the default replication factor for each block of data in the file system. For a production cluster, this should usually be left at its default value of 3. (You are free to increase your replication factor, though this may be unnecessary and use more space than is required. Fewer than three replicas impact the high availability of information, and possibly the reliability of its storage.)

### Interacting with HDFS


