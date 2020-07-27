package test;


import io.qameta.allure.*;
import org.testng.annotations.Test;

public class AuthorizationTest extends TestBase {

    @Epic ("TESTING FOR Банк санкт-петербург ")
    @Feature (value = "Authorization")
    @Severity (SeverityLevel.BLOCKER)
    @Description("go to the authorization page and check it for availability")
    @Story ("test for the presence of an authorization page")
    @Test
    public void smokeTest() {
        authorization
                .logoIsVisible ();
    }

    @Epic ("TESTING FOR Банк санкт-петербург ")
    @Feature (value = "Authorization")
    @Severity (SeverityLevel.CRITICAL)
    @Description("enter valid authorization data and check that we have passed the first stage of authorization")
    @Story ("test for login with valid credentials")
    @Test
    public void positiveTestAuthorization() {
        authorization
                .fillInUserName ("demo")
                .fillInPassword ("demo")
                .enter ();
        confirmationPage
                .verificationMessagesIsVisible ();
    }

    @Epic ("TESTING FOR Банк санкт-петербург ")
    @Feature (value = "Authorization")
    @Severity (SeverityLevel.MINOR)
    @Description("enter incorrect authorization data and make sure that we see a warning")
    @Story ("test for login with invalid credentials")
    @Test
    public void negativeTestAuthorizationNoPassword() {
        authorization
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
    public void negativeTestAuthorizationNoUserName() {
        authorization
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
    public void negativeTestAuthorizationNoLoginNoPassword() {
        authorization
                .noUserName ()
                .noPassword ()
                .enter ()
                .errorIsVisible ();
    }
}