package stage.nur;

import stage.nur.base.BaseTest;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

    @Test(alwaysRun = true)
    public void secondTestMethod(){
        driver.get("http://www.linked.in");
        log.info("LinkedIN opened");
    }
}
