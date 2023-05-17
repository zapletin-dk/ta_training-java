
import cloudGooglePageObjects.HomePage;
import mailPageObjects.YopmailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmailAndCloudGooglePageCostComparisonTest {
        private WebDriver driver;
        private static String expectedEstimatedCost;
        private static String actualEstimatedCost;

        @BeforeClass
        public void pricingCalculatorConfiguration() {
            driver = new ChromeDriver();

            YopmailPage yopmailPage = new YopmailPage(driver);
            String emailAddress = yopmailPage
                    .openPage()
                    .generateEmail()
                    .getEmailAddress();

            driver.switchTo().newWindow(WindowType.TAB);

            HomePage cloudGoogleHomepage = new HomePage(driver);
            expectedEstimatedCost = cloudGoogleHomepage
                    .openPage()
                    .searchOnRequest()
                    .followPricingCalculatorLink()
                    .fillForm().sendEmail(emailAddress).getTotalEstimatedCost();


            driver.switchTo().window(yopmailPage.getMailHomePageHandle());
            yopmailPage.checkEmailBox();

            actualEstimatedCost = yopmailPage.getTotalEstimatedCost();
        }

        @Test
        public void estimatedCostTest() {
            Assert.assertEquals (actualEstimatedCost, expectedEstimatedCost, "The estimated cost is incorrect!");
        }

        @AfterClass
        public void browserTearDown() {
            driver.quit();
        }
    }
