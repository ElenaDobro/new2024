package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class StudentRegistrationFormTest extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Elena";
    String lastName = "Dobrovolskaya";
    String email = "ally999@mail.ru";
    String gender = "Female";
    String number = "8906635610";
    String dayBirth = "27";
    String monthBirth = "February";
    String yearBirth = "1986";
    String subject = "Math";
    String hobbie = "Sports";
    String pictureDirectory = "1.jpg";
    String adress = "Yaroslavl, lenina st 54";
    String state = "Uttar Pradesh";
    String city = "Agra";

    @Test
    void fullSuccessfulRegistration() {
        registrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setEmail(email).
                setGender(gender).
                setUserNumber(number).
                setBDate(dayBirth, monthBirth, yearBirth).
                setSubject(subject).
                setHobbies(hobbie).
                uploadPicture(pictureDirectory).
                setAdress(adress).
                setState(state).
                setCity(city).
                clickSubmit().
                verifyResultsModalAppears().
                verifyResult("Student Name", firstName+" "+ lastName).
                verifyResult("Student Email", email).
                verifyResult("Gender", gender).
                verifyResult("Mobile", number).
                verifyResult("Date of Birth", dayBirth+" "+ monthBirth+","+yearBirth).
                verifyResult("Subjects", subject).
                verifyResult("Hobbies", hobbie).
                verifyResult("Picture", pictureDirectory.replaceAll("src/test/resources/","")).
                verifyResult("Address", adress).
                verifyResult("State and City", state+ " "+city).
                clickClose();
    }

    @Test
    void minimalSuccessfulRegistration() {
        registrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setGender(gender).
                setUserNumber(number).
                setBDate(dayBirth, monthBirth, yearBirth).
                clickSubmit().
                verifyResultsModalAppears().
                verifyResult("Student Name", firstName+" "+ lastName).
                verifyResult("Student Email", " ").
                verifyResult("Gender", gender).
                verifyResult("Mobile", number).
                verifyResult("Date of Birth", dayBirth+" "+ monthBirth+","+yearBirth).
                verifyResult("Subjects", " ").
                verifyResult("Hobbies", " ").
                verifyResult("Picture", " ").
                verifyResult("Address", " ").
                verifyResult("State and City", " ").
                clickClose();
    }
    @Test
    void negativeRegistration() {
        registrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setGender(gender).
                setBDate(dayBirth, monthBirth, yearBirth).
                clickSubmit().
                verifyResultsModalNotAppears();
    }


}
