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
        options.setApp("dtac/src/test/resources/apps/th.co.crie.tron2.android_10.29.1-10290100_minAPI23(arm64-v8a,armeabi,armeabi-v7a,x86,x86_64)(nodpi)_apkmirror.com.apk");
        options.setAppPackage("th.co.crie.tron2.android");
        options.setAppActivity("com.portonics.dtac.ui.splash.SplashActivity");
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