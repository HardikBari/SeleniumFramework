package TestComponents.comp;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static org.testng.ITestResult.SKIP;

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private static final int maxTry = 1; // Will retry the test 2 more times (total 3 attempts)

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxTry) {
            count++;
            result.setStatus(SKIP);
            return true; // Retry the test
        }
        return false; // Don't retry
    }
}

