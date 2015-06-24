$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("\u0027acceptance/feature/radioMe.feature\u0027");
formatter.feature({
  "id": "radio-me-module",
  "description": "",
  "name": "Radio Me Module",
  "keyword": "Feature",
  "line": 2
});
formatter.scenario({
  "id": "radio-me-module;tab-description;;2",
  "tags": [
    {
      "name": "@web",
      "line": 39
    }
  ],
  "description": "",
  "name": "Tab description",
  "keyword": "Scenario Outline",
  "line": 47,
  "type": "scenario"
});
formatter.step({
  "name": "I am on Radio me module",
  "keyword": "Given ",
  "line": 41
});
formatter.step({
  "name": "I signed in from benefits page",
  "keyword": "And ",
  "line": 42
});
formatter.step({
  "name": "I click on the \"Programme Updates\" tab",
  "keyword": "And ",
  "line": 43,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "description text \"Newly available episodes (most recent first) of the last 100 programmes you added to your favourites. Removing an item means you’ll stop getting new episodes of that programme here.\" should be displayed at the top",
  "keyword": "Then ",
  "line": 44,
  "matchedColumns": [
    1
  ]
});
formatter.match({
  "location": "radioMe.I_am_on_Radio_me_module()"
});
formatter.result({
  "duration": 7459548000,
  "status": "passed"
});
formatter.match({
  "location": "signIn.I_signed_in_from_benefits_page()"
});
formatter.result({
  "duration": 6033154000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Programme Updates",
      "offset": 16
    }
  ],
  "location": "radioMe.I_click_on_the_tab(String)"
});
formatter.result({
  "duration": 2647570000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Newly available episodes (most recent first) of the last 100 programmes you added to your favourites. Removing an item means you’ll stop getting new episodes of that programme here.",
      "offset": 18
    }
  ],
  "location": "radioMe.description_text_should_be_displayed_at_the_top(String)"
});
formatter.result({
  "duration": 296350000,
  "status": "passed"
});
formatter.scenario({
  "id": "radio-me-module;tab-description;;3",
  "tags": [
    {
      "name": "@web",
      "line": 39
    }
  ],
  "description": "",
  "name": "Tab description",
  "keyword": "Scenario Outline",
  "line": 48,
  "type": "scenario"
});
formatter.step({
  "name": "I am on Radio me module",
  "keyword": "Given ",
  "line": 41
});
formatter.step({
  "name": "I signed in from benefits page",
  "keyword": "And ",
  "line": 42
});
formatter.step({
  "name": "I click on the \"Episodes \u0026 Clips\" tab",
  "keyword": "And ",
  "line": 43,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "description text \"Clips and individual episodes you’ve added to your Favourites. Any newly available episodes of these programmes will appear in Programme Updates.\" should be displayed at the top",
  "keyword": "Then ",
  "line": 44,
  "matchedColumns": [
    1
  ]
});
formatter.match({
  "location": "radioMe.I_am_on_Radio_me_module()"
});
formatter.result({
  "duration": 6453803000,
  "status": "passed"
});
formatter.match({
  "location": "signIn.I_signed_in_from_benefits_page()"
});
formatter.result({
  "duration": 5906377000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Episodes \u0026 Clips",
      "offset": 16
    }
  ],
  "location": "radioMe.I_click_on_the_tab(String)"
});
formatter.result({
  "duration": 25174567000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Clips and individual episodes you’ve added to your Favourites. Any newly available episodes of these programmes will appear in Programme Updates.",
      "offset": 18
    }
  ],
  "location": "radioMe.description_text_should_be_displayed_at_the_top(String)"
});
formatter.result({
  "duration": 293932000,
  "status": "passed"
});
});