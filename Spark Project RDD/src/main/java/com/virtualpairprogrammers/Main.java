package com.virtualpairprogrammers;

import com.google.common.collect.Iterables;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "C:\\Users\\tar\\Documents\\dev\\tools\\hadoop-2.8.1");
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf conf = new SparkConf()
                .setAppName("Spark Local")
                .setMaster("local[*]");
        JavaSparkContext context = new JavaSparkContext(conf);

        JavaRDD<String> intitialRDD = context.textFile("src/main/resources/subtitles/input.txt");

        // Load input.txt to RDD
        // remove boring words
        // count remaining words
        // 10 most frequent
        intitialRDD
                .map(sentence -> sentence.replaceAll("[^a-zA-Z\\s]", "").toLowerCase())
                .filter(sentence -> sentence.trim().length() > 0)
                .flatMap(sentence -> Arrays.asList(sentence.split(" ")).iterator())
                .filter(word -> word.trim().length() > 0 && Util.isNotBoring(word))
                //.filter(Util::isNotBoring)
                .mapToPair(word -> new Tuple2<String, Long>(word, 1L))
                .reduceByKey(Long::sum)
                .filter(wordCountTuple -> wordCountTuple._2 > 10)
                .mapToPair(wordCountTuple -> new Tuple2<>(wordCountTuple._2, wordCountTuple._1))
                .sortByKey(false)
                .take(10)
                .forEach(value -> System.out.println(value)); // output those tuples
    }

    @SuppressWarnings("resource")
    public static void loadFromFile(String[] args) {
        System.setProperty("hadoop.home.dir", "C:\\Users\\tar\\Documents\\dev\\tools\\hadoop-2.8.1");
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf conf = new SparkConf()
                .setAppName("Spark Local")
                .setMaster("local[*]");
        JavaSparkContext context = new JavaSparkContext(conf);

        JavaRDD<String> intitialRDD = context.textFile("src/main/resources/subtitles/input.txt");

        intitialRDD
                .flatMap(value -> Arrays.asList(value.split(" ")).iterator())
                .collect()
                .forEach(System.out::println);
        context.close();
    }

    @SuppressWarnings("resource")
    public static void flatMapExa(String[] args) {
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf conf = new SparkConf()
                .setAppName("Spark Local")
                .setMaster("local[*]");
        JavaSparkContext context = new JavaSparkContext(conf);

        List<String> inputData = new ArrayList<>();
        inputData.add("WARN: Tuesday 4 September 0405");
        inputData.add("ERROR: Tuesday 4 September 0408");
        inputData.add("FATAL: Wednesday 5 September 1632");
        inputData.add("ERROR: Friday 7 September 1854");
        inputData.add("WARN: Saturday 8 September 1942");

        JavaRDD<String> words =  context.parallelize(inputData)
                .flatMap(value -> Arrays.asList(value.split(" ")).iterator());
        words.filter(word -> word.length() > 1)
                .collect()
                .forEach(System.out::println);
        context.close();
    }

    @SuppressWarnings("resource")
    public static void simpleCountExa(String[] args) {
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf conf = new SparkConf()
                .setAppName("Spark Local")
                .setMaster("local[*]");
        JavaSparkContext context = new JavaSparkContext(conf);

        List<String> inputData = new ArrayList<>();
        inputData.add("WARN: Tuesday 4 September 0405");
        inputData.add("ERROR: Tuesday 4 September 0408");
        inputData.add("FATAL: Wednesday 5 September 1632");
        inputData.add("ERROR: Friday 7 September 1854");
        inputData.add("WARN: Saturday 8 September 1942");

        context.parallelize(inputData)
                .mapToPair(rawValue -> new Tuple2<>(rawValue.split(":")[0], 1L))
                .reduceByKey(Long::sum)
                .foreach(tuple -> System.out.println(tuple._1 + " has " + tuple._2));

        // groupByKey
//        context.parallelize(inputData)
//                .mapToPair(rawValue -> new Tuple2<>(rawValue.split(":")[0], 1L))
//                .groupByKey()
//                .foreach(tuple -> System.out.println(tuple._1 + " has " + Iterables.size(tuple._2) + " instances"));
    }

    public static void simpleTuple(String[] args) {
        // reduce spark logs
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf conf = new SparkConf()
                .setAppName("Spark Local")
                .setMaster("local[*]");
        JavaSparkContext context = new JavaSparkContext(conf);

        List<Integer> input = Arrays.asList(34, 4, 22, 256);
        JavaRDD<Integer> inputRDD = context.parallelize(input);

        //JavaRDD<IntegerWithSqrt> sqrtRDD = inputRDD.map(IntegerWithSqrt::new);
        JavaRDD<Tuple2<Integer, Double>> sqrtRDD =
                inputRDD
                        .map(value -> new Tuple2<>(value, Math.sqrt(value)));

    }

    public static void simpleSparkStuff() {
        // reduce spark logs
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf conf = new SparkConf()
                .setAppName("Spark Local")
                .setMaster("local[*]");
        JavaSparkContext context = new JavaSparkContext(conf);

        List<Integer> input = Arrays.asList(34, 4, 22, 256);
        JavaRDD<Integer> inputRDD = context.parallelize(input);

        Integer sum = inputRDD.reduce(Integer::sum);
        JavaRDD<Double> sqrtRDD = inputRDD.map(Math::sqrt);

        sqrtRDD.collect().forEach(System.out::println);

        Long count = sqrtRDD
                .map(val -> 1L)
                .reduce(Long::sum);

        System.out.println(count); // or sqrtRDD.count()
        System.out.println(sum);

        context.close();
    }

}
