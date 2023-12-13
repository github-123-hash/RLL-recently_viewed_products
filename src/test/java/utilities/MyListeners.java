package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import stepDefintion.SharedSteps;

public class MyListeners implements ITestListener {

	ScreenshotUtilities screenshotUtil;
	ExtentReports extentReports;
	ExtentTest 	extentTest; 
	SharedSteps sharedSteps; 
	
//Listeners is defined as an interface. "listen" to the event defined in the selenium script behave accordingly.
//these interfaces are used in selenium to generate logs or customize the TestNG reports.
	

	public void onTestFailure(ITestResult result) {
	    try {
	    	extentTest.addScreenCaptureFromPath(screenshotUtil.takeScreenshot());
	    	System.out.println("Taking screenshot");
	    	extentTest.fail(result.getThrowable());
	    	extentTest.log(Status.FAIL, "This is a fail message");
//	        extentTest.log(Status.INFO, "This is an info message");
//	        extentTest.log(Status.WARNING, "This is a warning message");
//	        extentTest.log(Status.PASS, "This is an error message");
	    	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  }
	
	
	public void onStart(ITestContext context) {
		 screenshotUtil=new ScreenshotUtilities();
		 
		 System.out.println("TestNG Started");
		 //extent reports is an open-source reporting library useful for test automation.
		 //can be easily integrated with major testing frameworks like Junit,Nunit,TestNG etc.
		 //these reports are HTML documents that depict results as pie charts.
		 //Initialize :- start and ExtentHtmlReporter using AttachReporter
		 ExtentSparkReporter sparkreporter = new ExtentSparkReporter("report3.html");
		 extentReports = new ExtentReports();
			extentReports.attachReporter(sparkreporter);
			// ExtentSparkReporter spark = new ExtentSparkReporter("report3.html");
			//ExtentReports extent=new ExtentReports();
			//extent.attachReporter(spark);
			// on the report display more information about OS, browser, java etc
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
			extentReports.setSystemInfo("Host Name", System.getProperty("user.name"));
			extentReports.setSystemInfo("Browser", "Chrome");
			
			extentTest=	extentReports.createTest(context.getName());
			
				
		  }
	
	 
	  public  void onTestSuccess(ITestResult result) {
		  extentTest.log(Status.PASS, " Test Scenario is successfully pass");
	  }
	  
	public void onFinish(ITestContext context) {
		extentReports.flush();
		try {
			Desktop.getDesktop().browse(new File("report3.html").toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
