package org.example.pageobjects.yopmail;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailMainPage extends BasePage {

    public YopmailMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@id='listeliens']/a[@href='email-generator']")
    private WebElement createRandomEmailElement;

    public EmailGeneratorPage clickCreateRandomEmailElement(){
        waitForVisibility(createRandomEmailElement);
        createRandomEmailElement.click();

        return new EmailGeneratorPage(webDriver);
    }
}
