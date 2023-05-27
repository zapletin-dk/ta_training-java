package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeClass()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass()
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
