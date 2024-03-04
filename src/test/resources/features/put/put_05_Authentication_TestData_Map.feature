@authentication
  Feature: Authentication
    Scenario: Authentication
      Given heroku icin url olusturulur
      And heroku icin expected olusturulur
      And request gonderilir response alinir
      Then heroku icin response dogrulanir