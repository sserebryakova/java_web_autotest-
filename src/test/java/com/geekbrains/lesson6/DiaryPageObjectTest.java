package com.geekbrains.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiaryPageObjectTest {
    WebDriver driver;
    private final static String DIARY_URL = "https://diary.ru";


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get(DIARY_URL);
    }


    @Test
    void LikeContentTest() {
        new MainPage(driver)
                .clickEnterButton()
                .fillLogin("sveta73")
                .fillPassword("240573tm")
                .clickLoginButton()
                .clickContentOneDay()
                .clickContentThoughts()
                .likeContent()
                .checkAddedToFavourites();
    }

    @Test
    void SubscribeTest() {
        new MainPage(driver)
                .clickEnterButton()
                .fillLogin("sveta73")
                .fillPassword("240573tm")
                .clickLoginButton()
                .clickContentMonth()
                .clickFilmContent()
                .clickContentFilmByName("Milena Main")
                .clickSubscribeContent()
                .checkSubscribeContentFilm();

    }


    @AfterEach
    void killDriver() {
        driver.quit();
    }

}
