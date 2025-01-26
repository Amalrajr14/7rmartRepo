package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoriesPage {
	WebDriver driver;

	public SubCategoriesPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
	private WebElement managenewmenu;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement selectcategory;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement selectsubcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement selectfile;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savefile;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
//button[@type="submit"]

	

	public SubCategoriesPage clickNewButton() {
		managenewmenu.click();
		return this;
	}

	public SubCategoriesPage clickCategories() {
		PageUtility.visibleText(selectcategory, "phone");
return this;
	}

	public SubCategoriesPage clickSubCategories(String addsubcategory) {
		selectsubcategory.click();
		selectsubcategory.sendKeys(addsubcategory);
		return this;

	}

	public SubCategoriesPage uploadFile() {
//	 FileUploadUtility.uploadFile(selectfile, filePath); 
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(selectfile, Constants.MOBILEPHONEIMAGE);
		return this;

	}

	public SubCategoriesPage clickSaveButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.scrollAndClickSaveButton(driver, savefile, 20);
		return this;

	}

	public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}

}
