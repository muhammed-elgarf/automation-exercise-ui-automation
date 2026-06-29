package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class TC22_AddToCartFromRecommendedItems extends BaseTest {

    @Test
    public void addToCartFromRecommendedItemsSuccessfully() {

        // ==========================================
        // Initialize Page Objects
        // ==========================================

        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        // ==========================================
        // Step 1,2
        // Launch Browser + Navigate URL
        // ==========================================

        Assert.assertTrue(
                homePage.isHomePageVisible());
	    handleGoogleVignette();

        // ==========================================
        // Step 3
        // Scroll To Bottom Of Page
        // ==========================================

        homePage.scrollToFooter();
	    handleGoogleVignette();

        // ==========================================
        // Step 4
        // Verify Recommended Items
        // ==========================================

        Assert.assertTrue(
                homePage.isRecommendedItemsVisible());
	    handleGoogleVignette();

        // ==========================================
        // Step 5
        // Add Recommended Product To Cart
        // ==========================================

        homePage.addRecommendedProductToCart();
	    handleGoogleVignette();

        // ==========================================
        // Step 6
        // Click View Cart
        // ==========================================

        productsPage.clickViewCart();
	    handleGoogleVignette();

        // ==========================================
        // Step 7
        // Verify Product Displayed In Cart
        // ==========================================

        Assert.assertTrue(
                cartPage.isFirstProductDisplayed());
    }
}