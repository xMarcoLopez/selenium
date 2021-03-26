package com.workshop;

import com.workshop.utils.Util;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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
        // driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();
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
        Thread.sleep(5000);
        List <WebElement> flights = driver.findElements(By.className("from-price"));
        List <String> flightsText = new ArrayList<String>();
        for (WebElement flightPrice : flights){
            flightsText.add(flightPrice.getText());
        }
        List <String> flightsText2 = new ArrayList<String>();
        for(String flightText : flightsText){
            flightsText2.add(flightText.replaceAll("COP", ""));
        }
        List <String> flightsText3 = new ArrayList<String>();
        for(String flightText : flightsText2){
            flightsText3.add(flightText.replaceAll(",", ""));
        }

        flightsText3 = Util.removeCharacter(flightsText3, " ");
        List<Integer> flightPrices = Util.convertStringListToIntegerList(flightsText3);
        Integer cheapestFlight = Collections.min(flightPrices);
        flights.get(flightPrices.indexOf(cheapestFlight)).click();
        Thread.sleep(4000);
        WebElement continueButton = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[1]/div/div[2]/div/div[3]/div[2]/button"));
        Thread.sleep(4000);
        // Util.jsClick(continueButton);
        continueButton.click();

        // driver.close();
        // driver.quit();
    }

    private String getDate() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date currentDate = Date.from(LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        String date = simpleDateFormat.format(currentDate);
        return date;
    }
}



