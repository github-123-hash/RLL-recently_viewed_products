package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//path of feature file
		features = "D:\\DemoWebShop-Group-3-RLL\\DemoWebShop-Group-3-RLL\\src\\test\\resources\\DemoWebShop_Recently_Viewed_Products.feature",
		//path of step-definition file
		glue = {"stepDefintion"},
		//used to compile the step-definition and feature files
		dryRun = false,
		//to produce reports that contain info what scenarios have passed or failed.
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				  "html:target/TestreportToday.html",
				  "rerun:target/failed.txt"}, 
		monochrome = true )//to display console output in color format or not or will make console o/p for cucumber test much more readable.
public class DemoWebShopRunner extends AbstractTestNGCucumberTests {

}
