package pages;


import driver.DriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import static org.testng.AssertJUnit.assertTrue;

public class BasePage {
    private WebDriver webDriver = DriverSingleton.getDriver ();

    public void get(String text) {
        webDriver.get (text);
    }

    //переключиться на другое окно
    public void windowHandle() {
        for (String windowHandle : webDriver.getWindowHandles ()) {
            webDriver.switchTo ().window (windowHandle);
        }
    }

    //Сравниваются введенные данные и полученный тест с странички
    public void getText(By elementBy, String text) {
        WebElement element = webDriver.findElement (elementBy);
        assertTrue (element.getText ().equals (text));

    }

    //клик по элементу
    public void click(By elementBy) {
        Waiters.waitForElementVisible (webDriver, elementBy);
        Waiters.waitForElementClickable (webDriver, elementBy);
        webDriver.findElement (elementBy).click ();
    }

    //проверка на отображения элемента
    public void isElementDisplayed(By elementBy) {
        Waiters.waitForElementVisible (webDriver, elementBy);
        Waiters.waitForElementClickable (webDriver, elementBy);
        assertTrue (webDriver.findElement (elementBy).isDisplayed ());
    }

    //заолнения поля текстом
    public void writeText(By elementBy, String text) {
        Waiters.waitForElementVisible (webDriver, elementBy);
        Waiters.waitForElementClickable (webDriver, elementBy);
        WebElement element = webDriver.findElement (elementBy);
        element.clear ();
        element.sendKeys (text);
    }

    //пустое поле
    public void noText(By elementBy) {
        Waiters.waitForElementVisible (webDriver, elementBy);
        Waiters.waitForElementClickable (webDriver, elementBy);
        WebElement element = webDriver.findElement (elementBy);
        element.clear ();
    }

    //заполняем поля текстом и нажать ENTER
    public void writeTextEnter(By elementBy, String text) {
        Waiters.waitForElementVisible (webDriver, elementBy);
        Waiters.waitForElementClickable (webDriver, elementBy);
        WebElement element = webDriver.findElement (elementBy);
        element.clear ();
        element.sendKeys (text);
        element.sendKeys (Keys.ENTER);
    }

    //клик при помощи Js
    public void clickJs(By elementBy) {
        Waiters.waitForElementVisible (webDriver, elementBy);
        Waiters.waitForElementClickable (webDriver, elementBy);
        WebElement button = webDriver.findElement (elementBy);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript ("arguments[0].click();", button);
    }

    //проверка на отображения элемента Js
    public void isElementDisplayedJs(By elementBy) {
        Waiters.waitForElementVisible (webDriver, elementBy);
        Waiters.waitForElementClickable (webDriver, elementBy);
        WebElement ele = webDriver.findElement (elementBy);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        String assets = (String) js.executeScript ("return arguments[0]" +
                ".getElementsByTagName('span')[1].textContent;", ele);
    }

}
