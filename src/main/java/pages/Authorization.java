package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Authorization extends BasePage {
    final String pageURL = "https://idemo.bspb" +
            ".ru/auth?response_type=code&client_id=1&redirect_uri=https%3A%2F%2Fidemo" +
            ".bspb.ru%2Flogin%2Fsuccess&prefetch_uri=https%3A%2F%2Fidemo.bspb" +
            ".ru%2Flogin%2Fprefetch&force_new_session=true";

    By logo = By.id ("logo");
    By userName = By.xpath ("//input[@placeholder='Логин']");
    By password = By.xpath ("//input[@placeholder='Пароль']");
    By loginButton = By.id ("login-button");
    By error = By.xpath ("//div[@class='alert alert-error']");

    public Authorization(WebDriver driver) {
        super (driver);
    }


    public Authorization open() {
        driver.get (pageURL);
        return this;
    }

    @Step(value = "logo is visible")
    public Authorization logoIsVisible() {
        isElementDisplayed (logo);
        return this;
    }

    @Step(value = "Fill in login with {0}")
    public Authorization fillInUserName(String text) {
        writeText (userName, text);
        return this;
    }

    @Step(value = "Fill in password with {0}")
    public Authorization fillInPassword(String text) {
        writeText (password, text);
        return this;
    }

    @Step (value = "The empty user name field")
    public Authorization noUserName() {
        noText (userName);
        return this;
    }

    @Step (value = "The empty password field")
    public Authorization noPassword() {
        noText (password);
        return this;
    }

    @Step (value = "Click button login")
    public Authorization enter() {
        click (loginButton);
        return this;
    }

    @Step (value = "Error is visible")
    public Authorization errorIsVisible() {
        waitVisibility (error);
        isElementDisplayed (error);
        return this;
    }
}
