package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactUsPage;
import pages.HomePage;
import utilities.JsonReader;

public class TC06_ContactUsForm extends BaseTest {

    @Test
    public void contactUsForm() {

        // =========================
        // Read Test Data From JSON
        // =========================

        Map<String, String> contactData =
                JsonReader.getJsonData("contact.json");

        // =========================
        // Initialize Page Objects
        // =========================

        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        // =========================
        // Step 3: Verify Home Page
        // =========================

        Assert.assertTrue(homePage.isHomePageVisible());

        // =========================
        // Step 4: Click Contact Us
        // =========================

        homePage.clickContactUs();

        // =========================
        // Step 5: Verify GET IN TOUCH
        // =========================

        Assert.assertTrue(contactUsPage.isGetInTouchVisible());

        // =========================
        // Step 6: Enter Contact Data
        // =========================

        contactUsPage.enterName(contactData.get("name"));
        contactUsPage.enterEmail(contactData.get("email"));
        contactUsPage.enterSubject(contactData.get("subject"));
        contactUsPage.enterMessage(contactData.get("message"));

        // =========================
        // Step 7: Upload File
        // =========================

        String filePath =
                System.getProperty("user.dir")
                + "/src/test/resources/files/muhammed.txt";

        contactUsPage.uploadFile(filePath);

        // =========================
        // Step 8: Click Submit
        // =========================

        contactUsPage.clickSubmitButton();

        // =========================
        // Step 9: Accept Alert
        // =========================

        contactUsPage.acceptAlert();

        // =========================
        // Step 10: Verify Success Message
        // =========================

        Assert.assertTrue(contactUsPage.isSuccessMessageVisible());

        // =========================
        // Step 11: Click Home Button
        // =========================

        contactUsPage.clickHomeButton();
	    handleGoogleVignette();

        // =========================
        // Verify Home Page
        // =========================

        Assert.assertTrue(homePage.isHomePageVisible());
    }
}