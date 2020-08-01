package pages.pagesBank;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ConfirmationPageBank extends BasePage {

    final String pageURL = "https://idemo.bspb.ru/auth/otp?authOptionId=SMS%3A10005";


    By verificationMessages = By.id ("otp-code-text");

    @Step (value = "verification messages is visible")
    public ConfirmationPageBank verificationMessagesIsVisible() {
        isElementDisplayed (verificationMessages);
        return this;
    }

}
