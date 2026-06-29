package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginSignupPage;
import utilities.JsonReader;

public class TC05_RegisterUserWithExistingEmail extends BaseTest {

    @Test
    public void registerUserWithExistingEmail() {

        // ==========================================
        // Read Test Data From JSON
        // ==========================================

        Map<String, String> userData =
                JsonReader.getJsonData("existingUser.json");

        // ==========================================
        // Step 1,2,3
        // Launch Browser + Navigate URL + Verify Home Page
        // ==========================================

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageVisible());

        // ==========================================
        // Step 4
        // Click Signup / Login
        // ==========================================

        homePage.clickSignupLogin();

        // ==========================================
        // Step 5
        // Verify New User Signup Is Visible
        // ==========================================

        LoginSignupPage loginSignupPage =
                new LoginSignupPage(driver);

        Assert.assertTrue(
                loginSignupPage.isNewUserSignupVisible());

        // ==========================================
        // Step 6 & 7
        // Enter Name + Existing Email
        // Click Signup
        // ==========================================

        loginSignupPage.enterSignupData(
                userData.get("name"),
                userData.get("email"));

        // ==========================================
        // Step 8
        // Verify Email Already Exists Message
        // ==========================================

        Assert.assertTrue(
                loginSignupPage.isEmailAlreadyExistsMessageVisible());
    }
}