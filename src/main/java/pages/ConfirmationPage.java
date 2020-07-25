package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage {

    final String pageURL = "https://idemo.bspb.ru/auth/otp?authOptionId=SMS%3A10005";


    public ConfirmationPage(WebDriver driver) {
        super (driver);
    }

    By verificationMessages = By.id ("otp-code-text");

    public ConfirmationPage verificationMessagesIsVisible() {
        isElementDisplayed (verificationMessages);
        return this;
    }

}
