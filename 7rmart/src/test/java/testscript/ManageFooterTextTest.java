package testscript;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;

public class ManageFooterTextTest extends Base{
	@Test(description="Test case for  accessing Footer Area")
	public void verifyUseisabletoaccessfooterarea() throws Exception {
		String username=ExcelUtilities.readString(1, 0, "DataSheet1");
		String password=ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.submitOk();
		ManageFooterTextPage managefootertextpage =new ManageFooterTextPage(driver);
		managefootertextpage.clickManagefootertext();
		managefootertextpage.clickManageActionButton();
		String addresstext=ExcelUtilities.readString(1, 6, "DataSheet1");
		managefootertextpage.clickAddress(addresstext);
		String emailtext=ExcelUtilities.readString(1, 7, "DataSheet1");
		managefootertextpage.clickEmail(emailtext);
		String phonenumber=ExcelUtilities.readNumber(1, 8, "DataSheet1");
		managefootertextpage.clickPhone(phonenumber);
		managefootertextpage.clickupdate();
		boolean alertshown = managefootertextpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,"Test case failed");	
		
}
	@Test(description="Test case for verifying update button is enable or not")
	public void verifyiftheupdatebuttonisdisplayed() throws Exception {
		String username=ExcelUtilities.readString(1, 0, "DataSheet1");
		String password=ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.submitOk();
		ManageFooterTextPage managefootertextpage =new ManageFooterTextPage(driver);
		managefootertextpage.clickManagefootertext();
		managefootertextpage.clickManageActionButton();
		boolean alertshown = managefootertextpage.updateButtonIsDisplayedOrNot();
		Assert.assertTrue(alertshown,"Test case failed");
		
}
}