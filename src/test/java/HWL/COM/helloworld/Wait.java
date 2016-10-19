package HWL.COM.helloworld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    private WebDriver driver;

    public Wait(WebDriver driver) {
	this.driver = driver;
    }

    // 等待当前元素显示
    public void waitForElementPresent(String locator) {
	(new WebDriverWait(driver, 10)).until(ExpectedConditions
		.presenceOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementIsEnable(String locator) {
	(new WebDriverWait(driver, 10)).until(ExpectedConditions
		.elementToBeClickable(By.xpath(locator)));
    }

    public void waitFor(long timeout) {
	try {
	    Thread.sleep(timeout);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
}
