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
        loginPage.pageLang();
        loginPage.clickLoginButton();
        loginPage.enterPhoneNumber("081234567");
        loginPage.clickTool();
        loginPage.clickSubmit();
        loginPage.confirm();

    }

    @Test(description = "TC_LOGIN_VAL")
    public void testValidate() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.pageLang();
        loginPage.clickLoginButton();
        loginPage.clickTool();
        String[] testPhoneNumbers = {
                "", // กรณีว่าง
                "098929", // สั้นเกินไป
                "081234567890", // ยาวเกิน
        };
        for (String phone : testPhoneNumbers) {
            loginPage.clearPhoneInput(); // method ที่คุณต้องมีไว้เคลียร์ field
            loginPage.enterPhoneNumber(phone);
            loginPage.clickSubmit();

            if (phone.isEmpty()) {
                Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                        "Please enter mobile number.");
            } else {
                Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                        "Please enter valid mobile number.");
            }
        }

    }
}