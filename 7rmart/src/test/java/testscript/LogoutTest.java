package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtilities;

public class LogoutTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,description="Test case for sign out method")
	public void verifyusserisabletosignout() throws Exception {
		
		String username=ExcelUtilities.readString(1, 0, "DataSheet1");
		String password=ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.submitOk();
		LogoutPage logoutpage =new LogoutPage(driver);
		logoutpage.pressAdminLogo();
		logoutpage.selectLogoutOption();
		logoutpage.isSignInPageDisplayed();
		boolean alertshown = logoutpage.isSignInPageDisplayed();
		Assert.assertTrue(alertshown,"Test case failed");
		
		
	}

}
