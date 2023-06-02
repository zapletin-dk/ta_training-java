package page.object.google.cloud;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.object.AbstractPage;

public class GoogleCloudHomePage extends AbstractPage {
    public static final String HOME_PAGE_URL = "https://cloud.google.com/";
    public static final String SEARCH_TERM = "Google Cloud Platform Pricing Calculator";
    public static final String HOME_PAGE_SEARCH_SELECTOR = "//input[@name='q']";
    @FindBy(xpath = HOME_PAGE_SEARCH_SELECTOR)
    WebElement homePageSearch;

    public GoogleCloudHomePage(WebDriver driver, Logger logger){
        super(driver, logger);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudHomePage openPage(){
        logger.info("Trying to open the Google Cloud home page");
        driver.manage().deleteAllCookies();
        driver.get(HOME_PAGE_URL);
        driver.manage().window().maximize();
        logger.info("The Google Cloud home page has been opened");
        return this;
    }
    public GoogleCloudSearchResultPage searchOnRequest(){
        waitUntilVisibility(homePageSearch).click();
        homePageSearch.sendKeys(SEARCH_TERM);
        homePageSearch.submit();
        logger.info("Redirecting to the Google Cloud Pricing Calculator search page");
        return new GoogleCloudSearchResultPage(driver, logger);
    }
}
