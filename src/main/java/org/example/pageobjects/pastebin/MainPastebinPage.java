package org.example.pageobjects.pastebin;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPastebinPage extends BasePage {
    public MainPastebinPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "postform-text")
    private WebElement textArea;

    @FindBy(xpath = "//span[@aria-labelledby='select2-postform-expiration-container']")
    private WebElement expirationTimeListDropDownMenu;

    @FindBy(xpath = "//li[contains(@id,'10M')]")
    private WebElement expiration10min;

    @FindBy(id ="postform-name")
    private WebElement title;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPasteBtn;

    @FindBy(xpath = "//button[text()='AGREE']")
    private WebElement agreePrivacyBtn;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingDropDownMenu;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement bashLanguage;

    public PrivacyWindow openMainPage(){
        webDriver.get("https://pastebin.com/");
        return new PrivacyWindow(webDriver);
    }

    public MainPastebinPage writeTextIntoTextArea(String text){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("return document.readyState").equals("complete");
//        webDriverWait.until((ExpectedCondition<Boolean>) wd ->
//                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        textArea.sendKeys(text);
        return this;
    }

    public MainPastebinPage scrollDown(int value){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript(String.format("window.scrollBy(0,%d)", value));

        return this;
    }

    public MainPastebinPage selectExpirationTime(String expirationTime){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(expirationTimeListDropDownMenu));
        expirationTimeListDropDownMenu.click();

        if(expirationTime.equalsIgnoreCase("10 min")){
            webDriverWait.until(ExpectedConditions.visibilityOf(expiration10min));
            expiration10min.click();
        }

        return this;
    }

    public MainPastebinPage selectLanguage(String language){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(syntaxHighlightingDropDownMenu));

        syntaxHighlightingDropDownMenu.click();
        WebElement selectedLanguage = webDriver.findElement(By.xpath(String.format("//li[text()='%s']", language)));
        webDriverWait.until(ExpectedConditions.visibilityOf(selectedLanguage));
        bashLanguage.click();
        return this;
    }

    public MainPastebinPage setTitle(String text){
        title.sendKeys(text);
        return this;
    }

    public CreatedPastePage clickCreateNewBtn(){
        createNewPasteBtn.click();
        return new CreatedPastePage(webDriver);
    }




}
