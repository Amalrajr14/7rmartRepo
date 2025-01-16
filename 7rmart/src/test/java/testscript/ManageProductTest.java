package testscript;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtilities;

public class ManageProductTest extends Base {
	@Test(description="Test case for deleting product")
	public void verifyUseisabletodeleteproduct() throws Exception {
		String username=ExcelUtilities.readString(1, 0, "DataSheet1");
		String password=ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.submitOk();
		ManageProductPage manageproductpage =new ManageProductPage(driver);
//		manageproductpage.clickAdminuserpageUrl();
		manageproductpage.clickManageproduct();
		manageproductpage.clickdltbotton();
		boolean alertshown=manageproductpage.AlertDisplayed();
		Assert.assertTrue(alertshown,"Test case failed");

}
}