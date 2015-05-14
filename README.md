=Java Spark Application=

This is an example of a Java Application for Apache Spark.

For compiling, use this gradle
`gradle jar`

You can execute this app using the following command:

`./spark-submit --master spark://sparkmaster.spark.local:7100 --class ie.hujo.test.Pi ./build/libs/spark-java-app-1.0.jar`
