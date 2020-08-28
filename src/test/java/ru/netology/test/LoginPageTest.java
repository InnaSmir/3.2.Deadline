package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.DataSql;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPageTest {

    private LoginPage loginPage;

    @BeforeEach
    void setup() {
        open("http://localhost:7777", LoginPage.class);
    }

    @Test
    void shouldAddNewUser() {
        val AuthorizationInfo = DataHelper.getNewUser();
        val verificationPage = loginPage.validLogin(AuthorizationInfo);
        sleep(900);
        val verificationCode = DataSql.getVerificationCode();
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldLoginUser() {
        val authInfo = DataHelper.getAuthorizationInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataSql.getVerificationCode();
        verificationPage.validVerify(verificationCode);
    }

}