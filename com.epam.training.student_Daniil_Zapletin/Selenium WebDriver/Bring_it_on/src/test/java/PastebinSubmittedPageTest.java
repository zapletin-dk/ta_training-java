import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pastebinPageObjects.PastebinHomePage;
import pastebinPageObjects.PastebinSubmittedPage;

import static pastebinPageObjects.constants.Constants.HomePageConstantVariables.INPUT_TEXT;
import static pastebinPageObjects.constants.Constants.HomePageConstantVariables.TITLE_TEXT;
import static pastebinPageObjects.constants.Constants.SubmittedPage.EXPECTED_SYNTAX_HIGHLIGHTING;


public class PastebinSubmittedPageTest {

    private WebDriver driver;
    private PastebinSubmittedPage submittedPage;

    /**
     * If you are using selenium less than 4.8.2 version
     * to avoid ChromeDriver exception you'll need to add
     * ChromeOptions options = new ChromeOptions();
     * options.addArguments("--remote-allow-origins=*");
     * driver = new ChromeDriver(options);
     */
    @BeforeClass
    public void pastebinPageOpenAndSubmit() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        submittedPage = pastebinHomePage
                .openPage()
                .inputTextInPaste()
                .selectSyntaxHighlighting()
                .selectPasteExpirationTime()
                .inputTitleName()
                .submitForm()
                .waitForElementsToLoad();
    }

    @Test
    public void titleNameTest() {
        Assert.assertEquals(submittedPage.getPageTitleText(), TITLE_TEXT,
                "Something went wrong! The page title doesn't match!");
    }

    @Test
    public void syntaxHighlightingTest() {
        Assert.assertEquals(submittedPage.getSyntaxHighlighting(), EXPECTED_SYNTAX_HIGHLIGHTING,
                "Something went wrong! The syntax highlighting doesn't match!");
    }

    @Test
    public void pasteTextTest() {
        Assert.assertEquals(submittedPage.getPasteText(), INPUT_TEXT, "Something went wrong! The paste text doesn't match!");
    }

    @AfterClass
    public void browserTearDown() {
        driver.quit();
    }
}