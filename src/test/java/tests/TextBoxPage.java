package tests;

import com.codeborne.selenide.SelenideElement;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private SelenideElement fullName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit");

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullName.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage pressSubmit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkTextBoxResult(String key, String value) {
        registrationResultsModal.checkTextBoxResult(key, value);
        return this;
    }


}
