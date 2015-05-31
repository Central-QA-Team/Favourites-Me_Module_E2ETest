@web
Feature: Testing Web client

  Scenario: Test BBC news page
  Given The user is on BBC website
  When he clicks on News link
  Then I should be able to see Home link