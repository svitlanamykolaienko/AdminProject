package stage.nur.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {
    public static String USERNAME = "svetlana170";
    public static String ACCESSKEY = "s1p5HrVWHC3s41oasn2w";
    public static String URL = "https://"+USERNAME+":"+ACCESSKEY+"@hub.browserstack.com/wd/hub";
    public static WebDriver getDriver(String browser, Logger log) {
        WebDriver driver;
        log.info("Starting " + browser + " ");
        switch(browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            case "remote":
                DesiredCapabilities capability = new DesiredCapabilities();
                capability.setPlatform(Platform.MAC);
                capability.setBrowserName("chrome");
                capability.setVersion("69");

                URL browserStackURL = null;
                try {
                    browserStackURL = new URL(URL);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(browserStackURL, capability);
                break;

             default:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                 break;
        }
        driver.manage().window().setSize(new Dimension(1280, 800));
        return driver;
    }
}
