package utils;

import driver.DriverSingleton;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private WebDriver webDriver = DriverSingleton.getDriver ();

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshotOnFailure(webDriver);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        saveScreenshotOnFailure(webDriver);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshotOnFailure(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs (OutputType.BYTES);
    }
}
