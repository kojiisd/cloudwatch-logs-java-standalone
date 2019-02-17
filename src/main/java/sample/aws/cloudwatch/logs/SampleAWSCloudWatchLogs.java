package sample.aws.cloudwatch.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleAWSCloudWatchLogs {

    public static void main(String[] args) {
        SampleAWSCloudWatchLogs cloudwatchLogs = new SampleAWSCloudWatchLogs();
        cloudwatchLogs.doSomething("Hello");
    }

    public void doSomething(String message) {
        Logger logger = LoggerFactory.getLogger(SampleAWSCloudWatchLogs.class);
        logger.info("message -> " + message);
        try {
            Thread.sleep(20000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Finish execution.");

    }
}
