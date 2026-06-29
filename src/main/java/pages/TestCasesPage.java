package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class TestCasesPage extends BasePage {

    // =========================
    // Test Cases Page Locators
    // =========================

    private By testCasesTitle =
            By.xpath("//b[text()='Test Cases']");

    // =========================
    // Constructor
    // =========================

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the Test Cases page is displayed.
     */
    public boolean isTestCasesPageVisible() {

        return driver.findElement(testCasesTitle)
                .isDisplayed();
    }
}