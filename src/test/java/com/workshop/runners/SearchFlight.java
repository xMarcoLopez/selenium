package com.workshop.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/search_flights.feature",
        glue = "com.workshop.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class SearchFlight {
}
