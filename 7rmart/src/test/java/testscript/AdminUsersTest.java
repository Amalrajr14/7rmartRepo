package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class AdminUsersTest extends Base {
	HomePage homepage;
	AdminUsersPage adminuserspage;
	@Test(retryAnalyzer = retry.Retry.class, description = "Test case for access User Admin", groups = { "regression" })
	public void verifyUseisabletoaccessadminuser() throws Exception {
		String username = ExcelUtilities.readString(1, 0, "DataSheet1");
		String password = ExcelUtilities.readString(1, 1, "DataSheet1");
		String username2 = ExcelUtilities.readString(1, 3, "DataSheet1");
		String password2 = ExcelUtilities.readString(1, 4, "DataSheet1");
		String usertype = ExcelUtilities.readString(1, 5, "DataSheet1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.submitOk();
//		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage=homepage.clickAdminUserPageUrl().clickManageUserPage().clickNewButton().clickNewButton().enterUserName1(username2).enterPassword1(password2).selectOption(usertype).clickSaveButton();
//		FakerUtility fakerutility = new FakerUtility();
//		String adminuser =fakerutility.generateName();
//		String password3 =fakerutility.generatePassword();
		boolean alertshown = adminuserspage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,Constants.ADMINALERTMESSAGE1);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "Test case for Deleting Admin User", groups = {
			"regression" })
	public void verifyUseisabletoDeleteadminUser() throws Exception {
		String username = ExcelUtilities.readString(1, 0, "DataSheet1");
		String password = ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.submitOk();
//		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage=homepage.clickAdminUserPageUrl().clickManageUserPage().clickDeleteButton();
		boolean alertshown = adminuserspage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown, Constants.ADMINALERTMESSAGE2);
	}
}
