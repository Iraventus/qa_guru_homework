package tests;

import com.github.javafaker.Faker;
import config.BaseTest;
import pages.PracticeForm;
import org.junit.jupiter.api.Test;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;


public class AutomationPracticeForm extends BaseTest {
    private PracticeForm practiceForm = new PracticeForm();
    private static Faker faker = new Faker();
    private static String name = faker.name().firstName();
    private static String lastName = faker.name().lastName();
    private static String email = faker.internet().emailAddress("RU");
    private static String mobile = faker.phoneNumber().subscriberNumber(10);
    private static String address = faker.address().fullAddress();

    static Map<String, String> expectedData  = new HashMap<>() {{
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
    public void testRun () {
        practiceForm.openURL()
                .setValueInInputField("First Name", name)
                .setValueInInputField("Last Name", lastName)
                .setValueInInputField("name@example.com", email)
                .clickByRadiobutton("Male")
                .setValueInInputField("Mobile Number", mobile)
                .setDatePickerValue(04, Month.JANUARY, 1993)
                .setValueInSubjects("e", "English")
                .clickByCheckbox("Sports")
                .clickByCheckbox("Music")
                .uploadFile("Smadj.jpg")
                .setValueInInputField("Current Address", address)
                .chooseDropDownList("Select State", "NCR")
                .chooseDropDownList("Select City", "Delhi")
                .clickButton("Submit")
                .checkTextVisible("Thanks for submitting the form")
                .checkAttribute(expectedData);
    }
}