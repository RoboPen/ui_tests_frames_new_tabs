package org.example.pageobjects.googlecloud;

import org.example.pageobjects.BasePage;
import org.example.pageobjects.googlecloud.iframes.MyFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudCalculatorPage extends BasePage {
    public GoogleCloudCalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final String myFrameId = "myFrame";

    @FindBy(xpath = "//button[@class='devsite-snackbar-action']")
    private WebElement cookiesNotificationOkBtn;

    @FindBy(xpath = "//iframe[contains(@name,'goog')]")
    private WebElement outerFrame;

    @FindBy(id = "myFrame")
    private WebElement myFrame;

    public GoogleCloudCalculatorPage clickOkCookieNotification(){
        waitForVisibility(cookiesNotificationOkBtn);
        cookiesNotificationOkBtn.click();
        return this;
    }

    public MyFrame switchToMyFrame(){
        waitForVisibility(outerFrame);
        webDriver.switchTo().frame(outerFrame);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(myFrameId)));
        webDriver.switchTo().frame(myFrame);
        return new MyFrame(webDriver);
    }
}
