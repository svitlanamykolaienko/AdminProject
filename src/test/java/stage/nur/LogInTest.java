package stage.nur;

import org.openqa.selenium.By;
import stage.nur.base.BaseTest;
import stage.nur.base.CsvDataProvider;
import stage.nur.pages.LogInPage;
import stage.nur.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LogInTest extends BaseTest {

    @Test(priority = 1, groups = { "positive" })
    public void positiveTest() {
        LogInPage logInPage = new LogInPage(driver, log);

        //Open dice login page
        String expectedPageTitle = "nur.stage.systools.pro";

        String correctUsereName = "Editor admin";
        logInPage.openLogInPage();

        //Fill in email and password
        logInPage.fillUpEmailAndPassword("admin@gmail.com", "P@sword1");

        //Push Sign In button and wait for page profile to load
        DashboardPage dashboardPage = logInPage.pushSignInButton();
        dashboardPage.waitForDashboardPageToLoad();

        //Verifications

        // - Verify title
        log.info("Verifications");
        String actualTitle = dashboardPage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle), "Page title is not expected.\nExpected: "+ expectedPageTitle + "\nActual: " + actualTitle);

        // - Verify correct name on the page
        Assert.assertTrue(dashboardPage.isCorrectProfileLoaded(correctUsereName), "Profile name is not expected");
    }

    @Test(priority = 2, dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, groups = { "negative", "broken"})
    public void negativeTest(Map<String, String> testData) {
        String expectedErrorMessage = "The login or hash you entered is incorrect. Please double check and try again.";

        String testNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");

        log.info("Test No # " + testNumber + " for " + description + " where\nEmail: " + email
                + "\nPassword " + password);

        LogInPage logInPage = new LogInPage(driver, log);

        //Open dice login page
        logInPage.openLogInPage();

        //Fill in email and password
        logInPage.fillUpEmailAndPassword(email, password);

        //Push Sign In button and wait for page profile to load
        logInPage.pushSignInButton();

        String errorMessage = logInPage.getLogInErrorMessage();
         Assert.assertTrue(errorMessage.equals(expectedErrorMessage), "Error message is not expected.\nExpected: " + expectedErrorMessage + "\nActual: " + errorMessage);
   }
}
