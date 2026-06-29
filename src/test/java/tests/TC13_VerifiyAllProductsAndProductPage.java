package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class TC13_VerifiyAllProductsAndProductPage extends BaseTest {
	@Test
	public void VerifiyProductQuantityInCartSuccessfully() {

	    // ==========================================
	    // Initialize Page Objects
	    // ==========================================

	    HomePage homePage = new HomePage(driver);

	    ProductsPage productsPage =
	            new ProductsPage(driver);

	    ProductDetailsPage productDetailsPage =
	            new ProductDetailsPage(driver);

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
	    // Click View Product
	    // ==========================================

	    homePage.clickProducts();
	    
	    handleGoogleVignette();
	    productsPage.clickFirstViewProduct();

	    // ==========================================
	    // Step 5
	    // Verify Product Detail Is Opened
	    // ==========================================

	    Assert.assertTrue(
	            productDetailsPage.isProductNameVisible());

	    // ==========================================
	    // Step 6
	    // Increase Quantity To 4
	    // ==========================================
	    productDetailsPage.enterQuantity("4");

	    // ==========================================
	    // Step 7
	    // Click Add To Cart
	    // ==========================================
	    productDetailsPage.clickAddToCart();

	    // ==========================================
	    // Step 8
	    // Click View Cart
	    // ==========================================

	    productDetailsPage.clickViewCart();

	    // ==========================================
	    // Step 9
	    // Verify Product Quantity In Cart
	    // ==========================================

	    Assert.assertEquals(
	            cartPage.getProductQuantity(),
	            "4");
	}
}