@delete
  Feature: delete
    Scenario: delete
      Given urle gidilir
      And expected data olusturulur
      When request ve response yapilir
      Then delete response dogrulanir