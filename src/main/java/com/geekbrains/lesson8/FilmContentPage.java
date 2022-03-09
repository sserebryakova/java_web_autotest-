package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;


public class FilmContentPage {
    private ElementsCollection filmsContentList = $$(By.xpath("//*[@class='singlePost countSecond']"));

    private SelenideElement subscribeContentButton = $(By.xpath("//a[@class='subscribe post_subs']"));

    private SelenideElement subscribeContentFilm = $(By.xpath("//a[@class='unsubscribe post_subs']"));


    @Step("Клик на пост по имени профиля участника")
    public FilmContentPage clickContentFilmByName(String name) {
        filmsContentList.findBy(Condition.text(name)).click();
        return this;
    }

    @Step("Клик на элемент Подписаться")
    public FilmContentPage clickSubscribeContent() {
        subscribeContentButton.shouldBe(Condition.visible, Duration.ofSeconds(6)).click();
        return this;
    }

    @Step("Проверить подписку профиля участника")
    public FilmContentPage checkSubscribeContentFilm() {
        assertThat(subscribeContentFilm, isDisplayed());
        subscribeContentFilm.shouldBe(Condition.visible, Duration.ofSeconds(6));
        return this;
    }

}
