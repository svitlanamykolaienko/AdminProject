package stage.nur.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected Logger log;


    @Parameters({ "browser" })
    @BeforeClass(alwaysRun = true)
    protected void setUpClass(ITestContext ctx, @Optional("firefox") String browser){
        String testName = ctx.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);
        log.info("Method Set Up");
        driver = BrowserFactory.getDriver(browser,log);

    }

//    @Parameters({ "browser" })
//    @BeforeMethod(alwaysRun = true)
//    protected void methodSetUp(@Optional("firefox") String browser){
//
//
//        }

    @AfterClass(alwaysRun = true)
    protected void methodTearDown(){
        log.info("Method Tear Down");
        driver.quit();
    }

}
