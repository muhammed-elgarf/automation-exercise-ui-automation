package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutPage extends BasePage {

    // =========================
    // Checkout Page Locators
    // =========================

    private By registerLoginBtn =
            By.xpath("//a[@href='/login']//u[text()='Register / Login']");

    private By addressDetailsTitle =
            By.xpath("//h2[text()='Address Details']");

    private By reviewYourOrderTitle =
            By.xpath("//h2[text()='Review Your Order']");

    private By commentTextArea =
            By.cssSelector("textarea[name='message']");

    private By placeOrderBtn =
            By.cssSelector("a[href='/payment']");

    private By deliveryAddress =
            By.id("address_delivery");

    private By billingAddress =
            By.id("address_invoice");

    // =========================
    // Constructor
    // =========================

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Action Methods
    // =========================

    /*
     * Click the Register / Login button.
     */
    public void clickRegisterLogin() {

        safeClick(registerLoginBtn);
    }

    /*
     * Enter an order comment before placing the order.
     */
    public void enterComment(String comment) {

        driver.findElement(commentTextArea)
                .sendKeys(comment);
    }

    /*
     * Click the Place Order button.
     */
    public void clickPlaceOrder() {

        safeClick(placeOrderBtn);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the Address Details section is displayed.
     */
    public boolean isAddressDetailsVisible() {

        return driver.findElement(addressDetailsTitle)
                .isDisplayed();
    }

    /*
     * Verify that the Review Your Order section is displayed.
     */
    public boolean isReviewYourOrderVisible() {

        return driver.findElement(reviewYourOrderTitle)
                .isDisplayed();
    }

    /*
     * Get the Delivery Address details displayed on the checkout page.
     */
    public String getDeliveryAddressText() {

        return driver.findElement(deliveryAddress)
                .getText();
    }

    /*
     * Get the Billing Address details displayed on the checkout page.
     */
    public String getBillingAddressText() {

        return driver.findElement(billingAddress)
                .getText();
    }
}