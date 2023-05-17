package mailPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static mailPageObjects.Constants.*;

public class YopmailPage {
    WebDriver driver;
    private String mailHomePageHandle;
    @FindBy(xpath = GENERATE_NEW_EMAIL_LINK)
    private WebElement newEmail;
    @FindBy(xpath = GENERATED_EMAIL)
    private WebElement generatedEmail;
    @FindBy(xpath = CHECK_MAIL_BOX_BUTTON)
    private WebElement mailBoxButton;
    @FindBy(xpath = TOTAL_ESTIMATED_COST)
    private WebElement totalEstimatedCost;
    public YopmailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YopmailPage openPage(){
        driver.manage().deleteAllCookies();
        driver.get(MAIL_PAGE_URL);
        driver.manage().window().maximize();
        mailHomePageHandle = driver.getWindowHandle();
        return this;
    }
    public YopmailPage generateEmail(){
        waitUntilVisibility(newEmail).click();
        return this;
    }

    public String getEmailAddress(){
        return waitUntilVisibility(generatedEmail).getText();
    }

    public YopmailPage checkEmailBox(){
        waitUntilVisibility(mailBoxButton).click();
        return this;
    }

    public String getMailHomePageHandle() {
        return mailHomePageHandle;
    }

    public String getTotalEstimatedCost() {
        while (driver.switchTo().frame("ifmail").findElements(By.xpath(TOTAL_ESTIMATED_COST)).isEmpty()){
            driver.navigate().refresh();
        }

        return totalEstimatedCost.getAttribute("textContent");
    }

    private WebElement waitUntilVisibility(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(webElement));
    }
}
