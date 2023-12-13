package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText ="Digital downloads")
	public WebElement Digital_download_Link;
	
	@FindBy(xpath=("//a[@class='ico-wishlist'][1]"))
	public WebElement wishlist_Btn;
	
	@FindBy(xpath=("//a[@href='/books']"))
	public WebElement Book_Btn;
	
	@FindBy(xpath=("//a[@class='product-name'][1]"))
	public WebElement recently_viewed_product_name;

	@FindBy(xpath=("//h2[@class='product-title']/a[text()='14.1-inch Laptop']"))
	public WebElement laptop_link;
	
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
		//used to initialize elements of a page object model.it helps in initializing elements with annotations such as @FindBy
				//driver refers to the webdriver instance
				//this refers to the current class or page where you want to initialize the elements.
	}
	
	
	public void click_on_Digital_Download() {
		Digital_download_Link.click();
	}
	
	
	public void click_on_Wishlist_link() {
		wishlist_Btn.click();
	}
	
	public void click_on_Book_Btn() {
		Book_Btn.click();
	}
	
	public void click_on_laptop_link() {
		laptop_link.click();
	}
		
	
	
	public boolean isElementDisplayed(WebElement element) {
		boolean result=element.isDisplayed();
		return result;
	}
}
