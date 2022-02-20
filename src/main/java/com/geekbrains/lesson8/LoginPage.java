package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private SelenideElement loginInput = $(By.xpath("//*[@id='loginform-username']"));

    private SelenideElement passwordInput = $(By.xpath("//*[@id='loginform-password']"));

    private SelenideElement loginButton = $(By.xpath("//*[@id='login_btn']"));



    @Step("Заполнить поле логина")
    public LoginPage fillLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароля")
    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку логина")
    public MainPage clickLoginButton() {
        loginButton.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return page(MainPage.class);
    }

}

