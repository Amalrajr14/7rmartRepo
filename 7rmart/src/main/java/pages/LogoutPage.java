package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LogoutPage {
WebDriver driver;
public LogoutPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@data-toggle='dropdown']")private WebElement adminlogobutton;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")private WebElement logoutoption;
@FindBy(xpath="//p[text()='Sign in to start your session']")private WebElement signinpage;
public void pressAdminLogo() {	
	adminlogobutton.click();	
}
public void selectLogoutOption() {
	logoutoption.click();	
}
public boolean isSignInPageDisplayed() {
	return signinpage.isDisplayed();
}

}
