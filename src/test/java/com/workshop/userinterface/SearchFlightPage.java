package com.workshop.userinterface;

import com.workshop.utils.Util;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://vivaair.com")
public class SearchFlightPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"criteria\"]/div/div[1]/label/span[2]") private WebElementFacade oneWayCheckbox;
    @FindBy(id = "criteria-airport-select-departure-input") private WebElementFacade departure;
    @FindBy(id = "criteria-airport-select-destination-input") private WebElementFacade destination;
    @FindBy(id = "criteria-dates-from") private WebElementFacade departureDate;
    @FindBy(id = "criteria-search-button-desktop") private WebElementFacade searchButton;
    private WebElement dateButton;

    public void clickOneWayCheckbox(){
        oneWayCheckbox.waitUntilClickable().click();
    }

    public void writeDeparture(String departure){
        this.departure.waitUntilClickable().typeAndEnter(departure);
    }

    public void writeDestination(String destination){
        this.destination.waitUntilClickable().typeAndEnter(destination);
    }

    public void clickDepartureDate(){
        this.departureDate.waitUntilClickable().click();
    }

    public WebElement generateDateButton(){
        return this.dateButton = getDriver()
                .findElement(By.xpath(String.format("//button[@date='%s']", Util.generateNextDayDate())));
    }

    public void clickSearchButton(){
        this.searchButton.waitUntilClickable().click();
    }

}
