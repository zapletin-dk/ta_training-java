package cloudGooglePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static cloudGooglePageObjects.Constants.HomePageConstants.EXPLICIT_WAIT;
import static cloudGooglePageObjects.Constants.SearchResultsPageConstants.PLATFORM_PRICING_CALCULATOR_SELECTOR;

public class SearchResultsPage {

    WebDriver driver;

    @FindBy(xpath = PLATFORM_PRICING_CALCULATOR_SELECTOR)
    WebElement platformPricingCalculatorLink;
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage followPricingCalculatorLink(){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(platformPricingCalculatorLink)).click();
        return new PricingCalculatorPage(driver);
    }

}
