@automated
Feature: Adding a Food recipe as a favourite

  Scenario: Verify a a recipe can be added as favourite
    C172579,C171569: Verify Mouse hover on added state, it's assumed JS is ON
    Given I am on Food homepage
      And I sign in from barlesque menu
      And I find a recipe
    When I click on Favourite button
      And I hover the mouse pointer on favorite button
    Then button label should change from added state to remove state
      And the status of the button changes to Added to Favourites
      And I can find  the recipe on food me module

  Scenario: Removing item from favourites
  C171570, dependent on above scenario
    Given I am on Food homepage
      And I sign in from barlesque menu
      And I find a recipe
    When I click on Favourite button
    Then item should be removed from favorite
      And button should change to Add state
