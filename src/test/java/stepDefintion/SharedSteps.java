package stepDefintion;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SharedSteps {

	public static WebDriver driver;//this variable is declared in a class(DriverInit)and initialized in @Before class of various test classes
	//the driver will be used across the project in various reusable functions and @test methods	

	public static WebDriver getDriver() {
		return driver;
	}

	//TestNG Annotations used to control the next method to be executed in the test script.
	@Before//this will be executed before every @test annotated method.
	public void Setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	//@After
	public  void TearDown() {
		//
		driver.close();
	}
}
