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
        authorizationYandexMusicPage = new AuthorizationYandexMusicPage();
        yandexMusicMainPage = new YandexMusicMainPage();
        yandexMusicMainPage.open();
    }

    @Epic("TESTING FOR Яндекс.Музыка ")
    @Feature(value = "Authorization")
    @Severity(SeverityLevel.CRITICAL)
    @Description("enter valid authorization details and make sure we have passed the authorization step")
    @Story ("test for login with valid credentials")
    @Test
    public void positiveTestYandexMusicAuthorization() {
        yandexMusicMainPage
                .clickLoginButton();
        authorizationYandexMusicPage
                .fillInUserNameEnter("test.y4ndex913.test.test")
                .fillInPasswordEnter("zyf2971313");
        yandexMusicMainPage
                .clickAccountIcon()
                .accountNameAssertTrue("test.y4ndex913.test.test");
    }

    @Epic("TESTING FOR Яндекс.Музыка ")
    @Feature(value = "Authorization")
    @Severity(SeverityLevel.CRITICAL)
    @Description("enter not valid authorization data and make sure that we have not passed the authorization stage")
    @Story ("test for login with not valid credentials")
    @Test
    public void negativeTestYandexMusicAuthorization() {
        yandexMusicMainPage
                .clickLoginButton();
        authorizationYandexMusicPage
                .fillInUserNameEnter("test.y4ndex913.test.test")
                .fillInPasswordEnter("zyf29713")
                .errorMessagesIsDisplayed ();
    }

    @Epic("TESTING FOR Яндекс.Музыка ")
    @Feature(value = "Authorization")
    @Severity(SeverityLevel.CRITICAL)
    @Description("enter not valid authorization data and make sure that we have not passed the authorization stage")
    @Story ("test for logging in without a password")
    @Test
    public void negativeTestYandexMusicAuthorizationNoPassword() {
        yandexMusicMainPage
                .clickLoginButton();
        authorizationYandexMusicPage
                .fillInUserNameEnter("test.y4ndex913.test.test")
                .fillInPasswordEnter("")
                .errorMessagesIsDisplayed();
    }

    @Epic("TESTING FOR Яндекс.Музыка ")
    @Feature(value = "Authorization")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("not a working test to check if a screenshot is possible")
    @Story ("test, log in with valid credentials")
    @Test
    public void notAWorkingTest() {
        yandexMusicMainPage
                .clickLoginButton();
        authorizationYandexMusicPage
                .fillInUserNameEnter("test.y4ndex913.test.test")
                .fillInPasswordEnter("zyf2971313");
        yandexMusicMainPage
                .clickAccountIcon()
                .accountNameAssertTrue("test.y4ndex913.test");
    }

}
