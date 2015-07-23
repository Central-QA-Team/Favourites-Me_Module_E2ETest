
Feature: Adding a Food recipe as a favourite and removing from Me module

  @automated @favourite @radio @meModule
  Scenario: Verify a Brand can be added as a Favourite and removed from me module
    Add a brand as a favourite, verify on me module, remove favourite from action panel and Verify on me module,
    verify removal of brand reflects on the status of a button on brand page
    Given I am a signed in user
      And I navigate to BBC radio home page
    When I add brand to Favourite
    Then Add button should change to added state
      And I can find the brand on radio me module
      And I can remove the brand from Favourites on Radio Me Module
   When I navigate to brand page
      And brand button should change to Add state


  @automated @favourite @radio @meModule
  Scenario: C171570-Removing item from favourite button and verify removal reflects on me module
    Given I am a signed in user
      And I navigate to BBC radio home page
    When I remove brand from Favourite
     Then brand button should change to Add state
      And I should not find the brand on radio me module

  @automated @favourite @radio
  Scenario: Verify a Episode can be added as a Favourite and removed from me module
  Add an episode as a favourite, verify on me module, remove favourite from action panel and Verify on me module,
  verify removal of episode reflects on the status of a button on episode page

    Given I am a signed in user
      And I navigate to BBC radio home page
    When I add episode to Favourite
    Then favourite button for episode should change to added state
      And I can find the episode on radio me module
      And I can remove the episode from Favourites on Radio Me Module
      And I navigate to brand page
      And favourite button for episode should change to Add state
    #Last line failing even though strings are equal


  @automated @favourite @radio @current
  Scenario: Removing episode from favourite button and verify removal should not affect for brand

    Given I am a signed in user
      And I navigate to BBC radio home page
      And I add episode to Favourite
      And I navigate to brand page
      And status of brand favourite button should be added
      And I can find the brand on radio me module
      And I navigate back to episode page
    When I remove episode from Favourite
    Then favourite button for episode should change to Add state
    And I should not find episode on radio me module
    And I navigate to brand page
    Then status of brand favourite button should be added
    And I can find the brand on radio me module

#
#  @automated @favourite @food
#  Scenario: C171285-Verify sign in from page
#  when browser window is not at full screen
#    Given I navigate to BBC food home page
#      And I add recipe to Favourite
#      And I resize browser window to width "800" and height "600"
#    When I sign in from idCTA
#    Then the status of the button changes to Added to Favourites
#      And I remove recipe from Favourite
#    #Last step is just a cleanup step
#
#
#  @automated @favourite @food
#  Scenario: C171286-Verify sign in from overlay
#    Given I navigate to BBC food home page
#      And I add recipe to Favourite
#    When I sign in from idCTA
#    Then the status of the button changes to Added to Favourites
#      And I remove recipe from Favourite
#    #Last step is just a cleanup step
#
#  @automated @favourite @food
#  Scenario: C171288-Verify register from page
#    Given I navigate to BBC food home page
#      And I find a recipe
#      And I add recipe to Favourite
#    When I click on register from idICTA
#    Then I should be taken to "BBC - Register" page
#      And PTRT should be set to "/food/recipes/"

