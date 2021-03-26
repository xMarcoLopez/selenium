package com.workshop.userinterface;

import com.workshop.utils.Util;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class FlightResultPage extends PageObject {
    private List<WebElement> flightPrices;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[3]/div[1]/div/div[2]/div/div[3]/div[2]/button")
    private WebElementFacade continueButton;

    public List<WebElement> flightPrices(){
        return this.flightPrices = getDriver().findElements(By.className("from-price"));
    }

    public void clickCheapestFlight(){
        WebElement cheapestFlightElement = null;
        Integer cheapestFlight = null;
        this.flightPrices = flightPrices();
        List<String> textFlightPrices = Util.getTextList(flightPrices);
        textFlightPrices = Util.removeCharacters(textFlightPrices);
        List<Integer> flightPricesCOP = Util.convertStringListToIntegerList(textFlightPrices);
        cheapestFlight = Collections.min(flightPricesCOP);
        cheapestFlightElement = flightPrices.get(flightPricesCOP.indexOf(cheapestFlight));
        cheapestFlightElement.click();
    }

    public void clickContinueButton(){
        this.continueButton.waitUntilClickable().click();
    }
}
