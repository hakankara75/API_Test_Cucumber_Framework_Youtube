@patchHeroku
  Feature: patch
    Scenario: patch
      Given heroku url olusturulur
      And expected data olusur
      When request gonderilir ve response alinir
      Then body dogrulanir