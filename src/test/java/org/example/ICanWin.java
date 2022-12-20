package org.example;

import org.example.pageobjects.pastebin.CreatedPastePage;
import org.example.pageobjects.pastebin.MainPastebinPage;
import org.testng.annotations.Test;

public class ICanWin extends BaseTest {
    MainPastebinPage mainPastebinPage = new MainPastebinPage(webDriver);

    @Test
    public void verifyPasteCreatedWithCorrectText(){
        CreatedPastePage createdPastePage = mainPastebinPage
                .openMainPage()
                .clickAgree()
                .writeTextIntoTextArea("Hello from WebDriver")
                .setTitle("helloweb")
                .scrollDown(-100)
                .selectExpirationTime("10 min")
                .clickCreateNewBtn();

        softAssert.assertEquals(createdPastePage.getTitle(), "helloweb", "Incorrect title");
        softAssert.assertEquals(createdPastePage.getExpirationTime(), "10 MIN",
                "Incorrect expiration time");
        softAssert.assertEquals(createdPastePage.getText(), "Hello from WebDriver",
                "Incorrect text in text area");
        softAssert.assertAll();
    }



}
