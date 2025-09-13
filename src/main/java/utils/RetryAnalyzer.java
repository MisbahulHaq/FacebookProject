package utils;

import com.aventstack.extentreports.Status;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import base.BaseTest;

public class RetryAnalyzer extends BaseTest implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            test.log(Status.WARNING, "Retrying test: " + result.getName() + " | Attempt " + (retryCount + 1));
            return true;
        }
        return false;
    }
}
