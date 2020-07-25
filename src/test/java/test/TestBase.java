package test;


import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Authorization;
import pages.ConfirmationPage;

public class TestBase {

    public WebDriver driver;
    public Authorization authorization;
    public ConfirmationPage confirmationPage;

    @BeforeMethod
    public void start() {
        driver = DriverSingleton.getDriver ();
        authorization = PageFactory.initElements (driver, Authorization.class);
        confirmationPage = PageFactory.initElements (driver, ConfirmationPage.class);
        authorization.open ();
    }

    @AfterMethod
    public void finish() {
        DriverSingleton.quit ();
    }
}
