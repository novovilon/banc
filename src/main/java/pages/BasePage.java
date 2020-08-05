package pages;


import driver.DriverSingleton;
import org.openqa.selenium.*;
import utils.Waiters;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertTrue;

public class BasePage {
    private WebDriver webDriver = DriverSingleton.getDriver ();
    private ArrayList<String> tabs;

    public void get(String text) {
        webDriver.get(text);
    }


    //Сравниваются введенные данные и полученный тест с странички
    public void getText(By elementBy, String text) {
        WebElement element = webDriver.findElement(elementBy);
        assertTrue(element.getText ().equals (text));
    }

    //клик по элементу
    public void click(By elementBy) {
        webDriver.findElement(elementBy).click ();
    }

    //проверка на отображения элемента
    public void isElementDisplayed(By elementBy) {
        assertTrue(webDriver.findElement(elementBy).isDisplayed ());
    }

    //заолнения поля текстом
    public void writeText(By elementBy, String text) {
        WebElement element = webDriver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
    }

    //пустое поле
    public void noText(By elementBy) {
        Waiters.waitForElementVisible(webDriver, elementBy);
        Waiters.waitForElementClickable(webDriver, elementBy);
        WebElement element = webDriver.findElement(elementBy);
        element.clear();
    }

    //заполняем поля текстом и нажать ENTER
    public void writeTextEnter(By elementBy, String text) {
        WebElement element = webDriver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    //переключения странички
    public void windowHandle() {
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
    }

    //выбор странички
    public void windowHandle(int tab) {
        if (tabs == null) {
            tabs = new ArrayList<> (webDriver.getWindowHandles());
        }
        webDriver.switchTo().window(tabs.get(tab));
    }

    //клик при помощи Js
    public void clickJs(By elementBy) {
        WebElement button = webDriver.findElement (elementBy);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", button);
    }

    //проверка на отображения элемента Js
    public void isElementDisplayedJs(By elementBy) {
        WebElement ele = webDriver.findElement(elementBy);
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        String assets = (String) js.executeScript("return arguments[0]" +
                ".getElementsByTagName('span')[1].textContent;", ele);
    }

}
