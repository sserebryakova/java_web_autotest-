package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    private SelenideElement EnterButton = $(By.xpath("//a[.='Вход']"));


    @Step("Клик на кнопку логина главной страницы")
    public LoginPage clickEnterButton() {
        EnterButton.click();
        return page(LoginPage.class);
    }

    private SelenideElement contentOneDay =  $(By.xpath("//*[@id='page_content']//a[@data-days='1']"));

    private SelenideElement contentMonth =  $(By.xpath("//*[@id='page_content']//a[@data-days='30']"));

    private SelenideElement contentThoughts =  $(By.xpath("//*[@id='tags_list']/a[contains(., 'размышления')]"));

    private SelenideElement filmContent =  $(By.xpath("//*[@id='tags_list']/a[contains(., 'музыка')]"));


    @Step("Клик на элемент за день страницы Популярное")
    public MainPage clickContentOneDay() {
        contentOneDay.shouldBe(Condition.visible, Duration.ofSeconds(6)).click();
        return this;
    }

    @Step("Клик на элемент Мысли вслух страницы Популярное")
    public ContentPage clickContentThoughts() {
        contentThoughts.shouldBe(Condition.visible, Duration.ofSeconds(6)).click();
        return page(ContentPage.class);
    }

    @Step("Клик на элемент за месяц страницы Популярное")
    public MainPage clickContentMonth() {
        contentMonth.shouldBe(Condition.visible, Duration.ofSeconds(6)).click();
        return this;
    }

    @Step("Клик на элемент Кино страницы Популярное")
    public FilmContentPage clickFilmContent() {
        filmContent.shouldBe(Condition.visible, Duration.ofSeconds(6)).click();
        return page(FilmContentPage.class);
    }
}
