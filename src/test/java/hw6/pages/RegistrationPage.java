package hw6.pages;

import com.codeborne.selenide.SelenideElement;
import hw6.pages.components.ResultTableCheck;
import hw6.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement fistNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            eMailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput =$("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit"),
            results = $(".modal-body");


    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableCheck resultTable = new ResultTableCheck();


    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage closeBanner(){
        executeJavaScript("$('#fixedban').remove()");//Закрывают баннеры
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value){
        fistNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value) {
        eMailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjectInput (String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage selectUploadPicture (String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setAddress(String value){
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationPage setState (String value){
        state.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity (String value){
        city.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage clickSubmit (){
        submit.click();
        return this;
    }
    public RegistrationPage checkResult(String key, String value){
        return this;
    }
    public ResultTableCheck getResultTable(){
        return resultTable;
    }
    public void checkFirstNameColorInput (){
        fistNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }


}