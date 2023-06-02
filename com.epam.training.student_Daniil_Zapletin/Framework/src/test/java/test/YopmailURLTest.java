package test;

import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.yopmail.YopmailPage;

import static page.object.yopmail.YopmailPage.MAIL_PAGE_URL;

public class YopmailURLTest extends CommonConditions{
    Logger logger = LogManager.getRootLogger();
    String actualURL;
    
    @Description("yopmailInitialization() initializes page and gets current URL")
    public void yopmailInitialization() {
        YopmailPage yopmailPage = new YopmailPage(driver, logger);
        yopmailPage.openPage();
        actualURL = this.driver.getCurrentUrl().replaceAll("ru/", "");
    }
    @Test
    @Description("urlTest() compares actual URL to retrieved from the page ")
    public void urlTest() {
        yopmailInitialization();
        Assert.assertEquals(actualURL, MAIL_PAGE_URL);
    }
}
