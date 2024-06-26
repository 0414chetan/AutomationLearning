package learning;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtils {
	
	 public static WebElement findElement(WebDriver driver, By by) {
	        return driver.findElement(by);
	    }

	    public static void click(WebDriver driver, By by) {
	        findElement(driver, by).click();
	    }

	    public static void sendKeys(WebDriver driver, By by, String text) {
	        findElement(driver, by).sendKeys(text);
	    }

	    public static String getText(WebDriver driver, By by) {
	        return findElement(driver, by).getText();
	    }

	    public static boolean isDisplayed(WebDriver driver, By by) {
	        return findElement(driver, by).isDisplayed();
	    }
}
