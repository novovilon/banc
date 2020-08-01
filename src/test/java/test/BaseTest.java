package test;


import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;

public class BaseTest {


    @AfterMethod
    public void finish() {
        DriverSingleton.quit ();
    }
}
