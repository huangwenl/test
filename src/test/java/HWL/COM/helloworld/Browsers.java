package HWL.COM.helloworld;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
    private static WebDriver driver = null;
    // IE浏览器设置参数
    private static String projectPath = System.getProperty("user.dir");
    private static DesiredCapabilities caps = null;

    public static WebDriver getDriver(BrowsersType browsersType) {
	switch (browsersType) {
	case IE:
	    System.setProperty("webdriver.ie.driver", projectPath
		    + "//tools//IEDriverServer.exe");
	    caps = DesiredCapabilities.internetExplorer();
	    caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS,
		    false);
	    caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
	    caps.setCapability("ignoreZoomsetting", true);
	    driver = new InternetExplorerDriver(caps);
	    break;
	case CHROME:
	    System.setProperty("webdriver.chrome.driver", projectPath
		    + "//tools//chromedriver_x64.exe");
	    caps = DesiredCapabilities.chrome();
	    caps.setCapability("chrome.switches",
		    Arrays.asList("--start-maximized"));
	    driver = new ChromeDriver(caps);
	    break;
	case FIREFOX:
	    FirefoxProfile firefoxProfile = new FirefoxProfile();
	    firefoxProfile.setPreference("webdriver.accept.untrusted.certs",
		    true);// 绕过证书
	    driver = new FirefoxDriver(firefoxProfile);
	    break;
	}
	return driver;
    }
}
