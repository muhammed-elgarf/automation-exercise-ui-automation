package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CategoryPage;
import pages.HomePage;
import pages.ProductsPage;

public class TC18_ViewCategoryProducts extends BaseTest {

    @Test
    public void viewCategoryProductsSuccessfully() {
        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        // ==========================================
        // Step 1,2,3
        // Launch Browser + Navigate URL + Verify Categories
        // ==========================================

        Assert.assertTrue(homePage.isHomePageVisible());
        Assert.assertTrue(homePage.isCategoryVisible());

        // ==========================================
        // Step 4
        // Click Women Category
        // ==========================================

        homePage.clickWomenCategory();

        // ==========================================
        // Step 5
        // Click Dress Category
        // ==========================================

        categoryPage.clickDressCategory();

        // ==========================================
        // Step 6
        // Verify Women Category Page
        // ==========================================

        Assert.assertTrue(
                productsPage.getCategoryTitle()
                        .toUpperCase()
                        .contains("WOMEN"));

        // ==========================================
        // Step 7
        // Click Men Category + Tshirts
        // ==========================================

        homePage.clickMenCategory();
        categoryPage.clickTshirtsCategory();

        // ==========================================
        // Step 8
        // Verify Men Category Page
        // ==========================================

        Assert.assertTrue(categoryPage.getCategoryPageTitle().toUpperCase().contains("MEN"));
}
    

}