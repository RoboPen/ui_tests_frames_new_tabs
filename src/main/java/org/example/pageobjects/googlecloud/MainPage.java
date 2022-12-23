package org.example.pageobjects.googlecloud;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//form[@class='devsite-search-form']")
    private WebElement searchLoupe;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    public MainPage openMainPage(){
        webDriver.get("https://cloud.google.com/");
        return this;
    }

    public MainPage clickSearchLoupe(){
        webDriverWait.until(ExpectedConditions.visibilityOf(searchLoupe));
        searchLoupe.click();
        return this;
    }

    public SearchResultPage search(String input){
        webDriverWait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(input);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(webDriver);
    }
}
