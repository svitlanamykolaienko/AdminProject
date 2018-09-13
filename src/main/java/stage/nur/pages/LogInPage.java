package stage.nur.pages;

import stage.nur.base.BasePageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePageObject<LogInPage> {
    private static final String URL = "https://admin.nur.stage.systools.pro/login";

    private By emailField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By signInButton = By.xpath("//button[@type = 'submit']");
    private By errorMessage = By.xpath("//div[@class = 'errors__errors_1UK5p animation__fadeIn_3l1Lz']");
    //private By errorMessage = By.xpath("//span[@data-automation-id=\"login-failure-help-message\"]");


    public LogInPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void openLogInPage(){
        getPage(URL);
    }

    public void fillUpEmailAndPassword(String email, String password){
        log.info("Filling in email and password");
        waitForVisibilityOf(emailField,10);
        type(email, emailField);
        type(password, passwordField);
    }

    public DashboardPage pushSignInButton(){
        log.info("Clicking in on submit button");
        click(signInButton);
        return new DashboardPage(driver,log);
    }


    public String getLogInErrorMessage() {
        waitForVisibilityOf(errorMessage, 10);
        return getText(errorMessage);
    }
}
