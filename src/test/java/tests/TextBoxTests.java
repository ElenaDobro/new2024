package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Elena")
                .setUserEmail("ally999@mail.ru")
                .setCurrentAddress("Lenina 54")
                .setPermanentAddress("Chkalova 56")
                .submit()
                .checkOutput("name", "Elena")
                .checkOutput("email", "ally999@mail.ru")
                .checkOutput("currentAddress", "Lenina 54")
                .checkOutput("permanentAddress", "Chkalova 56");
    }

}