package framework;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumFrameWork {
    private WebDriver driver;
    private static WebDriverWait explicitWait;
    private final int DEFAULT_TIMEOUT = 10;

    // Initialize the browser
    public void Edges_initializeBrowser() {
        //driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        System.out.println("Edges: Browser Initialized.");
    }

    // Browser implicitly wait
    public void Edges_implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        System.out.println("Edges: Set Implicit Wait to " + seconds + " seconds.");
    }

    // Explicit wait for element presence
    public void Edges_explicitWait(By locator, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        System.out.println("Edges: Explicit wait for presence of " + locator);
    }

    // Fluent wait for element visibility with customizable timeout and polling interval
    public void Edges_fluentWait(By locator, int timeoutSeconds, int pollingMillis, String timeoutMessage) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(timeoutSeconds))
            .pollingEvery(Duration.ofMillis(pollingMillis))
            .withMessage(timeoutMessage)
            .ignoring(NoSuchElementException.class);

    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    System.out.println("Edges: Fluent wait found element " + locator);
}


    // Navigate to URL
    public void Edges_navigateToURL(String url) {
        driver.get(url);
        System.out.println("Edges: Navigated to URL: " + url);
    }
    

    // Get page title
    public String Edges_getPageTitle() {
        String title = driver.getTitle();
        System.out.println("Edges: Page title is '" + title + "'");
        return title;
    }

    // Get current URL
    public String Edges_getCurrentURL() {
        String currentURL = driver.getCurrentUrl();
        System.out.println("Edges: Current URL is '" + currentURL + "'");
        return currentURL;
    }
    
    public void waitUntilClickable(By locator, int timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    wait.until(ExpectedConditions.elementToBeClickable(locator));
}

    // Click element using explicit wait
    public void Edges_click(By locator) {
        explicitWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        System.out.println("Edges: Clicked element " + locator);
    }

    // Right click (context click) on element
    public void Edges_rightClick(By locator) {
        WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        System.out.println("Edges: Right-clicked on element " + locator);
    }

    // Send keys to element
    public void Edges_sendKeys(By locator, String text) {
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
        System.out.println("Edges: Sent keys to element " + locator);
    }
    
    public void hoverAndClick(By locator) {
    try {
        // Scroll للعنصر
        Edges_scrollToElement(locator);

        // Hover على العنصر
        Edges_hoverOverElement(locator);

        // انتظر العنصر يكون clickable ثم اضغط
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        // Click
        driver.findElement(locator).click();
    } catch (Exception e) {
        // Retry مرة واحدة
        System.out.println("Retrying hoverAndClick for locator: " + locator);
        Edges_scrollToElement(locator);
        Edges_hoverOverElement(locator);
        driver.findElement(locator).click();
    }
}

    // Get text from element
    public String Edges_getText(By locator) {
        String text = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        System.out.println("Edges: Got text from element " + locator + ": " + text);
        return text;
    }

    // Dropdown handling by visible text
    public void Edges_selectDropdownByVisibleText(By locator, String visibleText) {
        WebElement dropdown = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
        System.out.println("Edges: Selected dropdown value by visible text: " + visibleText);
    }

    // Dropdown handling by value
    public void Edges_selectDropdownByValue(By locator, String value) {
        WebElement dropdown = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select select = new Select(dropdown);
        select.selectByValue(value);
        System.out.println("Edges: Selected dropdown value by value: " + value);
    }

    // Dropdown handling by index
    public void Edges_selectDropdownByIndex(By locator, int index) {
        WebElement dropdown = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select select = new Select(dropdown);
        select.selectByIndex(index);
        System.out.println("Edges: Selected dropdown by index: " + index);
    }

    // Drag and drop element
    public void Edges_dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
        WebElement target = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
        System.out.println("Edges: Dragged element " + sourceLocator + " and dropped on " + targetLocator);
    }

    // Checkbox handling: check checkbox
    public void Edges_checkCheckbox(By locator) {
        WebElement checkbox = explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Edges: Checked the checkbox " + locator);
        } else {
            System.out.println("Edges: Checkbox already checked " + locator);
        }
    }

    // Checkbox handling: uncheck checkbox
    public void Edges_uncheckCheckbox(By locator) {
        WebElement checkbox = explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
        if (checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Edges: Unchecked the checkbox " + locator);
        } else {
            System.out.println("Edges: Checkbox already unchecked " + locator);
        }
    }

    // Radio button handling: select radio button
    public void Edges_selectRadioButton(By locator) {
        WebElement radioButton = explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
        if (!radioButton.isSelected()) {
            radioButton.click();
            System.out.println("Edges: Selected radio button " + locator);
        } else {
            System.out.println("Edges: Radio button already selected " + locator);
        }
    }

    // Window handle: switch to window by title
    public void Edges_switchToWindowByTitle(String windowTitle) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(windowTitle)) {
                System.out.println("Edges: Switched to window with title: " + windowTitle);
                return;
            }
        }

        driver.switchTo().window(currentWindow);
        System.out.println("Edges: Window with title '" + windowTitle + "' not found. Stayed in original window.");
    }

    // Window handle: switch to window by handle
    public void Edges_switchToWindowByHandle(String windowHandle) {
        Set<String> allWindows = driver.getWindowHandles();
        if (allWindows.contains(windowHandle)) {
            driver.switchTo().window(windowHandle);
            System.out.println("Edges: Switched to window handle: " + windowHandle);
        } else {
            System.out.println("Edges: Window handle " + windowHandle + " does not exist. No switch performed.");
        }
    }


    // Close current window
    public void Edges_closeCurrentWindow() {
        driver.close();
        System.out.println("Edges: Closed current window.");
    }

    // Navigate back
    public void Edges_navigateBack() {
        driver.navigate().back();
        System.out.println("Edges: Navigated back.");
    }

    // Navigate forward
    public void Edges_navigateForward() {
        driver.navigate().forward();
        System.out.println("Edges: Navigated forward.");
    }

    // Refresh the page
    public void Edges_refreshPage() {
        driver.navigate().refresh();
        System.out.println("Edges: Page refreshed.");
    }

    // Scroll to element using JavaScript
    public void Edges_scrollToElement(By locator) {
        WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
        System.out.println("Edges: Scrolled to element " + locator + " using Actions.scrollToElement().");
    }

    // Handle alert: accept alert
    public void Edges_acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        System.out.println("Edges: Alert accepted.");
    }


    // Handle alert: dismiss alert
    public void Edges_dismissAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        System.out.println("Edges: Alert dismissed.");
    }

    // Handle alert: get alert text
    public String Edges_getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        System.out.println("Edges: Alert text: " + text);
        return text;
    }

    public void Edges_sendTextToAlert(String text) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.sendKeys(text);
    alert.accept();
    System.out.println("Edges: Sent text to alert and accepted it: " + text);
    }
    
    public boolean Element_is_displayed(By locator) {
         WebElement element = explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
        if (element.isDisplayed()) {
            
            System.out.println("the element is displayed " + locator);
            return true;
        } else {
            System.out.println("the element is not displayed " + locator);
            return false;
        }
    }
    
    // Hover over element (move mouse without clicking)
    public void Edges_hoverOverElement(By locator) {
        WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        System.out.println("Edges: Hovered over element " + locator);
    }
    
    // get list of elements
    public List<WebElement> Edges_findElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        System.out.println("Edges: Found " + elements.size() + " elements for " + locator);
        return elements;
}
    



    public int Elements_count(By locator) {
    List<WebElement> elements = explicitWait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(locator)
    );
    int size = elements.size();
    System.out.println("Edges: Found " + size + " elements for locator: " + locator);
    return size;
}
    
    // Get text from element (like price, quantity, total) and return it as String
