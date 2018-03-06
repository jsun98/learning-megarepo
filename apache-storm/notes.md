
# Apache Storm notes
[](https://github.com/apache/storm/tree/v1.1.1/examples/storm-starter)


[](http://storm.apache.org/releases/current/Tutorial.html)

## Components
- Topology: a graph of computation
    - each worker process executes a subset of a topology
- master node: runs a daemon called 'Nimbus'
- child node: runs a daemon called 'Supervisor'
- Zookeeper: coordinates Numbus and Supervisors
<img src='http://storm.apache.org/releases/current/images/storm-cluster.png' width=350px; />

## Topologies
A graph of computation. Consists of **Spouts** and **Bolts**. A topology runs forever.
Running a topology:
`storm jar all-my-code.jar org.apache.storm.MyTopology arg1 arg2`


### Streams
A stream is an unbounded sequence of tuples.

**Spout**: source of streams, emits a stream

**Bolt**: consume any number of input streams, process them, then (possibly) emit new streams

[](http://storm.apache.org/releases/current/images/topology.png)



## Data model
Storm uses **tuples** as its data model. A tuple is a named list of values, and a field in a tuple can be an object of any type. 

Every node in a topology must declare the output fields for the tuples it emits.

```java
    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("double", "triple"));
    }    
```

## Topology
```java
TopologyBuilder builder = new TopologyBuilder();        
builder.setSpout("words", new TestWordSpout(), 10);        
builder.setBolt("exclaim1", new ExclamationBolt(), 3)
        .shuffleGrouping("words");
builder.setBolt("exclaim2", new ExclamationBolt(), 2)
        .shuffleGrouping("exclaim1");
```

`TopologyBuilder.setSpout(String id, Object processingLogic, optional int parallelism)`
`TopologyBuilder.setBolt(String id, Object processingLogic, optional int parallelism)`

### Stream grouping
- `shuffle grouping`: evenly distributes the work of processing the tuples across all of the bolt's tasks
- `fields grouping`": groups a stream by a subset of its fields, tuples of equal values for that subset of fields always go to the same task
- ...

## Code example for Bolt
```java
// BaseRichBolt provides default implementation where appropriate
public static class ExclamationBolt extends BaseRichBolt {
    // OutputCollector is used for emitting tuples from this bolt
    OutputCollector _collector;

    @Override
    public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
        _collector = collector;
    }

    @Override
    public void execute(Tuple tuple) {
        // tuple: input tuple
        // emits 
        _collector.emit(tuple, new Values(tuple.getString(0) + "!!!"));
        
        // for Storm's reliability API
        _collector.ack(tuple);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // declare an output of 1-tuple named word
        declarer.declare(new Fields("word"));
    }    
}
```

## Spout
A spout generates data. It usually implements the `IRichSpout` interface, which contains the following methods:
- `open` − Provides the spout with an environment to execute. The executors will run this method to initialize the spout.
- `nextTuple` − Emits the generated data through the collector.
- `close` − This method is called when a spout is going to shutdown.
- `declareOutputFields` − Declares the output schema of the tuple.
- `ack` − Acknowledges that a specific tuple is processed
- `fail` − Specifies that a specific tuple is not processed and not to be reprocessed.

### Example
```java
public void nextTuple() {
    Utils.sleep(100);
    final String[] words = new String[] {"nathan", "mike", "jackson", "golda", "bertels"};
    final Random rand = new Random();
    final String word = words[rand.nextInt(words.length)];
    _collector.emit(new Values(word));
}
```
Emits a 1-tuple 'word' every 100 ms
