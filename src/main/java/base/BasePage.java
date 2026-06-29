package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }


    /*
     * Click element safely.
     */
    protected void safeClick(By locator) {

        for (int i = 0; i < 5; i++) {

            try {

                // Remove Google Ads overlays if present
                js.executeScript(
                        "document.querySelectorAll('.google-auto-placed,"
                      + ".adsbygoogle,"
                      + "ins.adsbygoogle,"
                      + "iframe[src*=\"google\"],"
                      + "iframe[id*=\"google\"]').forEach(function(e){e.remove();});");

                // Try to close Google Vignette if Close button exists
                try {

                    WebElement closeButton =
                            new WebDriverWait(driver, Duration.ofSeconds(1))
                                    .until(ExpectedConditions.presenceOfElementLocated(
                                            By.xpath("//*[normalize-space()='Close']")));

                    js.executeScript(
                            "arguments[0].click();",
                            closeButton);

                } catch (Exception ignored) {
                }

                // =========================
                // Wait Time
                // =========================

                long waitStart = System.currentTimeMillis();

                WebElement element =
                        wait.until(ExpectedConditions.elementToBeClickable(locator));

                long waitTime = System.currentTimeMillis() - waitStart;

                // =========================
                // Scroll Time
                // =========================

                long scrollStart = System.currentTimeMillis();

                js.executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        element);

                long scrollTime = System.currentTimeMillis() - scrollStart;

                // =========================
                // Click Time
                // =========================

                long clickStart = System.currentTimeMillis();

                try {

                    element.click();

                } catch (Exception e) {

                    System.out.println("Normal click failed, using JavaScript click...");

                    js.executeScript(
                            "arguments[0].click();",
                            element);
                }

                long clickTime = System.currentTimeMillis() - clickStart;

                // =========================
                // Performance Log
                // =========================

                System.out.println("\n======================================");
                System.out.println("Locator : " + locator);
                System.out.println("WAIT    : " + waitTime + " ms");
                System.out.println("SCROLL  : " + scrollTime + " ms");
                System.out.println("CLICK   : " + clickTime + " ms");
                System.out.println("TOTAL   : " + (waitTime + scrollTime + clickTime) + " ms");
                System.out.println("======================================");

                // If Alert appears, click succeeded
                try {

                    driver.switchTo().alert();

                    return;

                } catch (Exception ignored) {
                }

                // Retry only if Google Vignette page is opened
                if (driver.getCurrentUrl().contains("google_vignette")) {

                    continue;
                }

                return;

            } catch (Exception e) {

                System.out.println("========== Attempt " + (i + 1) + " ==========");
                e.printStackTrace();
            }
        }

        throw new RuntimeException(
                "Unable to click element after multiple attempts.");
    }
    
}
    
