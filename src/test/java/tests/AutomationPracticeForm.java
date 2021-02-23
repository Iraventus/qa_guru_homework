package tests;

import com.github.javafaker.Faker;
import config.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import pages.PracticeForm;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;


public class AutomationPracticeForm extends BaseTest {
    private final PracticeForm practiceForm = new PracticeForm();
    private static final Faker faker = new Faker();
    private static final String name = faker.name().firstName();
    private static final String lastName = faker.name().lastName();
    private static final String email = faker.internet().emailAddress("RU");
    private static final String mobile = faker.phoneNumber().subscriberNumber(10);
    private static final String address = faker.address().fullAddress();

     Map<String, String> expectedData = new HashMap<>() {{
        put("Student Name", name + " " + lastName);
        put("Student Email", email);
        put("Gender", "Male");
        put("Mobile", mobile);
        put("Date of Birth", "04 January,1993");
        put("Subjects", "English");
        put("Hobbies", "Sports, Music");
        put("Picture", "Smadj.jpg");
        put("Address", address);
        put("State and City", "NCR Delhi");
    }};

    @Test
    @DisplayName("Тест на заполнение формы")
    @Tag("positive")
    public void testRun() {
        practiceForm.openURL()
                .setValueInInputField("First Name", name)
                .setValueInInputField("Last Name", lastName)
                .setValueInInputField("name@example.com", email)
                .clickByCheckbox("Male")
                .setValueInInputField("Mobile Number", mobile)
                .setDatePickerValue(04, Month.JANUARY, 1993)
                .setValueInSubjects("e", "English")
                .clickByCheckbox("Sports")
                .clickByCheckbox("Music")
                .uploadFile("Smadj.jpg")
                .setValueInInputField("Current Address", address)
                .chooseDropDownList("Select State", "NCR")
                .chooseDropDownList("Select City", "Delhi")
                .clickSubmit()
                .checkTextVisible("Thanks for submitting the form")
                .checkAttribute(expectedData);
    }
}