@automated
Feature: Adding a Food recipe as a favourite

  Scenario: C172579-Verify a a recipe can be added as favourite
    C171569-Verify Mouse hover on added state, it's assumed JS is ON
    Given I am on Food homepage
      And I sign in from barlesque menu
      And I find a recipe
    When I add recipe to Favourite
      And I hover the mouse pointer on favorite button
    Then button label should change from added state to remove state
      And the status of the button changes to Added to Favourites
      And I can find  the recipe on food me module

  Scenario: C171570-Removing item from favourites
    Given I am on Food homepage
      And I sign in from barlesque menu
      And I find a recipe
    When I remove recipe from Favourite
    Then item should be removed from favorite
      And button should change to Add state

  Scenario: C171285-Verify sign in from page

    Given I am on Food homepage
      And I find a recipe
      And I add recipe to Favourite
    When I sign in from idCTA
    Then the status of the button changes to Added to Favourites
      And I remove recipe from Favourite
    #Last step is just cleanup step