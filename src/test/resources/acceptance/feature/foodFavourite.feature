
Feature: Adding a Food recipe as a favourite

  @automated @favourite @food @meModule
  Scenario: C172579,C431534,-Verify a a recipe can be added as favourite
    C171569-Verify Mouse hover on added state, it's assumed JS is ON
    Given I am a signed in user
    And I navigate to BBC food home page
    When I add recipe to Favourite
    And I hover the mouse pointer on favorite button
    Then button label should change from added state to remove state
    And the status of the button changes to Added to Favourites
    And I can find  the recipe on food me module

  @automated @favourite @food @meModule
  Scenario: C171570-Removing item from favourites
    Given I am a signed in user
    And I navigate to BBC food home page
    And I find a recipe
    When I remove recipe from Favourite
    Then button should change to Add state
    And the recipe should not be found food me module



  @automated @favourite @food
  Scenario: C171285-Verify sign in from page
    when browser window is not at full screen
    Given I navigate to BBC food home page
    And I add recipe to Favourite
    And I resize browser window to width "800" and height "600"
    When I sign in from idCTA
    Then the status of the button changes to Added to Favourites
    And I remove recipe from Favourite
    #Last step is just a cleanup step


  @automated @favourite @food
  Scenario: C171286-Verify sign in from overlay
    Given I navigate to BBC food home page
    And I add recipe to Favourite
    When I sign in from idCTA
    Then the status of the button changes to Added to Favourites
    And I remove recipe from Favourite
    #Last step is just a cleanup step

  @automated @favourite @food
  Scenario: C171288-Verify register from page
    Given I navigate to BBC food home page
    And I find a recipe
    And I add recipe to Favourite
    When I click on register from idICTA
    Then I should be taken to "BBC - Register" page
    And PTRT should be set to "/food/recipes/"

