package test.yandexTest;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.pagesYandex.AuthorizationYandexMusicPage;
import pages.pagesYandex.YandexMusicMain;
import test.BaseTest;

public class YandexMusicTest extends BaseTest {
    AuthorizationYandexMusicPage authorizationYandexMusicPage;
    YandexMusicMain yandexMusicMain;

    @BeforeMethod
    public void setup(){
        authorizationYandexMusicPage = new AuthorizationYandexMusicPage ();
        yandexMusicMain = new YandexMusicMain ();
        yandexMusicMain.open ();

    }

    @Epic("TESTING FOR Яндекс.Музыка ")
    @Feature(value = "Authorization")
    @Severity(SeverityLevel.CRITICAL)
    @Description("enter valid authorization data and check that we have passed the first stage of authorization")
    @Story ("test for login with valid credentials")
    @Test
    public void positiveTestYandexMusicAuthorization() throws InterruptedException {
        yandexMusicMain
                .clickLoginButton ();
        authorizationYandexMusicPage
                .fillInUserNameEnter ("test.y4ndex913.test.test")
                .fillInPasswordEnter ("zyf2971313");
        Thread.sleep (10000);
        yandexMusicMain.clickAccountIcon();
        Thread.sleep (5000);
        yandexMusicMain.accountNameAssertTrue("test.y4ndex913.test.test");


    }
}
