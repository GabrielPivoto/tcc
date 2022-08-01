Feature: Login com Page Object Pattern

    Testar diferentes logins na página Sauce Demo utilizando o padrão Page Object

Background: Acessar o site Sauce Demo
    Given que a página Sauce Demo foi acessada

Scenario: Login como Standard User
    When o usuário "standard_user" é digitado
    And a senha "secret_sauce" é digitada
    And o botão LOGIN é pressionado
    Then a "Sauce Labs Backpack" deve estar disponível

Scenario: Login como Locked Out User
    When o usuário "locked_out_user" é digitado
    And a senha "secret_sauce" é digitada
    And o botão LOGIN é pressionado
    Then a mensagem "Epic sadface: Sorry, this user has been locked out." deve ser apresentada

Scenario: Login como Problem User
    When o usuário "problem_user" é digitado
    And a senha "secret_sauce" é digitada
    And o botão LOGIN é pressionado
    Then as imagens de cachorro devem ser apresentadas

Scenario: Login como Performance Glitch User
    When o usuário "performance_glitch_user" é digitado
    And a senha "secret_sauce" é digitada
    And o botão LOGIN é pressionado
    Then a "Sauce Labs Backpack" deve estar disponível