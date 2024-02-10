package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    private SelenideElement modalTitle = $("#example-modal-sizes-title-lg"),
            registrationTableResults = $(".table-responsive"),
            textBoxTableResults = $("#output");


    public void verifyModalAppears() {
        modalTitle
                .shouldHave(text("Thanks for submitting the form"))
                .shouldBe(Condition.visible);
    }

    public void verifyModalNotAppears() {
        modalTitle
                .shouldBe(Condition.not(visible));
    }

    public void verifyResults(String key, String value) {
        registrationTableResults.$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void checkTextBoxResult(String key, String value) {
        textBoxTableResults.shouldHave(text(key)).shouldHave(text(value));
    }
}
