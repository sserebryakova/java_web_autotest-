package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class FilmContentPage extends BasePage {
    public FilmContentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='singlePost countSecond']")
    private List<WebElement> filmsContentList;

    private final static String SUBSCRIBE_BUTTON_XPATH_LOCATOR = "//a[@class='subscribe post_subs']";
    @FindBy(xpath = SUBSCRIBE_BUTTON_XPATH_LOCATOR)
    private WebElement subscribeContentButton;

    private final static String SUBSCRIBE_XPATH_LOCATOR = "//a[@class='unsubscribe post_subs']";
    @FindBy(xpath = SUBSCRIBE_XPATH_LOCATOR)
    private WebElement subscribeContentFilm;

    public FilmContentPage clickContentFilmByName(String name) {
        filmsContentList.stream().filter(f -> f.getText().contains(name)).findFirst().get().click();
        return this;
    }
    public FilmContentPage clickSubscribeContent() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(SUBSCRIBE_BUTTON_XPATH_LOCATOR)));
        subscribeContentButton.click();
        return this;
    }

    public FilmContentPage checkSubscribeContentFilm() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(SUBSCRIBE_XPATH_LOCATOR)));
        assertThat(subscribeContentFilm, isDisplayed());
        return this;
    }

}

