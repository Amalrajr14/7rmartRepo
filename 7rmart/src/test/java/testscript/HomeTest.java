package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtilities;

public class HomeTest extends Base {
	HomePage homepage;
	@Test(retryAnalyzer = retry.Retry.class, description = "Test case for sign out method")
	public void verifyusserisabletosignout() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "DataSheet1");
		String password = ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.submitOk();
//		HomePage logoutpage = new HomePage(driver);
		homepage.pressAdminLogo().selectLogoutOption();
	
		homepage.isSignInPageDisplayed();
		boolean alertshown = homepage.isSignInPageDisplayed();
		Assert.assertTrue(alertshown,Constants.LOGOUTMESSAGE);

	}

}
