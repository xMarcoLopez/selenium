package com.workshop;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class TestSelenium {

    private String today;

    @Test
    public void searchFlights() throws InterruptedException {
        String departureCity = "Medellin";
        String destinationCity = "Bogota";
        today = getCurrentDay();
        System.out.println("Today's number: " + today + "\n");

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
        departure.sendKeys(departureCity + Keys.ENTER);
        destination.sendKeys(destinationCity + Keys.ENTER);
        departureDate.click();
        Thread.sleep(2000);
        WebElement dateWidgetFrom = driver.findElement(By.xpath("//*[@id='month-list']/div[1]/div[2]/table/tbody"));
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        for (WebElement cell : columns) {
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
        }
        // String text = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[2]/" +
        // "div/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div")).getText();
        searchButton.click();
        // driver.close();
        // driver.quit();
    }

    private String getCurrentDay() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        String todayStr = Integer.toString(todayInt);
        return todayStr;
    }
}



