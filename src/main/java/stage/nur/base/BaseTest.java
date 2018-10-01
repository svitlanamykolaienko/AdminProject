package stage.nur.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected Logger log;
    DesiredCapabilities caps = new DesiredCapabilities();
    private String os = System.getProperty("OS");
    private String osVersion = System.getProperty("OS_version");


    private void setBrowser() {
        if (System.getProperty("browser") != null) {
            caps.setCapability("browser",System.getProperty("browser"));
            caps.setCapability("browser_version", System.getProperty("browser_version"));
        } else {
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "69.0");
        }
    }

    @Parameters({ "browser" })
    @BeforeClass(alwaysRun = true)
    protected void setUpClass(ITestContext ctx, @Optional("firefox") String browser){
        String testName = ctx.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);
        log.info("Method Set Up");
        caps.setCapability("os", os);
        caps.setCapability("os_version", osVersion);
        setBrowser();
        log.info(os + " " + osVersion + " " +  System.getProperty("browser") + " " + System.getProperty("browser_version"));
        driver = BrowserFactory.getDriver(browser,log, caps);
    }

    @AfterClass(alwaysRun = true)
    protected void methodTearDown(){
        log.info("Method Tear Down");
        driver.quit();
    }
}
