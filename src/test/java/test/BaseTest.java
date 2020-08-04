package test;


import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;


public class BaseTest {


    @AfterMethod(alwaysRun = true)
    public void finish() {

            DriverSingleton.quit();


    }




}
