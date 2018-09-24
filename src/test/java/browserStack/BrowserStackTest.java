package browserStack;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserStackTest {
    public static String USERNAME = "svetlana170";
    public static String ACCESSKEY = "s1p5HrVWHC3s41oasn2w";
    public static String URL = "https://"+USERNAME+":"+ACCESSKEY+"@hub.browserstack.com/wd/hub";

    @Test
    public void openSTM() throws MalformedURLException {

        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setPlatform(Platform.MAC);
        capability.setBrowserName("chrome");
        capability.setVersion("69");

        URL browserStackURL = new URL(URL);
        WebDriver driver = new RemoteWebDriver(browserStackURL, capability);
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.google.com/";
        Assert.assertEquals(actualURL, expectedURL);
        driver.quit();
    }

}
