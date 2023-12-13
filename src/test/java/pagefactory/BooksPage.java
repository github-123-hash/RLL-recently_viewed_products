package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {
	
	@FindBy(xpath=("//a[text()='Computing and Internet']"))
	public WebElement book_link;
	
	
	@FindBy(xpath=("//img[@alt='Tricentis Demo Web Shop']"))
	public WebElement home_link;
	
	public void click_on_book_link() {
		book_link.click();
	}
	
	public void click_on_home_link() {
		home_link.click();
	}
	
	public boolean isElementDisplayed(WebElement element) {
		boolean result=element.isDisplayed();//verifies if a certain element is displayed or not.
		return result;
	}
	
	public BooksPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
		//used to initialize elements of a page object model.it helps in initializing elements with annotations such as @FindBy
		//driver refers to the webdriver instance
		//this refers to the current class or page where you want to initialize the elements.
	}
}
