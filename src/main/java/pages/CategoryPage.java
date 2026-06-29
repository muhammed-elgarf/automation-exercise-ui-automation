package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CategoryPage extends BasePage {

    // =========================
    // Category Page Locators
    // =========================

    private By dressCategory =
            By.cssSelector("a[href='/category_products/1']");

    private By topsCategory =
            By.cssSelector("a[href='/category_products/2']");

    private By sareeCategory =
            By.cssSelector("a[href='/category_products/7']");

    private By tshirtsCategory =
            By.cssSelector("a[href='/category_products/3']");

    private By jeansCategory =
            By.cssSelector("a[href='/category_products/6']");

    private By categoryPageTitle =
            By.cssSelector(".features_items h2.title.text-center");

    // =========================
    // Constructor
    // =========================

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Get the title of the selected Category Products page.
     */
    public String getCategoryPageTitle() {

        return driver.findElement(categoryPageTitle)
                .getText()
                .replaceAll("\\s+", " ")
                .trim();
    }

    // =========================
    // Action Methods
    // =========================

    /*
     * Select the Dress category.
     */
    public void clickDressCategory() {

        safeClick(dressCategory);
    }

    /*
     * Select the Tops category.
     */
    public void clickTopsCategory() {

        safeClick(topsCategory);
    }

    /*
     * Select the Saree category.
     */
    public void clickSareeCategory() {

        safeClick(sareeCategory);
    }

    /*
     * Select the T-Shirts category.
     */
    public void clickTshirtsCategory() {

        safeClick(tshirtsCategory);
    }

    /*
     * Select the Jeans category.
     */
    public void clickJeansCategory() {

        safeClick(jeansCategory);
    }
}