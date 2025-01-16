package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {
	WebDriver driver;
	public ManageProductPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']//following-sibling::i[@class='fas fa-arrow-circle-right']")private WebElement manageproduct;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/delete?del=579&page_ad=1']")private WebElement deletebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	

	public void clickManageproduct() {
		manageproduct.click();
	}
	public void clickdltbotton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", deletebutton);
		deletebutton.click();
	}
	
	public boolean AlertDisplayed() {
		return alert.isDisplayed();
	}
}
