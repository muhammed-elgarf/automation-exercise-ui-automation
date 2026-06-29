package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ProductsPage;
import utilities.JsonReader;

public class TC09_SearchProduct extends BaseTest {

    @Test
    public void searchProductSuccessfully() {

        // ==========================================
        // Read Test Data From JSON
        // ==========================================

        Map<String, String> productData =
                JsonReader.getJsonData("products.json");

        // ==========================================
        // Initialize Page Objects
        // ==========================================

        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // ==========================================
        // Step 1,2,3
        // Launch Browser + Navigate URL + Verify Home Page
        // ==========================================

        Assert.assertTrue(
                homePage.isHomePageVisible());

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
        // Search Product
        // ==========================================
        productsPage.searchProduct(
                productData.get("searchProduct"));

        // ==========================================
        // Step 7
        // Verify Searched Products
        // ==========================================
        Assert.assertTrue(
                productsPage.isSearchedProductsVisible());

        // ==========================================
        // Step 8
        // Verify Searched Product
        // ==========================================

        Assert.assertTrue(
                productsPage.isSearchedProductVisible());
    }
}