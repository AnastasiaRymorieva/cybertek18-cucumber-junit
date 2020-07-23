package com.cybertek.step_definition;

import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order = 2)
    public void setUpScenario() {
        System.out.println("-----> Before : Setting up browser");
    }

    @Before(value = "@db")
    public void setUpDatabaseConnections() {
        System.out.println("Before --->: DB connection created");
    }

    @After(order = 1)
    public void tearDownScenario(Scenario scenario) {
        //  System.out.println("------> After : Closing Browser");
        //  System.out.println("scenario.getName() = " + scenario.getName());
        //  System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        //  System.out.println("scenario.isFailed() = " + scenario.isFailed());
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // attach method accepts 3 arguments. 1)Screenshot itself 2)image type 3)current scenario's name
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

    }

    @After("@db")
    public void tearDownDatabaseConnection() {
        System.out.println("-----> After Annotation: DB Connection Closed");
    }
}
