package com.geekbrains.lesson6;

import com.geekbrains.lesson7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.Iterator;

@Story("Работа c публикациями в дневнике")
public class DiaryPageObjectTest {
    WebDriver driver;
    private final static String DIARY_URL = "https://diary.ru";


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.get(DIARY_URL);
    }


    @Test
    @Feature("Нравится")
    @Description("Проверка добавления лайка к посту в дневнике")
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
    @Feature("Подписка")
    @Description("Проверка добавления подписки на записи по имени профиля участника")
    void SubscribeTest() {
        new MainPage(driver)
                .clickEnterButton()
                .fillLogin("sveta73")
                .fillPassword("240573tm")
                .clickLoginButton()
                .clickContentMonth()
                .clickFilmContent()
                .clickContentFilmByName("царевна Лягушка")
                .clickSubscribeContent()
                .checkSubscribeContentFilm();

    }


    @AfterEach
    void killDriver() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        Iterator<LogEntry> iterator = logEntries.iterator();

        while (iterator.hasNext()) {
            Allure.addAttachment("Лог браузера:", iterator.next().getMessage());
        }

       /* for (LogEntry log: logEntries) {
            Allure.addAttachment("Лог браузера:", log.getMessage());
        }*/

        driver.quit();
    }

}
