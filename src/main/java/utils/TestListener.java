package utils;

import driver.DriverSingleton;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {



    @Override
    public void onTestFailure(ITestResult result) {
        ScreenShotService.saveScreenshot();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ScreenShotService.saveScreenshot();
    }


}
