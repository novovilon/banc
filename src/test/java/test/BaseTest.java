package test;


import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {


    @AfterMethod(alwaysRun = true)
    public void finish() {

            DriverSingleton.quit();


    }




}
