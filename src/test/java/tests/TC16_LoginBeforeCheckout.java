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
import pages.PaymentPage;
import pages.ProductsPage;
import pages.SignupPage;
import utilities.JsonReader;

public class TC16_LoginBeforeCheckout extends BaseTest {

    @Test
    public void placeOrderLoginBeforeCheckoutSuccessfully() {

        Map<String, String> registerData = JsonReader.getJsonData("register.json");
        Map<String, String> paymentData = JsonReader.getJsonData("payment.json");

        String name = registerData.get("name");
        String email = "mohamed" + System.currentTimeMillis() + "@gmail.com";
        String password = registerData.get("password");

        HomePage homePage = new HomePage(driver);
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
        SignupPage signupPage = new SignupPage(driver);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);

        Assert.assertTrue(homePage.isHomePageVisible());

        homePage.clickSignupLogin();

        loginSignupPage.enterSignupData(name, email);

        Assert.assertTrue(signupPage.isEnterAccountInformationVisible());

        signupPage.selectMrTitle();
        signupPage.enterPassword(password);
        signupPage.selectDateOfBirth(
                registerData.get("day"),
                registerData.get("month"),
                registerData.get("year"));
        signupPage.selectNewsletter();
        signupPage.selectSpecialOffers();
        signupPage.enterFirstName(registerData.get("firstName"));
        signupPage.enterLastName(registerData.get("lastName"));
        signupPage.enterCompany(registerData.get("company"));
        signupPage.enterAddress(registerData.get("address1"));
        signupPage.enterAddress2(registerData.get("address2"));
        signupPage.selectCountry(registerData.get("country"));
        signupPage.enterState(registerData.get("state"));
        signupPage.enterCity(registerData.get("city"));
        signupPage.enterZipCode(registerData.get("zipcode"));
        signupPage.enterMobileNumber(registerData.get("mobileNumber"));
        signupPage.clickCreateAccount();

        Assert.assertTrue(accountCreatedPage.isAccountCreatedVisible());
        accountCreatedPage.clickContinue();

        Assert.assertTrue(homePage.isLoggedInAsVisible());

        homePage.clickLogout();

        Assert.assertTrue(loginSignupPage.isLoginToYourAccountVisible());

        loginSignupPage.enterLoginEmail(email);
        loginSignupPage.enterLoginPassword(password);
        loginSignupPage.clickLoginButton();

        Assert.assertTrue(homePage.isLoggedInAsVisible());

        // ==========================================
        // Step 7
        // Add Product To Cart
        // ==========================================

        homePage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsPageVisible());        
        productsPage.hoverFirstProduct();
        productsPage.addFirstProductToCart();

        // ==========================================
        // Step 8
        // Click Cart
        // ==========================================

        productsPage.clickViewCart();

        // ==========================================
        // Step 9
        // Verify Cart Page
        // ==========================================

        Assert.assertTrue(cartPage.isCartPageDisplayed());

        // ==========================================
        // Step 10
        // Click Proceed To Checkout
        // ==========================================

        cartPage.clickProceedToCheckout();

        // ==========================================
        // Step 11
        // Verify Address Details And Review Your Order
        // ==========================================

        Assert.assertTrue(checkoutPage.isAddressDetailsVisible());
        Assert.assertTrue(checkoutPage.isReviewYourOrderVisible());

        // ==========================================
        // Step 12
        // Enter Comment And Click Place Order
        // ==========================================

        checkoutPage.enterComment(paymentData.get("comment"));
        checkoutPage.clickPlaceOrder();

        // ==========================================
        // Step 13
        // Verify Payment Page And Enter Payment Details
        // ==========================================

        Assert.assertTrue(paymentPage.isPaymentPageVisible());

        paymentPage.enterPaymentDetails(
                paymentData.get("nameOnCard"),
                paymentData.get("cardNumber"),
                paymentData.get("cvc"),
                paymentData.get("expiryMonth"),
                paymentData.get("expiryYear"));

        // ==========================================
        // Step 14
        // Click Pay And Confirm Order
        // ==========================================

        paymentPage.clickPayAndConfirmOrder();

        // ==========================================
        // Step 15
        // Verify Order Placed Successfully
        // ==========================================

        Assert.assertTrue(paymentPage.isOrderPlacedSuccessfully());

        // ==========================================
        // Step 16
        // Click Delete Account
        // ==========================================

        homePage.clickDeleteAccount();

        // ==========================================
        // Step 17
        // Verify Account Deleted And Click Continue
        // ==========================================

        Assert.assertTrue(accountDeletedPage.isAccountDeletedVisible());
        accountDeletedPage.clickContinue();
    }
}