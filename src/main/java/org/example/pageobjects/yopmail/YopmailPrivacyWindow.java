package org.example.pageobjects.yopmail;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailPrivacyWindow extends BasePage {
    public YopmailPrivacyWindow(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "accept")
    private WebElement acceptCookiesBtm;

    public YopmailMainPage clickAcceptCookies(){
        waitForVisibility(acceptCookiesBtm);
        acceptCookiesBtm.click();

        return new YopmailMainPage(webDriver);
    }
}
