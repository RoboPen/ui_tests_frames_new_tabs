package org.example.pageobjects.googlecloud;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[@aria-label='Open search']")
    private WebElement searchLoupe;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    public MainPage open(){
        webDriver.get("https://cloud.google.com/");
        return this;
    }

    public MainPage clickSearchLoupe(){
        searchLoupe.click();
        return this;
    }

    public SearchResultPage search(String input){
        searchInput.sendKeys(input);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(webDriver);
    }
}
