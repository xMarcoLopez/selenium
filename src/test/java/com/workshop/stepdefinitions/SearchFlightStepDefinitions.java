package com.workshop.stepdefinitions;

import com.workshop.steps.FlightResult;
import com.workshop.steps.SearchFlight;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchFlightStepDefinitions {
    @Steps
    SearchFlight user;

    @Steps
    FlightResult userFlightResult;

    @Given("^Daniel wants to search for flights$")
    public void prepareSearchForFlights() {
        user.isTheHomePage();
    }


    @When("^Daniel enters departure (.*) and destination (.*)$")
    public void searchFlights(String departure, String destination) {
        user.checkOneWayBox();
        user.writeDeparture(departure);
        user.writeDestination(destination);
        user.openDepartureDate();
        user.writeDepartureDate();
        user.searchFlights();
    }

    @Then("^Daniel should pick up the cheapest flight$")
    public void pickLowerFlight() {
        userFlightResult.clickCheapestFlight();
        userFlightResult.clickContinueButton();
    }
}
