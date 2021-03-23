package com.workshop;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class TestSelenium {

    private String date;

    @Test
    public void searchFlights() throws InterruptedException {
        String departureCity = "Medellin";
        String destinationCity = "Bogota";
        date = getDate();

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
        //departure.sendKeys(departureCity + Keys.ENTER);
        destination.sendKeys(destinationCity + Keys.ENTER);
        departureDate.click();
        Thread.sleep(2000);
        WebElement dateButton = driver.findElement(By.xpath(String.format("//button[@date='%s']", date)));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", dateButton);
        Thread.sleep(4000);
        searchButton.click();
        // driver.close();
        // driver.quit();
    }

    private String getDate() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }
}



