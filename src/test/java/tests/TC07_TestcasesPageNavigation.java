package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.TestCasesPage;

public class TC07_TestcasesPageNavigation extends BaseTest {

    @Test
    public void verifyTestCasesPageSuccessfully() {

        // ==========================================
        // Initialize Page Objects
        // ==========================================
        HomePage homePage = new HomePage(driver);
        TestCasesPage testCasesPage =
                new TestCasesPage(driver);

        // ==========================================
        // Step 1,2,3
        // Launch Browser + Navigate URL + Verify Home Page
        // ==========================================
        Assert.assertTrue(
                homePage.isHomePageVisible());

        // ==========================================
        // Step 4
        // Click Test Cases Button
        // ==========================================
        homePage.clickTestCases();

        // ==========================================
        // Step 5
        // Verify Test Cases Page Is Visible
        // ==========================================
        Assert.assertTrue(
                testCasesPage.isTestCasesPageVisible());

    }
}