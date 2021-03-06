package com.geekbrains.lesson6;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class ContentPage extends BasePage {
    public ContentPage(WebDriver driver) {
        super(driver);
    }

    private final static String LIKE_BUTTON_LOCATOR_BY_XPATH =
            "//*[@id='more-links221062450']/a/descendant::span[@class='name_likes']";
    @FindBy(xpath = LIKE_BUTTON_LOCATOR_BY_XPATH)
    private WebElement likeButton;

    @Step("Клик элемент Нравится к посту")
    public ContentPage likeContent() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LIKE_BUTTON_LOCATOR_BY_XPATH)));
        likeButton.click();
        return this;
    }

    private final static String ADDED_TO_FAV_XPATH_LOCATOR = "//*[@id='blog_post_like_221062450']";
    @FindBy(xpath = ADDED_TO_FAV_XPATH_LOCATOR)
    private WebElement addedToFavouritesElement;

    @Step("Проверить добавление лайка к посту")
    public ContentPage checkAddedToFavourites() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ADDED_TO_FAV_XPATH_LOCATOR)));
        assertThat(addedToFavouritesElement, isDisplayed());
        return this;
    }
}
