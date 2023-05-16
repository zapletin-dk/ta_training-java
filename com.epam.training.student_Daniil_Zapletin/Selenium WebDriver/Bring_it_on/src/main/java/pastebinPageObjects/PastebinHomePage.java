package pastebinPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pastebinPageObjects.constants.Constants.HomePageSelectors.*;
import static pastebinPageObjects.constants.Constants.HomePageConstantVariables.*;

public class PastebinHomePage {
    private WebDriver driver;
    @FindBy(xpath = INPUT_FORM_SELECTOR)
    private WebElement inputForm;
    @FindBy(xpath = SYNTAX_HIGHLIGHTING_OPTION_SELECTOR)
    private WebElement syntaxHighlightingOption;
    @FindBy(xpath = SYNTAX_HIGHLIGHTING_CHOICE_SELECTOR)
    private WebElement syntaxHighlightingChoice;
    @FindBy(xpath = PASTE_EXPIRATION_OPTION_SELECTOR)
    private WebElement pasteExpirationOption;
    @FindBy(xpath = PASTE_EXPIRATION_CHOICE_SELECTOR)
    private WebElement pasteExpirationChoice;
    @FindBy(xpath = PASTE_TITLE_NAME_SELECTOR)
    private WebElement pasteTitleName;
    @FindBy(xpath = SUBMIT_BUTTON_SELECTOR)
    private WebElement submitButton;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
        waitForElementLocatedBy(driver, inputForm);
        return this;
    }

    public PastebinHomePage inputTextInPaste() {
        inputForm.sendKeys(INPUT_TEXT);
        return this;
    }
    public PastebinHomePage selectSyntaxHighlighting() {
        syntaxHighlightingOption.click();
        waitForElementLocatedBy(driver, syntaxHighlightingChoice).click();
        return this;
    }

    public PastebinHomePage selectPasteExpirationTime() {
        pasteExpirationOption.click();
        waitForElementLocatedBy(driver, pasteExpirationChoice).click();
        return this;
    }

    public PastebinHomePage inputTitleName() {
        pasteTitleName.sendKeys(TITLE_TEXT);
        return this;
    }

    public PastebinSubmittedPage submitForm() {
        submitButton.click();
        return new PastebinSubmittedPage(driver);
    }

    public void closePage() {
        driver.quit();
        driver = null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver,
                Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

}
