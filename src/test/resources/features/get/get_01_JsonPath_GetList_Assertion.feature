@get
  Feature: get JsonPath
    Scenario: get JsonPath
      Given jsonplaceholder sitesinde gidilir
      And get yapilir
      Then body assert edilir
