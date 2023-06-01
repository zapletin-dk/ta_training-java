package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.YopmailPage;

import static page.Constants.YopmailPageConstants.MAIL_PAGE_URL;

public class YopmailURLTest extends CommonConditions{
    Logger logger = LogManager.getRootLogger();
    @Test
    public void urlTest() {
        YopmailPage yopmailPage = new YopmailPage(driver, logger);
        yopmailPage.openPage();
        String actualURL = this.driver.getCurrentUrl().replaceAll("ru/", "");
        Assert.assertEquals(actualURL, MAIL_PAGE_URL);
    }
}
