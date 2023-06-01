package test;

import model.PricingCalculatorPageConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GoogleCloudHomePage;
import page.YopmailPage;
import service.GoogleCloudPricingCalculatorConfigurationCreator;

import java.util.ArrayList;
import java.util.List;

public class EmailAndCloudGooglePageCostComparisonTest extends CommonConditions {
    PricingCalculatorPageConfiguration pageConfiguration;
    Logger logger = LogManager.getRootLogger();
    private static String expectedEstimatedCost;
    private static String actualEstimatedCost;

    @BeforeMethod
    public void configureModel(){
        pageConfiguration = GoogleCloudPricingCalculatorConfigurationCreator.createWithProperty();
    }
    public void pricingCalculatorConfiguration() {

        YopmailPage yopmailPage = new YopmailPage(driver, logger);
        String emailAddress = yopmailPage
                .openPage()
                .generateEmail()
                .getEmailAddress();

                driver.switchTo().newWindow(WindowType.TAB);

        GoogleCloudHomePage cloudGoogleHomepage = new GoogleCloudHomePage(driver, logger);

        cloudGoogleHomepage
                .openPage()
                .searchOnRequest()
                .followPricingCalculatorLink()
                .fillForm()
                .sendEmail(emailAddress);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        actualEstimatedCost = yopmailPage.checkEmailBox().getTotalEstimatedCost();

        expectedEstimatedCost = pageConfiguration.getTotalEstimate();
    }

    @Test
    public void estimatedCostTest() {
        pricingCalculatorConfiguration();
        logger.info("Comparing estimated cost from mail and actual");
        Assert.assertEquals (actualEstimatedCost, expectedEstimatedCost, "The estimated cost is incorrect!");
    }
}