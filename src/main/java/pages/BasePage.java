package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait (driver, 10);

    }

    //ожедания элемента
    public void waitVisibility(By elementBy) {
        wait.until (ExpectedConditions.visibilityOfAllElementsLocatedBy (elementBy));
    }

    //клик по элементу
    public void click(By elementBy) {
        waitVisibility (elementBy);
        driver.findElement (elementBy).click ();
    }

    //проверка на отображения элемента
    public void isElementDisplayed(By elementBy) {
        waitVisibility (elementBy);
        assertTrue (driver.findElement (elementBy).isDisplayed ());
    }

    //заолнения поля текстом
    public void writeText(By elementBy, String text) {
        waitVisibility (elementBy);
        WebElement element = driver.findElement (elementBy);
        element.clear ();
        element.sendKeys (text);
    }

    //пустое поле
    public void noText(By elementBy) {
        waitVisibility (elementBy);
        WebElement element = driver.findElement (elementBy);
        element.clear ();
    }

}
