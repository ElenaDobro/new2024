import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ActionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void actionstest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A")).shouldBe(visible);
        $("#column-b").shouldHave(text("B")).shouldBe(visible);
        //Перенесите прямоугольник А на место В
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(240, 0).release().perform();
        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B")).shouldBe(visible);
        $("#column-b").shouldHave(text("A")).shouldBe(visible);
    }

    public static class TestBase {

        @BeforeAll
        static void beforeAll() {
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1920x1080";
    //        Configuration.browser = "chrome";
            Configuration.timeout = 10000;
    //        Configuration.holdBrowserOpen = false;
        }

    }
}
