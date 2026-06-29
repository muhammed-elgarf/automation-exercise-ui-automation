package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class SignupPage extends BasePage {

    // =========================
    // Enter Account Information Locators
    // =========================

    private By enterAccountInfoText =
            By.xpath("//b[text()='Enter Account Information']");

    private By mrRadioButton =
            By.id("id_gender1");

    private By passwordField =
            By.id("password");

    private By dayDropdown =
            By.id("days");

    private By monthDropdown =
            By.id("months");

    private By yearDropdown =
            By.id("years");

    private By newsletterCheckbox =
            By.id("newsletter");

    private By specialOffersCheckbox =
            By.id("optin");

    // =========================
    // Address Information Locators
    // =========================

    private By firstNameField =
            By.id("first_name");

    private By lastNameField =
            By.id("last_name");

    private By companyField =
            By.id("company");

    private By addressField =
            By.id("address1");

    private By address2Field =
            By.id("address2");

    private By countryDropdown =
            By.id("country");

    private By stateField =
            By.id("state");

    private By cityField =
            By.id("city");

    private By zipCodeField =
            By.id("zipcode");

    private By mobileNumberField =
            By.id("mobile_number");

    // =========================
    // Action Locators
    // =========================

    private By createAccountBtn =
            By.cssSelector("[data-qa='create-account']");

    // =========================
    // Constructor
    // =========================

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Private Helper Methods
    // =========================

    /*
     * Enter text into the specified input field.
     */
    private void type(By locator, String text) {

        driver.findElement(locator)
                .sendKeys(text);
    }

    // =========================
    // Verification Methods
    // =========================

    /*
     * Verify that the Enter Account Information section is displayed.
     */
    public boolean isEnterAccountInformationVisible() {

        return driver.findElement(enterAccountInfoText)
                .isDisplayed();
    }

    // =========================
    // Account Information Actions
    // =========================

    /*
     * Select the Mr. title.
     */
    public void selectMrTitle() {

    	safeClick(mrRadioButton);
    }

    /*
     * Enter the account password.
     */
    public void enterPassword(String password) {

        type(passwordField, password);
    }

    /*
     * Select the birth day.
     */
    public void selectDay(String day) {

        Select selectDay =
                new Select(driver.findElement(dayDropdown));

        selectDay.selectByVisibleText(day);
    }

    /*
     * Select the birth month.
     */
    public void selectMonth(String month) {

        Select selectMonth =
                new Select(driver.findElement(monthDropdown));

        selectMonth.selectByVisibleText(month);
    }

    /*
     * Select the birth year.
     */
    public void selectYear(String year) {

        Select selectYear =
                new Select(driver.findElement(yearDropdown));

        selectYear.selectByVisibleText(year);
    }

    /*
     * Select the complete date of birth.
     */
    public void selectDateOfBirth(String day,
                                  String month,
                                  String year) {

        selectDay(day);
        selectMonth(month);
        selectYear(year);
    }

    /*
     * Subscribe to the newsletter.
     */
    public void selectNewsletter() {

        if (!driver.findElement(newsletterCheckbox).isSelected()) {

            safeClick(newsletterCheckbox);
        }
    }

    /*
     * Subscribe to special offers.
     */
    public void selectSpecialOffers() {

        if (!driver.findElement(specialOffersCheckbox).isSelected()) {

            safeClick(specialOffersCheckbox);
        }
    }

    // =========================
    // Address Information Actions
    // =========================

    /*
     * Enter the user's first name.
     */
    public void enterFirstName(String firstName) {

        type(firstNameField, firstName);
    }

    /*
     * Enter the user's last name.
     */
    public void enterLastName(String lastName) {

        type(lastNameField, lastName);
    }

    /*
     * Enter the company name.
     */
    public void enterCompany(String company) {

        type(companyField, company);
    }

    /*
     * Enter the primary address.
     */
    public void enterAddress(String address) {

        type(addressField, address);
    }

    /*
     * Enter the secondary address.
     */
    public void enterAddress2(String address2) {

        type(address2Field, address2);
    }

    /*
     * Select the country.
     */
    public void selectCountry(String country) {

        Select selectCountry =
                new Select(driver.findElement(countryDropdown));

        selectCountry.selectByVisibleText(country);
    }

    /*
     * Enter the state.
     */
    public void enterState(String state) {

        type(stateField, state);
    }

    /*
     * Enter the city.
     */
    public void enterCity(String city) {

        type(cityField, city);
    }

    /*
     * Enter the ZIP code.
     */
    public void enterZipCode(String zipCode) {

        type(zipCodeField, zipCode);
    }

    /*
     * Enter the mobile number.
     */
    public void enterMobileNumber(String mobileNumber) {

        type(mobileNumberField, mobileNumber);
    }

    // =========================
    // Action Methods
    // =========================

    /*
     * Click the Create Account button.
     */
    public void clickCreateAccount() {

    	safeClick(createAccountBtn);
    }
}