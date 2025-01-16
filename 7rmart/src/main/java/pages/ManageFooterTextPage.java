package pages;





import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class ManageFooterTextPage {
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")private WebElement managefootertext;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=2']")private WebElement manageactionicon;
	@FindBy(xpath="//textarea[@id='content']")private WebElement editaddress;
	@FindBy(xpath="//input[@id='email']")private WebElement email;
	@FindBy(xpath="//input[@id='phone']")private WebElement phone;
	@FindBy(xpath="//button[@type='submit']")private WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
//	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")private WebElement update;
	
	public void clickManagefootertext() {
		managefootertext.click();
	}
	public void clickManageActionButton() {
		manageactionicon.click();
	}
	public void clickAddress(String newaddress) {
		editaddress.clear();
		editaddress.sendKeys(newaddress);
	}
	public void clickEmail(String newemail) {
		email.clear();
		email.sendKeys(newemail);
	}
	public void clickPhone(String newphonenumber) {
		phone.clear();
		phone.sendKeys(newphonenumber);
	}
//	public void clickupdate(WebDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.elementToBeClickable(update));
//		update.click();	
//	
//	}
	public void clickupdate() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//	    js.executeScript("arguments[0].scrollIntoView(true);", update);
	    update.click();
	}
	
	public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}
	public boolean updateButtonIsDisplayedOrNot() { 
	    return update.isDisplayed();
	}

	
}

