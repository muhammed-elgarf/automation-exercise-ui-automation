package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class HomePage extends BasePage {

    // =========================
    // Home Page Locators
    // =========================

    private By homePageLogo =
            By.xpath("//img[@alt='Website for automation practice']");

    private By signupLoginBtn =
            By.xpath("//a[@href='/login']");

    private By contactUsBtn =
            By.cssSelector("a[href='/contact_us']");

    private By testCasesBtn =
            By.cssSelector("a[href='/test_cases']");

    private By productsBtn =
            By.cssSelector("a[href='/products']");

    private By cartBtn =
            By.cssSelector("a[href='/view_cart']");

    private By categoryTitle =
            By.xpath("//h2[text()='Category']");

    private By womenCategory =
            By.cssSelector("a[href='#Women']");

    private By menCategory =
            By.cssSelector("a[href='#Men']");

    private By recommendedItemsTitle =
            By.xpath("//h2[text()='recommended items']");

    private By recommendedProductAddToCart =
            By.cssSelector(".recommended_items a[data-product-id='1']");

    private By scrollUpArrow =
            By.id("scrollUp");

    private By fullFledgedText =
            By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']");

    // =========================
    // Account Locators
    // =========================

    private By loggedInAsText =
            By.xpath("//a[contains(text(),'Logged in as')]");

    private By logoutBtn =
            By.cssSelector("a[href='/logout']");

    private By deleteAccountBtn =
            By.cssSelector("a[href='/delete_account']");

    // =========================
    // Subscription Locators
    // =========================

    private By subscriptionTitle =
            By.xpath("//h2[text()='Subscription']");

    private By subscriptionEmailField =
            By.id("susbscribe_email");

    private By subscribeButton =
            By.id("subscribe");

    private By subscriptionSuccessMessage =
            By.xpath("//div[text()='You have been successfully subscribed!']");

    // =========================
    // Constructor
    // =========================

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Navigation Methods
    // =========================

    /*
     * Navigate to the Login / Signup page.
     */
    public void clickSignupLogin() {

        safeClick(signupLoginBtn);
    }
    /*
     * Navigate to the Contact Us page.
     */
    public void clickContactUs() {

        safeClick(contactUsBtn);
    }

    /*
     * Navigate to the Test Cases page.
     */
    public void clickTestCases() {

        safeClick(testCasesBtn);
    }

    /*
     * Navigate to the Products page.
     */
    public void clickProducts() {

        safeClick(productsBtn);
    }
    

    /*
     * Navigate to the Shopping Cart page.
     */
    public void clickCart() {

        safeClick(cartBtn);
    }
    

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the Home page is displayed successfully.
     */
    public boolean isHomePageVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(homePageLogo))
                .isDisplayed();
    }

    /*
     * Verify that the Logged in as text is displayed.
     */
    public boolean isLoggedInAsVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loggedInAsText))
                .isDisplayed();
    }

    /*
     * Verify that the Subscription section is displayed.
     */
    public boolean isSubscriptionVisible() {

        return driver.findElement(subscriptionTitle)
                .isDisplayed();
    }

    /*
     * Verify that the Category section is displayed.
     */
    public boolean isCategoryVisible() {

        return driver.findElement(categoryTitle)
                .isDisplayed();
    }

    /*
     * Verify that the Recommended Items section is displayed.
     */
    public boolean isRecommendedItemsVisible() {

        return driver.findElement(recommendedItemsTitle)
                .isDisplayed();
    }

    /*
     * Verify that the Full-Fledged practice website text is displayed.
     */
    public boolean isFullFledgedTextVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(fullFledgedText))
                .isDisplayed();
    }

    /*
     * Verify that the subscription success message is displayed.
     */
    public boolean isSubscriptionSuccessMessageVisible() {

        return driver.findElement(subscriptionSuccessMessage)
                .isDisplayed();
    }

    // =========================
    // Account Actions
    // =========================

    /*
     * Log out the current user.
     */
    public void clickLogout() {

        safeClick(logoutBtn);
    }
    

    /*
     * Delete the current user account.
     */
    public void clickDeleteAccount() {

        safeClick(deleteAccountBtn);
    }

    // =========================
    // Subscription Actions
    // =========================

    /*
     * Scroll to the bottom of the page.
     */
    public void scrollToFooter() {

        js.executeScript(
                "window.scrollTo(0, document.body.scrollHeight)");
    }

    /*
     * Subscribe using the provided email address.
     */
    public void subscribe(String email) {

        driver.findElement(subscriptionEmailField)
                .sendKeys(email);

        safeClick(subscribeButton);
    }

    // =========================
    // Category Actions
    // =========================

    /*
     * Open the Women category.
     */
    public void clickWomenCategory() {

        safeClick(womenCategory);
    }

    /*
     * Open the Men category.
     */
    public void clickMenCategory() {

        safeClick(menCategory);
    }

    // =========================
    // Recommended Items Actions
    // =========================

    /*
     * Add the recommended product to the shopping cart.
     */
    public void addRecommendedProductToCart() {

        safeClick(recommendedProductAddToCart);
    }

    // =========================
    // Scroll Actions
    // =========================

    /*
     * Click the Scroll Up arrow to return to the top of the page.
     */
    public void clickScrollUpArrow() {

        WebElement arrow =
                wait.until(ExpectedConditions.visibilityOfElementLocated(scrollUpArrow));

        js.executeScript("arguments[0].click();", arrow);
    }
    /*
     * Scroll to the top of the page.
     */
    public void scrollToTop() {

        js.executeScript("window.scrollTo(0, 0);");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}