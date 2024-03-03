package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.getRandomString;

public class RegistrationWithRandomUtilsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(getRandomString(10))
                .setLastName(getRandomString(10))
                .setEmail(getRandomString(5) + "@" + getRandomString(5) + ".ru")
                .setGender("Female")
                .setNumber("1234567890")
                //.setDateOfBirth("30", "July", "1986")
                .setSubject("English").setSubject("Computer")
                .setHobbies("Reading").setHobbies("Music")
                .setPicture("1.jpg")
                .setAddress("Lenina, 54")
                //.setState("Uttar Pradesh")
                //.setCity("Merrut")
                .submit()
                .checkSubmitResult("Student Name", "Elena Dobrovolskaya")
                .checkSubmitResult("Student Email", "ally999@mail.ru")
                .checkSubmitResult("Gender", "Female")
                .checkSubmitResult("Mobile", "1234567890")
                .checkSubmitResult("Date of Birth", "30 July,1986")
                .checkSubmitResult("Subjects", "English, Computer Science")
                .checkSubmitResult("Hobbies", "Reading, Music")
                .checkSubmitResult("Picture", "1.jpg")
                .checkSubmitResult("Address", "Lenina, 54")
                .checkSubmitResult("State and City", "Uttar Pradesh Merrut");
    }
}

   // @Test
   // void emptySubmitTest() {
    //    registrationPage.openPage().submit().checkValidation();
//    }
//   @Test
//  void minimalRegistrationTest() {
//      registrationPage.openPage()
//              .setFirstName("getRandomString(len: 10)")
//              .setLastName("getRandomString(len: 10)")
//             .setGender("Female")
//             .setNumber("1234567890")
//            .submit()
//           .checkSubmitResult("Student Name", "Elena Dobrovolskaya")
//           .checkSubmitResult("Gender", "Female")
//           .checkSubmitResult("Mobile", "1234567890");



