package HWL.COM.helloworld;

import java.util.List;

import org.apache.tools.ant.property.ParseProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBrowsers implements JDweb {
    private WebDriver driver;
    private Wait wait;
    private SwitchToSome switchToSome;

    @BeforeClass
    public void before() {
	driver = Browsers.getDriver(BrowsersType.FIREFOX);

    }

    @Test
    public void SelectItemFromDropDownList() {
	driver.get("https://passport.jd.com/uc/login?ltype=logout");
	driver.findElement(By.xpath(loginNo)).sendKeys(username);
	driver.findElement(By.xpath(loginPassword)).sendKeys(password);
	driver.findElement(By.xpath(loginBtn)).click();
	wait = new Wait(driver);
	wait.waitForElementPresent(logo);
	driver.findElement(By.xpath(usernameLocator)).click();
	switchToSome = new SwitchToSome(driver);
	switchToSome.swtichToNewWindows("�ҵľ���");
	// ������������Ϣλ��
	((JavascriptExecutor) driver)
		.executeScript("window.scrollBy(0,900)", 0);
	wait.waitFor(5000);
	driver.findElement(By.xpath(self)).click();
	switchToSome.swtichToNewWindows("�˻���Ϣ");
	wait.waitForElementPresent(brithday);
	Select selectYear = new Select(driver.findElement(By.xpath(brithday)));
	// selectYear.selectByVisibleText("2005");
	List<WebElement> allyear = selectYear.getOptions();
	for (WebElement e : allyear) {
	    System.out.println(e.getText());
	}
    }
    // update 20161014 10:29 By hwl

}