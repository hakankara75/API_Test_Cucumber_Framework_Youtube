@mapObjectMapper
  Feature: patch
    Scenario: patch reqres
      Given reqres api urle gidilir
      And reqres expecpected data olusturulur
      And reqres request gonderilir ve response alinir
      Then reqres json body dogrulanir