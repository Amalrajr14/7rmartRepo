package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;
	

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath="//input[@name='username']")private WebElement userfield;
//	@FindBy(xpath="//input[@name='password']")private WebElement passwordfield;
//	@FindBy(xpath="//button[@type='submit']")private WebElement signinbutton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement typenews;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savethebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

//	public void enterUsername(String usernamevalue) {
//		userfield.sendKeys(usernamevalue);
//	}
//	public void enterPassword(String upasswordvalue) {
//		passwordfield.sendKeys(upasswordvalue);
//	}
//	public void submitOk() {
//		signinbutton.click(); 
//	}

	public ManageNewsPage clickNewButton() {
		newbutton.click();
		return this;
	}

	public ManageNewsPage enterNews(String newsdata) {

		typenews.sendKeys(newsdata);
		return this;
	}

	public ManageNewsPage clickSaveButton() {

		savethebutton.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}

}
