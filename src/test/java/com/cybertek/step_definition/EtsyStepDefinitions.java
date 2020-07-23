package com.cybertek.step_definition;

import com.cybertek.pages.EtsyPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsyStepDefinitions {
    EtsyPage etsyPage=new EtsyPage();

    @Given("User is on etsy home page")
    public void user_is_on_etsy_home_page() {
        Driver.getDriver().get("https://www.etsy.com");

    }




    @Then("User should sees title is as expected")
    public void user_should_sees_title_is_as_expected() {
String actualTitle=Driver.getDriver().getTitle();
String expectedTitle="Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @When("User searches wooden spoon in the search box")
    public void userSearchesWoodenSpoonInTheSearchBox() {
        etsyPage.searchBox.sendKeys("wooden spoon");

    }

    @And("User clicks to the search button")
    public void userClicksToTheSearchButton() {
        etsyPage.searchButton.click();
    }

    @Then("User should see {string} int etsy title")
    public void userShouldSeeIntEtsyTitle(String titleName) {
       String actualTitle= Driver.getDriver().getTitle();
       Assert.assertTrue(actualTitle.contains(titleName));

    }
}
