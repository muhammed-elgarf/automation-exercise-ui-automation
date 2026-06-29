package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class TC08_ProductQuantityInCart extends BaseTest {

    @Test
    public void verifyAllProductsAndProductDetailPageSuccessfully() {

        // ==========================================
        // Initialize Page Objects
        // ==========================================

        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage =
                new ProductDetailsPage(driver);

        // ==========================================
        // Step 1,2,3
        // Launch Browser + Navigate URL + Verify Home Page
        // ==========================================

        Assert.assertTrue(
                homePage.isHomePageVisible());
        handleGoogleVignette();

        // ==========================================
        // Step 4
        // Click Products Button
        // ==========================================

        homePage.clickProducts();

        // ==========================================
        // Step 5
        // Verify All Products Page
        // ==========================================

        Assert.assertTrue(
                productsPage.isAllProductsPageVisible());

        // ==========================================
        // Step 6
        // Verify Products List Is Visible
        // ==========================================

        Assert.assertTrue(
                productsPage.isProductsListVisible());

        // ==========================================
        // Step 7
        // Click First View Product
        // ==========================================

        productsPage.clickFirstViewProduct();
        handleGoogleVignette();

        // ==========================================
        // Step 8
        // Verify Product Name
        // ==========================================

        Assert.assertTrue(
                productDetailsPage.isProductNameVisible());
        handleGoogleVignette();

        // ==========================================
        // Step 9
        // Verify Category
        // ==========================================

        Assert.assertTrue(
                productDetailsPage.isCategoryVisible());
        handleGoogleVignette();

        // ==========================================
        // Step 10
        // Verify Price
        // ==========================================

        Assert.assertTrue(
                productDetailsPage.isPriceVisible());
        handleGoogleVignette();

        // ==========================================
        // Step 11
        // Verify Availability
        // ==========================================

        Assert.assertTrue(
                productDetailsPage.isAvailabilityVisible());
        handleGoogleVignette();

        // ==========================================
        // Step 12
        // Verify Condition
        // ==========================================

        Assert.assertTrue(
                productDetailsPage.isConditionVisible());
        handleGoogleVignette();

        // ==========================================
        // Step 13
        // Verify Brand
        // ==========================================

        Assert.assertTrue(
                productDetailsPage.isBrandVisible());
    }
}