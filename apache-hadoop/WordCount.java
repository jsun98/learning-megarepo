import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// to use command line arguments more easily we can do:
// public class WordCount extends Configured implements Tool
public class WordCount {

  // Hadoop IO (Text, IntWritable etc) are used to replace Java primitives
  // mapper, input <Object, Text>, output <Text, IntWritable>
  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    // declare fields here so when map is called repeated, we don't have to 
    // create new memory everytime
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    // Context provides the write(T key, T val) api for emitted key-value pairs
    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        context.write(word, one);
      }
    }

    // specify 3 user-defined counters 
    private static enum COUNTERS {
	    COUNTERNAME1,
	    COUNTERNAME2,
	    COUNTERNAME3
    }

  }

  // reducer
  public static class IntSumReducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable val : values) {
        sum += val.get();
      }
      result.set(sum);
      context.write(key, result);
    }
  }

  // driver method
  public static void main(String[] args) throws Exception {
    // default configuration, we can also provide our own
    // additional configuration files via the cmd line
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    // which jar file to look for when running the mapper and reducer
    job.setJarByClass(WordCount.class);

    // mapper setup
    job.setMapperClass(TokenizerMapper.class);

    // [optional] combiner setup
    job.setCombinerClass(IntSumReducer.class);

    // reducer setup
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);

    // we could also specify multiple input path, each with its own mapper
    FileInputFormat.addInputPath(job, new Path(args[0]));
    // we could also specify multiple output path
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
