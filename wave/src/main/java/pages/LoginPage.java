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

    @AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id=\"mm.com.wavemoney.wavepay:id/spinner\"]/android.view.ViewGroup\n")
    private WebElement english;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"mm.com.wavemoney.wavepay:id/rv_language_list\"]/android.view.ViewGroup[2]")
    private WebElement englishButton;

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement loginButton;

    @AndroidFindBy(id = "mm.com.wavemoney.wavepay:id/et_misdn")
    private WebElement phoneInput;

    @AndroidFindBy(id = "mm.com.wavemoney.wavepay:id/btn_confirm")
    private WebElement tick;

    @AndroidFindBy(id = "mm.com.wavemoney.wavepay:id/cbTnC")
    private WebElement clickTool;

    @AndroidFindBy(id = "mm.com.wavemoney.wavepay:id/btn_continue")
    private WebElement submitButton;

    @AndroidFindBy(id = "mm.com.wavemoney.wavepay:id/tv_error_message")
    private WebElement errorMessage;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pageLang() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(english));
        english.click();
        wait.until(ExpectedConditions.elementToBeClickable(englishButton));
        englishButton.click();

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

    public void clickTool() {
        clickTool.click();
    }

    public void clickSubmit() {

        submitButton.click();

    }

    public void confirm() {
        tick.click();
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
