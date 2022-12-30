package org.example.pageobjects.googlecloud.modules;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailYourEstimatePage extends BasePage {

    public EmailYourEstimatePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "input_544")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailBtn;

    public EmailYourEstimatePage inputEmail(String email){
        waitForVisibility(emailInput);
        emailInput.sendKeys(email);

        return this;
    }

    public void clickSendEmailBtn(){
        sendEmailBtn.click();
    }
}
