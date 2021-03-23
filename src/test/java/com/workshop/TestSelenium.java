package com.workshop;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDate;
import java.util.List;

public class TestSelenium {

    @Test
    public void test() throws InterruptedException {
        String departureCity = "Medellin";
        String destinationCity = "Bogota";
        String month = "Marzo 2021";
        String day = "23";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.vivaair.com");
        Thread.sleep(4000);
        driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();
        WebElement oneWayCheckbox = driver.findElement(By.xpath("//*[@id=\"criteria\"]/div/div[1]/label/span[2]"));
        WebElement departure = driver.findElement(By.id("criteria-airport-select-departure-input"));
        WebElement destination = driver.findElement(By.id("criteria-airport-select-destination-input"));
        WebElement departureDate = driver.findElement(By.id("criteria-dates-from"));
        WebElement searchButton = driver.findElement(By.id("criteria-search-button-desktop"));
        oneWayCheckbox.click();
        // departure.sendKeys("Medellin" + Keys.ENTER);
        destination.sendKeys(destinationCity + Keys.ENTER);
        departureDate.click();
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[2]/" +
                    "div/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div")).getText();



        // searchButton.click();
        // oneWayCheckbox.click();


        // driver.close();
        // driver.quit();
    }
}
