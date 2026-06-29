package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class OrderPlacedPage extends BasePage {

    // =========================
    // Order Placed Page Locators
    // =========================

    private By orderPlacedMessage =
            By.cssSelector("[data-qa='order-placed']");

    private By downloadInvoiceBtn =
            By.cssSelector("a[href*='/download_invoice/']");

    private By continueBtn =
            By.cssSelector("[data-qa='continue-button']");

    // =========================
    // Constructor
    // =========================

    public OrderPlacedPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the Order Placed confirmation message is displayed.
     */
    public boolean isOrderPlacedVisible() {

        return driver.findElement(orderPlacedMessage)
                .isDisplayed();
    }

    // =========================
    // Action Methods
    // =========================

    /*
     * Click the Download Invoice button.
     */
    public void clickDownloadInvoice() {

    	safeClick(downloadInvoiceBtn);
    }

    /*
     * Click the Continue button to navigate to the Home page.
     */
    public void clickContinue() {

    	safeClick(continueBtn);
    }
}