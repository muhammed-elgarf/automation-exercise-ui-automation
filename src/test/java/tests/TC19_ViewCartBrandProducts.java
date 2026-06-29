package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BrandPage;
import pages.HomePage;

public class TC19_ViewCartBrandProducts extends BaseTest {

    @Test
    public void viewCartBrandProductsSuccessfully() {

        // ==========================================
        // Initialize Page Objects
        // ==========================================

        HomePage homePage = new HomePage(driver);
        BrandPage brandPage = new BrandPage(driver);

     // ==========================================
     // Step 1,2,3
     // Launch Browser + Navigate URL + Verify Home Page
     // ==========================================

     Assert.assertTrue(homePage.isHomePageVisible());
     homePage.clickProducts();

	  // ==========================================
	  // Step 4
	  // Verify Brands Are Visible
	  // ==========================================
	
	  Assert.assertTrue(brandPage.isBrandsVisible());

        // ==========================================
        // Step 5
        // Click Polo Brand
        // ==========================================

        brandPage.clickPoloBrand();


        // ==========================================
        // Step 6
        // Verify Polo Brand Page
        // ==========================================

        Assert.assertEquals(
                brandPage.getBrandPageTitle().toUpperCase(),
                "BRAND - POLO PRODUCTS");

        // ==========================================
        // Step 7
        // Click H&M Brand
        // ==========================================

        brandPage.clickHMBrand();

        // ==========================================
        // Step 8
        // Verify H&M Brand Page
        // ==========================================

        Assert.assertEquals(
                brandPage.getBrandPageTitle(),
                "BRAND - H&M PRODUCTS");
    }
}