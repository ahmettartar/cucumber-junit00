package com.eduzeny.step_definitions;

import com.eduzeny.pages.GoogleSearchPage;
import com.eduzeny.pages.GoogleSearchResultPage;
import com.eduzeny.utilities.ConfigurationReader;
import com.eduzeny.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoogleDataDrivenTesting {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage();

    @Given("User is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));

    }

    @When("User types {string} in the google search box and clicks enter")
    public void user_types_in_the_google_search_box_and_clicks_enter(String item) {
        googleSearchPage.searchBox.sendKeys(item + Keys.ENTER);

    }

    @Then("User sees {string} is in the google title")
    public void user_sees_is_in_the_google_title(String title) {
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);

        //assertTrue(actualTitle.equals(title));
        assertEquals(title, actualTitle);

    }

    @Then("User should be able to search for following:")
    public void user_should_be_able_to_search_for_following(List<String> str) {

        for (String each : str) {
            googleSearchPage.searchBox.clear();
            googleSearchPage.searchBox.sendKeys(each + Keys.ENTER);
            assertEquals(each+" - Google Search", Driver.getDriver().getTitle());
        }

    }


    @When("User searches for {string} capital")
    public void user_searches_for_capital(String country) {
        googleSearchPage.searchBox.sendKeys("What is the capital of " + country + Keys.ENTER);

    }

    @Then("User should see {string} in the result")
    public void user_should_see_in_the_result(String capital) {

        String actualCapital = googleSearchResultPage.capitalName.getText();
        assertEquals(capital, actualCapital);

    }

}
