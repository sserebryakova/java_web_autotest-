package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final static String LOGIN_INPUT_LOCATOR_BY_XPATH = "//*[@id='loginform-username']";
    @FindBy(xpath = LOGIN_INPUT_LOCATOR_BY_XPATH)
    public WebElement loginInput;

    @FindBy(xpath = "//*[@id='loginform-password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login_btn']")
    public WebElement loginButton;

    @Step("Заполнить поле логина")
    public LoginPage fillLogin(String login) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_INPUT_LOCATOR_BY_XPATH)));
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
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginButton.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new MainPage(driver);
    }
}



