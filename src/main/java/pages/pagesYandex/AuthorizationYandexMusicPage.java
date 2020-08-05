package pages.pagesYandex;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BasePage;

public class AuthorizationYandexMusicPage extends BasePage {
    final String pageURL = "https://passport.yandex.by/auth?origin=music_button-header&retpath=https%3A%2F%2Fmusic" +
            ".yandex.by%2Fsettings%3Freqid%3D50800214015958618805943356014739769%26from-passport";

    By userName = By.id("passp-field-login");
    By password = By.id("passp-field-passwd");
    By errorMessages = By.xpath("//div[@class='passp-form-field__error']");

    @Step(value = "Fill in login with {0}, press enter")
    public AuthorizationYandexMusicPage fillInUserNameEnter(String text) {
        windowHandle(1);
        writeTextEnter(userName, text);
        return this;
    }

    @Step(value = "Fill in password with {0}, press enter")
    public AuthorizationYandexMusicPage fillInPasswordEnter(String text) {
        writeTextEnter(password, text);
        return this;
    }

    @Step(value = "test for error messages")
    public AuthorizationYandexMusicPage errorMessagesIsDisplayed(){
        isElementDisplayed(errorMessages);
        return this;
    }


}
