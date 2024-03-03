package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import com.github.javafaker.Faker;
import java.util.Locale;
import static utils.RandomUtils.*;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

        Faker faker = new Faker(new Locale("eng"));
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = getRandomGender(),
                phoneNumber = faker.phoneNumber().subscriberNumber(10),
                month = getRandomMonth(),
                year = getRandomYear(),
                subject = getRandomSubject(),
                hobbies = getRandomHobbies(),
                picture = "1.jpg",
                currentAddress = faker.address().fullAddress(),
                state = randomState,
                city = getRandomCity(),
                checkName = "Student Name",
                name = String.format("%s %s", firstName, lastName),
                checkEmail = "Student Email",
                checkGender = "Gender",
                checkMobile = "Mobile",
                checkDateOfBirth = "Date of Birth",
                birthDay = String.format("%s %s,%s", "15", month, year),
                checkSubjects = "Subjects",
                checkHobbies = "Hobbies",
                checkPicture = "Picture",
                checkAdress = "Address",
                checkStateAndCity = "State and City",
                stateAndCity = String.format("%s %s", state, city);

    @Test
    void fullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setDateOfBirth(month, year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(currentAddress)
                .setStateAndCity(state, city)
                .submit()
                .checkSubmitResult("Student Name", name)
                .checkSubmitResult("Student Email", userEmail)
                .checkSubmitResult("Gender", gender)
                .checkSubmitResult("Mobile", phoneNumber)
                .checkSubmitResult("Date of Birth", birthDay)
                .checkSubmitResult("Subjects", subject)
                .checkSubmitResult("Hobbies", hobbies)
                .checkSubmitResult("Picture", picture)
                .checkSubmitResult("Address", currentAddress)
                .checkSubmitResult("State and City", stateAndCity);
    }

 @Test
void emptySubmitTest() {
    registrationPage.openPage().submit().checkValidation();
 }
   @Test
  void minimalRegistrationTest() {
     registrationPage.openPage()
             .setFirstName(firstName)
             .setLastName(lastName)
             .setGender(gender)
             .setNumber(phoneNumber)
             .submit()
             .checkSubmitResult("Student Name", name)
             .checkSubmitResult("Gender", gender)
             .checkSubmitResult("Mobile", phoneNumber);
   }
}



