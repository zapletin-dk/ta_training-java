package page.object.yopmail;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.object.AbstractPage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class YopmailPage extends AbstractPage {
    private String mailHomePageHandle;
    public static final String MAIL_PAGE_URL = "https://yopmail.com/";
    public static final String GENERATE_NEW_EMAIL_LINK = "//h3[contains(text(),'Случайный адрес электронной почты')]";
    public static final String GENERATED_EMAIL = "//div[@id='egen']";
    public static final String CHECK_MAIL_BOX_BUTTON = "//button[@onclick='egengo();']";
    public static final String TOTAL_ESTIMATED_COST = "//td/h3[contains(text(), 'USD')]";
    @FindBy(xpath = GENERATE_NEW_EMAIL_LINK)
    private WebElement newEmail;
    @FindBy(xpath = GENERATED_EMAIL)
    private WebElement generatedEmail;
    @FindBy(xpath = CHECK_MAIL_BOX_BUTTON)
    private WebElement mailBoxButton;
    @FindBy(xpath = TOTAL_ESTIMATED_COST)
    private WebElement totalEstimatedCost;
    public YopmailPage(WebDriver driver, Logger logger){
        super(driver, logger);
        PageFactory.initElements(driver, this);
    }

    public YopmailPage openPage(){
        logger.info("Trying to open the Yopmail home page");
        driver.manage().deleteAllCookies();
        driver.get(MAIL_PAGE_URL);
        driver.manage().window().maximize();
        mailHomePageHandle = driver.getWindowHandle();
        logger.info("The Yopmail home page has been opened");
        return this;
    }
    public YopmailPage generateEmail(){
        logger.info("Trying to generate random email");
        waitUntilVisibility(newEmail).click();
        logger.info("Random email has been created");
        return this;
    }

    public String getEmailAddress(){
        return waitUntilVisibility(generatedEmail).getText();
    }

    public YopmailPage checkEmailBox(){
        logger.info("Trying to check email box");
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(mailBoxButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", mailBoxButton);
        logger.info("Redirected to email box");
        return this;
    }

    public String getMailHomePageHandle() {
        return mailHomePageHandle;
    }

    public String getTotalEstimatedCost() {
        logger.info("Trying to search for email message in mail box");
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, Boolean> function = driver -> {
            if (driver.switchTo().frame("ifmail")
                    .findElements(By.xpath(TOTAL_ESTIMATED_COST))
                    .isEmpty())
            {
                driver.navigate().refresh();
                return false;
            }
            return true;
        };
        wait.until(function);
        logger.info("Email has been parsed");
        return totalEstimatedCost.getAttribute("textContent");
    }
}
