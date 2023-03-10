package org.example.pageobjects.pastebin;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class PastebinPrivacyWindow extends BasePage {
    public PastebinPrivacyWindow(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath ="//button[text()='AGREE']")
    private WebElement agreePrivacyBtn;

    public PastebinMainPage clickAgree(){
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(agreePrivacyBtn));

        agreePrivacyBtn.click();
        return new PastebinMainPage(webDriver);
    }
}
