package com.eduzeny.step_definitions;

import com.eduzeny.pages.GoogleSearchPage;
import com.eduzeny.utilities.ConfigurationReader;
import com.eduzeny.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleSearchVerification {

    //Bunlara snippets lari buraya yapistirdik.

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("User is on the google page")
    public void user_is_on_the_google_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));

    }

    @When("User enter apple into search box")
    public void user_enter_apple_into_search_box() {
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);

    }

    @Then("user should see the title of search item")
    public void user_should_see_the_title_of_search_item() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "apple";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @When("User enter turkey into search box")
    public void user_enter_turkey_into_search_box() {
        googleSearchPage.searchBox.sendKeys("Turkey" + Keys.ENTER);

    }

    @Then("user should see the  turkey title of search item")
    public void user_should_see_the_turkey_title_of_search_item() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Turkey";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
