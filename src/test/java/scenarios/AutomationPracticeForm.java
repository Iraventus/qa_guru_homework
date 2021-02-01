package scenarios;

import config.BaseTest;
import homePage.PracticeForm;
import org.junit.jupiter.api.Test;
import java.time.Month;

public class AutomationPracticeForm extends BaseTest {
    private PracticeForm practiceForm = new PracticeForm();

    @Test
    public void testRun () {
        practiceForm.openURL()
                .setValueInInputField("First Name", "Smadj")
                .setValueInInputField("Last Name", "White")
                .setValueInInputField("name@example.com", "Whitecat@mail.ru")
                .clickByRadiobutton("Male")
                .setValueInInputField("Mobile Number", "8005553535")
                .setDatePickerValue(04, Month.JANUARY, 1993)
                .setValueInSubjects("e", "English")
                .clickByCheckbox("Sports")
                .clickByCheckbox("Music")
                .uploadFile("Smadj.jpg")
                .setValueInInputField("Current Address", "The big beautiful home")
                .chooseDropDownList("Select State", "NCR")
                .chooseDropDownList("Select City", "Delhi")
                .clickButton("Submit")
                .checkTextVisible("Thanks for submitting the form");
    }
}