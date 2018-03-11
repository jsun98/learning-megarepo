
# Distributed System

## Topics
**Storage**: relational/Mongo, Cassandra, HDFS
**Computation**: Hadoop, Spark, Storm
**Synchronization**: NTP, vector clocks
**Concensus**: Paxos, Zookeeper

## What is a distributed system?
- a collection of machines that work together and appear to its users as one
- these machines fail independently
- the machines do not share a common global glock

## Read Replication
a master machine can replicate its data to child machines. When new data is added to the master machine, the change is propagated, but not all child machines will be consistent.

