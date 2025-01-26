package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement adminlogobutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement logoutoption;
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	private WebElement signinpage;

	public HomePage pressAdminLogo() {
		adminlogobutton.click();
		return this;
	}

	public void selectLogoutOption() {
		logoutoption.click();
	}

	public boolean isSignInPageDisplayed() {
		return signinpage.isDisplayed();
	}

//Admin user page
	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminuserpageurl;
	public AdminUsersPage clickAdminUserPageUrl() {
		adminuserpageurl.click();
		return new AdminUsersPage(driver);
	}
// Manage Contact page
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	private WebElement managecontactmenu;
	public ManageContactPage clickManageContactButton() {
		managecontactmenu.click();
		return new ManageContactPage(driver);
	}
// Manage Footertext page
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	private WebElement managefootertext;
	public ManageFooterTextPage clickManageFooterText() {
		managefootertext.click();
		return new ManageFooterTextPage(driver);
	}
// Manage News Page
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement managepageinfo;
	public ManageNewsPage clickManagenewsMoreInfo() {
		managepageinfo.click();
		return new ManageNewsPage(driver);
	}
// Manage Product page
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']//following-sibling::i[@class='fas fa-arrow-circle-right']")
	private WebElement manageproduct;
	public ManageProductPage clickManageProduct() {
		manageproduct.click();
		return new ManageProductPage(driver);
	}
//Sub categories page
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement managecontactmenusub;
	public SubCategoriesPage clickManageContactMenu() {
		managecontactmenusub.click();
		return new SubCategoriesPage(driver);
	}
	
	
	
}
