#@automated
Feature: Adding a Food recipe as a favourite

  Scenario: Verify a a recipe can be added as favourite
    Given I am signed in on Food homepage
    And I find a recipe to add to his favourite
    When I click on Favourite button
    Then the status of the button changes to Added to Favourites
    And I can find the recipe on food me module