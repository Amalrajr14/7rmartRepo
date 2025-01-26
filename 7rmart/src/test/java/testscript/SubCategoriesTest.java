package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoriesPage;
import utilities.ExcelUtilities;

public class SubCategoriesTest extends Base {
	HomePage homepage;
	SubCategoriesPage subcategoriespage;
	@Test(description = "Test case for Adding sub categories")
	public void verifyUseisabletoAddSubCategories() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "DataSheet1");
		String password = ExcelUtilities.readString(1, 1, "DataSheet1");
		String addingsubcategory = ExcelUtilities.readString(1, 0, "SubCategory");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage =loginpage.submitOk();
//		SubCategoriesPage subcategoriespage = new SubCategoriesPage(driver);
		subcategoriespage=homepage.clickManageContactMenu().clickNewButton().clickCategories().clickSubCategories(addingsubcategory).uploadFile().clickSaveButton();	
		boolean alertshown = subcategoriespage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,Constants.SUBCATEGORIESMESSAGE);

	}
}
