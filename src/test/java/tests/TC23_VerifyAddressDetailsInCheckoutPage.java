package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountCreatedPage;
import pages.AccountDeletedPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginSignupPage;
import pages.ProductsPage;
import pages.SignupPage;
import utilities.JsonReader;

public class TC23_VerifyAddressDetailsInCheckoutPage extends BaseTest {

    @Test
    public void verifyAddressDetailsInCheckoutPageSuccessfully() {

        // ==========================================
        // Read Test Data From JSON
        // ==========================================

        Map<String, String> registerData =
                JsonReader.getJsonData("register.json");

        // ==========================================
        // Initialize Page Objects
        // ==========================================

        HomePage homePage = new HomePage(driver);

        LoginSignupPage loginSignupPage =
                new LoginSignupPage(driver);

        SignupPage signupPage =
                new SignupPage(driver);

        AccountCreatedPage accountCreatedPage =
                new AccountCreatedPage(driver);
        

        ProductsPage productsPage =
                new ProductsPage(driver);

        CartPage cartPage =
                new CartPage(driver);

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        AccountDeletedPage accountDeletedPage =
                new AccountDeletedPage(driver);

        // ==========================================
        // Step 1,2,3
        // Launch Browser + Navigate URL + Verify Home Page
        // ==========================================

        Assert.assertTrue(
                homePage.isHomePageVisible());

        // ==========================================
        // Step 4
        // Click Signup / Login
        // ==========================================
        homePage.clickSignupLogin();

        // ==========================================
        // Step 5
        // Fill Signup Details And Create Account
        // ==========================================

        Assert.assertTrue(
                loginSignupPage.isNewUserSignupVisible());

        String name =
                registerData.get("name");

        String email =
                "mohamed"
                + System.currentTimeMillis()
                + "@gmail.com";

        loginSignupPage.enterSignupData(
                name,
                email);

        Assert.assertTrue(
                signupPage.isEnterAccountInformationVisible());

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

        signupPage.clickCreateAccount();

        // ==========================================
        // Step 6
        // Verify Account Created And Click Continue
        // ==========================================

        Assert.assertTrue(accountCreatedPage.isAccountCreatedVisible());
        accountCreatedPage.clickContinue();
   
        
        // ==========================================
        // Step 7
        // Verify Logged In As Username
        // ==========================================

        Assert.assertTrue(homePage.isLoggedInAsVisible());

	     // ==========================================
	     // Step 8
	     // Add Product To Cart
	     // ==========================================

	     homePage.clickProducts();

	     productsPage.hoverFirstProduct();
	     productsPage.addFirstProductToCart();

        // ==========================================
        // Step 9
        // Click Cart
        // ==========================================

        productsPage.clickViewCart();
	    handleGoogleVignette();
        Assert.assertTrue(cartPage.isCartPageDisplayed());

        // ==========================================
        // Step 10
        // Verify Cart Page
        // ==========================================

        Assert.assertTrue(cartPage.isCartPageDisplayed());

        // ==========================================
        // Step 11
        // Click Proceed To Checkout
        // ==========================================
	    handleGoogleVignette();
        cartPage.clickProceedToCheckout();

        // ==========================================
        // Step 12,13
        // Verify Delivery And Billing Address
        // ==========================================

        Assert.assertTrue(
                checkoutPage.isAddressDetailsVisible());

        String deliveryAddress =
                checkoutPage.getDeliveryAddressText();

        String billingAddress =
                checkoutPage.getBillingAddressText();

        Assert.assertTrue(
                deliveryAddress.contains(
                        registerData.get("firstName")));

        Assert.assertTrue(
                deliveryAddress.contains(
                        registerData.get("lastName")));

        Assert.assertTrue(
                deliveryAddress.contains(
                        registerData.get("address1")));

        Assert.assertTrue(
                deliveryAddress.contains(
                        registerData.get("country")));

        Assert.assertTrue(
                deliveryAddress.contains(
                        registerData.get("mobileNumber")));

        Assert.assertTrue(
                billingAddress.contains(
                        registerData.get("firstName")));

        Assert.assertTrue(
                billingAddress.contains(
                        registerData.get("lastName")));

        Assert.assertTrue(
                billingAddress.contains(
                        registerData.get("address1")));

        Assert.assertTrue(
                billingAddress.contains(
                        registerData.get("country")));

        Assert.assertTrue(
                billingAddress.contains(
                        registerData.get("mobileNumber")));

        // ==========================================
        // Step 14
        // Click Delete Account
        // ==========================================

        homePage.clickDeleteAccount();
        // ==========================================
        // Step 15
        // Verify Account Deleted And Click Continue
        // ==========================================

        Assert.assertTrue(accountDeletedPage.isAccountDeletedVisible());
        accountDeletedPage.clickContinue();
    }
}
