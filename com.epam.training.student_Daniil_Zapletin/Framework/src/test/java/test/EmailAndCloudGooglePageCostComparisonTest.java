package test;

import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.google.cloud.GoogleCloudHomePage;
import page.object.yopmail.YopmailPage;

public class EmailAndCloudGooglePageCostComparisonTest extends CommonConditions {

    Logger logger = LogManager.getRootLogger();
    private static String actualEstimatedCost;
    
    @Description("pricingCalculatorConfiguration() configurates the yopmail and the calculator pages" +
            " then sends the email with estimated coast")
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
    }

    @Test
    @Description("estimatedCostTest() compares actual estimated cost to retrieved from the email")
    public void estimatedCostTest() {
        pricingCalculatorConfiguration();
        logger.info("Comparing estimated cost from mail and actual");
        Assert.assertEquals (actualEstimatedCost, "USD 1,081.20", "The estimated cost is incorrect!");
    }
}
