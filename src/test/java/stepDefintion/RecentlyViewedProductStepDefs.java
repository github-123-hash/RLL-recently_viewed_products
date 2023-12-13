package stepDefintion;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.BooksPage;
import pagefactory.HomePage;
import pagefactory.RecentlyViewdPage;
import utilities.ReadDataProperties;

public class RecentlyViewedProductStepDefs {
	
	WebDriver driver;
	SharedSteps sharedSteps;
	BooksPage booksPage;
	HomePage homePage; 
	RecentlyViewdPage recentlyViewdPage; 
	ReadDataProperties readDataProperties;
	
	private static final Logger logger =LogManager.getLogger();//used to obtain a logger instance for logging purposes.
	//This enables you to capture and manage log messages from selenium tests or scripts.
	
	// it is a open source.with Log4j,it is possible to store the flow details of our selenium automation in a file or databases.
	public RecentlyViewedProductStepDefs (SharedSteps sharedSteps) {
		this.sharedSteps = sharedSteps;
	}
	//pico-container dependency injection container used to manage and resolve dependencies in applications.
	
	
	@Given("User navigate to URL")
	public void user_navigate_to_url() throws IOException {
		logger.info("Inside User navigate to URL steps");
		//All,DEBUG,INFO,WARN,ERROR,FATAL,OFF
		//INFO:-print informational message that highlights the progress of the application.
		driver=sharedSteps.driver;
	   homePage=new HomePage(driver); 
	    booksPage=new BooksPage(driver);
	    readDataProperties=new ReadDataProperties();
	    String url=readDataProperties.getData("web.url");
	    driver.get(url);
	    String actual_url=driver.getCurrentUrl();
	    Assert.assertEquals(actual_url, url);
	}

	@Then("User click on Books link")
	public void user_click_on_books_link() {
		logger.info("Inside User click on Books link steps");
		boolean result=homePage.isElementDisplayed(homePage.Book_Btn);
		assertTrue(result);
		homePage.click_on_Book_Btn();
		
	}

	@When("Usen click on a Book")
	public void usen_click_on_a_book() {
		logger.info("Inside Usen click on a Book steps");
		boolean result=booksPage.isElementDisplayed(booksPage.book_link);
		assertTrue(result);
		booksPage.click_on_book_link();
	}

	

	@Then("User go to home page")
	public void user_go_to_home_page() {
		logger.info("Inside User go to home page steps");
		boolean result=booksPage.isElementDisplayed(booksPage.home_link);
		assertTrue(result);
	   booksPage.click_on_home_link();
	}

	@When("User click on a featured product")
	public void user_click_on_a_featured_product() {
		logger.info("Inside User click on a featured product steps");
		boolean result=homePage.isElementDisplayed(homePage.laptop_link);
		assertTrue(result);
		homePage.click_on_laptop_link();
	}
	
	@When("User come to home page")
	public void user_come_to_home_page() {
		logger.info("Inside User come to home page steps");
		boolean result=booksPage.isElementDisplayed(booksPage.home_link);
		assertTrue(result);
	   booksPage.click_on_home_link();
	}


	@Then("User should able to see that product in Recently viewed product")
	public void user_should_able_to_see_that_product_in_recently_viewed_product() {
		
		logger.info("Inside User should able to see that product in Recently viewed product steps");
		
		String expected_Result_Firstproduct="14.1-inch Laptop";
		String expected_Result_Secondproduct="Computing and Internet";
		recentlyViewdPage=new RecentlyViewdPage(driver);
		String first_pdt_name= recentlyViewdPage.check_first_product_viewd();
		String second_pdt_name= recentlyViewdPage.check_second_product_viewd();
		Assert.assertEquals(first_pdt_name, expected_Result_Firstproduct);
		Assert.assertEquals(second_pdt_name, expected_Result_Secondproduct);
		
	}
}
