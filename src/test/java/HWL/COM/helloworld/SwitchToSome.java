package HWL.COM.helloworld;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchToSome {
    private WebDriver driver;

    public SwitchToSome(WebDriver driver) {
	this.driver = driver;
    }

    public void swtichToIFrame(String iframeLocator) {
	driver.switchTo().frame(driver.findElement(By.xpath(iframeLocator)));
    }

    public void swtichToNewWindows(String windowsTitle) {
	Set<String> handles = driver.getWindowHandles();
	for (String s : handles) {
	    String title = driver.switchTo().window(s).getTitle();
	    if (title.contains(windowsTitle)) {
		break;
	    }
	}
    }

}
