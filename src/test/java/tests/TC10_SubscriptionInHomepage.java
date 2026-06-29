package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utilities.JsonReader;

public class TC10_SubscriptionInHomepage extends BaseTest {

    @Test
    public void verifySubscriptionInHomePageSuccessfully() {

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
        // Scroll To Footer
        // ==========================================
	    handleGoogleVignette();
        homePage.scrollToFooter();

        // ==========================================
        // Step 5
        // Verify Subscription Text
        // ==========================================

        Assert.assertTrue(
                homePage.isSubscriptionVisible());

        // ==========================================
        // Step 6
        // Subscribe With Email
        // ==========================================
	    handleGoogleVignette();
        homePage.subscribe(
                subscriptionData.get("email"));

        // ==========================================
        // Step 7
        // Verify Subscription Success Message
        // ==========================================

        Assert.assertTrue(
                homePage.isSubscriptionSuccessMessageVisible());
    }
}