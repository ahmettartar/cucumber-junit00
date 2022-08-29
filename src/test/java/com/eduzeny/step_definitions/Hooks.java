package com.eduzeny.step_definitions;

import com.eduzeny.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    // @Before is coming from cucumber. It is running before each scenario
    @Before //io.cucumber.java must be selected. Before Scenario - After Scenario
    public void setUpScenario(){
        System.out.println("--> It is coming from @Before in Hooks ");
    }

    // @After is coming from cucumber. It is running after each scenario
    @After //io.cucumber.java
    public void teardownScenario(Scenario scenario){
        System.out.println("--> It is coming from @After in Hooks ");

        if(scenario.isFailed()){//passed durumlar icin kanita gerek yok. Fail olan durum icin kanit gerekir.
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }

        Driver.closeDriver();

    }

}

