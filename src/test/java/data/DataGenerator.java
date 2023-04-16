package data;


import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.github.javafaker.Faker;


public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String city = faker.address().cityName();
        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = "+7" + faker.phoneNumber().subscriberNumber(10);
        return phone;
    }

    public static class Registration {
        public Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}