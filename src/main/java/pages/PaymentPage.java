package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class PaymentPage extends BasePage {

    // =========================
    // Payment Page Locators
    // =========================

    private By paymentTitle =
            By.xpath("//h2[text()='Payment']");

    private By nameOnCardField =
            By.cssSelector("[data-qa='name-on-card']");

    private By cardNumberField =
            By.cssSelector("[data-qa='card-number']");

    private By cvcField =
            By.cssSelector("[data-qa='cvc']");

    private By expiryMonthField =
            By.cssSelector("[data-qa='expiry-month']");

    private By expiryYearField =
            By.cssSelector("[data-qa='expiry-year']");

    private By payAndConfirmOrderBtn =
            By.cssSelector("[data-qa='pay-button']");

    private By orderSuccessMessage =
            By.cssSelector("[data-qa='order-placed']");

    // =========================
    // Constructor
    // =========================

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the Payment page is displayed.
     */
    public boolean isPaymentPageVisible() {

        return driver.findElement(paymentTitle)
                .isDisplayed();
    }

    /*
     * Verify that the order has been placed successfully.
     */
    public boolean isOrderPlacedSuccessfully() {

        return driver.findElement(orderSuccessMessage)
                .isDisplayed();
    }

    // =========================
    // Payment Actions
    // =========================

    /*
     * Enter the payment details required to complete the order.
     */
    public void enterPaymentDetails(String nameOnCard,
                                    String cardNumber,
                                    String cvc,
                                    String expiryMonth,
                                    String expiryYear) {

        driver.findElement(nameOnCardField)
                .sendKeys(nameOnCard);

        driver.findElement(cardNumberField)
                .sendKeys(cardNumber);

        driver.findElement(cvcField)
                .sendKeys(cvc);

        driver.findElement(expiryMonthField)
                .sendKeys(expiryMonth);

        driver.findElement(expiryYearField)
                .sendKeys(expiryYear);
    }

    /*
     * Click the Pay and Confirm Order button.
     */
    public void clickPayAndConfirmOrder() {

        safeClick(payAndConfirmOrderBtn);
    }
}