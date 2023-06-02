package page.object;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final Logger logger;
    public static final int EXPLICIT_WAIT = 5;

    protected AbstractPage(WebDriver driver, Logger logger)
    {
        this.driver = driver;
        this.logger = LogManager.getRootLogger();
    }
    protected WebElement waitUntilVisibility(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(webElement));
    }
    protected WebElement waitUntilVisibility(String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
    protected void tearDown() {
        driver.quit();
    }
}
