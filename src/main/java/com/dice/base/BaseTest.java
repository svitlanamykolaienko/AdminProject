package com.dice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    protected void methodSetUp(){
        System.out.println("Method Set Up");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        driver = new FirefoxDriver();
    }

    @AfterMethod(alwaysRun = true)
    protected void methodTearDown(){
        System.out.println("Method Tear Down");

        driver.quit();
    }

}
