package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test(description = "Test case for Manage News section", groups = { "regression" })
	public void verifyUseisabletoClickManagenewsTab() throws Exception {
		String username = ExcelUtilities.readString(1, 0, "DataSheet1");
		String password = ExcelUtilities.readString(1, 1, "DataSheet1");
		String news = ExcelUtilities.readString(1, 2, "DataSheet1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.submitOk();
//		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		managenewspage=homepage.clickManagenewsMoreInfo().clickNewButton().enterNews(news).clickSaveButton();
		
		boolean alertshown = managenewspage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,Constants.MANAGENEWSMESSAGE);

	}
}
