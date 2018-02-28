
// when using Avro data for input/output in MapReduce, a suitable wrapper must be used
// key: AvroKey<T>, value: AvroValue<T>
public class MapReduceColorCount extends Configured implements Tool {
  public int run(String[] args) throws Exception {
    Job job = new Job(getConf());
    job.setJarByClass(MapReduceColorCount.class);
    job.setJobName("Color Count");

    FileInputFormat.setInputPaths(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    job.setReducerClass(ColorCountReducer.class);
    job.setmapperclass(colorcountmapper.class);
    
    // this is required if input is Avro
    job.setInputFormatClass(AvroKeyInputFormat.class);
    // whenever a AvroValue<> or AvroKey<> is used,
    // always set the schema
    AvroJob.setInputKeySchema(job, InputKeySchema);
    AvroJob.setInputValueSchema(job, InputValueSchema);
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(IntWritable.class);

    // this is also required if output is Avro
    job.setOutputFormatClass(AvroKeyValueOutputFormat.class);
    // notice input keys schemas don't need to be set because the
    // input to the reducer are not Avro data
    // always set schema for keys/values in mapper and reducer
    AvroJob.setOutputKeySchema(job, Schema.create(Schema.Type.STRING));
    AvroJob.setOutputValueSchema(job, Schema.create(Schema.Type.INT));

    return (job.waitForCompletion(true) ? 0 : 1);
  }

  public static void main(String[] args) throws Exception {
    int res = ToolRunner.run(new MapReduceColorCount(), args);
    System.exit(res);
  }
}
