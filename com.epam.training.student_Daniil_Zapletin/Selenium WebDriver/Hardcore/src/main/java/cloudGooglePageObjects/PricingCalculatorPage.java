package cloudGooglePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static cloudGooglePageObjects.Constants.HomePageConstants.EXPLICIT_WAIT;
import static cloudGooglePageObjects.Constants.PricingCalculatorPageConstants.*;

public class PricingCalculatorPage {
    WebDriver driver;

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

    public PricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage fillForm(){
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

    public PricingCalculatorPage selectCalculatorFrame() {
        WebElement element = driver.findElement(By.xpath("//iframe[contains(@name,'goog_')]"));
        driver.switchTo().frame(element);
        driver.switchTo().frame("myFrame");
        return this;
    }
    public PricingCalculatorPage fillNumberOfInstance(){
        waitUntilVisibility(numberOfInstance).click();
        numberOfInstance.sendKeys("4");
        return this;
    }

    public PricingCalculatorPage chooseOSSoftware(){
        ocSoftware.click();
        waitUntilVisibility(ocSoftwareValue).click();
        return this;
    }

    public PricingCalculatorPage chooseProvisioningModel(){
        provisioningModel.click();
        waitUntilVisibility(provisioningModelValue).click();
        return this;
    }

    public PricingCalculatorPage chooseSeries(){
        series.click();
        waitUntilVisibility(seriesValue).click();
        return this;
    }

    public PricingCalculatorPage chooseMachineType(){
        machineType.click();
        waitUntilVisibility(machineTypeValue).click();
        return this;
    }

    /**
     * If checkbox isn't swooshed
     * then tick it
     * else do nothing
     */
    public PricingCalculatorPage tickGPUsMarkBox(){
        if (gpuMarkBox.getAttribute("aria-checked").equals("false")){ gpuMarkBox.click(); }
        return this;
    }

    public PricingCalculatorPage chooseGpuTypeAndNumber(){
        gpuType.click();
        waitUntilVisibility(gpuTypeValue).click();
        gpuNumber.click();
        waitUntilVisibility(gpuNumberValue).click();
        return this;
    }

    public PricingCalculatorPage chooseLocalSSDValue(){
        localSSD.click();
        waitUntilVisibility(localSSDValue).click();
        return this;
    }

    public PricingCalculatorPage chooseDatacenterLocation(){
        datacenterLocation.click();
        waitUntilVisibility(datacenterValue).click();
        return this;
    }

    public PricingCalculatorPage chooseCommittedUsage(){
        committedUsage.click();
        waitUntilVisibility(committedUsageValue).click();
        return this;
    }

    public PricingCalculatorPage addToEstimate(){
        addToEstimateButton.click();
        return this;
    }

    public PricingCalculatorPage sendEmail(String email){
        waitUntilVisibility(sendEmailLink).click();
        waitUntilVisibility(inputEmailField).click();
        inputEmailField.sendKeys(email);
        sendEmailButton.click();
        return this;
    }
    private WebElement waitUntilVisibility(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(webElement));
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
