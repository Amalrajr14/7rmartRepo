package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	HomePage homepage;
	ManageContactPage managecontactpage;
	@Test(description = "Test case for Manage Contact")
	public void verifyUseisabletoEditManageContact() throws Exception {
		String username = ExcelUtilities.readString(1, 0, "DataSheet1");
		String password = ExcelUtilities.readString(1, 1, "DataSheet1");
		String updatephone = ExcelUtilities.readNumber(1, 0, "DataSheet2");
		String updateemail = ExcelUtilities.readString(1, 1, "DataSheet2");
		String updateaddress = ExcelUtilities.readString(1, 2, "DataSheet2");
		String updatedeliverytime = ExcelUtilities.readNumber(1, 3, "DataSheet2");
		String updatedeliverycharge = ExcelUtilities.readNumber(1, 4, "DataSheet2");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.submitOk();
//		ManageContactPage managecontactpage = new ManageContactPage(driver);

		managecontactpage=homepage.clickManageContactButton().clickActionButton().updatePhoneNumber(updatephone).addEmailId(updateemail).addAddress(updateaddress).addDeliveryTime(updatedeliverytime).addDeliveryCharge(updatedeliverycharge);
		managecontactpage.clickUpdateButton();
		boolean alertshown = managecontactpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,Constants.MANAGECONTACTMESSAGE);

	}

	@Test(description = "Test case for verifying update button is enable or not")
	public void verifyiftheUpdatebuttinisenableorNot() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "DataSheet1");
		String password = ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.submitOk();
//		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage=homepage.clickManageContactButton().clickActionButton();
		boolean updatebuttonshown = managecontactpage.isupdateButtonIsDisplayedOrNot();
		Assert.assertTrue(updatebuttonshown,Constants.UPDATEBUTTONENABLEMESSAGE);

	}

}
