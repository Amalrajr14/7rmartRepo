package testscript;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtilities;


public class AdminUsersTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="Test case for access User Admin")
	public void verifyUseisabletoaccessadminuser() throws Exception {
		String username=ExcelUtilities.readString(1, 0, "DataSheet1");
		String password=ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.submitOk();
		AdminUsersPage adminuserspage =new AdminUsersPage(driver);
		adminuserspage.clickAdminuserpageUrl();
		adminuserspage.clickManageuserpage();
		adminuserspage.clicknewbotton();
//		FakerUtility fakerutility = new FakerUtility();
//		String adminuser =fakerutility.generateName();
//		String password3 =fakerutility.generatePassword();
		String username2=ExcelUtilities.readString(1, 3, "DataSheet1");
		String password2=ExcelUtilities.readString(1, 4, "DataSheet1");
		adminuserspage.enterusername1(username2);
		adminuserspage.enterpassword1(password2);
		
		String usertype=ExcelUtilities.readString(1, 5, "DataSheet1");
		adminuserspage.selectoption(usertype);
		adminuserspage.clickSaveButton();
		boolean alertshown = adminuserspage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,"Test case failed");
}
	@Test(retryAnalyzer=retry.Retry.class,description="Test case for Deleting Admin User")
	public void verifyUseisabletoDeleteadminUser() throws Exception {
		String username=ExcelUtilities.readString(1, 0, "DataSheet1");
		String password=ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.submitOk();
		AdminUsersPage adminuserspage =new AdminUsersPage(driver);
		adminuserspage.clickAdminuserpageUrl();
		adminuserspage.clickManageuserpage();
		adminuserspage.clickDeleteButton();
		boolean alertshown = adminuserspage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,"Test case failed");
}
}
