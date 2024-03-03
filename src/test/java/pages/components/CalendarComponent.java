package pages.components;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;


public class CalendarComponent {
    private SelenideElement
            yearInput =  $(".react-datepicker__year-select"),
            monthInput  = $(".react-datepicker__month-select"),
            dayInput = $(".react-datepicker__day--015:not(.react-datepicker__day--outside-month)");

    public CalendarComponent setDate(String month, String year) {
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        dayInput.click();


        return this;
    }
    }
