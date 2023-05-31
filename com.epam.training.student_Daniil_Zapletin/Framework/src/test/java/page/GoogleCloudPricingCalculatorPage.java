package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static page.Constants.EXPLICIT_WAIT;
import static page.Constants.PricingCalculatorPageConstants.*;

public class GoogleCloudPricingCalculatorPage extends AbstractPage{


    @FindBy(xpath = COMPUTE_ENGINE_SECTION_BUTTON_XPATH)
    private WebElement computeEngineSectionButton;
    @FindBy(xpath = NUMBER_OF_INSTANCE_SELECTOR)
    private WebElement numberOfInstance;
    @FindBy(xpath = OC_SOFTWARE_SELECTOR)
    private WebElement ocSoftware;
    @FindBy(xpath = OC_SOFTWARE_VALUE_SELECTOR)
    private WebElement ocSoftwareValue;
    @FindBy(xpath = PROVISIONING_MODEL_SELECTOR)
    private WebElement provisioningModel;
    @FindBy(xpath = PROVISIONING_MODEL_VALUE_SELECTOR)
    private WebElement provisioningModelValue;
    @FindBy(xpath = SERIES_SELECTOR)
    private WebElement series;
    @FindBy(xpath = SERIES_VALUE)
    private WebElement seriesValue;
    @FindBy(xpath = MACHINE_TYPE_SELECTOR)
    private WebElement machineType;
    @FindBy(xpath = MACHINE_TYPE_VALUE)
    private WebElement machineTypeValue;
    @FindBy(xpath = GPUs_MARK_BOX_SELECTOR)
    private WebElement gpuMarkBox;
    @FindBy(xpath = GPU_TYPE_SELECTOR)
    private WebElement gpuType;
    @FindBy(xpath = GPU_TYPE_VALUE)
    private WebElement gpuTypeValue;
    @FindBy(xpath = GPU_NUMBER_SELECTOR)
    private WebElement gpuNumber;
    @FindBy(xpath = GPU_NUMBER_VALUE)
    private WebElement gpuNumberValue;
    @FindBy(xpath = LOCAL_SSD_SELECTOR)
    private WebElement localSSD;
    @FindBy(xpath = LOCAL_SSD_VALUE)
    private WebElement localSSDValue;
    @FindBy(xpath = DATACENTER_LOCATION_SELECTOR)
    private WebElement datacenterLocation;
    @FindBy(xpath = DATACENTER_VALUE)
    private WebElement datacenterValue;
    @FindBy(xpath = COMMITTED_USAGE_SELECTOR)
    private WebElement committedUsage;
    @FindBy(xpath = COMMITTED_USAGE_VALUE)
    private WebElement committedUsageValue;
    @FindBy(xpath = ADD_TO_ESTIMATE_BUTTON_SELECTOR)
    private WebElement addToEstimateButton;
    @FindBy(xpath = TOTAL_ESTIMATED_COST)
    private WebElement totalEstimatedCost;
    @FindBy(xpath = SEND_EMAIL_LINK)
    private WebElement sendEmailLink;
    @FindBy(xpath = INPUT_EMAIL_FIELD)
    private WebElement inputEmailField;
    @FindBy(xpath = SEND_EMAIL_BUTTON)
    private WebElement sendEmailButton;

    protected GoogleCloudPricingCalculatorPage(WebDriver driver, Logger logger) {
        super(driver, logger);
        PageFactory.initElements(this.driver, this);
    }
    public GoogleCloudPricingCalculatorPage fillForm(){
        this
                .selectCalculatorFrame()
                .fillNumberOfInstance()
                .chooseOSSoftware()
                .chooseProvisioningModel()
                .chooseSeries()
                .chooseMachineType()
                .tickGPUsMarkBox()
                .chooseGpuTypeAndNumber()
                .chooseLocalSSDValue()
                .chooseDatacenterLocation()
                .chooseCommittedUsage()
                .addToEstimate();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCalculatorFrame() {
        WebElement element = driver.findElement(By.xpath("//iframe[contains(@name,'goog_')]"));
        driver.switchTo().frame(element);
        driver.switchTo().frame("myFrame");
        logger.info("Redirected to the calculator frame");
        return this;
    }
    public GoogleCloudPricingCalculatorPage fillNumberOfInstance(){
        waitUntilVisibility(numberOfInstance).click();
        numberOfInstance.sendKeys("4");
        logger.info("Number of instance field is filled");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseOSSoftware(){
        ocSoftware.click();
        waitUntilVisibility(ocSoftwareValue).click();
        logger.info("OS Software value has been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseProvisioningModel(){
        provisioningModel.click();
        waitUntilVisibility(provisioningModelValue).click();
        logger.info("Provisioning model has been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseSeries(){
        series.click();
        waitUntilVisibility(seriesValue).click();
        logger.info("Series type has been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseMachineType(){
        machineType.click();
        waitUntilVisibility(machineTypeValue).click();
        logger.info("Machine type has been chosen");
        return this;
    }

    /**
     * If checkbox isn't swooshed
     * then tick it
     * else do nothing
     */
    public GoogleCloudPricingCalculatorPage tickGPUsMarkBox(){
        if (gpuMarkBox.getAttribute("aria-checked").equals("false")){ gpuMarkBox.click(); }
        logger.info("GPUs mark box has been ticked");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseGpuTypeAndNumber(){
        gpuType.click();
        waitUntilVisibility(gpuTypeValue).click();
        gpuNumber.click();
        waitUntilVisibility(gpuNumberValue).click();
        logger.info("GPUs type and number have been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseLocalSSDValue(){
        localSSD.click();
        waitUntilVisibility(localSSDValue).click();
        logger.info("Local SSD value has been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseDatacenterLocation(){
        datacenterLocation.click();
        waitUntilVisibility(datacenterValue).click();
        logger.info("Datacenter location has been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseCommittedUsage(){
        committedUsage.click();
        waitUntilVisibility(committedUsageValue).click();
        logger.info("Committed usage duration has been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage addToEstimate(){
        addToEstimateButton.click();
        logger.info("Form has been estimated");
        return this;
    }

    public GoogleCloudPricingCalculatorPage sendEmail(String email){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.elementToBeClickable(sendEmailLink)).click();
        logger.info("Send email link clicked");
        waitUntilVisibility(inputEmailField).sendKeys(email);
        logger.info("Email field is filled")
        sendEmailButton.click();
        logger.info("Email with estimated cost has been send");
        return this;
    }

    public String getTotalEstimatedCost(){
        return trimAndReplaceRegex(totalEstimatedCost, "Total Estimated Cost: ")
                .replaceAll("per 1 month","")
                .trim();
    }
    private String trimAndReplaceRegex(WebElement webElement, String regex){
        return webElement.getText().trim().replaceAll(regex, "");
    }
}
