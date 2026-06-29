package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountCreatedPage;
import pages.AccountDeletedPage;
import pages.HomePage;
import pages.LoginSignupPage;
import pages.SignupPage;
import utilities.JsonReader;

public class TC02_ValidLogin extends BaseTest {

    @Test
    public void loginUserWithCorrectEmailAndPassword() {

        // Test Data
        // Read Data From JSON File

        Map<String, String> registerData =
                JsonReader.getJsonData("register.json");

        String name =
                registerData.get("name");

        String email =
                "mohamed" + System.currentTimeMillis() + "@gmail.com";

        String password =
                registerData.get("password");

        // Initialize Page Objects

        HomePage homePage = new HomePage(driver);
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
        SignupPage signupPage = new SignupPage(driver);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);

        // Step 1,2,3
        // Launch Browser + Navigate URL + Verify Home Page

        Assert.assertEquals(
                driver.getTitle(),
                "Automation Exercise");

        // Step 4
        // Click Signup / Login

        homePage.clickSignupLogin();

        // Precondition
        // Create New Account To Keep Test Independent
        loginSignupPage.enterSignupData(name, email);

        // Verify Enter Account Information Page
        Assert.assertTrue(signupPage.isEnterAccountInformationVisible());

        // Fill Account Information
        signupPage.selectMrTitle();
        signupPage.enterPassword(password);
        signupPage.selectDateOfBirth(
                registerData.get("day"),
                registerData.get("month"),
                registerData.get("year"));

        // Select Newsletter & Special Offers
        signupPage.selectNewsletter();
        signupPage.selectSpecialOffers();

        // Fill Address Information
        signupPage.enterFirstName(
                registerData.get("firstName"));

        signupPage.enterLastName(
                registerData.get("lastName"));

        signupPage.enterCompany(
                registerData.get("company"));

        signupPage.enterAddress(
                registerData.get("address1"));

        signupPage.enterAddress2(
                registerData.get("address2"));

        signupPage.selectCountry(
                registerData.get("country"));

        signupPage.enterState(
                registerData.get("state"));

        signupPage.enterCity(
                registerData.get("city"));

        signupPage.enterZipCode(
                registerData.get("zipcode"));

        signupPage.enterMobileNumber(
                registerData.get("mobileNumber"));

        // Create Account
        signupPage.clickCreateAccount();

        // Verify Account Created
        Assert.assertTrue(accountCreatedPage.isAccountCreatedVisible());

        // Continue To Home Page
        accountCreatedPage.clickContinue();

        // Verify Logged In
        Assert.assertTrue(homePage.isLoggedInAsVisible());

        // Logout
        homePage.clickLogout();

        // Test Case 2 Starts Here
        // Step 5
        // Verify Login To Your Account Is Visible
        Assert.assertTrue(loginSignupPage.isLoginToYourAccountVisible());

        
        // Step 6
        // Enter Correct Email And Password
        loginSignupPage.enterLoginEmail(email);
        loginSignupPage.enterLoginPassword(password);


        // Step 7
        // Click Login Button
        loginSignupPage.clickLoginButton();

        // Step 8
        // Verify Logged In As Username
        Assert.assertTrue(homePage.isLoggedInAsVisible());

        // Step 9
        // Delete Account
        homePage.clickDeleteAccount();

        // Step 10
        // Verify Account Deleted
        Assert.assertTrue(accountDeletedPage.isAccountDeletedVisible());
        accountDeletedPage.clickContinue();

    }
} 