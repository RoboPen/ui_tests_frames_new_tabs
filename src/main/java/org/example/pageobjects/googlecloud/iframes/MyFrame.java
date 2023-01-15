package org.example.pageobjects.googlecloud.iframes;

import org.example.pageobjects.BasePage;
import org.example.pageobjects.googlecloud.modules.EmailYourEstimatePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFrame extends BasePage {
    public MyFrame(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "input_90")
    private WebElement numberOfInstancesInput;

    @FindBy(id = "select_115")
    private WebElement instanceSeriesTypeDropDownMenu;

    @FindBy(xpath = "//div[@id='select_container_116']//md-option")
    private List<WebElement> instanceSeries;

    @FindBy(id = "select_117")
    private WebElement machineTypeDropDownMenu;

    @FindBy(xpath = "//div[@id='select_container_118']//md-option")
    private List<WebElement> machineTypes;

    @FindBy(xpath ="//md-checkbox[@aria-label='Add GPUs']")
    private WebElement adGPUCheckbox;

    @FindBy(id ="select_466")
    private WebElement GPUtypeDropDownMenu;

    @FindBy(xpath ="//div[@id='select_container_467']//md-option")
    private List<WebElement> GPUTypes;

    @FindBy(id ="select_468")
    private WebElement numberOfGPUsDropDownMenu;

    @FindBy(xpath ="//div[@id='select_container_469']//md-option")
    private List<WebElement> numbersOfGPU;

    @FindBy(id ="select_423")
    private WebElement localSSDDropDownMenu;

    @FindBy(xpath ="//div[@id='select_container_424']//md-option")
    private List<WebElement> localSSDs;

    @FindBy(id="select_123")
    private WebElement datacenterLocationDropDownMenu;

    @FindBy(xpath ="//div[@id='select_container_124']//md-option")
    private List<WebElement> regions;

    @FindBy(id ="select_130")
    private WebElement committedUsageDropDownMenu;

    @FindBy(xpath ="//div[@id='select_container_131']//md-option")
    private List<WebElement> committedUsages;

    @FindBy(xpath = "(//button[@aria-label='Add to Estimate'])[1]")
    private WebElement addToEstimateBtn;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(),'Region')]")
    private WebElement regionEstimate;

    @FindBy(xpath ="//md-content[@id='compute']//div[contains(text(),'Commitment term')]")
    private WebElement commitmentTermEstimate;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(),'Instance type')]")
    private WebElement instanceTypeEstimate;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(),'Local SSD')]")
    private WebElement localSDDEstimate;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']//h2[@class='md-title']/b")
    private WebElement getMonthlyEstimatedCost;

    @FindBy(id = "Email Estimate")
    private WebElement emailEstimateBtn;

    public MyFrame setNumberOfInstancesInput(String numOfInstances) {
        webDriverWait.until(ExpectedConditions.visibilityOf(numberOfInstancesInput));
        numberOfInstancesInput.sendKeys(numOfInstances);
        return this;
    }

    public MyFrame setInstanceSeries(String series) {
        instanceSeriesTypeDropDownMenu.click();
        instanceSeries.stream()
                .filter(e -> e.getAttribute("value").equalsIgnoreCase(series))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such series"); })
                .click();
        return this;
    }

    public MyFrame setMachineType(String machineType) {
        machineTypeDropDownMenu.click();
        machineTypes.stream()
                .filter(e -> e.getText().contains(machineType))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such machine type"); })
                .click();
        return this;
    }

    public MyFrame checkAdGPUCheckbox() {
        adGPUCheckbox.click();
        return this;
    }

    public MyFrame setGPUType(String GPUType) {
        webDriverWait.until(ExpectedConditions.visibilityOf(GPUtypeDropDownMenu));
        GPUtypeDropDownMenu.click();
        GPUTypes.stream()
                .filter(e -> e.getText().equalsIgnoreCase(GPUType))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such GPU type"); })
                .click();
        return this;
    }

    public MyFrame setNumberOfGPU(String numberOfGPU) {
        numberOfGPUsDropDownMenu.click();
        numbersOfGPU.stream()
                .filter(e -> e.getText().equalsIgnoreCase(numberOfGPU))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such number of GPU"); })
                .click();
        return this;
    }

    public MyFrame setLocalSSD(String localSSD) {
        localSSDDropDownMenu.click();
        localSSDs.stream()
                .filter(e -> e.getText().equalsIgnoreCase(localSSD))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such localSSD"); })
                .click();
        return this;
    }

    public MyFrame setRegion(String region) {
        datacenterLocationDropDownMenu.click();
        regions.stream()
                .filter(e -> e.getText().contains(region))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such region"); })
                .click();
        return this;
    }

    public MyFrame setCommittedUsage(String committedUsage) {
        committedUsageDropDownMenu.click();
        committedUsages.stream()
                .filter(e -> e.getText().equalsIgnoreCase(committedUsage))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such committed usage"); })
                .click();
        return this;
    }

    public MyFrame clickAddToEstimateBtn(){
        addToEstimateBtn.click();
        return this;
    }

    public String getRegionEstimate() {
        webDriverWait.until(ExpectedConditions.visibilityOf(regionEstimate));
        return regionEstimate.getText();
    }

    public String getCommitmentTermEstimate() {
        return commitmentTermEstimate.getText();
    }

    public String getInstanceTypeEstimate() {
        return instanceTypeEstimate.getText();
    }

    public String getLocalSDDEstimate() {
        return localSDDEstimate.getText();
    }

    public String getEstimatedMonthlyCost(){
        Pattern p = Pattern.compile("(\\d{1,3},)?\\d{3}\\.\\d{2}");
        Matcher m = p.matcher(getMonthlyEstimatedCost.getText());
        m.find();
        return m.group();
    }

    public EmailYourEstimatePage clickEmailEstimateBtn(){
        waitForVisibility(emailEstimateBtn);
        emailEstimateBtn.click();

        return new EmailYourEstimatePage(webDriver);
    }
}
