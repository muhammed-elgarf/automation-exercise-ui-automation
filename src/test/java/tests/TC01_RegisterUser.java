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

public class TC01_RegisterUser extends BaseTest {

    @Test
    public void registerUser() {


        // =========================
        // Read Test Data From JSON
        // =========================

        Map<String, String> registerData =
                JsonReader.getJsonData("register.json");

        // =========================
        // Step 1,2,3
        // =========================

        Assert.assertEquals(driver.getTitle(),
                "Automation Exercise");

        // =========================
        // Step 4
        // =========================


        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();



        // =========================
        // Step 5
        // =========================


        LoginSignupPage loginSignupPage =
                new LoginSignupPage(driver);

        Assert.assertTrue(
                loginSignupPage.isNewUserSignupVisible());


        // =========================
        // Step 6 & 7
        // =========================

        String name = registerData.get("name");

        String email =
                "mohamed"
                + System.currentTimeMillis()
                + "@gmail.com";


        loginSignupPage.enterSignupData(name, email);

       
        // =========================
        // Step 8
        // =========================

        SignupPage signupPage = new SignupPage(driver);


        Assert.assertTrue(
                signupPage.isEnterAccountInformationVisible());

        
        // =========================
        // Step 9 - 12
        // =========================


        signupPage.selectMrTitle();

        signupPage.enterPassword(
                registerData.get("password"));

        signupPage.selectDateOfBirth(
                registerData.get("day"),
                registerData.get("month"),
                registerData.get("year"));

        signupPage.selectNewsletter();
        signupPage.selectSpecialOffers();

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

        
        // =========================
        // Step 13
        // =========================


        signupPage.clickCreateAccount();

        
        // =========================
        // Step 14
        // =========================

        AccountCreatedPage accountCreatedPage =
                new AccountCreatedPage(driver);


        Assert.assertTrue(
                accountCreatedPage.isAccountCreatedVisible());

        
        handleGoogleVignette();

        // =========================
        // Step 15
        // =========================


        accountCreatedPage.clickContinue();

        

        // =========================
        // Step 16
        // =========================

        

        Assert.assertTrue(
                homePage.isLoggedInAsVisible());

        

        // =========================
        // Step 17
        // =========================


        homePage.clickDeleteAccount();

        
        // =========================
        // Step 18
        // =========================

        AccountDeletedPage accountDeletedPage =
                new AccountDeletedPage(driver);


        Assert.assertTrue(
                accountDeletedPage.isAccountDeletedVisible());

        accountDeletedPage.clickContinue();

        
       
    }
}