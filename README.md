# cloudwatch-logs-java-standalone
This program is a standalone program with Java for sending logs to Amazon CloudWatch Logs with slf4j/logback.
For the purpose, it is using [cloudwatch-logback-appender](https://github.com/j256/cloudwatch-logback-appender)

# Preparation
Modify following contents for src/main/resources/logback.xml

1. accessKeyId
2. secretKey

If you are using environment variables for them, you can delete them.

```
    <appender name="CLOUDWATCH" class="com.j256.cloudwatchlogbackappender.CloudWatchAppender">
        <region>us-east-1</region>
        <accessKeyId>XXXXXXX</accessKeyId>
        <secretKey>XXXXXXX</secretKey>
        <logGroup>test-loggroup</logGroup>
        <logStream>test-logstream</logStream>
        <layout>
            <pattern>[%d{HH:mm:ss.SSS} [%thread] %-5level %logger{20} - %msg%n</pattern>
        </layout>
        <maxBatchSize>32</maxBatchSize>
    </appender>
```

# Notice
This program is a standalone program and cloudwatch log appending is done by thread, so this program needs to wait for finishing the thread otherwise after finishing thi program, the cloudwatch sending process is also stopped.
That is written as ```Thread.sleep``` in the sample code.

```
        try {
            Thread.sleep(20000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
```

When you use this program with any processing that not stopped immediately, you can delete above sleep coding.


