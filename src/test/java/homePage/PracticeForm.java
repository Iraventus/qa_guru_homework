package homePage;

import com.codeborne.selenide.Condition;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    public static final String MAIN_URL = "https://demoqa.com/automation-practice-form";

    public PracticeForm setValueInInputField (String placeholderName, String value) {
      String inputSelector = "//*[contains(@placeholder, '%s')]";
      String selector = String.format(inputSelector, placeholderName);
      $x(selector).setValue(value);
      return this;
    }

    public PracticeForm clickByRadiobutton(String radiobuttonName) {
        String inputSelector = "//input[@value='%s']/following-sibling::label";
        String selector = String.format(inputSelector, radiobuttonName);
        $x(selector).click();
        return this;
    }

    public PracticeForm clickByCheckbox(String checkboxName) {
        String checkboxSelector = "//label[text()='%s']";
        String selector = String.format(checkboxSelector, checkboxName);
        $x(selector).click();
        return this;
    }

    public PracticeForm uploadFile (String filename) {
        String inputSelector = "//input[@type='file']";
        $x(inputSelector).uploadFile(new File("./src/test/resources/upload/"+ filename));
        return this;
    }

    public PracticeForm chooseDropDownList (String placeholderName, String chooseValue) {
       String placeholderNameSelector = "//div[text()='%s']";
       String selector = String.format(placeholderNameSelector, placeholderName);
       $x(selector).click();
       String chooseSelector = String.format(placeholderNameSelector, chooseValue);
       $x(chooseSelector).click();
       return this;
    }

    public PracticeForm setValueInSubjects (String value) {
        String selector = "//input[@id='subjectsInput']";
        $x(selector).setValue(value);
        return this;
    }

    public PracticeForm clickButton (String buttonName) {
        String buttonSelector = "//button[text()='%s']";
        String selector = String.format(buttonSelector, buttonName);
        $x(selector).click();
        return this;
    }

    public PracticeForm setDatePickerValue(String date) {
        executeJavaScript(
                String.format("$('[id=dateOfBirthInput]').val('%s')", date));
        return this;
    }

    public PracticeForm openURL() {
        open(MAIN_URL);
        return this;
    }

    public PracticeForm checkTextVisible(String text) {
        String textSelector = "//*[contains(text(),'%s')]";
        String selector = String.format(textSelector, text);
        $x(selector).shouldBe(Condition.visible);
        return new PracticeForm();
    }
}