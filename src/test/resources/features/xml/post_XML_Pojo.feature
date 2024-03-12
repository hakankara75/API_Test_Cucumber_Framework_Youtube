@xmlPost
  Feature: xmlPost
    Scenario: xmlPost
      Given petstore url girilir
      And expected pet olusturulur
      And petster urle request gonderilir ve response alinir
      Then petden gelen response dogrulanir