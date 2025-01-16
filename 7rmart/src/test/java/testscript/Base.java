package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;

public class Base {
	public WebDriver driver;
	public ScreenshotUtility scrshot;
	@BeforeMethod(alwaysRun= true)
	public void instalizeBrowser() {
		driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		}
	
//	@Parameters("browser")
//	public void instalizeBrowser(String browser) throws Exception {
//		//driver=new ChromeDriver();
//		if(browser.equalsIgnoreCase("chrome")) {
//			
//		driver = new ChromeDriver();	
//			
//			
//		}else if(browser.equalsIgnoreCase("edge")) {
//			
//		driver = new EdgeDriver();	
//			
//		}else if(browser.equalsIgnoreCase("firefox")) {
//			
//		driver = new FirefoxDriver();	
//			
//		}else {
//			
//			throw new Exception("Browser is invalid");
//		}
//		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
//		driver.manage().window().maximize();
//		}
	@AfterMethod(alwaysRun= true)
	public void driveQuitAndClose(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) // status of test case is checked here
		{
			scrshot = new ScreenshotUtility();// creating object
			scrshot.getScreenShot(driver, iTestResult.getName());// calling method using the object if test case fail pass driver and name of failed test case
		}
//		driver.close();
//		driver.quit();
	}
}
