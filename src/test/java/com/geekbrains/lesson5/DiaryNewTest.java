package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;



public class DiaryNewTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String DIARY_URL = "https://diary.ru";


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(DIARY_URL);
        Cookie cookie = new Cookie("_identity_", "97ad5e9db7fa0cb5240873c4fc6e2eee2f6863693ac8d8ed72b8914f165" +
                "d7348a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A54%3A%22%5B%223562637%22%2C%22RS3nxkB8" +
                "cN6NogcVMUvXMExWZo_wzEN-%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

    }
    @Test
    void MyProfileTest() {
        actions.click(driver.findElement(By.xpath("//*[@id='navbar_user-collapse']/ul/li[@class='username']/a")))
                .build()
                .perform();
        assertThat(driver.findElement(By.xpath("//*[@id='wrapper']//div[@class='user col-lg-4']/h1")), hasText("sveta73"));
    }

    @Test
    void LikeContentTest() {
        actions.click(driver.findElement(By.xpath("//a[@class='TagsTop TagsTop1 current']")))
                .build()
                .perform();
        actions.click(driver.findElement(By.xpath("//*[@id='tags_list']/a[contains(., 'мысли')]")))
                .build()
                .perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='more-links221055708']/a/descendant::span[@class='name_likes']")));
        actions.click(driver.findElement(By.xpath("//*[@id='more-links221055708']/a/descendant::span[@class='name_likes']")))
                .build()
                .perform();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='blog_post_like_221055708']")).isDisplayed());
    }

    @Test
    void ProfileTest() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page_content']//a[@data-days='30']")));
        actions.click(driver.findElement(By.xpath("//*[@id='page_content']//a[@data-days='30']")))
                .build()
                .perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tags_list']/a[contains(.,  'музыка')]")));
        actions.click(driver.findElement(By.xpath("//*[@id='tags_list']/a[contains(.,  'музыка')]")))
                .build()
                .perform();
        actions.click(driver.findElement(By.xpath("//*[@id='more-links221056801']/a[@class='profile']")))
                .build()
                .perform();
        assertThat(driver.findElement(By.xpath("//*[@id='wrapper']//div[@class='user col-lg-4']/h1")), hasText("roseIceberg"));
    }


        @AfterEach
        void tearDown () {
            driver.quit();
        }
    }

