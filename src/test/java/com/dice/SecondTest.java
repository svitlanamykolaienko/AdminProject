package com.dice;

import com.dice.base.BaseTest;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

    @Test(alwaysRun = true)
    public void secondTestMethod(){
        driver.get("http://www.linked.in");
        System.out.println("LinkedIN opened");
    }
}
