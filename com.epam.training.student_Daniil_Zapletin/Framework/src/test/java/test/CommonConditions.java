package test;

import driver.DriverSingleton;
import jdk.jfr.Description;
import model.PricingCalculatorPageConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import service.GoogleCloudPricingCalculatorConfigurationCreator;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    PricingCalculatorPageConfiguration pageConfiguration;
    @BeforeClass()
    @Description("setUp() gets the driver type from the bundle")
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }
    @BeforeMethod
    @Description("configureModel() configurates the pricing calculator page model with the values from the bundle")
    public void configureModel(){
        pageConfiguration = GoogleCloudPricingCalculatorConfigurationCreator.createWithProperty();
    }
    @AfterClass()
    @Description("tearDown() stops the driver")
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
