package org.example.pageobjects.googlecloud;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudMainPage extends BasePage {
    public GoogleCloudMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//form[@class='devsite-search-form']")
    private WebElement searchLoupe;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    public GoogleCloudMainPage openMainPage(){
        webDriver.get("https://cloud.google.com/");
        return this;
    }

    public GoogleCloudMainPage clickSearchLoupe(){
        waitForVisibility(searchLoupe);
        searchLoupe.click();
        return this;
    }

    public SearchResultPage search(String input){
        waitForVisibility(searchInput);
        searchInput.sendKeys(input);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(webDriver);
    }
}
