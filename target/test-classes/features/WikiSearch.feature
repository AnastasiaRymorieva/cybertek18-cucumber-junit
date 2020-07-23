@wiki
Feature: Wiki title and search verification

  Background: User is on Wiki home page
    Given User is on the Wikipedia home page



  Scenario: Search functionality title verification
  When User search "Steve Jobs" in the wiki search page
    Then User should see "Steve Jons" in the wiki title


  Scenario: Search functionality Main Header verification
    When User search "Steve Jobs" in the wiki search page
    Then User should see "Steve Jobs" in the main header

  @wikiOutline
  Scenario Outline: Search functionality Main Header verification

    When User search "<search>" in the wiki search page
    * User should see "<expectedTitle>" in the wiki title
    * User should see "<expectedHeader>" in the main header
    * User should see "<expectedImage>" in the image Header

    Examples: example test data for wikipedia search
      | search          | expectedTitle   | expectedHeader  | expectedImage   |
      | Steve Jobs      | Steve Jobs      | Steve Jobs      | Steve Jobs      |
      | Albert Einstein | Albert Einstein | Albert Einstein | Albert Einstein |
      | Vladimir Putin  | Vladimir Putin  | Vladimir Putin  | Vladimir Putin  |