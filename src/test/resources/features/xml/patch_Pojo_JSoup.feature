@patchJSoup
  Feature: patch
    Scenario: patch
  Given patch icin herokuapp urle gidilir
      And patch icin expected data olusturulur
      And patch icin request gonderilir response alinir
      Then patch icin dogrulama yapilir

