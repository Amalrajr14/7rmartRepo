package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AdminUsersPage {
WebDriver driver;

public AdminUsersPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']")private WebElement adminuserpageurl;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private WebElement manageadmin;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
	@FindBy(xpath="//input[@name='username']")private WebElement userfield;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordfield;
	@FindBy(xpath="//select[@id='user_type']")private WebElement usertypedropdown;
	@FindBy(xpath="//button[@name='Create']")private WebElement savethebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/user/delete?del=11198&page_ad=1']")private WebElement deletethebutton;
	
	
	public void clickAdminuserpageUrl() {
		adminuserpageurl.click();
	}
	public void clickManageuserpage() {
		manageadmin.click();
	}
	public void clicknewbotton() {
		newbutton.click();
	}
	public void enterusername1(String user) {
		
		userfield.sendKeys(user);
	}
	public void enterpassword1(String pass) {
		
		passwordfield.sendKeys(pass);
	}
	
public void selectoption(String option) {
		
	usertypedropdown.sendKeys(option);
	}
public void clickSaveButton() {
	
	savethebutton.click();	}


public void clickDeleteButton() {
	
	deletethebutton.click();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	
}
public boolean isAlertMessageDisplayed() {
	return alert.isDisplayed();
}

}
