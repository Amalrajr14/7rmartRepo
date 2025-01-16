package testscript;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	@Test(description="Test case for Manage News section")
	public void verifyUseisabletoClickManagenewsTab() throws Exception {
		String username=ExcelUtilities.readString(1, 0, "DataSheet1");
		String password=ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.submitOk();
		ManageNewsPage manageNewsPage =new ManageNewsPage(driver);
		manageNewsPage.clickManagenewsMoreinfo();
		manageNewsPage.clickNewButton();
		String news=ExcelUtilities.readString(1, 2, "DataSheet1");
		manageNewsPage.enterNews(news);
		manageNewsPage.clickSaveButton();
		boolean alertshown=manageNewsPage.AlertDisplayed();
		Assert.assertTrue(alertshown,"Test case failed");

		
		}
}
