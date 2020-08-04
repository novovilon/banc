package test.bakcTast;


import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.pagesBank.AuthorizationBankPage;
import pages.pagesBank.ConfirmationPageBank;
import test.BaseTest;

public class AuthorizationTestBank extends BaseTest {
    AuthorizationBankPage authorizationBankPage;
    ConfirmationPageBank confirmationPageBank;


    @BeforeMethod
    public void setup(){
        authorizationBankPage = new AuthorizationBankPage();
        confirmationPageBank = new ConfirmationPageBank ();
        authorizationBankPage.open ();
    }

    @Epic ("TESTING FOR Банк санкт-петербург ")
    @Feature (value = "Authorization")
    @Severity (SeverityLevel.BLOCKER)
    @Description("go to the authorization page and check it for availability")
    @Story ("test for the presence of an authorization page")
    @Test
    public void smokeTestBank() {
        authorizationBankPage
                .logoIsVisible ();
    }

    @Epic ("TESTING FOR Банк санкт-петербург ")
    @Feature (value = "Authorization")
    @Severity (SeverityLevel.CRITICAL)
    @Description("enter valid authorization data and check that we have passed the first stage of authorization")
    @Story ("test for login with valid credentials")
    @Test
    public void positiveTestAuthorizationBank() {
        authorizationBankPage
                .fillInUserName ("demo")
                .fillInPassword ("demo")
                .enter ();
        confirmationPageBank
                .verificationMessagesIsVisible ();
    }

    @Epic ("TESTING FOR Банк санкт-петербург ")
    @Feature (value = "Authorization")
    @Severity (SeverityLevel.MINOR)
    @Description("enter incorrect authorization data and make sure that we see a warning")
    @Story ("test for login with invalid credentials")
    @Test
    public void negativeTestAuthorizationBankNoPassword() {
        authorizationBankPage
                .fillInUserName ("demo")
                .noPassword ()
                .enter ()
                .errorIsVisible ();
    }

    @Epic ("TESTING FOR Банк санкт-петербург ")
    @Feature (value = "Authorization")
    @Severity (SeverityLevel.MINOR)
    @Description("enter incorrect authorization data and make sure that we see a warning")
    @Story ("test for login with invalid credentials")
    @Test
    public void negativeTestAuthorizationBankNoUserName() {
        authorizationBankPage
                .noUserName ()
                .fillInPassword ("demo")
                .enter ()
                .errorIsVisible ();
    }

    @Epic ("TESTING FOR Банк санкт-петербург ")
    @Feature (value = "Authorization")
    @Severity (SeverityLevel.MINOR)
    @Description("enter incorrect authorization data and make sure that we see a warning")
    @Story ("test for login with invalid credentials")
    @Test
    public void negativeTestAuthorizationBankNoLoginNoPassword() {
        authorizationBankPage
                .noUserName ()
                .noPassword ()
                .enter ()
                .errorIsVisible ();
    }

}