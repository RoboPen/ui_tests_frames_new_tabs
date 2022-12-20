package org.example;

import org.example.pageobjects.pastebin.CreatedPastePage;
import org.example.pageobjects.pastebin.MainPastebinPage;
import org.testng.annotations.Test;

public class BringItOn extends BaseTest {
    MainPastebinPage mainPastebinPage = new MainPastebinPage(webDriver);

    @Test
    public void verifyPasteCreatedWithCorrectText() {
        String code = """
                git config --global user.name  "New Sheriff in Town"
                git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                git push origin master --force""";
        String title = "how to gain dominance among developers";
        String language = "Bash";
        String expirationTime = "10 min";
        int value = -150;

        CreatedPastePage createdPastePage = mainPastebinPage
                .openMainPage()
                .clickAgree()
                .writeTextIntoTextArea(code)
                .setTitle(title)
                .scrollDown(value)
                .selectExpirationTime(expirationTime)
                .selectLanguage(language)
                .clickCreateNewBtn();

        softAssert.assertEquals(createdPastePage.getTitle(), "how to gain dominance among developers", "Incorrect title");
        softAssert.assertEquals(createdPastePage.getLanguage(), "Bash",
                "Incorrect expiration time");
        softAssert.assertEquals(createdPastePage.getText(), code,
                "Incorrect text in text area");
        softAssert.assertAll();
    }
}
