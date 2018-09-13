package stage.nur.pages;

import org.openqa.selenium.JavascriptExecutor;
import stage.nur.base.BasePageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePageObject<DashboardPage> {
    private By dropDown = By.xpath("//div[@data-test = 'dropdown']");
    private By addTaskButton = By.xpath("//button[@data-test = 'add-task-button']");
    private By userNameText = By.xpath("//div[@class = 'header__text_m2Dj_']");

    public DashboardPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void waitForDashboardPageToLoad(){
        log.info("Waiting for dashboard to load");
        waitForVisibilityOf(dropDown,10);
        waitForVisibilityOf(addTaskButton, 20);
    }

    public boolean isCorrectProfileLoaded(String correctUserName){
        if (getText(userNameText).equals(correctUserName)){
            return true;
        }
        return false;

    }
}
