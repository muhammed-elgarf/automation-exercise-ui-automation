package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class AccountDeletedPage extends BasePage {

    // =========================
    // Locators
    // =========================

    private By accountDeletedText =
            By.cssSelector("[data-qa='account-deleted']");

    private By continueButton =
            By.cssSelector("[data-qa='continue-button']");

    // =========================
    // Constructor
    // =========================

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the Account Deleted confirmation message is displayed.
     */
    public boolean isAccountDeletedVisible() {

        return driver.findElement(accountDeletedText)
                .isDisplayed();
    }

    // =========================
    // Action Methods
    // =========================

    /*
     * Click Continue button to navigate to the Home page.
     */
    public void clickContinue() {

        safeClick(continueButton);
    }
}