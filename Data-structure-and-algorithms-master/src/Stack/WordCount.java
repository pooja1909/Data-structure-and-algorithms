package Stack;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCount {

  public static class Map 
            extends Mapper<LongWritable, Text, Text, DoubleWritable>{

   // private final static IntWritable one = new IntWritable(1); // type of output key
    private DoubleWritable number; //type of output value

    //private Text word = new Text();   // type of output key
 private Text one = new Text();   // type of output key
      
      
    public void map(LongWritable key, Text value, Context context
                    ) throws IOException, InterruptedException {
        String str = value.toString(); // line to string token
        number = new DoubleWritable(Double.parseDouble(str));

         
         // set word as each input keyword
        context.write(one,number);     // create a pair <keyword, 1> 
        
      
    }
  }
  
  public static class Reduce
       extends Reducer<Text,DoubleWritable,Text,DoubleWritable> {

    private DoubleWritable result = new DoubleWritable();
    //private DoubleWritable result2 = new DoubleWritable();

    public void reduce(Text key, Iterable<DoubleWritable> values, 
                       Context context
                       ) throws IOException, InterruptedException {
      double sum = 0.0; // initialize the sum for each keyword
     double diff = 0.0; // initialize the sum for each keyword
      int count =0; // intialize the count for each keyword
      double max_number = Double.MIN_VALUE;
      double min_number = Double.MAX_VALUE;
      double difference = 0.0;
	  double square_difference = 0.0;
	  double variance = 0.0;
	  double standard_dev = 0.0;
	  double average = 0.0;
     ArrayList<DoubleWritable> cache = new ArrayList<DoubleWritable>();
          for (DoubleWritable val : values) {
            sum += val.get();
			
			
            max_number = Math.max(max_number,val.get());
            min_number = Math.min(min_number,val.get());
			
			             
            DoubleWritable writable = new DoubleWritable();
                writable.set(val.get());
                cache.add(writable);
            count ++;            
          }
          result.set(sum/count);//Average of the values
          context.write(new Text("AVERAGE"), result); // create a pair <keyword, number of occurence
		  average = (sum/count);
        result.set(max_number);//Average of the values
          context.write(new Text("MAX"), result); // create a pair <keyword, number of occurences>
        result.set(min_number);//Average of the values
          context.write(new Text("MIN"), result); // create a pair <keyword, number of occurences>
		
        
        //

		for (DoubleWritable val : values) {
		   diff = val.get() - sum/count;

		   square_difference += Math.pow(diff,2);
		   
		   }
                   variance = square_difference/count;
		   standard_dev = Math.sqrt(variance);
/* int size = cache.size();
 for (int i = 0; i < size; ++i) {
     //System.out.println("second iteration: " + cache.get(i));
    sum2+=i;
  } */

//

        
          result.set(standard_dev);//Average of the values
          context.write(new Text("new std devia"), result); // create a pair <keyword, number of occurences>        

        
/*
          max_number = Double.MIN_VALUE;
          for(DoubleWritable val : values){
              if(val.get() > max_number) {
                  max_number = val.get();                 
              }
           }      
          result.set(max_number);//Average of the values
          context.write(new Text("MAX"), result); // create a pair <keyword, number of occurences>
          min_number = Double.MAX_VALUE;
          for(DoubleWritable val : values){
              if(val.get() < min_number) {
                  min_number = val.get();                 
              }
          }  
          result.set(min_number);//Average of the values
          context.write(new Text("MIN"), result); // create a pair <keyword, number of occurences>

         for (DoubleWritable val : values) {
            sum += val.get();
            count ++;            
          }
         double mean = sum/count;
         for (DoubleWritable val : values) {
                squared_difference = Math.pow((mean - (val.get())),2);
            count ++;
         }
         result.set(Math.sqrt(squared_difference/count));
         context.write(new Text("Standard Deviation"), result); */
         
           
    }
  }

  // Driver program
  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration(); 
    String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs(); // get all args
    if (otherArgs.length != 2) {
      System.err.println("Usage: WordCount <in> <out>");
      System.exit(2);
    }

    // create a job with name "wordcount"
    Job job = new Job(conf, "wordcount");
    job.setJarByClass(WordCount.class);
    job.setMapperClass(Map.class);
    job.setReducerClass(Reduce.class);
   
    // Add a combiner here, not required to successfully run the wordcount program  

    // set output key type   
    job.setOutputKeyClass(Text.class);
    // set output value type
    job.setOutputValueClass(DoubleWritable.class);
    //set the HDFS path of the input data
    FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
    // set the HDFS path for the output
    FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

    //Wait till job completion
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
