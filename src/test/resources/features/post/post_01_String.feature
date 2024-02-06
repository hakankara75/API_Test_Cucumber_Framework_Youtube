@postString
  Feature: post string
    Scenario: post string
      Given kullanici "https://reqres.in/api/users" sitesine gider
      And post islemi yapar
      Then response dogrulanir