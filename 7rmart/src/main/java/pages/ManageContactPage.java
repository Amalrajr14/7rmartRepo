package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageContactPage  {
	WebDriver driver;
public 	ManageContactPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")private WebElement managecontactmenu;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")private WebElement manageactionmenu;
	@FindBy(xpath="//input[@name='phone']")private WebElement editphone;
	@FindBy(xpath="//input[@id='email']")private WebElement editemail;
	@FindBy(xpath="//textarea[@name='address']")private WebElement editaddres;
	@FindBy(xpath="//textarea[@name='del_time']")private WebElement editdeliverytime;
	@FindBy(xpath="//input[@name='del_limit']")private WebElement editdeliverycharge;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")private WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	WaitUtility waitutility =new WaitUtility();
public void clickManageContactbutton() {
	managecontactmenu.click();			
}	

public void clickactionbutton() {
	manageactionmenu.click();			
}	

public void updatePhoneNumber(String phoneNumber) {
	editphone.clear();
	editphone.sendKeys(phoneNumber);
}
public void addEmailId(String emailId) {
	editemail.clear();
	editemail.sendKeys(emailId);
}
public void addAddress(String address) {
	editaddres.clear();
	editaddres.sendKeys(address);
}
public void addDeliveryTime(String deliverytime) {
	editdeliverytime.clear();
	editdeliverytime.sendKeys(deliverytime);
}
public void addDeliveryCharge(String deliverycharge) {
	editdeliverycharge.clear();
	editdeliverycharge.sendKeys(deliverycharge);
}
public void clickupdatebutton() {
	waitutility.scrollAndClickSaveButton(driver, updatebutton, 20);
}
public boolean isAlertMessageDisplayed() {
	return alert.isDisplayed();
}


public boolean updateButtonIsDisplayedOrNot() {
    return updatebutton.isDisplayed();
}







}
