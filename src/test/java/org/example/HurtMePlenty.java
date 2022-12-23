package org.example;

import org.example.pageobjects.googlecloud.MainPage;
import org.example.pageobjects.googlecloud.iframes.MyFrame;
import org.testng.annotations.Test;

public class HurtMePlenty extends BaseTest {
    MainPage mainPage = new MainPage(webDriver);

    @Test
    public void verifyGoogleCloudCalculatorEstimateContainsSelectedOptions(){
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

        MyFrame myFrame = mainPage
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
                .clickAddToEstimateBtn();

        softAssert.assertTrue(myFrame.getRegionEstimate().contains(region), "Incorrect region");
        softAssert.assertTrue(myFrame.getCommitmentTermEstimate().contains(committedUsage),
                "Incorrect commitment term");
        softAssert.assertTrue(myFrame.getInstanceTypeEstimate().contains(machineType),
                "Incorrect instance type");
        softAssert.assertTrue(myFrame.getLocalSDDEstimate().contains(localSSD.replace("GB","GiB")),
                "Incorrect local SDD");
        softAssert.assertAll();
    }
}
