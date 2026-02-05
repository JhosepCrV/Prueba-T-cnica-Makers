package com.makers.qa.tests;

import com.makers.qa.pages.InventoryPage;
import com.makers.qa.pages.LoginPage;
import com.makers.qa.utils.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSmokeTest extends BaseTest {

    @Test
    void loginSuccessWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(TestData.VALID_USERNAME, TestData.VALID_PASSWORD);

        InventoryPage inventoryPage = new InventoryPage(driver, wait);
        assertTrue(inventoryPage.isLoaded(), "Inventory page should be visible after login");
    }

    @Test
    void loginFailsWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(TestData.VALID_USERNAME, TestData.INVALID_PASSWORD);

        String error = loginPage.getErrorMessage();
        assertTrue(error.contains(TestData.ERROR_INVALID_CREDENTIALS));
    }

    @Test
    void loginShowsErrorWhenUsernameIsMissing() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(null, TestData.VALID_PASSWORD);

        String error = loginPage.getErrorMessage();
        assertTrue(error.contains(TestData.ERROR_USERNAME_REQUIRED));
    }

    @Test
    void loginShowsErrorWhenPasswordIsMissing() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(TestData.VALID_USERNAME, null);

        String error = loginPage.getErrorMessage();
        assertTrue(error.contains(TestData.ERROR_PASSWORD_REQUIRED));
    }

    @Test
    void loginShowsErrorWhenBothFieldsAreMissing() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(null, null);

        String error = loginPage.getErrorMessage();
        assertTrue(error.contains(TestData.ERROR_USERNAME_REQUIRED));
    }
}


