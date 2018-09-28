package stage.nur.pages;

import stage.nur.base.BasePageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePageObject<LogInPage> {
    private static String URL;



    private By emailField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By signInButton = By.xpath("//button[@type = 'submit']");
    private By errorMessage = By.xpath("//div[@class = 'errors__errors_1UK5p animation__fadeIn_3l1Lz']");


    public LogInPage(WebDriver driver, Logger log){
        super(driver, log);
        setUrl();
    }

    private void setUrl(){
     if (System.getProperty("url")!=null){
         URL = System.getProperty("url");
     }else{
         URL = "https://admin.nur.stage.systools.pro";
     }

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
