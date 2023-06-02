package page.object.google.cloud;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.object.AbstractPage;
import static service.GoogleCloudPricingCalculatorConfigurationCreator.createWithProperty;

import java.time.Duration;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    public static final String COMPUTE_ENGINE_SECTION_BUTTON_XPATH = "(//div[@title='Compute Engine'])[1]";
    public static final String NUMBER_OF_INSTANCE_SELECTOR = "//input[@ng-model = 'listingCtrl.computeServer.quantity']";
    public static final String OC_SOFTWARE_VALUE_SELECTOR = "//md-option//div[contains(text(), '" + createWithProperty().operatingSystem() + "')]";
    public static final String PROVISIONING_MODEL_VALUE_SELECTOR = "//md-option//div[contains(text(), '" + createWithProperty().provisioningModel() + "')]";
    public static final String SERIES_VALUE = "//md-option//div[contains(text(), '" + createWithProperty().series() + "')]";
    public static final String MACHINE_TYPE_VALUE = "//md-option//div[contains(text(), '" + createWithProperty().machineType() + "')]";
    public static final String GPUs_MARK_BOX_SELECTOR = "(//md-checkbox[@aria-label = 'Add GPUs'])[1]";
    public static final String GPU_TYPE_SELECTOR = "//md-select[@placeholder = 'GPU type']";
    public static final String GPU_TYPE_VALUE =  "//md-option//div[contains(text(), '" + createWithProperty().typeOfGPU() + "')]";
    public static final String GPU_NUMBER_VALUE = "//div/md-select-menu/md-content/md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU'][@value='" + createWithProperty().numberOfGPU() +"']";
    public static final String LOCAL_SSD_VALUE = "//md-option//div[contains(text(), '" + createWithProperty().capacityOfLocalSSD() + "')]";
    public static final String DATACENTER_VALUE = "//md-option[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer']//div[contains(text(),'" + createWithProperty().locationOfDataCenter() + "')]";
    public static final String COMMITTED_USAGE_VALUE = "//md-select-menu[@style]//md-option//div[contains(text(), '" + createWithProperty().committedUsage() + "')]";
    public static final String ADD_TO_ESTIMATE_BUTTON_SELECTOR = "(//button[contains(text(), 'Add to Estimate')])[1]";
    public static final String TOTAL_ESTIMATED_COST = "//b[contains(text(), 'Total Estimated Cost')]";
    public static final String SEND_EMAIL_LINK = "//span[text() = 'email']";
    public static final String INPUT_EMAIL_FIELD = "//form//input[@type = 'email']";
    public static final String SEND_EMAIL_BUTTON = "//button[contains(text(), 'Send Email')]";
    @FindBy(xpath = COMPUTE_ENGINE_SECTION_BUTTON_XPATH)
    private WebElement computeEngineSectionButton;
    @FindBy(xpath = NUMBER_OF_INSTANCE_SELECTOR)
    private WebElement numberOfInstance;
    @FindBy(id= "select_value_label_88")
    private WebElement ocSoftware;
    @FindBy(id = "select_value_label_89")
    private WebElement provisioningModel;
    @FindBy(id = "select_value_label_91")
    private WebElement series;
    @FindBy(id = "select_value_label_92")
    private WebElement machineType;
    @FindBy(xpath = GPUs_MARK_BOX_SELECTOR)
    private WebElement gpuMarkBox;
    @FindBy(xpath = GPU_TYPE_SELECTOR)
    private WebElement gpuType;
    @FindBy(id = "select_value_label_486")
    private WebElement gpuNumber;
    @FindBy(id = "select_value_label_445")
    private WebElement localSSD;
    @FindBy(id = "select_value_label_94")
    private WebElement datacenterLocation;
    @FindBy(id = "select_value_label_95")
    private WebElement committedUsage;
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
        numberOfInstance.sendKeys(createWithProperty().numberOfInstances());
        logger.info("Number of instance field is filled");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseOSSoftware(){
        ocSoftware.click();
        waitUntilVisibility(OC_SOFTWARE_VALUE_SELECTOR).click();
        logger.info("OS Software value has been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseProvisioningModel(){
        provisioningModel.click();
        waitUntilVisibility(PROVISIONING_MODEL_VALUE_SELECTOR).click();
        logger.info("Provisioning model has been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseSeries(){
        series.click();
        waitUntilVisibility(SERIES_VALUE).click();
        logger.info("Series type has been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseMachineType(){
        machineType.click();
        waitUntilVisibility(MACHINE_TYPE_VALUE).click();
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
        waitUntilVisibility(GPU_TYPE_VALUE).click();
        gpuNumber.click();
        waitUntilVisibility(GPU_NUMBER_VALUE).click();
        logger.info("GPUs type and number have been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseLocalSSDValue(){
        localSSD.click();
        waitUntilVisibility(LOCAL_SSD_VALUE).click();
        logger.info("Local SSD value has been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseDatacenterLocation(){
        datacenterLocation.click();
        waitUntilVisibility(DATACENTER_VALUE).click();
        logger.info("Datacenter location has been chosen");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseCommittedUsage(){
        committedUsage.click();
        waitUntilVisibility(COMMITTED_USAGE_VALUE).click();
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
