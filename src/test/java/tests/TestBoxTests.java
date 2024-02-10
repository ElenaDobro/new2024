package tests;

import org.junit.jupiter.api.Test;

public class TestBoxTests extends TestBase{
    TextBoxPage textBoxPage= new TextBoxPage();

    String fullName = "Elena Dobrovolskaya";
    String email = "ally999@mail.ru";
    String address = "Yaroslavl, lenina st 54";
    String permanentAddress = "Yaroslavl, lenina st 54";


    @Test
    void successfulTestBoxTest() {
        textBoxPage.openPage()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(address)
                .setPermanentAddress(permanentAddress)
                .pressSubmit();

        textBoxPage.checkTextBoxResult("Name","Elena Dobrovolskaya")
                .checkTextBoxResult("Email","ally999@mail.ru")
                .checkTextBoxResult("Current Address","Yaroslavl, lenina st 54")
                .checkTextBoxResult("Permananet Address","Yaroslavl, lenina st 54");
    }

}
