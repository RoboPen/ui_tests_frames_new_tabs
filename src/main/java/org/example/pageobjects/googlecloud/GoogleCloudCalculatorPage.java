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

    @FindBy(xpath = "//button[@class='devsite-snackbar-action']")
    private WebElement cookiesNotificationOkBtn;

    @FindBy(xpath = "//iframe[contains(@name,'goog')]")
    private WebElement outerFrame;

    public GoogleCloudCalculatorPage clickOkCookieNotification(){
        webDriverWait.until(ExpectedConditions.visibilityOf(cookiesNotificationOkBtn));
        cookiesNotificationOkBtn.click();
        return this;
    }

    public MyFrame switchToMyFrame(){
        webDriverWait.until(ExpectedConditions.visibilityOf(outerFrame));
        webDriver.switchTo().frame(outerFrame);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='myFrame']")));
        WebElement innerFrame = webDriver.findElement(By.xpath("//iframe[@id='myFrame']"));
        webDriver.switchTo().frame(innerFrame);
        return new MyFrame(webDriver);
    }
}
