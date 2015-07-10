
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
  And user should have at max 10 recipes per page

#@wip
#Scenario:Deletion of recipe
#  Given Given I am on Food homepage
#  And I sign in from barlesque menu
#  And I find a recipe
#  And I add recipe to Favourite
#  And I am on Food me module
#  When I click on action panel of any item
#  And I confirm a deletion
#  Then item should be removed from me module
#  And change should also reflect on 'add' button for that item"