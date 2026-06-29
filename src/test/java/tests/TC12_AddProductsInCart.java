package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class TC12_AddProductsInCart extends BaseTest {
	@Test
	public void addProductsInCartSuccessfully() {

	    // ==========================================
	    // Initialize Page Objects
	    // ==========================================

	    HomePage homePage = new HomePage(driver);

	    ProductsPage productsPage =
	            new ProductsPage(driver);

	    CartPage cartPage =
	            new CartPage(driver);

	    // ==========================================
	    // Step 1,2,3
	    // Launch Browser + Navigate URL + Verify Home Page
	    // ==========================================

	    Assert.assertTrue(
	            homePage.isHomePageVisible());

	    // ==========================================
	    // Step 4
	    // Click Products
	    // ==========================================

	    homePage.clickProducts();

	 // ==========================================
	 // Step 5
	 // Hover First Product And Add To Cart
	 // ==========================================
	    handleGoogleVignette();
	    productsPage.hoverFirstProduct();
	    productsPage.addFirstProductToCart();

	    
	 // ==========================================
	 // Step 6
	 // ==========================================
	 productsPage.clickContinueShopping();



	    // Step 7
	    productsPage.hoverSecondProduct();
	    productsPage.addSecondProductToCart();



	    // ==========================================
	    // Step 8
	    productsPage.clickViewCart();

	    // ==========================================
	    // Step 9
	    // Verify Both Products Are Added To Cart
	    // ==========================================

	    Assert.assertTrue(
	            cartPage.isFirstProductDisplayed());

	    Assert.assertTrue(
	            cartPage.isSecondProductDisplayed());

	    // ==========================================
	    // Step 10
	    // Verify Prices, Quantities And Totals
	    // ==========================================

	    Assert.assertTrue(
	            cartPage.areProductPricesDisplayed());

	    Assert.assertTrue(
	            cartPage.areProductQuantitiesDisplayed());

	    Assert.assertTrue(
	            cartPage.areProductTotalsDisplayed());
	}
}