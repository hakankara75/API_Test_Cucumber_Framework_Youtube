@patch
Feature: patch
  Scenario: patch
    Given kullanici jsonplaceholder sitesine gider
    And herokuapp sitesinde patch islemi yapar
    Then pattch den gelen response dogrulanir