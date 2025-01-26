package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void javaSriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollBy(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	public void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)"); // Scrolls down by 500 pixels
	}

	public void scrollToElementAndClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}

	public void moveToElementAndClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform(); // Move to the element
		element.click(); // Click the element
	}

	public void clickUsingActions(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	public static void visibleText(WebElement element, String text) {
		Select obj = new Select(element);
		obj.selectByVisibleText(text);

	}

	public static void visibleValue(WebElement element) {
		Select obj = new Select(element);
		obj.selectByValue("Green");

	}

	public void byIndex(WebElement element) {
		Select obj = new Select(element);
		obj.selectByIndex(3);

	}

	public void doubleClick(WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.doubleClick();

	}

	public void rightClick(WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.contextClick();

	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions obj = new Actions(driver);
		obj.dragAndDrop(source, target);

	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		return formater.format(date);

	}

}
