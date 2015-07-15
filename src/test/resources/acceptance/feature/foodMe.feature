
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
    Then I should be taken to "BBC - Sign in" page
    And PTRT should be set to "/food/my/favourites"

  @automated
  Scenario: Benefits page ID controls
    Given I am on Food me module
    When I click on Register button on benefits page
    Then I should be taken to "BBC - Register" page
    And PTRT should be set to "/food/my/favourites"

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
  And user should have at max 10 per page

@automated
Scenario:C431546 Deletion of recipe
  Given I am a signed in user
  And I am on Food homepage
  And I add recipe to Favourite
  And I am on Food me module
  When I delete item from action panel
  Then item should be removed from me module
  When I go to recipe page
  And item should be removed from favorite

  @automated
Scenario:C172185 Action panel contains 3 dots
  Given I am a signed in user
    And I am on Food homepage
    And I add recipe to Favourite
    And I am on Food me module
  Then action panel will be displayed as 3 vertical dots

    @automated
Scenario: C172186
  Given I am a signed in user
  And I am on Food homepage
  And I add recipe to Favourite
  When I am on Food me module
  Then action panel should contain "Remove?,Yes,No"


