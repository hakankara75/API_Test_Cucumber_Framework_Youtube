@postTMap
Feature: post map
  Scenario: post map
    Given kullanici jsonplaceholder sitesine gider
    And jsonplaceholder sitesinde post islemi yapar
    Then jsonplaceholder sitesinden gelen response dogrulanir