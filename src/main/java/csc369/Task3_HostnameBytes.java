package csc369;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class Task3_HostnameBytes {

    public static final Class OUTPUT_KEY_CLASS = Text.class;
    public static final Class OUTPUT_VALUE_CLASS = IntWritable.class;
    public static final String HOSTNAME_LOOKUP = "200.160.249.68.bmf.com.br"; //hardcoded Hostname



    public static class MapperImpl extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final IntWritable bytes = new IntWritable();


        @Override
	protected void map(LongWritable key, Text value,
			   Context context) throws IOException, InterruptedException {
	    String[] sa = value.toString().split(" ");
	    Text hostname = new Text();
        if(sa[0].equals(HOSTNAME_LOOKUP)){
            hostname.set(sa[0]);
            bytes.set(Integer.parseInt(sa[9]));
	        context.write(hostname, bytes);
            }
        }
    }

    public static class ReducerImpl extends Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable result = new IntWritable();
    
        @Override
	protected void reduce(Text hostname, Iterable<IntWritable> bytes,
	Context context) throws IOException, InterruptedException {
            int sum = 0;
            Iterator<IntWritable> itr = bytes.iterator();
        
            while (itr.hasNext()){

                sum  += itr.next().get();
            }
            result.set(sum);
            context.write(hostname, result);
       }
    }

}
