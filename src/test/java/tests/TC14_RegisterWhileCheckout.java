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

public class TC14_RegisterWhileCheckout extends BaseTest {

	
	@Test
	public void placeOrderRegisterWhileCheckoutSuccessfully() {

	    // ==========================================
	    // Read Test Data From JSON
	    // ==========================================

	    Map<String, String> registerData =
	            JsonReader.getJsonData("register.json");

	    Map<String, String> paymentData =
	            JsonReader.getJsonData("payment.json");

	    // ==========================================
	    // Initialize Page Objects
	    // ==========================================

	    HomePage homePage = new HomePage(driver);

	    ProductsPage productsPage =
	            new ProductsPage(driver);

	    CartPage cartPage =
	            new CartPage(driver);

	    CheckoutPage checkoutPage =
	            new CheckoutPage(driver);

	    LoginSignupPage loginSignupPage =
	            new LoginSignupPage(driver);

	    SignupPage signupPage =
	            new SignupPage(driver);

	    AccountCreatedPage accountCreatedPage =
	            new AccountCreatedPage(driver);

	    PaymentPage paymentPage =
	            new PaymentPage(driver);

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
	    // Add Product To Cart
	    // ==========================================

	    homePage.clickProducts();
	    productsPage.hoverFirstProduct();
	    productsPage.addFirstProductToCart();
	    
	    // ==========================================
	    // Step 5
	    // Click Cart
	    // ==========================================
	    productsPage.clickViewCart();

	    // ==========================================
	    // Step 6
	    // Verify Cart Page
	    // ==========================================

	    Assert.assertTrue(cartPage.isCartPageDisplayed());

	    // ==========================================
	    // Step 7
	    // Click Proceed To Checkout
	    // ==========================================

	    cartPage.clickProceedToCheckout();

	    // ==========================================
	    // Step 8
	    // Click Register / Login
	    // ==========================================

	    checkoutPage.clickRegisterLogin();
	    
	    // ==========================================
	    // Step 9
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
	    // Step 10
	    // Verify Account Created And Click Continue
	    // ==========================================

	    Assert.assertTrue(accountCreatedPage.isAccountCreatedVisible());

	    accountCreatedPage.clickContinue();

	    // ==========================================
	    // Step 11
	    // Verify Logged In As Username
	    // ==========================================

	    Assert.assertTrue(homePage.isLoggedInAsVisible());


	 // ==========================================
	 // Step 12
	 // Click Cart Button
	 // ==========================================

	 homePage.clickCart();

	 // ==========================================
	 // Step 13
	 // Verify Cart Page And Proceed To Checkout
	 // ==========================================

	 Assert.assertTrue(cartPage.isCartPageDisplayed());
	 cartPage.clickProceedToCheckout();
	    
	    // ==========================================
	    // Step 14
	    // Verify Address Details And Review Your Order
	    // ==========================================

	    Assert.assertTrue(checkoutPage.isAddressDetailsVisible());
	    Assert.assertTrue(checkoutPage.isReviewYourOrderVisible());

	    // ==========================================
	    // Step 15
	    // Enter Comment And Click Place Order
	    // ==========================================

	    checkoutPage.enterComment(paymentData.get("comment"));
	    checkoutPage.clickPlaceOrder();

	    // ==========================================
	    // Step 16
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
	    // Step 17
	    // Click Pay And Confirm Order
	    // ==========================================

	    paymentPage.clickPayAndConfirmOrder();

	    // ==========================================
	    // Step 18
	    // Verify Order Placed Successfully
	    // ==========================================

	    Assert.assertTrue(paymentPage.isOrderPlacedSuccessfully());

	    // ==========================================
	    // Step 19
	    // Click Delete Account
	    // ==========================================

	    homePage.clickDeleteAccount();

	    // ==========================================
	    // Step 20
	    // Verify Account Deleted And Click Continue
	    // ==========================================

	    Assert.assertTrue(accountDeletedPage.isAccountDeletedVisible());

	    accountDeletedPage.clickContinue();
	}
	
}