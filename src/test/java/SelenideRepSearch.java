import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepSearch {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void fillFormTest() {

        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$("[data-testid='results-list']").first().$("a").click();
        $("#wiki-tab").click();
        $("[placeholder='Find a page…']").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions")).shouldBe(visible);
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));

    }

    public static class RegistrationPage {
        private SelenideElement firstNameInput = $("#firstName"),
                lastNameInput = $("#lastName"),
                userEmailInput = $("#userEmail"),
                genderWrapper = $("#genterWrapper"),
                userNumberInput = $("#userNumber"),
                calendarInput = $("#dateOfBirthInput");

        CalendarComponent calendarComponent = new CalendarComponent();

        public RegistrationPage openPage() {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");

            return this;
        }

        public RegistrationPage setFirstName(String value) {
            firstNameInput.setValue(value);

            return this;
        }

        public RegistrationPage setLastName(String value) {
            lastNameInput.setValue(value);

            return this;
        }

        public RegistrationPage setEmail(String value) {
            userEmailInput.setValue(value);

            return this;
        }

        public RegistrationPage setGender(String value) {
            genderWrapper.$(byText(value)).click();

            return this;
        }

        public RegistrationPage setUserNumber(String value) {
            userNumberInput.setValue(value);

            return this;
        }

        public RegistrationPage setDateOfBirth(String day, String month, String year) {
            calendarInput.click();
            calendarComponent.setDate(day, month, year);

            return this;
        }

        public RegistrationPage checkResult(String key, String value) {
            $(".table-responsive").$(byText(key)).parent()
                    .shouldHave(text(value));

            return this;
        }
    }
}


// Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
// Откройте страницу SoftAssertions
// проверьте что внутри есть пример кода для JUnit5
//$("[href='/selenide/selenide/wiki/SoftAssertions']"). click();
//$x("//*[@id=\"wiki-body\"]/div/h4[contains(text(),'JUnit5')]").click();

//sleep(5000);