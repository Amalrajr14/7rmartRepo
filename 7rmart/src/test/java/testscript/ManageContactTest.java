package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	@Test(description="Test case for Manage Contact")
public void verifyUseisabletoManageContact() throws Exception {
	String username=ExcelUtilities.readString(1, 0, "DataSheet1");
	String password=ExcelUtilities.readString(1, 1, "DataSheet1");
	LoginPage loginpage =new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.submitOk();		
	ManageContactPage managecontactpage =new ManageContactPage(driver);	
	managecontactpage.clickManageContactbutton();
	managecontactpage.clickactionbutton();
	String updatephone=ExcelUtilities.readNumber(1, 0, "DataSheet2");
	managecontactpage.updatePhoneNumber(updatephone);
	String updateemail=ExcelUtilities.readString(1, 1, "DataSheet2");
	managecontactpage.addEmailId(updateemail);
	String updateaddress=ExcelUtilities.readString(1, 2, "DataSheet2");
	managecontactpage.addAddress(updateaddress);
	String updatedeliverytime=ExcelUtilities.readNumber(1, 3, "DataSheet2");
	managecontactpage.addDeliveryTime(updatedeliverytime);	
	String updatedeliverycharge=ExcelUtilities.readNumber(1, 4, "DataSheet2");
	managecontactpage.addDeliveryCharge(updatedeliverycharge);
	managecontactpage.clickupdatebutton();
	boolean alertshown = managecontactpage.isAlertMessageDisplayed();
	Assert.assertTrue(alertshown,"Test case failed");	
		
	}
	@Test(description="Test case for verifying update button is enable or not")
	public void verifyiftheUpdatebuttinisenableorNot() throws Exception {
		
		String username=ExcelUtilities.readString(1, 0, "DataSheet1");
		String password=ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.submitOk();		
		ManageContactPage managecontactpage =new ManageContactPage(driver);	
		managecontactpage.clickManageContactbutton();
		managecontactpage.clickactionbutton();
		boolean updatebuttonshown = managecontactpage.updateButtonIsDisplayedOrNot();
		Assert.assertTrue(updatebuttonshown,"Test case failed");	
		
	}
	
}
