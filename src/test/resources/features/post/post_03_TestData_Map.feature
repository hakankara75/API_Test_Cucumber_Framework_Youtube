@postTestData
Feature: post map
  Scenario: post map
    Given kullanici herokuapp sitesine gider
    And herokuapp sitesinde post islemi yapar
    Then herokuapp sitesinden gelen response dogrulanir