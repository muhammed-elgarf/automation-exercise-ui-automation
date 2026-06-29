package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class ProductsPage extends BasePage {

    private Actions actions;

    // =========================
    // Products Page Locators
    // =========================

    private By allProductsTitle =
            By.xpath("//h2[text()='All Products']");

    private By productsList =
            By.className("features_items");

    private By firstViewProductBtn =
            By.cssSelector("a[href='/product_details/1']");

    private By searchInput =
            By.id("search_product");

    private By searchButton =
            By.id("submit_search");

    private By searchedProductsTitle =
            By.xpath("//h2[text()='Searched Products']");

    private By searchedProducts =
            By.cssSelector(".features_items .productinfo");

    private By firstProductAddToCart =
            By.cssSelector(".product-overlay a[data-product-id='1']");

    private By secondProductAddToCart =
            By.cssSelector(".product-overlay a[data-product-id='2']");

    private By continueShoppingBtn =
            By.cssSelector("button.close-modal");

    private By viewCartBtnModal =
            By.cssSelector("div#cartModal a[href='/view_cart']");

    private By firstProduct =
            By.xpath("(//div[@class='single-products'])[1]");

    private By secondProduct =
            By.xpath("(//div[@class='single-products'])[2]");

    private By searchedProductAddToCart =
            By.cssSelector("a[data-product-id='43']");
    
    private By categoryTitle =
            By.xpath("//div[@class='features_items']//h2");
    // =========================
    // Constructor
    // =========================

    public ProductsPage(WebDriver driver) {

        super(driver);
        this.actions = new Actions(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the All Products page is displayed.
     */
    public boolean isAllProductsPageVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(allProductsTitle))
                .isDisplayed();
    }

    /*
     * Verify that the products list is displayed.
     */
    public boolean isProductsListVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productsList))
                .isDisplayed();
    }

    /*
     * Verify that the Searched Products title is displayed.
     */
    public boolean isSearchedProductsVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchedProductsTitle))
                .isDisplayed();
    }

    /*
     * Verify that at least one searched product is displayed.
     */
    public boolean isSearchedProductVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(searchedProducts))
                .size() > 0;
    }

    // =========================
    // Navigation Actions
    // =========================

    /*
     * Open the details page of the first product.
     */
    public void clickFirstViewProduct() {

        wait.until(
                ExpectedConditions.elementToBeClickable(firstViewProductBtn));

        safeClick(firstViewProductBtn);

        wait.until(
                ExpectedConditions.urlContains("/product_details/"));
    }

    /*
     * Open the Shopping Cart from the Add to Cart modal.
     */
    public void clickViewCart() {

        safeClick(viewCartBtnModal);
    }

    /*
     * Close the Add to Cart confirmation modal.
     */
    public void clickContinueShopping() {

        safeClick(continueShoppingBtn);
    }
    

    // =========================
    // Search Actions
    // =========================

    /*
     * Search for a product using its name.
     */
    public void searchProduct(String productName) {

        driver.findElement(searchInput)
                .sendKeys(productName);

        safeClick(searchButton);
    }

    // =========================
    // Cart Actions
    // =========================

    /*
     * Add the first product to the shopping cart.
     */
    public void addFirstProductToCart() {

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                driver.findElement(firstProductAddToCart));

        actions.moveToElement(
                driver.findElement(firstProduct))
                .perform();

        wait.until(
                ExpectedConditions.elementToBeClickable(firstProductAddToCart));

        js.executeScript("window.scrollBy(0, -100);");

        safeClick(firstProductAddToCart);


    }

    /*
     * Add the second product to the shopping cart.
     */
    public void addSecondProductToCart() {

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                driver.findElement(secondProduct));

        actions.moveToElement(
                driver.findElement(secondProduct))
                .perform();

        wait.until(
                ExpectedConditions.elementToBeClickable(secondProductAddToCart));

        js.executeScript("window.scrollBy(0, -100);");

        safeClick(secondProductAddToCart);
    }

    /*
     * Add the searched product to the shopping cart.
     */
    public void addSearchedProductToCart() {

        safeClick(searchedProductAddToCart);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        viewCartBtnModal));
    }
    

    // =========================
    // Hover Actions
    // =========================

    /*
     * Hover over the first product.
     */
    public void hoverFirstProduct() {

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                driver.findElement(firstProduct));

        actions.moveToElement(
                driver.findElement(firstProduct))
                .perform();
    }

    /*
     * Hover over the second product.
     */
    public void hoverSecondProduct() {

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                driver.findElement(secondProduct));

        actions.moveToElement(
                driver.findElement(secondProduct))
                .perform();
    }
    
    public String getCategoryTitle() {

        return driver.findElement(categoryTitle).getText();
    }
}