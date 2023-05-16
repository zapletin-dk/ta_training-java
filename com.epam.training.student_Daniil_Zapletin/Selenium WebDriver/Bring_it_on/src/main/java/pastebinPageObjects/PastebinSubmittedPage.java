package pastebinPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pastebinPageObjects.constants.Constants.HomePageConstantVariables.EXPLICIT_WAIT;
import static pastebinPageObjects.constants.Constants.SubmittedPage.*;

public class PastebinSubmittedPage {
    private WebDriver driver;
    @FindBy(xpath = TITLE_TEXT_SELECTOR)
    private WebElement titleText;
    @FindBy(xpath = SYNTAX_HIGHLIGHTING_SELECTOR)
    private WebElement syntaxHighlighting;
    @FindBy(xpath = PASTE_TEXT_BLOCK_SELECTOR)
    private WebElement pasteText;


    public PastebinSubmittedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinSubmittedPage waitForElementsToLoad(){
        new WebDriverWait(driver,
                Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                        TITLE_TEXT_SELECTOR + "|" +
                                SYNTAX_HIGHLIGHTING_SELECTOR + "|" +
                                PASTE_TEXT_BLOCK_SELECTOR)));
        return this;
    }
    public String getPageTitleText() {
        return titleText.getText();
    }

    public String getSyntaxHighlighting() {
        return syntaxHighlighting.getText();
    }
    public String getPasteText() { return pasteText.getText(); }
    public void closePage() {
        driver.quit();
    }

}
