import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.PastebinHomePage;

public class Main {
    public static void main(String[] args) {
        PastebinHomePage pastebinHomePage = new PastebinHomePage(new ChromeDriver());
        pastebinHomePage.openPage()
                .inputTextInPaste()
                .selectPasteExpirationTime()
                .inputTitleName()
                .submitForm()
                .closePage();
    }
}

