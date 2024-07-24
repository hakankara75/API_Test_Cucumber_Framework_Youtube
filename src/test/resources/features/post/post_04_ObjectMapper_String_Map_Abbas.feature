@objectMapperReqres
Feature: object mapper
  Scenario: object mapper
    Given kullanici https://reqres.in/api/ sitesine gider
    And kullanici register icin post islemi yapar
    Then kullanici register islemi icin gelen response dogrular