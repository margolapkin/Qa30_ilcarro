package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    Logger logger = LoggerFactory.getLogger( TestNGListener.class);

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        logger.info("Start testing on date---> "+context.getStartDate());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info("Skipped test--->"+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("Success test--->"+result.getName());
        logger.info("Success test(method)--->"+result.getMethod());
    }
}
