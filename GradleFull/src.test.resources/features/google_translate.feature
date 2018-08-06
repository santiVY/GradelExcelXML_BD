
Feature: Facebook
  As a web user
  I want to use Facebook
  to search a lot of friends

  @tag1
  Scenario: Search Friends in BD on Facebook
    Given that juanita opened her browser at facebook home page
    When inicia sesion en facebook Email y password
    When busca los nombres contenidos en el archivo excel
    #Then deberia ver el titulo del amigo buscado

  
