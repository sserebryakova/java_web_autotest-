package com.geekbrains;

import com.codeborne.selenide.Selenide;
import com.geekbrains.lesson8.ContentPage;
import com.geekbrains.lesson8.FilmContentPage;
import com.geekbrains.lesson8.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DiaryStepDefinition {
    @Given("Пользователь авторизовался на сайте")
    public void userAuthorized() {
        Selenide.open("https://diary.ru");
        new MainPage()
                .clickEnterButton()
                .fillLogin("sveta73")
                .fillPassword("240573tm")
                .clickLoginButton();
    }

    @When("Пользователь кликает на элемент за день страницы Популярное")
    public void userClickContentOneDay() {
        new MainPage().clickContentOneDay();
    }

    @When("Пользователь кликает на элемент Мысли вслух страницы Популярное")
    public void userClickContentThoughts() {
        new MainPage().clickContentThoughts();
    }

    @When("Пользователь кликает элемент Нравится к посту")
    public void userLikeContent() {
        new ContentPage().likeContent();
    }

    @Then("Пользователь видит добавление лайка к посту")
    public void userSeeAddToFavourites() {
        new ContentPage().checkAddedToFavourites();
    }


    @When("Пользователь кликает на элемент за месяц страницы Популярное")
    public void userClickContentMonth() { new MainPage().clickContentMonth();
    }

    @When("Пользователь кликает на элемент Кино страницы Популярное")
    public void userClickFilmContent() { new MainPage().clickFilmContent();
    }

    @When("Пользователь кликает на пост по имени профиля участника{string}")
    public void userClickContentFilmByName(String name) { new FilmContentPage().clickContentFilmByName(name);
    }

    @When("Пользователь кликает на элемент Подписаться")
    public void userClickSubscribeContent() { new FilmContentPage().clickSubscribeContent();
    }

    @Then("Пользователь видит добавление подписки на профиль участника")
    public void userCheckSubscribeContentFilm() { new FilmContentPage().checkSubscribeContentFilm();
    }

    @After(value = "@close_browser")
    public void after() {
        Selenide.closeWebDriver();
    }
}
