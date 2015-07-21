
Feature: Adding a Food recipe as a favourite and removing from Me module

  @automated @favourite @radio1
  Scenario: Verify a Brand can be added as a Favourite
    Given I am a signed in user
      And I navigate to BBC radio home page
    When I add brand to Favourite
    Then Add button should change to remove state
      And I can find  the brand on radio me module
      And I can remove the brand from Favourites on Radio Me Module

  @automated @favourite @food
  Scenario: C171570-Removing item from favourites
    Given I am a signed in user
    And I navigate to BBC food home page
    And I find a recipe
    When I remove recipe from Favourite
    Then item should be removed from favorite
    And button should change to Add state


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

