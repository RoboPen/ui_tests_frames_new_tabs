package org.example.pageobjects.googlecloud;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    private String searchResultXpath = "//div[@class='gs-title']/a";

    @FindBy(xpath = "//div[@class='gs-title']/a")
    private List<WebElement> searchResults;

    public GoogleCloudCalculatorPage selectCalculatorPage(String title){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResultXpath)));
        for(WebElement result : searchResults){
            if(result.getText().equals(title)){
                result.click();
                break;
            }
        }
        return new GoogleCloudCalculatorPage(webDriver);
    }
}
