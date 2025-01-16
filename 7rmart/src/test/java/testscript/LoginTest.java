 package testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base{
	@DataProvider(name="usercredentials")
	public Object[][] testData(){
		Object data[][]= {{"admin","admin"}};
		return data;
		
		}
	@Test(dataProvider = "usercredentials", description="Test case used to login into admin site using valid credentials ",groups= {"regression"})
	public void verifyTheUserIsAbletoLoginUsingValidcredentials(String username1,String password1) throws Exception {
		String username=ExcelUtilities.readString(1, 0, "DataSheet1");
		String password=ExcelUtilities.readString(1, 1, "DataSheet1");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.submitOk();
		loginpage.mainDasbord();
		boolean mainDasbord = loginpage.mainDasbord();
		Assert.assertTrue(mainDasbord,"Test case failed");
	}
	@Test
//	@Parameters({"username","password"})
	public void verifyTheUserIsAbletoLoginUsingValidusernameandwrongpassword() throws Exception {
		String username1=ExcelUtilities.readString(1, 9, "DataSheet1");
		String password2=ExcelUtilities.readString(1, 10, "DataSheet1");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(username1);
		loginpage.enterPassword(password2);
		loginpage.submitOk();
		loginpage.mainDasbord();
		boolean mainDasbord = loginpage.mainDasbord();
		Assert.assertTrue(mainDasbord,"Test case failed");
		loginpage.isAlertMessageDisplayed();
	}
}
 