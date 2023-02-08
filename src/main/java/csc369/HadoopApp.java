package csc369;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class HadoopApp {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "Hadoop example");
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

	if (otherArgs.length < 3) {
	    System.out.println("Expected parameters: <job class> <input dir> <output dir>");
	    System.exit(-1);
	} else if ("WordCount".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(WordCount.ReducerImpl.class);
	    job.setMapperClass(WordCount.MapperImpl.class);
	    job.setOutputKeyClass(WordCount.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(WordCount.OUTPUT_VALUE_CLASS);
	} else if ("AccessLog".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(AccessLog.ReducerImpl.class);
	    job.setMapperClass(AccessLog.MapperImpl.class);
	    job.setOutputKeyClass(AccessLog.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(AccessLog.OUTPUT_VALUE_CLASS);
        } 
	else if ("Task1a_PathCountAscending".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(Task1a_PathCountAscending.ReducerImpl.class);
		job.setMapperClass(Task1a_PathCountAscending.MapperImpl.class);
		job.setOutputKeyClass(Task1a_PathCountAscending.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(Task1a_PathCountAscending.OUTPUT_VALUE_CLASS);
		} 
	else if ("Task1b_PathCountAscending".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(Task1b_PathCountAscending.ReducerImpl.class);
		job.setMapperClass(Task1b_PathCountAscending.MapperImpl.class);
		job.setOutputKeyClass(Task1b_PathCountAscending.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(Task1b_PathCountAscending.OUTPUT_VALUE_CLASS);
		} 
	else if ("Task2a_HTTPCountAscending".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(Task2a_HTTPCountAscending.ReducerImpl.class);
		job.setMapperClass(Task2a_HTTPCountAscending.MapperImpl.class);
		job.setOutputKeyClass(Task2a_HTTPCountAscending.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(Task2a_HTTPCountAscending.OUTPUT_VALUE_CLASS);
		} 
	else if ("Task2b_HTTPCountAscending".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(Task2b_HTTPCountAscending.ReducerImpl.class);
		job.setMapperClass(Task2b_HTTPCountAscending.MapperImpl.class);
		job.setOutputKeyClass(Task2b_HTTPCountAscending.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(Task2b_HTTPCountAscending.OUTPUT_VALUE_CLASS);
		} 
	else if ("Task3_HostnameBytes".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(Task3_HostnameBytes.ReducerImpl.class);
		job.setMapperClass(Task3_HostnameBytes.MapperImpl.class);
		job.setOutputKeyClass(Task3_HostnameBytes.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(Task3_HostnameBytes.OUTPUT_VALUE_CLASS);
		} 
	else if ("Task4a_URLClientCount".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(Task4a_URLClientCount.ReducerImpl.class);
		job.setMapperClass(Task4a_URLClientCount.MapperImpl.class);
		job.setOutputKeyClass(Task4a_URLClientCount.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(Task4a_URLClientCount.OUTPUT_VALUE_CLASS);
		} 
	else if ("Task4b_URLClientCount".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(Task4b_URLClientCount.ReducerImpl.class);
		job.setMapperClass(Task4b_URLClientCount.MapperImpl.class);
		job.setOutputKeyClass(Task4b_URLClientCount.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(Task4b_URLClientCount.OUTPUT_VALUE_CLASS);
		} 
	else if ("Task5_MonthYearCount".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(Task5_MonthYearCount.ReducerImpl.class);
		job.setMapperClass(Task5_MonthYearCount.MapperImpl.class);
		job.setOutputKeyClass(Task5_MonthYearCount.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(Task5_MonthYearCount.OUTPUT_VALUE_CLASS);
		} 
	else if ("Task6a_DayBytesTotal".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(Task6a_DayBytesTotal.ReducerImpl.class);
		job.setMapperClass(Task6a_DayBytesTotal.MapperImpl.class);
		job.setOutputKeyClass(Task6a_DayBytesTotal.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(Task6a_DayBytesTotal.OUTPUT_VALUE_CLASS);
		} 
	else if ("Task6b_DayBytesTotal".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(Task6b_DayBytesTotal.ReducerImpl.class);
		job.setMapperClass(Task6b_DayBytesTotal.MapperImpl.class);
		job.setOutputKeyClass(Task6b_DayBytesTotal.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(Task6b_DayBytesTotal.OUTPUT_VALUE_CLASS);
		} 
	else if ("AccessLog2".equalsIgnoreCase(otherArgs[0])) {
	job.setReducerClass(AccessLog2.ReducerImpl.class);
	job.setMapperClass(AccessLog2.MapperImpl.class);
	job.setOutputKeyClass(AccessLog2.OUTPUT_KEY_CLASS);
	job.setOutputValueClass(AccessLog2.OUTPUT_VALUE_CLASS);
	} else {
	    System.out.println("Unrecognized job: " + otherArgs[0]);
	    System.exit(-1);
	}

        FileInputFormat.addInputPath(job, new Path(otherArgs[1]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[2]));

        System.exit(job.waitForCompletion(true) ? 0: 1);
    }

}
