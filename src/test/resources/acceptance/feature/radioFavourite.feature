
Feature: Adding a Food recipe as a favourite and removing from Me module

  @automated @favourite @radio
  Scenario: Verify a Brand can be added as a Favourite and removed from me module
    Add a brand as a favourite, verify on me module, remove favourite from action panel and Verify on me module,
    verify removal of brand reflects on the status of a button on brand page
    Given I am a signed in user
      And I navigate to BBC radio home page
    When I add brand to Favourite
    Then Add button should change to added state
      And I can find the brand on radio me module
      And I can remove the brand from Favourites on Radio Me Module
   When Navigate back to Brand page
      And brand button should change to Add state


  @automated @favourite @radio
  Scenario: C171570-Removing item from favourite button and verify removal reflects on me module
    Given I am a signed in user
      And I navigate to BBC radio home page
    When I remove brand from Favourite
    Then item should be removed from favorite
      And brand button should change to Add state
      And I should not find the brand on radio me module

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

