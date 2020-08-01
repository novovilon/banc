package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {

    public static void waitForElementVisible(WebDriver webDriver, By elementBy) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20), Duration.ofMillis(7000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }
    public static void waitForElementClickable(WebDriver webDriver, By elementBy) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20), Duration.ofMillis(7000));
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }
}
