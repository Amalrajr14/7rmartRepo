package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;

public class ManageFooterTextTest extends Base {
	HomePage homepage;
	ManageFooterTextPage managefootertextpage;
	@Test(description = "Test case for  accessing Footer Area")
	public void verifyUseisabletoaccessfooterarea() throws Exception {
		String username = ExcelUtilities.readString(1, 0, "DataSheet1");
		String password = ExcelUtilities.readString(1, 1, "DataSheet1");
		String addresstext = ExcelUtilities.readString(1, 6, "DataSheet1");
		String emailtext = ExcelUtilities.readString(1, 7, "DataSheet1");
		String phonenumber = ExcelUtilities.readNumber(1, 8, "DataSheet1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.submitOk();
//		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage=homepage.clickManageFooterText().clickManageActionButton().clickAddress(addresstext).clickEmail(emailtext).clickPhone(phonenumber).clickUpdate();
		boolean alertshown = managefootertextpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,Constants.FOOTERMESSAGE);

	}

	@Test(description = "Test case for verifying update button is enable or not")
	public void verifyiftheupdatebuttonisdisplayed() throws Exception {
		String username = ExcelUtilities.readString(1, 0, "DataSheet1");
		String password = ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.submitOk();
//		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage=homepage.clickManageFooterText().clickManageActionButton();
		boolean alertshown = managefootertextpage.isUpdateButtonIsDisplayedOrNot();
		Assert.assertTrue(alertshown,Constants.UPDATEBUTTONFOOTERMESSAGE);

	}
}