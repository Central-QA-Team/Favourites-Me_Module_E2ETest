
Feature: Adding a brand/episode/clip as a favourite and removing from Me module

  @automated @favourite @radio @meModule @test
  Scenario: Verify a Brand can be added as a Favourite and removed from me module
    Add a brand as a favourite, verify on me module, remove favourite from action panel and Verify on me module,
    verify removal of brand reflects on the status of a button on brand page
    C385958-Metadata for brands having no update available
    and brand tile navigation and available episode pane text and navigation

    Given I am a signed in user
    And I navigate to BBC radio home page
    When I add brand to Favourite
    Then Favourite button should be in added state
    And I can find the brand on radio me module
    And I get me service response from brand
    And I can verify brand metadata as per available episodes
    Then available episode pane should be visible if applicable and point to available episode page
    And clicking on brand tile should take user to respective page
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


  @automated @favourite @radio @MYPROFILE-472
  Scenario: Verify a Episode can be added as a Favourite and removed from me module
  --Add an episode as a favourite, verify on me module, remove favourite from action panel and Verify on me module,
  verify removal of episode reflects on the status of a button on episode page

    Given I am a signed in user
    And I navigate to BBC radio home page
    When I add episode to Favourite
    Then Favourite button should be in added state
    And I can find the episode on radio me module
    And I can verify episode metadata
    And I can remove the episode from Favourites on Radio Me Module
    And I navigate back to episode page
    And favourite button for episode should change to Add state


  @automated @favourite @radio @MYPROFILE-472
  Scenario: verify if adding episode to favourite adds associated brand favourite too

    Given I am a signed in user
    And I navigate to BBC radio home page
    When I add episode to Favourite
    And I navigate to brand page
    Then Favourite button should be in added state
    And I can find the brand on radio me module

  @automated @favourite @radio @MYPROFILE-472
    Scenario: verify I can remove an episode from favourite from episode page but brand remains in favourite
      This scenario is in continuation with above scenario and is dependent on the same.

    Given I am a signed in user
    And I navigate to BBC radio home page
    When I add episode to Favourite
    And I navigate back to episode page
    When I remove episode from Favourite
    Then favourite button for episode should change to Add state
    And I should not find episode on radio me module
    And I navigate to brand page
    And Favourite button should be in added state
    And I can find the brand on radio me module

  @automated @favourite @radio
  Scenario: Verify a clip can be added as a Favourite and removed from me module
  Add a clip as a favourite, verify on me module, remove favourite from action panel and Verify on me module,
  verify removal of clip reflects on the status of a button on clip page

    Given I am a signed in user
    When I add clip to Favourite
    Then Favourite button should be in added state
    And I can find the clip on radio me module
    And I can remove the clip from Favourites on Radio Me Module
    When Navigate back to clip page
    And favourite button for clip should change to Add state


  @automated @favourite @radio
  Scenario: Removing clip from favourite button and verify removal should not affect for brand

    Given I am a signed in user
    When I add clip to Favourite
#    And I navigate to brand page
#    Then favourite button for brand should not change to added state
    And I should not find the brand on radio me module
    And Navigate back to clip page
    When I remove clip from Favourite
    Then favourite button for clip should change to Add state
    And I should not find clip on radio me module

  @meModule @radio @automated
  Scenario: Verify Clip metadata
    Given I am a signed in user
    When I add clip to Favourite
    And I can find the clip on radio me module
    And I request feeds from MeService API for clip
#    Then image should match with feeds
    And name should match with feeds
    And description should match with feeds
    And duration should match with feeds
    And availability should match with feeds
    And publication should match with feeds
    And I can remove the clip from Favourites on Radio Me Module

