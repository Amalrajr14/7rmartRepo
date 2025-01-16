package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//	@FindBy(xpath="//input[@name='username']")private WebElement userfield;
//	@FindBy(xpath="//input[@name='password']")private WebElement passwordfield;
//	@FindBy(xpath="//button[@type='submit']")private WebElement signinbutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")private WebElement managepageinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")private WebElement typenews;
	@FindBy(xpath="//button[text()='Save']")private WebElement savethebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;

	
	
	
	
	
//	public void enterUsername(String usernamevalue) {
//		userfield.sendKeys(usernamevalue);
//	}
//	public void enterPassword(String upasswordvalue) {
//		passwordfield.sendKeys(upasswordvalue);
//	}
//	public void submitOk() {
//		signinbutton.click(); 
//	}
	public void clickManagenewsMoreinfo() {
		managepageinfo.click();
	}
public void clickNewButton() {		
		newbutton.click();	}
	public void enterNews(String newsdata) {
		
		typenews.sendKeys(newsdata);
	}
	public void clickSaveButton() {
		
		savethebutton.click();	}

	public boolean AlertDisplayed() {
			return alert.isDisplayed();
		}

	
	
	
}
