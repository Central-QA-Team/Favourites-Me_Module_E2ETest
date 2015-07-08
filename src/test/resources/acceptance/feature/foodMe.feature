
Feature: Food Me Module

 @automated
Scenario: Favourite page title
  Given I am on Food me module
  And Food page should have title "BBC Food"

 @automated
Scenario: Benefits page
  Given I am on Food me module
  Then Food benefits page should have "Save stuff for later.,Get the latest updates.,All on any device."
  And Benefits page should have ID CTA with text "Sign inwith your BBC iD,or Register to Add to Your Favourites"

@automated
  Scenario: Benefits page ID controls
    Given I am on Food me module
    When I click on Sign In button on benefits page
    Then User should be taken to sign in page
    And PTRT should be set to food me module

  @automated
  Scenario: Benefits page ID controls
    Given I am on Food me module
    When I click on Register button on benefits page
    Then User should be taken to register page
    And PTRT should be set to food me module

  @automated
Scenario: Empty page
  Given I am on Food me module
  And I signed in from benefits page as a new user
  Then Food empty page should have desired image on it
  And Food empty page should have first line "You have no Food favourites yet."
  And Food empty page should have second line "Start adding things wherever you see the ."
  And Food empty page should have second line appended with favourite button image
  And Food empty page should have third line "Get started on Recipes Index."
  And Link Recipe index page should point to recipe page.

  @automated
Scenario: Tile navigation for recipe
   Given I am on Food me module
   And I signed in from benefits page as a normal user
   Then clicking on tile should take user to respective recipe page

  @automated
Scenario: Number of recipe per page
  Given I am on Food me module
  And I signed in from benefits page as a normal user
  And user should have at max 10 recipes per page