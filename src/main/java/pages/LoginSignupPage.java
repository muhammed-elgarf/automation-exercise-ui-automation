package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class LoginSignupPage extends BasePage {

    // =========================
    // Signup Locators
    // =========================

    private By newUserSignupText =
            By.xpath("//h2[text()='New User Signup!']");

    private By nameField =
            By.cssSelector("[data-qa='signup-name']");

    private By emailField =
            By.cssSelector("[data-qa='signup-email']");

    private By signupButton =
            By.cssSelector("[data-qa='signup-button']");

    // =========================
    // Login Locators
    // =========================

    private By loginToYourAccountText =
            By.xpath("//h2[text()='Login to your account']");

    private By loginEmailField =
            By.cssSelector("[data-qa='login-email']");

    private By loginPasswordField =
            By.cssSelector("[data-qa='login-password']");

    private By loginButton =
            By.cssSelector("[data-qa='login-button']");

    private By loginErrorMessage =
            By.xpath("//p[text()='Your email or password is incorrect!']");

    private By emailAlreadyExistsMessage =
            By.xpath("//p[contains(text(),'Email Address already exist!')]");

    // =========================
    // Constructor
    // =========================

    public LoginSignupPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the New User Signup section is displayed.
     */
    public boolean isNewUserSignupVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        newUserSignupText))
                .isDisplayed();
    }

    /*
     * Verify that the Login to your account section is displayed.
     */
    public boolean isLoginToYourAccountVisible() {

        return driver.findElement(loginToYourAccountText)
                .isDisplayed();
    }

    /*
     * Verify that the login error message is displayed.
     */
    public boolean isLoginErrorMessageVisible() {

        return driver.findElement(loginErrorMessage)
                .isDisplayed();
    }

    /*
     * Verify that the Email Address already exists message is displayed.
     */
    public boolean isEmailAlreadyExistsMessageVisible() {

        return driver.findElement(emailAlreadyExistsMessage)
                .isDisplayed();
    }

    // =========================
    // Signup Actions
    // =========================

    /*
     * Enter the user's name and email, then click the Signup button.
     */
    public void enterSignupData(String name, String email) {

        driver.findElement(nameField)
                .sendKeys(name);

        driver.findElement(emailField)
                .sendKeys(email);

        safeClick(signupButton);
    }

    // =========================
    // Login Actions
    // =========================

    /*
     * Enter the user's email address.
     */
    public void enterLoginEmail(String email) {

        driver.findElement(loginEmailField)
                .sendKeys(email);
    }

    /*
     * Enter the user's password.
     */
    public void enterLoginPassword(String password) {

        driver.findElement(loginPasswordField)
                .sendKeys(password);
    }

    /*
     * Click the Login button.
     */
    public void clickLoginButton() {

    	safeClick(loginButton);
    }
}