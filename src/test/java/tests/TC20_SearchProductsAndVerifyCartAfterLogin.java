package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginSignupPage;
import pages.ProductsPage;
import utilities.JsonReader;

public class TC20_SearchProductsAndVerifyCartAfterLogin extends BaseTest {

    @Test
    public void searchProductsAndVerifyCartAfterLogin() {

        // ==========================================
        // Read Test Data From JSON
        // ==========================================

        Map<String, String> productData =
                JsonReader.getJsonData("products.json");

        Map<String, String> loginData =
                JsonReader.getJsonData("login.json");

        // ==========================================
        // Initialize Page Objects
        // ==========================================

        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        LoginSignupPage loginSignupPage =new LoginSignupPage(driver);

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

        // ==========================================
        // Step 5
        // Search Product
        // ==========================================

        productsPage.searchProduct(productData.get("searchProduct"));

        // ==========================================
        // Step 6
        // Verify Searched Products
        // ==========================================

        Assert.assertTrue(productsPage.isSearchedProductsVisible());

        // ==========================================
        // Step 7
        // Verify Products Related To Search
        // ==========================================

        Assert.assertTrue(productsPage.isSearchedProductVisible());

        // ==========================================
        // Step 8
        // Add Product To Cart
        // ==========================================

        productsPage.addSearchedProductToCart();
        productsPage.clickViewCart();
        
        // ==========================================
        // Step 10
        // Login
        // ==========================================

        homePage.clickSignupLogin();
        loginSignupPage.enterLoginEmail(loginData.get("validEmail"));
        loginSignupPage.enterLoginPassword( loginData.get("validPassword"));
        loginSignupPage.clickLoginButton();

        // ==========================================
        // Step 11
        // Go To Cart Again
        // ==========================================

        homePage.clickCart();

        // ==========================================
        // Step 12
        // Verify Product Still Exists
        // ==========================================

        Assert.assertTrue(cartPage.isSearchedProductDisplayed());
    }
}
