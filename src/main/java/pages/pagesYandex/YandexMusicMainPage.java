package pages.pagesYandex;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BasePage;

public class YandexMusicMainPage extends BasePage {

    final String pageURL = "https://music.yandex.by/home";

    By accountIcon = By.xpath ("//div[contains(@class,'user__userpic user__userpic_size_L')]");
    By loginButton = By.className ("button__label");
    By accountName = By.xpath ("//div[@class='multi-auth__user-name typo']");

    public void open() {
        get (pageURL);
    }

    public YandexMusicMainPage clickLoginButton() {
        click (loginButton);
        return this;
    }

    @Step(value = "Click button account")
    public YandexMusicMainPage clickAccountIcon() {
        windowHandle(0);
        click(accountIcon);
        return this;
    }

    @Step(value = "Compare the names of the user name with the display on the page {0} ")
    public YandexMusicMainPage accountNameAssertTrue(String userName) {
        getText (accountName, userName);
        return this;
    }

}
