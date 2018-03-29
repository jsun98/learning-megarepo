// this typical run method contains nearly all 
// the setup for org.apache.hadoop.mapreduce.Job
// that I could possibly need
// NOTE: configs not marked 'optional' are usually required
public int run (String[] args) {
	Configuration conf = new Configuration();
	Job job = Job.getInstance(conf, this.getClass.getSimpleName);

	// optional, in this case name is already set in the job constructor
	job.setJobName("myjob");

	// This method sets the jar file in which each node will look for the Mapper and Reducer classes
	job.setJarByClass(MyJob.class);

	// set mapper and reducer classes
	job.setMapperClass(myMapper.class);
	job.setReducerClass(myReducer.class);
	
	// specify output classes, for BOTH mapper and reducer
	job.setOutputKeyClass(Text.class);
	job.setOutputValueClass(IntWritable.class);

	// optional, if mapper output is not the same as job's output
	// then this is required, set mapper output ONLY 
	job.setMapOutputKeyClass(someType.class); 
	job.setMapOutputValueClass(someType.class);

	// input and output paths
	job.setInputPath(new Path("in"));
	job.setOutputPath(new Path("out"));

	// optional, default output format is TextOutputFormat
	// and input format is TextInputFormat,
	// unless a different input/output format is required
	job.setOutputFormatClass(TextOutputFormat.class);
	job.setInputFormatClass(TextInputFormat.class);

	// set output file path for the mapreduce job
	FileOutputFormat.setOutputPath(job, outputPath);

	// Submit the job, then poll for progress until the job is complete
	job.waitForCompletion(true);
}
