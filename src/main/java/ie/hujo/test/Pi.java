package ie.hujo.test;

import java.util.List;
import java.util.ArrayList;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;

public class Pi {
	// Config app
	static final String appName = "ie.hujo.test.Pi";
	static final int NUM_SAMPLES = 100000;

	public static List<Integer> makeRange(int begin, int end) {
		List<Integer> range = new ArrayList<Integer>();
		for (int i = begin; i <= end; i++ )
			range.add(i);
		return range;
	}

	public static void main(String[] args) {
		// Initial Spark
		SparkConf conf = new SparkConf().setAppName(appName);
		JavaSparkContext sc = new JavaSparkContext(conf);

		// Execute Job
		long count = sc.parallelize(makeRange(1, NUM_SAMPLES)).filter(
			new Function<Integer, Boolean>() {
				public Boolean call(Integer i) {
					double x = Math.random();
					double y = Math.random();
					return x*x + y*y < 1;
				}
			}).count();
		double pi = count / (double) NUM_SAMPLES;
		System.out.println("Pi is roughly " + 4 * pi);
	}
}
