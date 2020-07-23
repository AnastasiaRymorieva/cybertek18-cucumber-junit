Feature: Etsy search feature
  Agile story: User should be able to enter search terms and see relevant results in the page and in title

  Background:User is on the etsy home page
    Given User is on etsy home page


  Scenario: Title Verification
    Then User should sees title is as expected

    #expected: Etsy -Shop for handmade, vintage, custom, and unique gifts for everyone
  @etsyWip
  Scenario: Title verification after search term
    When User searches wooden spoon in the search box
    And User clicks to the search button
    Then User should see "Wooden spoon" int etsy title