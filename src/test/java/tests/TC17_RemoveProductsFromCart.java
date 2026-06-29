package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class TC17_RemoveProductsFromCart extends BaseTest {

    @Test
    public void removeProductsFromCartSuccessfully() {

        // ==========================================
        // Initialize Page Objects
        // ==========================================

        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        
     // ==========================================
     // Step 1,2,3
     // Launch Browser + Navigate URL + Verify Home Page
     // ==========================================

     Assert.assertTrue(homePage.isHomePageVisible());

	 // ==========================================
	// Step 4
	// Add Product To Cart
	// ==========================================
		
     homePage.clickProducts();

     Assert.assertTrue(
             productsPage.isAllProductsPageVisible());

     productsPage.hoverFirstProduct();
     productsPage.addFirstProductToCart();
     // ==========================================
     // Step 5
     // Click Cart
     // ==========================================

     productsPage.clickViewCart();

     // ==========================================
     // Step 6
     // Verify Cart Page
     // ==========================================

     Assert.assertTrue(cartPage.isCartPageDisplayed());

	  // ==========================================
	  // Step 7
	  // Click Remove Product
	  // ==========================================

      Assert.assertTrue(cartPage.isFirstProductDisplayed());
	  cartPage.clickRemoveProduct();
	
	  // ==========================================
	  // Step 8
	  // Verify Product Removed
	  // ==========================================
	
	  Assert.assertTrue(cartPage.isFirstProductRemoved());
     
    }
}