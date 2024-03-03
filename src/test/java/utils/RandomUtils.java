package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String randomState = getRandomState();
    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomAddress());
        System.out.println(getRandomInt(111, 99999999));
        //System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
    }

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++)
            result.append(AB.charAt(rnd.nextInt(AB.length())));
        return result.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@qa.guru";
    }

    public static String getRandomAddress() {
        return getRandomString(10) + " " + getRandomString(10) + " " + getRandomString(10);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    // +3 (263) 253 - 66 - 12

public static String getRandomPhone() {
//        String a = "a123";
//        String b = "b456";
//        String c1 = a + " " + b; // "a123 b456"
//        String c2 = String.format("%s %s", a, b); // "a123 b456"

   return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
              getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
 }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return new Faker().options().option(genders);
    }

    public static String getRandomMonth() {
        String[] monthNames = {"January", "February", "March",
                "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        return new Faker().options().option(monthNames);

    }


    public static String getRandomYear() {
        Random random = new Random();
        int minYear = 1950;
        int maxYear = 2024;
        int randomYearInt = random.nextInt(maxYear - minYear + 1) + minYear;
        String randomYear = String.valueOf(randomYearInt);
        return randomYear;
    }

    public static String getRandomSubject() {
        String[] subjects = {"Maths", "Arts", "English",
                "Biology", "Hindi", "Commerce"};
        return new Faker().options().option(subjects);

    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return new Faker().options().option(hobbies);
    }


    private static final Map<String, String[]> CITIESBYSTATE = new HashMap<>();

    static {
        CITIESBYSTATE.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        CITIESBYSTATE.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        CITIESBYSTATE.put("Haryana", new String[]{"Karnal", "Panipat"});
        CITIESBYSTATE.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    private static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return new Faker().options().option(states);
    }

    public static String getRandomCity() {
        String[] cities = CITIESBYSTATE.get(randomState);
        return new Faker().options().option(cities);
    }


}
