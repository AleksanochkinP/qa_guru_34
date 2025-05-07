package hw6.tests;

import org.junit.jupiter.api.Test;
import hw6.pages.RegistrationPage;
import hw6.pages.components.ResultTableCheck;
import hw6.utils.FakeData;


public class AutoFormWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableCheck resultCheck = new ResultTableCheck();


    @Test
    void registrationPageFullTest() {
        String firstName = FakeData.getRandomFirstName();
        String lastName = FakeData.getRandomLastName();
        String email = FakeData.getRandomEmail();
        String gender = FakeData.getRandomGender();
        String phone = FakeData.getRandomPhoneNumber();
        String day = FakeData.getRandomDayOfBirth();
        String month = FakeData.getRandomMonthOfBirth();
        String year = FakeData.getRandomYearOfBirth();
        String subject = FakeData.getRandomSubject();
        String hobbies = FakeData.getRandomHobbies();
        String picture = FakeData.getRandomPicture();
        String address = FakeData.getRandomAddress();
        String state = FakeData.getRandomState();
        String city = FakeData.getRandomCity(state);
        String dateOfBirth = day + " " + month + "," + year;
        registrationPage.openPage()
                .closeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(day, month, year)
                .setSubjectInput(subject)
                .setHobbies(hobbies)
                .selectUploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();
        resultCheck.checkResult("Student Name", firstName + " " + lastName);
        resultCheck.checkResult("Student Email", email);
        resultCheck.checkResult("Gender", gender);
        resultCheck.checkResult("Mobile", phone);
        resultCheck.checkResult("Date of Birth", dateOfBirth);
        resultCheck.checkResult("Subjects", subject);
        resultCheck.checkResult("Hobbies", hobbies);
        resultCheck.checkResult("Picture", picture);
        resultCheck.checkResult("Address", address);
        resultCheck.checkResult("State and City", state + " " + city);
    }

    @Test
    void registrationPageMinimalTest() {
        String firstName = FakeData.getRandomFirstName();
        String lastName = FakeData.getRandomLastName();
        String gender = FakeData.getRandomGender();
        String phone = FakeData.getRandomPhoneNumber();

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phone)
                .clickSubmit();

        resultCheck.checkResult("Student Name", firstName + " " + lastName);
        resultCheck.checkResult("Gender", gender);
        resultCheck.checkResult("Mobile", phone);
    }

    @Test
    void negativeTest() {
        registrationPage.openPage()
                .setFirstName("")
                .clickSubmit()
                .checkFirstNameColorInput();
    }
}