@petXMLPost
  Feature: petXMLPost
    Scenario: petXMLPost
      Given petstore urle gidilir
      And xml icin expected data olusturulur
      And xml icin request gonderilir ve response alinir
      Then xml body dogrulanir