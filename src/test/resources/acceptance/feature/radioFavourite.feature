
Feature: Adding a brand/episode/clip as a favourite and removing from Me module

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

  @automated @favourite @radio
  Scenario: Verify a clip can be added as a Favourite and removed from me module
  Add a clip as a favourite, verify on me module, remove favourite from action panel and Verify on me module,
  verify removal of clip reflects on the status of a button on clip page

    Given I am a signed in user
    And I navigate to BBC radio home page
    When I add clip to Favourite
    Then favourite button for clip should change to added state
    And I can find the clip on radio me module
    And I can remove the clip from Favourites on Radio Me Module
    When Navigate back to clip page
    And favourite button for clip should change to Add state


  @automated @favourite @radio
  Scenario: Removing clip from favourite button and verify removal should not affect for brand

    Given I am a signed in user
    And I navigate to BBC radio home page
    When I add clip to Favourite
#    And I navigate to brand page
#    Then favourite button for brand should not change to added state
    And I should not find the brand on radio me module
    And Navigate back to clip page
    When I remove clip from Favourite
    Then favourite button for clip should change to Add state
    And I should not find clip on radio me module
