package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utilities.JsonReader;

public class TC11_SubscriptionInCartpage extends BaseTest {

    @Test
    public void verifySubscriptionInCartPageSuccessfully() {

        // ==========================================
        // Read Test Data From JSON
        // ==========================================

        Map<String, String> subscriptionData =
                JsonReader.getJsonData("subscription.json");

        // ==========================================
        // Initialize Page Object
        // ==========================================

        HomePage homePage = new HomePage(driver);

        // ==========================================
        // Step 1,2,3
        // Launch Browser + Navigate URL + Verify Home Page
        // ==========================================

        Assert.assertTrue(
                homePage.isHomePageVisible());

        // ==========================================
        // Step 4
        // Click Cart
        // ==========================================

        homePage.clickCart();

        // ==========================================
        // Step 5
        // Scroll To Footer
        // ==========================================

        homePage.scrollToFooter();

        // ==========================================
        // Step 6
        // Verify Subscription Text
        // ==========================================

        Assert.assertTrue(
                homePage.isSubscriptionVisible());

        // ==========================================
        // Step 7
        // Subscribe With Email
        // ==========================================

        homePage.subscribe(
                subscriptionData.get("email"));

        // ==========================================
        // Step 8
        // Verify Subscription Success Message
        // ==========================================

        Assert.assertTrue(
                homePage.isSubscriptionSuccessMessageVisible());
    }
}