package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthorizationInfo {
        private String login;
        private String password;
    }

    public static AuthorizationInfo getAuthorizationInfo() {
        return new AuthorizationInfo("vasya", "qwerty123");
    }

    public static AuthorizationInfo getNewUser(){
        return new AuthorizationInfo(DataSql.getNewUser(), "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String verificationCode;
    }


    public static AuthorizationInfo  getUserWithWrongPassword() {
        val faker = new Faker();
        return new AuthorizationInfo ("vasya", faker.internet().password());
    }
}
