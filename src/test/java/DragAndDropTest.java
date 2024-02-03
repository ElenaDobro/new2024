import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void draganddrop() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A")).shouldBe(visible);
        $("#column-b").shouldHave(text("B")).shouldBe(visible);
        //Перенесите прямоугольник А на место В
        $("#column-a").dragAndDrop(to("#column-b"));
        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B")).shouldBe(visible);
        $("#column-b").shouldHave(text("A")).shouldBe(visible);
    }
}
