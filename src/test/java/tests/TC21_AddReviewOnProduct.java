package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import utilities.JsonReader;

public class TC21_AddReviewOnProduct extends BaseTest {

    @Test
    public void addReviewOnProductSuccessfully() {

        // ==========================================
        // Read Test Data From JSON
        // ==========================================

        Map<String, String> reviewData =
                JsonReader.getJsonData("review.json");

        // ==========================================
        // Initialize Page Objects
        // ==========================================

        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        // ==========================================
        // Step 1,2
        // Launch Browser + Navigate URL
        // ==========================================

        Assert.assertTrue(homePage.isHomePageVisible());

        // ==========================================
        // Step 3
        // Click Products Button
        // ==========================================
        homePage.clickProducts();

        // ==========================================
        // Step 4
        // Verify All Products Page
        // ==========================================
        Assert.assertTrue(productsPage.isAllProductsPageVisible());
	    handleGoogleVignette();

        // ==========================================
        // Step 5
        // Click View Product
        // ==========================================

        productsPage.clickFirstViewProduct();

        // ==========================================
        // Step 6
        // Verify Write Your Review
        // ==========================================

        Assert.assertTrue(productDetailsPage.isWriteYourReviewVisible());

        // ==========================================
        // Step 7,8
        // Enter Review Data And Submit
        // ==========================================

        productDetailsPage.submitReview(
                reviewData.get("name"),
                reviewData.get("email"),
                reviewData.get("review"));
        System.out.println(driver.getPageSource());

        // ==========================================
        // Step 9
        // Verify Success Message
        // ==========================================

        Assert.assertTrue(productDetailsPage.isReviewSuccessMessageVisible());
    }
}
