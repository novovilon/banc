package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.WebDriverListener;

import java.util.concurrent.TimeUnit;


public class DriverSingleton {
    private static EventFiringWebDriver driver;



    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            driverStart();
        }
        return driver;
    }

    private static void driverStart(){
        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeDriver ());
        driver.register(new WebDriverListener());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void quit() {
        if (driver != null) {
            driver.quit ();
            driver = null;
        }
    }
}