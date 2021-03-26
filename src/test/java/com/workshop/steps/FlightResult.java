package com.workshop.steps;

import net.thucydides.core.annotations.Step;


public class FlightResult {
    FlightResult vivaAir;

    @Step
    public void clickCheapestFlight(){
        vivaAir.clickCheapestFlight();
    }

    @Step
    public void clickContinueButton(){
        vivaAir.clickContinueButton();
    }
}
