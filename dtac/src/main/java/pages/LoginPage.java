// src/main/java/pages/LoginPage.java
package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private AndroidDriver driver;

    @AndroidFindBy(id = "th.co.crie.tron2.android:id/tvSkip")
    private WebElement skipButton;

    @AndroidFindBy(id = "th.co.crie.tron2.android:id/btnLogin")
    private WebElement loginButton;

    @AndroidFindBy(id = "th.co.crie.tron2.android:id/etMsisdn")
    private WebElement phoneInput;

    @AndroidFindBy(id = "th.co.crie.tron2.android:id/btnSignIn")
    private WebElement submitButton;

    @AndroidFindBy(id = "th.co.crie.tron2.android:id/tvMsisdnError")
    private WebElement errorMessage;

    public void skipOnboardingIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(skipButton));
            skipButton.click();
        } catch (Exception e) {
        }
    }

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void enterPhoneNumber(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }

    public void clearPhoneInput() {
        phoneInput.clear();
    }
}
