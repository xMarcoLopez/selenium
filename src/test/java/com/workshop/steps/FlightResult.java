package com.workshop.steps;

import com.workshop.userinterface.FlightResultPage;
import net.thucydides.core.annotations.Step;


public class FlightResult {
    FlightResultPage vivaAir;

    @Step
    public void clickCheapestFlight(){
        vivaAir.clickCheapestFlight();
    }

    @Step
    public void clickContinueButton(){
        vivaAir.clickContinueButton();
    }
}
