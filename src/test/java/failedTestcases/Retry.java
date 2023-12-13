package failedTestcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int count = 0;
    private static int maxTry = 3;
    //IRetryAnalyzer in TestNG is an interface that can retry the failed test.
    //IRetryAnalyzers retry() method returns true if we need to retry and re-execute our tests; otherwise, it returns false.
    
    //There are two ways to retry tests using TestNG:
   //Using the retryAnalyzer attribute in the @Test annotation
   //Using Retry class with IAnnotationTransformer interface
   
    
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
            if (count < maxTry) {                            //Check if max try count is reached
                count++;                                     //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
                return true;                                 //Tells TestNG to re-run the test
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
}
