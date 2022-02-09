package com.geekbrains.lesson6;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Вход']")
    public WebElement EnterButton;

    @Step("Клик на кнопку логина главной страницы")
    public LoginPage clickEnterButton() {
        EnterButton.click();
        return new LoginPage(driver);
    }


    private final static String ONEDAY_BUTTON_LOCATOR_BY_XPATH =
            "//*[@id='page_content']//a[@data-days='1']";
    @FindBy(xpath = ONEDAY_BUTTON_LOCATOR_BY_XPATH)
    private WebElement contentOneDay;

    private final static String
            MONTH_BUTTON_LOCATOR_BY_XPATH =
            "//*[@id='page_content']//a[@data-days='30']";
    @FindBy(xpath = MONTH_BUTTON_LOCATOR_BY_XPATH)
    private WebElement contentMonth;

    private final static String CONTENT_BUTTON_LOCATOR_BY_XPATH =
            "//*[@id='tags_list']/a[contains(., 'Мысли вслух')]";
    @FindBy(xpath = CONTENT_BUTTON_LOCATOR_BY_XPATH)
    private WebElement contentThoughts;

    private final static String FILM_BUTTON_LOCATOR_BY_XPATH =
            "//*[@id='tags_list']/a[contains(., 'фильмы')]";
    @FindBy(xpath = FILM_BUTTON_LOCATOR_BY_XPATH)
    private WebElement filmContent;

    @Step("Клик на элемент за день страницы Популярное")
    public MainPage clickContentOneDay() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ONEDAY_BUTTON_LOCATOR_BY_XPATH)));
        contentOneDay.click();
      return this;
    }

    @Step("Клик на элемент Мысли вслух страницы Популярное")
    public ContentPage clickContentThoughts() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONTENT_BUTTON_LOCATOR_BY_XPATH)));
        contentThoughts.click();
        return new ContentPage(driver);
    }

    @Step("Клик на элемент за месяц страницы Популярное")
    public MainPage clickContentMonth() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MONTH_BUTTON_LOCATOR_BY_XPATH)));
        contentMonth.click();
        return this;
    }

    @Step("Клик на элемент Кино страницы Популярное")
    public FilmContentPage clickFilmContent() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILM_BUTTON_LOCATOR_BY_XPATH)));
        filmContent.click();
        return new FilmContentPage(driver);
    }
}
