package com.cybertek.step_definition;

import io.cucumber.java.en.Then;

import java.util.List;

public class DataTableStepDefinition {


    @Then("User should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> fruitList) {

        System.out.println("fruitList.size() = "+fruitList.size());
        System.out.println(fruitList);
    }

}
