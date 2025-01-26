package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import pages.ManageProductPage;
import utilities.ExcelUtilities;

public class ManageProductTest extends Base {
	HomePage homepage;
	ManageProductPage manageproductpage;
	@Test(description = "Test case for deleting product")
	public void verifyUseisabletodeleteproduct() throws Exception {
		String username = ExcelUtilities.readString(1, 0, "DataSheet1");
		String password = ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.submitOk();
//		ManageProductPage manageproductpage = new ManageProductPage(driver);
		manageproductpage=homepage.clickManageProduct().clickDltButton();
		boolean alertshown = manageproductpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,Constants.DELETEPRODUCTMESSAGE);

	}
}