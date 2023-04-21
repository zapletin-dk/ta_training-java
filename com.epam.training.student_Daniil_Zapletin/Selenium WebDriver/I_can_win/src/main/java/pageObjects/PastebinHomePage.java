package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageObjects.constants.Constants.Selectors.*;
import static pageObjects.constants.Constants.TimeOutVariable.*;

public class PastebinHomePage {
    private WebDriver driver;
    @FindBy(xpath = inputFormSelector)
    private WebElement inputForm;
    @FindBy(xpath = pasteExpirationSelectSelector)
    private WebElement pasteExpirationSelect;
    @FindBy(xpath = pasteExpirationChoiceSelector)
    private WebElement pasteExpirationChoice;
    @FindBy(xpath = pasteNameInputFieldSelector)
    private WebElement pasteNameInputField;
    @FindBy(xpath = submitButtonSelector)
    private WebElement submitButton;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
        waitForElementLocatedBy(driver, By.xpath(inputFormSelector));
        return this;
    }

    public PastebinHomePage inputTextInPaste() {
        inputForm.sendKeys(INPUT_TEXT);
        return this;
    }

    public PastebinHomePage selectPasteExpirationTime() {
        pasteExpirationSelect.click();
        pasteExpirationChoice.click();
        return this;
    }

    public PastebinHomePage inputTitleName() {
        pasteNameInputField.sendKeys(TITLE_TEXT);
        return this;
    }

    public PastebinHomePage submitForm() {
        submitButton.click();
        return this;
    }

    public void closePage() {
        driver.quit();
        driver = null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver,
                Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
