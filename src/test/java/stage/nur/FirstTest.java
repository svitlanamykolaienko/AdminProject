package stage.nur;

import stage.nur.base.BaseTest;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test (alwaysRun = true)
    public void firstTestMethod(){
        driver.get("http://www.dice.com");
        log.info("Dice opened");
    }


}
