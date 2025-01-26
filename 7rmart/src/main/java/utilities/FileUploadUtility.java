package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendKeys(WebElement element, String path) {
		element.sendKeys(path);

	}

	public void fileuploadUsingRobertClass(WebElement element, String path) throws AWTException {

		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
//	 public static void uploadFile(WebElement fileInputElement, String filePath) {
//	        if (fileInputElement != null && filePath != null) {
//	            fileInputElement.sendKeys(filePath); // Sends the file path to the file input element
//	        } else {
//	            throw new IllegalArgumentException("File input element or file path is null");
//	        }
//	    }
}
