package com.workshop.steps;

import com.workshop.userinterface.SearchFlightPage;
import com.workshop.utils.Util;
import net.thucydides.core.annotations.Step;

public class SearchFlight {
    SearchFlightPage vivaAir;

    @Step
    public void isTheHomePage(){
        vivaAir.open();
    }

    @Step
    public void checkOneWayBox(){
        vivaAir.clickOneWayCheckbox();
    }

    @Step
    public void writeDeparture(String departure){
        vivaAir.writeDeparture(departure);
    }

    @Step
    public void writeDestination(String destination){
        vivaAir.writeDestination(destination);
    }

    @Step
    public void openDepartureDate(){
        vivaAir.clickDepartureDate();
    }

    @Step
    public void writeDepartureDate(){
        Util.jsClick(vivaAir.generateDateButton());
    }

    @Step
    public void searchFlights(){
        vivaAir.clickSearchButton();
    }
}
