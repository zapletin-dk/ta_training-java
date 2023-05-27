package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static page.Constants.SearchResultsPageConstants.PLATFORM_PRICING_CALCULATOR_SELECTOR;

public class GoogleCloudSearchResultPage extends AbstractPage {
    @FindBy(xpath = PLATFORM_PRICING_CALCULATOR_SELECTOR)
    WebElement platformPricingCalculatorLink;
    protected GoogleCloudSearchResultPage(WebDriver driver, Logger logger) {
        super(driver, logger);
        PageFactory.initElements(this.driver, this);
    }
    public GoogleCloudPricingCalculatorPage followPricingCalculatorLink(){
        waitUntilVisibility(platformPricingCalculatorLink).click();
        logger.info("Following the Google Pricing Calculator link");
        return new GoogleCloudPricingCalculatorPage(driver, logger);
    }

}
