package testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	@DataProvider(name = "usercredentials")
	public Object[][] testData() {
		Object data[][] = { { "admin", "admin" } };
		return data;

	}

	@Test(dataProvider = "usercredentials", description = "Test case used to login into admin site using valid credentials ", groups = {
			"regression" })
	public void verifyTheUserIsAbletoLoginUsingValidcredentials(String username1, String password1) throws Exception {
		String username = ExcelUtilities.readString(1, 0, "DataSheet1");
		String password = ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password).submitOk();
		loginpage.mainDasbord();
		boolean mainDasbord = loginpage.mainDasbord();
		Assert.assertTrue(mainDasbord,Constants.LOGINMESSAGE1);
	}

	@Test
//	@Parameters({"username","password"})
	public void verifyTheUserIsAbletoLoginUsingValidusernameandwrongpassword() throws Exception {
		String username1 = ExcelUtilities.readString(1, 9, "DataSheet1");
		String password2 = ExcelUtilities.readString(1, 10, "DataSheet1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username1).enterPassword(password2).submitOk();
		boolean isAlertMessageDisplayed= loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,Constants.LOGINMESSAGE2);
	}
}
