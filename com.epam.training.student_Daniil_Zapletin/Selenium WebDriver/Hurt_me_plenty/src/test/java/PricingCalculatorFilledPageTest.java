import cloudeGooglePageObjects.HomePage;
import cloudeGooglePageObjects.PricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PricingCalculatorFilledPageTest {
    private WebDriver driver;
    private PricingCalculatorPage pricingCalculatorPage;
    @BeforeClass
    public void pricingCalculatorConfiguration() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        pricingCalculatorPage = homePage
                .openPage()
                .searchOnRequest()
                .followPricingCalculatorLink()
                .fillForm();
    }

    @Test
    public void provisioningModelTest(){
        String expectedProvisioningModel = "Regular";
        Assert.assertEquals(pricingCalculatorPage.getProvisioningModel(), expectedProvisioningModel, "The provisioning model is incorrect!");
    }

    @Test
    public void instanceTypeTest() {
        String expectedInstanceType = "n1-standard-8";
        Assert.assertEquals(pricingCalculatorPage.getInstanceType(), expectedInstanceType, "The instance type is incorrect!");
    }

    @Test
    public void regionTest() {
        String expectedRegion = "Frankfurt";
        Assert.assertEquals(pricingCalculatorPage.getRegion(), expectedRegion, "The region is incorrect!");
    }

    @Test
    public void localSSDTypeTest() {
        String expectedSSDType = "2x375 GiB";
        Assert.assertEquals(pricingCalculatorPage.getLocalSSD(), expectedSSDType, "The SSD type is incorrect!");
    }

    @Test
    public void commitmentTermTest() {
        String expectedCommitmentTerm = "1 Year";
        Assert.assertEquals(pricingCalculatorPage.getCommitmentTerm(), expectedCommitmentTerm, "The commitment term is incorrect!");
    }

    @Test
    public void estimatedCostTest() {
        String expectedEstimatedCost = "USD 1,081.20";
        Assert.assertEquals(pricingCalculatorPage.getTotalEstimatedCost(), expectedEstimatedCost, "The estimated cost is incorrect!");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
