import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pastebinPageObjects.PastebinHomePage;
import pastebinPageObjects.PastebinSubmittedPage;

import java.util.Arrays;

import static pastebinPageObjects.constants.Constants.HomePageConstantVariables.INPUT_TEXT;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        /**
         * If you are using selenium less than 4.8.2 version
         * to avoid ChromeDriver exception you'll need to add
         * ChromeOptions options = new ChromeOptions();
         * options.addArguments("--remote-allow-origins=*");
         * WebDriver driver = new ChromeDriver(options);
         */
        WebDriver driver = new ChromeDriver();
        PastebinHomePage page = new PastebinHomePage(driver);

        PastebinSubmittedPage subPage = page
                .openPage()
                .inputTextInPaste()
                .selectSyntaxHighlighting()
                .selectPasteExpirationTime()
                .inputTitleName().submitForm().waitForElementsToLoad();
        System.out.println("paste length = " + subPage.getPasteText().length());
        System.out.println("Input length = " + INPUT_TEXT.length());
        System.out.println(Arrays.toString(subPage.getPasteText().toCharArray()));
        System.out.println(Arrays.toString(INPUT_TEXT.toCharArray()));
        System.out.println(INPUT_TEXT.equals(subPage.getPasteText()));
        for (int i =0; i < INPUT_TEXT.length(); i++ ){
            System.out.println((int)INPUT_TEXT.toCharArray()[i] + " = " + (int)subPage.getPasteText().toCharArray()[i]);
            System.out.println(INPUT_TEXT.toCharArray()[i] == subPage.getPasteText().toCharArray()[i]);
        }
//        subPage.closePage();

    }
}