package qaguru.demoqa.tests.HW8;

import qaguru.demoqa.pages.RegistrationPage;
import qaguru.demoqa.tests.BaseTest;
import qaguru.demoqa.utils.GetRandomData;
import org.junit.jupiter.api.Test;

public class RegistrationWithFakerTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    GetRandomData randomData = new GetRandomData();

    String firstName = randomData.getFirstName(),
           lastName = randomData.getLastName(),
           email = randomData.getEmail(),
           gender = randomData.getGender(),
           phoneNumber = randomData.getPhoneNumber(),
           day = randomData.getDay(),
           month = randomData.getMonth(),
           year = randomData.getYear(),
           subject = randomData.getSubjects(),
           hobby = randomData.getHobbies(),
           fileName = "1.png",
           address = randomData.getAddress(),
           state = randomData.getState(),
           city = randomData.getCity(state);


    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage().executeJs()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setBirthDay(day, month, year)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadFile(fileName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();


        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", fileName)
                .checkResult("Picture", "1.png")
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }
}
