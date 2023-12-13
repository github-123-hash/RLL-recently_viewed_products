package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecentlyViewdPage {
	
	
	
	@FindBy(xpath=("//a[@class='product-name'][1]"))
	public WebElement first_product_link;
	
	@FindBy(xpath=("//a[@class='product-name'][2]"))
	public WebElement second_product_link;
	
	
	public RecentlyViewdPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
		//used to initialize elements of a page object model.it helps in initializing elements with annotations such as @FindBy
				//driver refers to the webdriver instance
				//this refers to the current class or page where you want to initialize the elements.
	}
	
	public String check_first_product_viewd() {
		String first_product_name=first_product_link.getText();
		return first_product_name;
	}
	
	public String check_second_product_viewd() {
		String second_product_name=second_product_link.getText();
		return second_product_name;
	}
	
	public boolean isElementDisplayed(WebElement element) {
		boolean result=element.isDisplayed();
		return result;
	}
}
