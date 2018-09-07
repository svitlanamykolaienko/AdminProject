package com.dice;

import com.dice.base.BaseTest;
import com.dice.pages.LogInPage;
import com.dice.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void positiveTest() {
        LogInPage logInPage = new LogInPage(driver);
        //Open dice login page
        String expectedPafeTitle = "Seeker Dashboard - Profile";
        String correctProfileName = "Svitlana Mykolaienko";
        logInPage.openLogInPage();
        //Fill in email and password
        logInPage.fillUpEmailAndPassword("svetlana.mikolaenko@gmail.com", "Svitlana1!");
        //Push Sign In button and wait for page profile to load
        ProfilePage profilePage = logInPage.pushSignInButton();
        profilePage.waitForProfilePageToLoad();
        //Verifications
        // - Verify title
        System.out.println("Verifications: ");
        String actualTitle = profilePage.getTitle();
        Assert.assertTrue(expectedPafeTitle.equals(actualTitle), "Page title is not expected.\nExpectedActual: " + actualTitle);
        // - Verify correct name on the page
        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected");
    }

    @Test
    public void negativeTest() {
        String expectedErrorMessage = "Email and/or password incorrect. Please use the \"Forgot password?\" link, or contact Dice at techsupport@dice.com.";
        LogInPage logInPage = new LogInPage(driver);

        //Open dice login page
        logInPage.openLogInPage();

        //Fill in email and password
        logInPage.fillUpEmailAndPassword("hello123@gmail.com", "Svitlana1!");

        //Push Sign In button and wait for page profile to load
        logInPage.pushSignInButton();

        String errorMessage = logInPage.getLogInErrorMessage();
         Assert.assertTrue(errorMessage.equals(expectedErrorMessage), "Error message is not expected.\nExpected: " + expectedErrorMessage + "\nActual: " + errorMessage);
   }
}
