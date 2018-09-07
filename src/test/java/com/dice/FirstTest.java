package com.dice;

import com.dice.base.BaseTest;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test (alwaysRun = true)
    public void firstTestMethod(){
        driver.get("http://www.dice.com");
        System.out.println("Dice opened");
    }


}
