// src/test/java/base/BaseTest.java
package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_4");
        options.setPlatformName("Android");
        options.setPlatformVersion("11");
        // options.setApp(System.getProperty("user.dir")
        //         + "/src/test/resources/apps/mm.com.wavemoney.wavepay_2.2.0-1460_minAPI21(arm64-v8a,armeabi-v7a,x86,x86_64)(nodpi)_apkmirror.com.apk");
        options.setAppPackage("mm.com.wavemoney.wavepay");
        options.setAppActivity("mm.com.wavemoney.wavepay.ui.view.MainActivity");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(false);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}