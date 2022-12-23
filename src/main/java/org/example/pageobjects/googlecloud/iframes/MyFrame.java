package org.example.pageobjects.googlecloud.iframes;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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

    public MyFrame setNumberOfInstancesInput(String numOfInstances) {
        webDriverWait.until(ExpectedConditions.visibilityOf(numberOfInstancesInput));
        numberOfInstancesInput.sendKeys(numOfInstances);
        return this;
    }

    public MyFrame clickInstanceSeriesTypeDropDownMenu() {
        instanceSeriesTypeDropDownMenu.click();
        return this;
    }

    public MyFrame selectInstanceSeries(String series) {
        instanceSeries.stream()
                .filter(e -> e.getAttribute("value").equalsIgnoreCase(series))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such series"); })
                .click();
        return this;
    }

    public MyFrame clickMachineTypeDropDownMenu() {
        machineTypeDropDownMenu.click();
        return this;
    }

    public MyFrame selectMachineType(String machineType) {
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

    public MyFrame clickGPUtypeDropDownMenu() {
        webDriverWait.until(ExpectedConditions.visibilityOf(GPUtypeDropDownMenu));
        GPUtypeDropDownMenu.click();
        return this;
    }

    public MyFrame selectGPUType(String GPUType) {
        GPUTypes.stream()
                .filter(e -> e.getText().equalsIgnoreCase(GPUType))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such GPU type"); })
                .click();
        return this;
    }

    public MyFrame clickNumberOfGPUsDropDownMenu() {
        numberOfGPUsDropDownMenu.click();
        return this;
    }

    public MyFrame selectNumberOfGPU(String numberOfGPU) {
        numbersOfGPU.stream()
                .filter(e -> e.getText().equalsIgnoreCase(numberOfGPU))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such number of GPU"); })
                .click();
        return this;
    }

    public MyFrame clickLocalSSDDropDownMenu() {
        localSSDDropDownMenu.click();
        return this;
    }

    public MyFrame selectLocalSSD(String localSSD) {
        localSSDs.stream()
                .filter(e -> e.getText().equalsIgnoreCase(localSSD))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such localSSD"); })
                .click();
        return this;
    }

    public MyFrame clickDatacenterLocationDropDownMenu() {
        datacenterLocationDropDownMenu.click();
        return this;
    }

    public MyFrame selectRegion(String region) {
        regions.stream()
                .filter(e -> e.getText().contains(region))
                .findFirst()
                .orElseThrow(() -> { throw new RuntimeException("No such region"); })
                .click();
        return this;
    }

    public MyFrame clickCommittedUsageDropDownMenu() {
        committedUsageDropDownMenu.click();
        return this;
    }

    public MyFrame selectCommittedUsage(String committedUsage) {
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
}
