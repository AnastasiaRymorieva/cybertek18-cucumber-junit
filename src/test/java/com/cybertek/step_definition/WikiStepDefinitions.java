package com.cybertek.step_definition;

import com.cybertek.pages.WikiPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class WikiStepDefinitions {
WikiPage wiki=new WikiPage();

    @Given("User is on the Wikipedia home page")
    public void user_is_on_the_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }


    @When("User search {string} in the wiki search page")
    public void user_search_in_the_wiki_search_page(String search) {
wiki.searchBox.sendKeys(search+ Keys.ENTER);
    }
    @Then("User should see {string} in the wiki title")
    public void user_should_see_in_the_wiki_title(String expectedTitle) {
       String actualTitle= Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Then("User should see {string} in the main header")
    public void userShouldSeeStringInTheMainHeader(String expectedHeader) {
String actualHeaderText=wiki.mainHeader.getText();
Assert.assertTrue(actualHeaderText.equals(expectedHeader));
    }


    @Then("User should see {string} in the image Header")
    public void userShouldSeeInTheImageHeader(String expectedImage) {
       String actualHeader= wiki.image.getText();
        Assert.assertEquals(actualHeader,expectedImage);
    }
}
