package tests;

import com.github.javafaker.Faker;
import config.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import pages.PracticeForm;
import org.junit.jupiter.api.Test;

import java.time.Month;

public class AutomationPracticeForm extends BaseTest {
    private final PracticeForm practiceForm = new PracticeForm();
    private static final Faker faker = new Faker();
    private static final String name = faker.name().firstName();
    private static final String lastName = faker.name().lastName();
    private static final String email = faker.internet().emailAddress("RU");
    private static final String mobile = faker.phoneNumber().subscriberNumber(10);
    private static final String address = faker.address().fullAddress();

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
                .checkAttribute("Student Email", email)
                .checkAttribute("Student Name", name)
                .checkAttribute("Gender", "Male")
                .checkAttribute("Mobile", mobile)
                .checkAttribute("Date of Birth", "04 JANUARY,1993 ")
                .checkAttribute("Address", address);
    }
}