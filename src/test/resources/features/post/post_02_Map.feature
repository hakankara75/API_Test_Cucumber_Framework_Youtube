@postMap
Feature: post map
  Scenario: post map
    Given kullanici https://jsonplaceholder.typicode.com/todos sitesine gider
    And jsonplaceholder sitesinde post islemi yapar
    Then jsonplaceholder sitesinden gelen response dogrulanir