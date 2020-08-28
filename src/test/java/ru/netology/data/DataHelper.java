package ru.netology.data;

import lombok.Value;

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
}
