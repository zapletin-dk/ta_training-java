package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleCloudHomePage;
import page.YopmailPage;

public class EmailAndCloudGooglePageCostComparisonTest extends CommonConditions {

    Logger logger = LogManager.getRootLogger();
    private static String expectedEstimatedCost;
    private static String actualEstimatedCost;

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

        driver.switchTo().window(yopmailPage.getMailHomePageHandle());
        actualEstimatedCost = yopmailPage.checkEmailBox().getTotalEstimatedCost();

        expectedEstimatedCost = pageConfiguration.totalEstimate();
    }

    @Test
    public void estimatedCostTest() {
        pricingCalculatorConfiguration();
        logger.info("Comparing estimated cost from mail and actual");
        Assert.assertEquals (actualEstimatedCost, expectedEstimatedCost, "The estimated cost is incorrect!");
    }
}