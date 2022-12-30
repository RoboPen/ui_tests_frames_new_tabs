package org.example;

import org.example.pageobjects.googlecloud.GoogleCloudCalculatorPage;
import org.example.pageobjects.googlecloud.GoogleCloudMainPage;
import org.example.pageobjects.yopmail.EmailGeneratorPage;
import org.example.pageobjects.yopmail.YopmailMainPage;
import org.example.pageobjects.yopmail.YopmailPrivacyWindow;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCalculatorSendEstimationByEmailTest extends BaseTest {
    private final GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(webDriver);
    private final GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(webDriver);
    private final EmailGeneratorPage emailGeneratorPage = new EmailGeneratorPage(webDriver);
    private final YopmailPrivacyWindow yopmailPrivacyWindow = new YopmailPrivacyWindow(webDriver);


    @Test
    public void verifyGoogleCloudCalculatorEstimateEqualsEstimateFromEmail(){
        String input = "Google Cloud Platform Pricing Calculator";
        String title = "Google Cloud Pricing Calculator";

        String numberOfInstances = "4";
        String instanceSeries = "N1";
        String machineType = "n1-standard-8";
        String GPUType = "NVIDIA TESLA V100";
        String numberOfGPU = "1";
        String localSSD = "2x375 GB";
        String region = "Frankfurt";
        String committedUsage = "1 Year";

        String estimatedMonthlyCostFromCalculator = googleCloudMainPage
                .openMainPage()
                .clickSearchLoupe()
                .search(input)
                .selectCalculatorPage(title)
                .clickOkCookieNotification()
                .switchToMyFrame()
                .setNumberOfInstancesInput(numberOfInstances)
                .clickInstanceSeriesTypeDropDownMenu()
                .selectInstanceSeries(instanceSeries)
                .clickMachineTypeDropDownMenu()
                .selectMachineType(machineType)
                .checkAdGPUCheckbox()
                .clickGPUtypeDropDownMenu()
                .selectGPUType(GPUType)
                .clickNumberOfGPUsDropDownMenu()
                .selectNumberOfGPU(numberOfGPU)
                .clickLocalSSDDropDownMenu()
                .selectLocalSSD(localSSD)
                .clickDatacenterLocationDropDownMenu()
                .selectRegion(region)
                .clickCommittedUsageDropDownMenu()
                .selectCommittedUsage(committedUsage)
                .clickAddToEstimateBtn()
                .getEstimatedMonthlyCost();

        String googleCloudCalculator = webDriver.getWindowHandle();
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get("https://yopmail.com/");



        String generatedEmail = yopmailPrivacyWindow
                .clickAcceptCookies()
                .clickCreateRandomEmailElement()
                .getEmailAddress();

        String yopmail = webDriver.getWindowHandle();

        webDriver.switchTo().window(googleCloudCalculator);

        googleCloudCalculatorPage
                .switchToMyFrame()
                .clickEmailEstimateBtn()
                .inputEmail(generatedEmail)
                .clickSendEmailBtn();

        webDriver.switchTo().window(yopmail);

        String estimatedMonthlyCostFromEmail = emailGeneratorPage
                .clickCheckEmailBtn()
                .delayedClickRefreshBtn(10)
                .switchToIfMailFrame()
                .getEstimatedMonthlyCost();

        System.out.println(estimatedMonthlyCostFromCalculator);
        System.out.println(estimatedMonthlyCostFromEmail);
        Assert.assertEquals(estimatedMonthlyCostFromCalculator, estimatedMonthlyCostFromEmail,
                "Estimated costs from calculator and email are not equal");
    }

}
