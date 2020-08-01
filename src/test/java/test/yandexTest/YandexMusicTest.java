package test.yandexTest;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.pagesYandex.AuthorizationYandexMusicPage;
import pages.pagesYandex.YandexMusicMainPage;
import test.BaseTest;

public class YandexMusicTest extends BaseTest {
    AuthorizationYandexMusicPage authorizationYandexMusicPage;
    YandexMusicMainPage yandexMusicMainPage;

    @BeforeMethod
    public void setup(){
        authorizationYandexMusicPage = new AuthorizationYandexMusicPage ();
        yandexMusicMainPage = new YandexMusicMainPage ();
        yandexMusicMainPage.open ();
    }

    @Epic("TESTING FOR Яндекс.Музыка ")
    @Feature(value = "Authorization")
    @Severity(SeverityLevel.CRITICAL)
    @Description("enter valid authorization data and check that we have passed the first stage of authorization")
    @Story ("test for login with valid credentials")
    @Test
    public void positiveTestYandexMusicAuthorization() {
        yandexMusicMainPage
                .clickLoginButton ();
        authorizationYandexMusicPage
                .fillInUserNameEnter ("test.y4ndex913.test.test")
                .fillInPasswordEnter ("zyf2971313");
        yandexMusicMainPage
                .clickAccountIcon()
                .accountNameAssertTrue("test.y4ndex913.test.test");


    }
}