public String Edges_getElementText(By locator) {
    WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    String text = element.getText().trim();
    System.out.println("Edges: Got text from " + locator + " = " + text);
    return text;
}

// Convert price string like "$500" or "Rs. 500" to integer
public int Edges_extractPrice(String priceText) {
    // Remove everything except digits
    String numberOnly = priceText.replaceAll("[^0-9]", "");
    int value = Integer.parseInt(numberOnly);
    System.out.println("Edges: Converted price text '" + priceText + "' to integer: " + value);
    return value;
}

// Get list of elements
public List<WebElement> Edges_getElements(By locator) {
    List<WebElement> elements = explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    System.out.println("Edges: Found " + elements.size() + " elements for " + locator);
    return elements;
}

// Clear text from input
public void Edges_clear(By locator) {
    explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    System.out.println("Edges: Cleared text from element " + locator);
}

    // Check if a file is downloaded in the given folder
    public boolean Edges_isFileDownloaded(String downloadPath, String fileName) {
    File file = new File(downloadPath + File.separator + fileName);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    boolean isDownloaded = wait.until((ExpectedCondition<Boolean>) wd -> file.exists());

    if (isDownloaded) {
        System.out.println("File downloaded successfully: " + fileName);
    } else {
        System.out.println("File not found: " + fileName);
    }

    return isDownloaded;
}

By AdIframe = By.cssSelector("iframe[id^='aswift']");
public void closeAdIfPresent() {
    try {
        if (driver.findElements(AdIframe).size() > 0) {
            driver.switchTo().frame(driver.findElement(AdIframe));
            driver.findElement(By.cssSelector("button[aria-label='Close']")).click();
            driver.switchTo().defaultContent();
        }
    } catch (Exception e) {
        driver.switchTo().defaultContent();
    }
}
    
public void safeClick(By locator) {
    int attempts = 0;
    while (attempts < 3) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            
            // Scroll to element
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            // Try normal click
            element.click();
            return; // success -> exit
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted! Retrying... Attempt " + (attempts + 1));

            // Try JS Click as fallback
            try {
                WebElement element = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                return;
            } catch (Exception jsEx) {
                // ignore and retry
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on element: " + locator, e);
        }
        attempts++;
    }
    throw new RuntimeException("Failed to click element after retries: " + locator);
}

public void Edges_hoverAndClick(By locator) {
    int attempts = 0;
    while (attempts < 3) {
        try {
            // 1. الحصول على العنصر
            WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            // 2. عمل hover
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();

            // 3. Scroll to element
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            // 4. انتظار أن يكون clickable ثم click
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();

            return; // نجاح -> خروج من الميثود
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted! Retrying hoverAndClick... Attempt " + (attempts + 1));
            try {
                WebElement element = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                return;
            } catch (Exception jsEx) {
                // ignore and retry
            }
        } catch (Exception e) {
            System.out.println("hoverAndClick failed attempt " + (attempts + 1) + " for " + locator);
        }
        attempts++;
    }
    throw new RuntimeException("Failed to hoverAndClick element after retries: " + locator);
}

public void Edges_safeClick(By locator) {
    int attempts = 0;
    while (attempts < 3) { // نجرب 3 مرات
        try {
            Edges_scrollToElement(locator);      // نضمن العنصر ظاهر على الشاشة
            Edges_hoverOverElement(locator);     // نعمل hover لو محتاج
            driver.findElement(locator).click(); // نعمل click
            return;                              // لو نجح نخرج
        } catch (ElementClickInterceptedException e) {
            try {
                Thread.sleep(500);               // ننتظر نص ثانية قبل المحاولة التالية
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        attempts++;
    }
    throw new RuntimeException("Failed to click on element: " + locator);
}


    
    // Close the browser
    public void Edges_closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Edges: Browser Closed.");
        }
    }
}