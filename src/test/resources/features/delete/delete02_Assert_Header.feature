@assertHeader
  Feature: header
    Scenario: header
      Given fakerestapi icin url olusturulur
      And fakerestapi icin expected data olusturulur
      When fakerestapi icin request ve response yapilir
      Then fakerestapi icin response dogrulanir
