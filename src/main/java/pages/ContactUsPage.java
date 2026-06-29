package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class ContactUsPage extends BasePage {

    // =========================
    // Contact Us Page Locators
    // =========================

    private By getInTouchText =
            By.xpath("//h2[text()='Get In Touch']");

    private By nameField =
            By.cssSelector("[data-qa='name']");

    private By emailField =
            By.cssSelector("[data-qa='email']");

    private By subjectField =
            By.cssSelector("[data-qa='subject']");

    private By messageField =
            By.cssSelector("[data-qa='message']");

    private By uploadFileField =
            By.cssSelector("input[name='upload_file']");

    private By submitButton =
            By.cssSelector("[data-qa='submit-button']");

    private By successMessage =
            By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");

    private By homeButton =
            By.xpath("//a[@href='/']");

    // =========================
    // Constructor
    // =========================

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the Get In Touch section is displayed.
     */
    public boolean isGetInTouchVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(getInTouchText))
                .isDisplayed();
    }

    /*
     * Verify that the success message is displayed after submitting the form.
     */
    public boolean isSuccessMessageVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage))
                .isDisplayed();
    }

    // =========================
    // Contact Form Actions
    // =========================

    /*
     * Enter the user's name.
     */
    public void enterName(String name) {

        driver.findElement(nameField)
                .sendKeys(name);
    }

    /*
     * Enter the user's email address.
     */
    public void enterEmail(String email) {

        driver.findElement(emailField)
                .sendKeys(email);
    }

    /*
     * Enter the subject of the message.
     */
    public void enterSubject(String subject) {

        driver.findElement(subjectField)
                .sendKeys(subject);
    }

    /*
     * Enter the message details.
     */
    public void enterMessage(String message) {

        driver.findElement(messageField)
                .sendKeys(message);
    }

    /*
     * Upload a file using the file input field.
     */
    public void uploadFile(String filePath) {

        driver.findElement(uploadFileField)
                .sendKeys(filePath);
    }

    /*
     * Submit the Contact Us form.
     */
    public void clickSubmitButton() {

        safeClick(submitButton);
    }

    /*
     * Accept the confirmation alert displayed after form submission.
     */
    public void acceptAlert() {

        wait.until(
                ExpectedConditions.alertIsPresent());

        driver.switchTo()
                .alert()
                .accept();
    }

    // =========================
    // Navigation Methods
    // =========================

    /*
     * Click the Home button to navigate back to the Home page.
     */
    public void clickHomeButton() {

        safeClick(homeButton);
    }
}