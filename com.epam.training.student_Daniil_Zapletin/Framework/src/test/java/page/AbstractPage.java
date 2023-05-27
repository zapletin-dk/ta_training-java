package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static page.Constants.EXPLICIT_WAIT;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final Logger logger;

    protected AbstractPage(WebDriver driver, Logger logger)
    {
        this.driver = driver;
        this.logger = LogManager.getRootLogger();
    }
    protected WebElement waitUntilVisibility(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(webElement));
    }
    protected void tearDown() {
        driver.quit();
    }
}
