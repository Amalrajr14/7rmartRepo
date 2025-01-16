package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoriesPage;
import utilities.ExcelUtilities;

public class SubCategoriesTest extends Base {
	@Test(description="Test case for Adding sub categories")
	public void verifyUseisabletoAddSubCategories() throws Exception{
		
		String username=ExcelUtilities.readString(1, 0, "DataSheet1");
		String password=ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.submitOk();	
		SubCategoriesPage subcategoriespage = new SubCategoriesPage(driver);
		subcategoriespage.clickManagecontactmenu();
		subcategoriespage.clickNewButton();
		subcategoriespage.clickCategories();
		String addingsubcategory=ExcelUtilities.readString(1, 0, "SubCategory");
		subcategoriespage.clickSubCategories(addingsubcategory);
		subcategoriespage.uploadFile();
	
		subcategoriespage.clickSaveButton();
		boolean alertshown=subcategoriespage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,"Test case failed");
		
		
		
		
	}
}
