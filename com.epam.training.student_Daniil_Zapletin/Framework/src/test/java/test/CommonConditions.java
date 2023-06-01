package test;

import driver.DriverSingleton;
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
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }
    @BeforeMethod
    public void configureModel(){
        pageConfiguration = GoogleCloudPricingCalculatorConfigurationCreator.createWithProperty();
    }
    @AfterClass()
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
