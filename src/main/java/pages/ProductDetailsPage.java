package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class ProductDetailsPage extends BasePage {

    // =========================
    // Product Details Locators
    // =========================

    private By productName =
            By.xpath("//div[@class='product-information']/h2");

    private By category =
            By.xpath("//p[contains(text(),'Category')]");

    private By price =
            By.xpath("//div[@class='product-information']//span/span");

    private By availability =
            By.xpath("//b[text()='Availability:']");

    private By condition =
            By.xpath("//b[text()='Condition:']");

    private By brand =
            By.xpath("//b[text()='Brand:']");

    private By quantityField =
            By.id("quantity");

    private By addToCartBtn =
            By.cssSelector("button.cart");

    private By viewCartBtn =
            By.xpath("//a[@href='/view_cart']//u[text()='View Cart']");

    private By writeYourReviewTitle =
            By.xpath("//a[@href='#reviews']");

    private By reviewNameField =
            By.id("name");

    private By reviewEmailField =
            By.id("email");

    private By reviewTextArea =
            By.id("review");

    private By submitReviewBtn =
            By.id("button-review");

    private By reviewSuccessMessage =
            By.xpath("//span[text()='Thank you for your review.']");

    // =========================
    // Constructor
    // =========================

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the product name is displayed.
     */
    public boolean isProductNameVisible() {

        return driver.findElement(productName)
                .isDisplayed();
    }

    /*
     * Verify that the product category is displayed.
     */
    public boolean isCategoryVisible() {

        return driver.findElement(category)
                .isDisplayed();
    }

    /*
     * Verify that the product price is displayed.
     */
    public boolean isPriceVisible() {

        return driver.findElement(price)
                .isDisplayed();
    }

    /*
     * Verify that the product availability is displayed.
     */
    public boolean isAvailabilityVisible() {

        return driver.findElement(availability)
                .isDisplayed();
    }

    /*
     * Verify that the product condition is displayed.
     */
    public boolean isConditionVisible() {

        return driver.findElement(condition)
                .isDisplayed();
    }

    /*
     * Verify that the product brand is displayed.
     */
    public boolean isBrandVisible() {

        return driver.findElement(brand)
                .isDisplayed();
    }

    /*
     * Verify that the Write Your Review section is displayed.
     */
    public boolean isWriteYourReviewVisible() {

        return driver.findElement(writeYourReviewTitle)
                .isDisplayed();
    }

    /*
     * Verify that the review success message is displayed.
     */
    public boolean isReviewSuccessMessageVisible() {

        return wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .visibilityOfElementLocated(reviewSuccessMessage))
                .isDisplayed();
    }

    // =========================
    // Product Actions
    // =========================

    /*
     * Enter the desired product quantity.
     */
    public void enterQuantity(String quantity) {

        driver.findElement(quantityField)
                .clear();

        driver.findElement(quantityField)
                .sendKeys(quantity);
    }

    /*
     * Add the product to the shopping cart.
     */
    public void clickAddToCart() {

    	safeClick(addToCartBtn);
    }

    /*
     * Navigate to the Shopping Cart page.
     */
    public void clickViewCart() {

    	safeClick(viewCartBtn);
    }

    // =========================
    // Review Actions
    // =========================

    /*
     * Submit a product review.
     */
    public void submitReview(String name,
                             String email,
                             String review) {

        driver.findElement(reviewNameField)
                .sendKeys(name);

        driver.findElement(reviewEmailField)
                .sendKeys(email);

        driver.findElement(reviewTextArea)
                .sendKeys(review);

        safeClick(submitReviewBtn);
    }
}