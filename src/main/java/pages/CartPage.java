package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class CartPage extends BasePage {

    // =========================
    // Cart Page Locators
    // =========================

    private By firstProduct =
            By.id("product-1");

    private By secondProduct =
            By.id("product-2");

    private By productPrices =
            By.cssSelector(".cart_price p");

    private By productQuantities =
            By.cssSelector(".cart_quantity button");

    private By productTotals =
            By.cssSelector(".cart_total_price");

    private By productQuantity =
            By.cssSelector(".cart_quantity button");

    private By proceedToCheckoutBtn =
            By.cssSelector("a.check_out");

    private By shoppingCartBreadcrumb =
            By.xpath("//li[text()='Shopping Cart']");

    private By removeProductBtn =
            By.cssSelector("a.cart_quantity_delete");

    private By searchedProductInCart =
            By.id("product-43");

    // =========================
    // Constructor
    // =========================

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the first product is displayed in the cart.
     */
    public boolean isFirstProductDisplayed() {

        return driver.findElement(firstProduct)
                .isDisplayed();
    }

    /*
     * Verify that the second product is displayed in the cart.
     */
    public boolean isSecondProductDisplayed() {

        return driver.findElement(secondProduct)
                .isDisplayed();
    }

    /*
     * Verify that product prices are displayed.
     */
    public boolean areProductPricesDisplayed() {

        return driver.findElements(productPrices)
                .size() >= 2;
    }

    /*
     * Verify that product quantities are displayed.
     */
    public boolean areProductQuantitiesDisplayed() {

        return driver.findElements(productQuantities)
                .size() >= 2;
    }

    /*
     * Verify that product total prices are displayed.
     */
    public boolean areProductTotalsDisplayed() {

        return driver.findElements(productTotals)
                .size() >= 2;
    }

    /*
     * Get the quantity of the product in the cart.
     */
    public String getProductQuantity() {

        return driver.findElement(productQuantity)
                .getText();
    }

    /*
     * Verify that the Shopping Cart page is displayed.
     */
    public boolean isCartPageDisplayed() {

        return driver.findElement(
                shoppingCartBreadcrumb)
                .isDisplayed();
    }

    /*
     * Verify that the searched product is displayed in the cart.
     */
    public boolean isSearchedProductDisplayed() {

        return driver.findElement(searchedProductInCart)
                .isDisplayed();
    }

    /*
     * Verify that the first product has been removed from the cart.
     */
    public boolean isFirstProductRemoved() {

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        firstProduct));

        return driver.findElements(firstProduct)
                .size() == 0;
    }

    // =========================
    // Action Methods
    // =========================

    /*
     * Click the Proceed To Checkout button.
     */
    public void clickProceedToCheckout() {

        safeClick(proceedToCheckoutBtn);
    }

    /*
     * Remove a product from the shopping cart.
     */
    public void clickRemoveProduct() {

        safeClick(removeProductBtn);
    }
}