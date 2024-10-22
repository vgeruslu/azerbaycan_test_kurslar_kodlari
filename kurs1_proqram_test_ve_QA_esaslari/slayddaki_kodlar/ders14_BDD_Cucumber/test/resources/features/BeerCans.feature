# language: en
Feature: Beer cans

  Scenario: Counting beer cans
    Given I have <opening balance> beer cans
    And I have drunk <processed> beer cans
    When I go to my fridge
    Then I should have <in stock> beer cans