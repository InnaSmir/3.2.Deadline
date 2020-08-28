package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginInput= $("[data-test-id=login] input");
    private SelenideElement passwordInput = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(DataHelper.AuthorizationInfo info) {
        loginInput.setValue(info.getLogin());
        passwordInput.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public SelenideElement showErrorMessage() {
        return $(".notification").shouldHave(Condition.text("Ошибка! Неверно указан логин или пароль"));
    }
}
