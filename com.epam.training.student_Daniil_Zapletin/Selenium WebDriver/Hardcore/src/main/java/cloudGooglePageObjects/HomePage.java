package cloudGooglePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static cloudGooglePageObjects.Constants.HomePageConstants.*;

public class HomePage {
    private WebDriver driver;
    @FindBy (xpath = HOME_PAGE_SEARCH_SELECTOR)
    WebElement homePageSearch;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(){
        driver.manage().deleteAllCookies();
        driver.get(HOME_PAGE_URL);
        driver.manage().window().maximize();
        return this;
    }
    public SearchResultsPage searchOnRequest(){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOf(homePageSearch)).click();
        homePageSearch.sendKeys(SEARCH_TERM);
        homePageSearch.submit();

        return new SearchResultsPage(driver);
    }

    public void pageTearDown(){
        driver.quit();
        driver = null;
    }
}