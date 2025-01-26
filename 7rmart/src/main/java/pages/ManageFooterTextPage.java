package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageFooterTextPage {
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=2']")
	private WebElement manageactionicon;
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement editaddress;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phone;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
//	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")private WebElement update;

	

	public ManageFooterTextPage clickManageActionButton() {
		manageactionicon.click();
		return this;
	}

	public ManageFooterTextPage clickAddress(String newaddress) {
		editaddress.clear();
		editaddress.sendKeys(newaddress);
		return this;
	}

	public ManageFooterTextPage clickEmail(String newemail) {
		email.clear();
		email.sendKeys(newemail);
		return this;
	}

	public ManageFooterTextPage clickPhone(String newphonenumber) {
		phone.clear();
		phone.sendKeys(newphonenumber);
		return this;
	}

//	public void clickupdate(WebDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.elementToBeClickable(update));
//		update.click();	
//	
//	}
	public ManageFooterTextPage clickUpdate() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//	    js.executeScript("arguments[0].scrollIntoView(true);", update);
		update.click();
		return this;
		
	}

	public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}

	public boolean isUpdateButtonIsDisplayedOrNot() {
		return update.isDisplayed();
	}

}
