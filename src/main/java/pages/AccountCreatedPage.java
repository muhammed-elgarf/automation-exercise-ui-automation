package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class AccountCreatedPage extends BasePage {

    // =========================
    // Locators
    // =========================

    private By accountCreatedText =
            By.cssSelector("[data-qa='account-created']");

    private By continueButton =
            By.cssSelector("[data-qa='continue-button']");

    // =========================
    // Constructor
    // =========================

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the Account Created confirmation message is displayed.
     */
    public boolean isAccountCreatedVisible() {
        return driver.findElement(accountCreatedText).isDisplayed();
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