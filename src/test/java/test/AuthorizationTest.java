package test;


import org.testng.annotations.Test;

public class AuthorizationTest extends TestBase {


    @Test
    public void smokeTest() {
        authorization
                .logoIsVisible ();
    }

    @Test
    public void positiveTestAuthorization() {
        authorization
                .fillInUserName ("demo")
                .fillInPassword ("demo")
                .enter ();
        confirmationPage
                .verificationMessagesIsVisible ();
    }

    @Test
    public void negativeTestAuthorizationNoPassword() {
        authorization
                .fillInUserName ("demo")
                .noPassword ()
                .enter ()
                .errorIsVisible ();
    }

    @Test
    public void negativeTestAuthorizationNoUserName() {
        authorization
                .noUserName ()
                .fillInPassword ("demo")
                .enter ()
                .errorIsVisible ();
    }

    @Test
    public void negativeTestAuthorizationNoLoginNoPassword() {
        authorization
                .noUserName ()
                .noPassword ()
                .enter ()
                .errorIsVisible ();
    }
}