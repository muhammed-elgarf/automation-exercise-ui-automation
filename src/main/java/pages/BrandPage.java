package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class BrandPage extends BasePage {

    // =========================
    // Brand Page Locators
    // =========================

    private By brandsTitle =
            By.xpath("//h2[text()='Brands']");

    private By poloBrand =
            By.cssSelector("a[href='/brand_products/Polo']");

    private By hmBrand =
            By.xpath("//a[@href='/brand_products/H&M']");

    private By brandPageTitle =
            By.xpath("//div[@class='features_items']//h2[contains(normalize-space(.), 'Brand')]");

    // =========================
    // Constructor
    // =========================

    public BrandPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the Brands section is displayed.
     */
    public boolean isBrandsVisible() {

        return driver.findElement(brandsTitle)
                .isDisplayed();
    }

    /*
     * Get the title of the selected Brand Products page.
     */
    public String getBrandPageTitle() {

        return driver.findElement(brandPageTitle)
                .getText()
                .trim()
                .replaceAll("\\s+", " ");
    }

    // =========================
    // Action Methods
    // =========================

    /*
     * Select the Polo brand from the Brands section.
     */
    public void clickPoloBrand() {

        safeClick(poloBrand);
    }

    /*
     * Select the H&M brand from the Brands section.
     */
    public void clickHMBrand() {

        safeClick(hmBrand);
    }
}