package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginSignupPage;
import utilities.JsonReader;

public class TC04_LogoutUser extends BaseTest {

    @Test
    public void logoutUser() {

        // ==========================================
        // Read Test Data From JSON
        // ==========================================

        Map<String, String> loginData =
                JsonReader.getJsonData("login.json");

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
        // Verify Login To Your Account
        // ==========================================

        LoginSignupPage loginSignupPage =
                new LoginSignupPage(driver);

        Assert.assertTrue(
                loginSignupPage.isLoginToYourAccountVisible());

        // ==========================================
        // Step 6
        // Enter Valid Email And Password
        // ==========================================

        loginSignupPage.enterLoginEmail(
                loginData.get("validEmail"));

        loginSignupPage.enterLoginPassword(
                loginData.get("validPassword"));

        // ==========================================
        // Step 7
        // Click Login Button
        // ==========================================

        loginSignupPage.clickLoginButton();

        // ==========================================
        // Step 8
        // Verify Logged In As Username
        // ==========================================

        Assert.assertTrue(
                homePage.isLoggedInAsVisible());

        // ==========================================
        // Step 9
        // Click Logout
        // ==========================================

        homePage.clickLogout();

        // ==========================================
        // Step 10
        // Verify User Is Navigated To Login Page
        // ==========================================

        Assert.assertTrue(
                loginSignupPage.isLoginToYourAccountVisible());
    }
}