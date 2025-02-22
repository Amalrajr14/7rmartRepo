package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userfield;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signinbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dasboardvalue;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertmsg;

	public LoginPage enterUsername(String usernamevalue) {
		userfield.sendKeys(usernamevalue);
		return this;
	}

	public LoginPage enterPassword(String upasswordvalue) {
		passwordfield.sendKeys(upasswordvalue);
		return this;
	}

	public HomePage submitOk() {
		signinbutton.click();
		return new HomePage(driver);
	}

	public boolean mainDasbord() {
		boolean value = dasboardvalue.isDisplayed();
		return value;
	}

	public boolean isAlertMessageDisplayed() {
		boolean value = alertmsg.isDisplayed();
		return value;
	}

}
