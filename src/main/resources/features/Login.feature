Feature: Login Demoblaze


  @Login
  Scenario Outline: Log in Demoblaze
    Given Usuario se encuentra en la Web "<url>"
    When Usuario ingresa usuario y contraseña "<login>"
    Then Usuario da clic en el boton Log in y se verifica acceso

    Examples:
      | url | login |
      | 1   | 1     |
