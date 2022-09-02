package com.eduzeny.step_definitions;

import com.eduzeny.pages.WebAllOrderPage;
import com.eduzeny.pages.WebLoginPage;
import com.eduzeny.pages.WebOrderPage;
import com.eduzeny.utilities.ConfigurationReader;
import com.eduzeny.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebTableOneStepDef {

    WebLoginPage webLoginPage = new WebLoginPage();
    WebOrderPage webOrderPage = new WebOrderPage();
    WebAllOrderPage webAllOrderPage = new WebAllOrderPage();


    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.app.url"));
        webLoginPage.login();
        webOrderPage.orderBtn.click();

    }


    @When("user selects product type {string}")
    public void user_selects_product_type(String productType) {

        Select select = new Select(webOrderPage.product);
        select.selectByVisibleText(productType);

    }
    @When("user enters quantity {int}")
    public void user_enters_quantity(int quantity) {
        // webTableOrderPage.quantity.sendKeys(String.valueOf(quantity));
        webOrderPage.quantity.clear();
        webOrderPage.quantity.sendKeys(quantity+""); //

    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String customerName) {
        webOrderPage.customerName.sendKeys(customerName);
    }

    @When("user enters street {string}")
    public void user_enters_street(String street) {
        webOrderPage.street.sendKeys(street);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        webOrderPage.city.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        webOrderPage.state.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        webOrderPage.zipCode.sendKeys(string);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {

        List<WebElement> cardTypes = webOrderPage.creditCardType;

        for (WebElement each : cardTypes) {
            if(each.getAttribute("value").equalsIgnoreCase(expectedCardType)){
                each.click();
            }

        }
    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        webOrderPage.creditCardNumber.sendKeys(string);

    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        webOrderPage.expiryDate.sendKeys(string);

    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        webOrderPage.processOrderBtn.click();
    }

    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {

        String actualName = webAllOrderPage.firstRowname.getText();
        Assert.assertEquals(expectedName,actualName);
    }
}
