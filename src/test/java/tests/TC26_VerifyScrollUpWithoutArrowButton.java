package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class TC26_VerifyScrollUpWithoutArrowButton extends BaseTest {

    @Test
    public void verifyScrollUpWithoutArrowButtonSuccessfully() {

        // ==========================================
        // Initialize Page Objects
        // ==========================================

        HomePage homePage =
                new HomePage(driver);

        // ==========================================
        // Step 1,2,3
        // Launch Browser + Navigate URL + Verify Home Page
        // ==========================================

        Assert.assertTrue(
                homePage.isHomePageVisible());

        // ==========================================
        // Step 4
        // Scroll Down To Bottom
        // ==========================================

        homePage.scrollToFooter();
	    handleGoogleVignette();

        // ==========================================
        // Step 5
        // Verify Subscription Is Visible
        // ==========================================

        Assert.assertTrue(homePage.isSubscriptionVisible());

        // ==========================================
        // Step 6
        // Scroll Up To Top
        // ==========================================

        homePage.scrollToTop();
	    handleGoogleVignette();

        // ==========================================
        // Step 7
        // Verify Page Scrolled Up Successfully
        // ==========================================

        Assert.assertTrue(homePage.isFullFledgedTextVisible());
    }
}