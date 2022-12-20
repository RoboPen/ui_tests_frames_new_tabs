package org.example.pageobjects.pastebin;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreatedPastePage extends BasePage {

    protected CreatedPastePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement title;

    @FindBy(xpath = "//div[@title='When this paste gets automatically deleted']")
    private WebElement expirationTime;

    @FindBy(tagName = "ol")
    private WebElement textArea;

    @FindBy(xpath = "//div[@class='content']//div[@class='left']/a[1]")
    private WebElement language;

    public String getTitle(){
        webDriverWait.until(ExpectedConditions.visibilityOf(title));
        return title.getText();
    }

    public String getExpirationTime(){
        return expirationTime.getText();
    }

    public String getText(){
        return textArea.getText();
    }

    public String getLanguage(){ return language.getText();}
}
