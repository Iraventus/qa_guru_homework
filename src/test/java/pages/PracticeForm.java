package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    public static final String MAIN_URL = "https://demoqa.com/automation-practice-form";

    @Step("Переход по основной ссылке")
    public PracticeForm openURL() {
        open(MAIN_URL);
        return this;
    }

    @Step("Ввод значения {1} в поле {0}")
    public PracticeForm setValueInInputField (String placeholderName, String value) {
      $("[placeholder='" + placeholderName + "']").val(value);
      return this;
    }

    @Step("Клик по чекбоксу с названием {0}")
    public PracticeForm clickByCheckbox(String checkboxName) {
        $$(".custom-control-label").find(text(checkboxName)).click();
        return this;
    }

    @Step("Загрузка файла с названием {0}")
    public PracticeForm uploadFile (String filename) {
        $("#uploadPicture").uploadFile(new File("./src/test/resources/upload/" + filename));
        return this;
    }

    @Step("Выбор значения {1} из дроплиста {0}")
    public PracticeForm chooseDropDownList (String placeholderName, String chooseValue) {
       $(byText(placeholderName)).click();
       $(byText(chooseValue)).click();
       return this;
    }

    @Step("Ввод символа {0} и выбор знаечния {1}")
    public PracticeForm setValueInSubjects (String key, String value) {
        $("#subjectsInput").val(key);
        $(byText(value)).click();
        return this;
    }

    @Step("Отправка формы")
    public PracticeForm clickSubmit() {
        $("#submit").click();
        return this;
    }

    @Step("Указать день {0}, Месяц {1} и год {2} в календаре")
    public PracticeForm setDatePickerValue(int day, Month month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("en"));
        String formattedString = localDate.format(formatter);
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
        $("#dateOfBirthInput").sendKeys(formattedString + Keys.ENTER);
        return this;
    }

    @Step("Проверка отображения текста {0}")
    public PracticeForm checkTextVisible(String text) {
        $(byText(text)).shouldBe(Condition.visible);
        return new PracticeForm();
    }

    @Step("Проверка корректности введенных значений {0}")
    public PracticeForm checkAttribute (Map<String, String> list) {
        SoftAssertions softly = new SoftAssertions();
        for(SelenideElement element: $$(".table-responsive tbody tr")) {
            String key = element.$("td").getText();
            String actualValue = element.$("td", 1).getText();
            String expectedValue = list.get(key);
            softly.assertThat(actualValue).isEqualTo(expectedValue);
        }
        softly.assertAll();
        return this;
    }
}