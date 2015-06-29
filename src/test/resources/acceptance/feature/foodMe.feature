@automated
Feature: Food Me Module

Scenario: Favourite page title
  Given I am on Food me module
  And Food page should have title "BBC Food"


Scenario: Benefits page
  Given I am on Food me module
  Then Food benefits page should have "Save stuff for later.,Get the latest updates.,All on any device."
  And Benefits page should have ID CTA with text "Sign inwith your BBC iD,or Register to Add to Your Favourites"


Scenario: Empty page
  Given I am on Food me module
  And I signed in from benefits page as a new user
  Then Food empty page should have desired image on it
  And Food empty page should have first line "You have no Food favourites yet."
  And Food empty page should have second line "Start adding things wherever you see the ."
  And Food empty page should have second line appended with favourite button image
  And Food empty page should have third line "Get started on Recipes Index."
  And Link Recipe index page should point to recipe page.
