package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static page.Constants.HomePageConstants.*;

public class GoogleCloudHomePage extends AbstractPage {
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
