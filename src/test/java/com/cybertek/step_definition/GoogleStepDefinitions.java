package com.cybertek.step_definition;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoogleStepDefinitions {
    GoogleSearchPage googleSearchPage=new GoogleSearchPage();
    @Given("User is on the google search page")
    public void user_is_on_the_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }




    @Then("User should see title is Google")
    public void user_should_see_title_is_google() {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="Google";
      //  Assert.fail("Unporpose fail");
        Assert.assertEquals("Title doesn't match",actualTitle,expectedTitle);
    }

    @When("User searches apple")
    public void userSearchesApple() {
        //creating the page object
        GoogleSearchPage googleSearchPage=new GoogleSearchPage();
        //sending value into search box using page

        googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);
    }

    @Then("User should see apple in the title")
    public void userShouldSeeAppleInTheTitle() {
       String expectedTitle="apple";
       String actualTitle=Driver.getDriver().getTitle();
       Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @When("User searches {string}")
    public void userSearches(String serchValue) {
        GoogleSearchPage googleSearchPage=new GoogleSearchPage();
        //sending value into search box using page

        googleSearchPage.searchBox.sendKeys(serchValue+ Keys.ENTER);
    }

    @Then("User should see {string} in the title")
    public void userShouldSeeInTheTitle(String searchValue) {
        String expectedTitle=searchValue;
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Then("User should see About link")
    public void userShouldSeeAboutLink() {
        //asserting that about link is displayed
        Assert.assertTrue(googleSearchPage.aboutLink.isDisplayed());
    }

    @And("User clicks to About link")
    public void userClicksToAboutLink() {
        googleSearchPage.aboutLink.click();
    }

    @Then("User should see title Google - About Google, Our Culture & Company News")
    public void userShouldSeeTitleGoogleAboutGoogleOurCultureCompanyNews() {
        String expectedTitle="Google - About Google, Our Culture & Company News";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Then("User should see six links in the footer")
    public void user_should_see_six_links_in_the_footer(List<String> linkStrings) {

        int actualSize=googleSearchPage.footerLinks.size();
        int expectedSize=linkStrings.size();
        Assert.assertEquals(actualSize,expectedSize);


    }
}
