// src/test/java/tests/LoginTests.java
package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "TC_LOGIN_001: Login With Correct phone number")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.skipOnboardingIfPresent();
        loginPage.clickLoginButton();
        loginPage.enterPhoneNumber("0812345678");
        loginPage.clickSubmit();

        // Verify successful login
        // Add assertion based on success indicator
    }

    @Test(description = "TC_LOGIN_002: Login With invalid phone number")
    public void testInvalidPhoneNumber() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.skipOnboardingIfPresent();
        loginPage.clickLoginButton();
        loginPage.enterPhoneNumber("0970177078");
        loginPage.clickSubmit();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "หมายเลขนี้ไม่ใช่หมายเลขดีแทค กรุณาใช้หมายเลขดีแทคเพื่อลองใหม่อีกครั้ง");
    }

    @Test(description = "TC_LOGIN_VAL")
    public void testValidate() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.skipOnboardingIfPresent();
        loginPage.clickLoginButton();
        String[] testPhoneNumbers = {
                "", // กรณีว่าง
                "098929", // สั้นเกินไป
                "081234567890", // ยาวเกิน
                "2012345678" // ขึ้นต้นผิด
        };
        for (String phone : testPhoneNumbers) {
            loginPage.clearPhoneInput(); // method ที่คุณต้องมีไว้เคลียร์ field
            loginPage.enterPhoneNumber(phone);
            loginPage.clickSubmit();

            // ตรวจสอบว่า error message แสดง
            Assert.assertFalse(loginPage.isSubmitButtonEnabled(),
                    "ปุ่มเข้าสู่ระบบควรจะถูกปิดใช้งานเมื่อไม่มีการกรอกข้อมูล");
        }

    }
}