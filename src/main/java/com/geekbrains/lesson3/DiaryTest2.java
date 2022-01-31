package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DiaryTest2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[.='Вход']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginform-username']")));
        driver.findElement(By.xpath("//*[@id='loginform-username']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='loginform-password']")).click();
        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'recaptcha')]")));
        driver.findElement(By.xpath("//*[@id='recaptcha-anchor']")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id='login_btn']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page_content']//a[@data-days='30']")));
        driver.findElement(By.xpath("//*[@id='page_content']//a[@data-days='30']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tags_list']/a[contains(., 'кино')]")));
        driver.findElement(By.xpath("//*[@id='tags_list']/a[contains(., 'кино')]")).click();
        List<WebElement> filmsList = driver.findElements(By.xpath("//div[@class='singlePost countSecond']"));
        filmsList.stream().filter(f -> f.getText().contains("django")).findFirst().get().click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='more-links221046241']/a[@class='subscribe post_subs']")));
        driver.findElement(By.xpath("//*[@id='more-links221046241']/a[@class='subscribe post_subs']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
