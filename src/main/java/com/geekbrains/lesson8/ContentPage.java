package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;


public class ContentPage {

    private SelenideElement likeButton = $(By.xpath("//*[@id='more-links221075633']/a/descendant::span[@class='name_likes']"));

    private SelenideElement addedToFavouritesElement = $(By.xpath("//*[@id='blog_post_like_221075633']"));

    @Step("Клик элемент Нравится к посту")
    public ContentPage likeContent() {
        likeButton.shouldBe(Condition.visible, Duration.ofSeconds(6)).click();
        return this;
    }

    @Step("Проверить добавление лайка к посту")
    public ContentPage checkAddedToFavourites() {
        assertThat(addedToFavouritesElement, isDisplayed());
        addedToFavouritesElement.shouldBe(Condition.visible, Duration.ofSeconds(6));
        return this;
    }
}
