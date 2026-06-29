package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

import org.testng.annotations.Listeners;
import listeners.TestExecutionListener;

@Listeners(TestExecutionListener.class)

public class BaseTest {


    // WebDriver
    protected WebDriver driver;

    /*
     * Initialize the Chrome browser and navigate to the application URL.
     */
    @BeforeSuite
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
    	
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--disable-extensions");
        //options.addArguments("--load-extension=src/test/resources/uBlock0.chromium");

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(ConfigReader.getProperty("baseUrl"));

        handleGoogleVignette();
    }

    
    
    // =========================
    // Advertisement Helpers
    // =========================

    /*
     * Remove Google advertisements if they appear.
     */
    protected void handleGoogleVignette() {

        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "document.querySelectorAll("
                  + "'.google-auto-placed,"
                  + ".adsbygoogle,"
                  + "ins.adsbygoogle,"
                  + "iframe[src*=\"google\"],"
                  + "iframe[id*=\"google\"]')"
                  + ".forEach(function(e){e.remove();});");

            try {

                new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(ExpectedConditions.elementToBeClickable(
                                By.xpath("//div[text()='Close']")))
                        .click();

            } catch (Exception ignored) {
            }

            } catch (Exception ignored) {
            }
        
    }


    
    
    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}