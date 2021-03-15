Feature:  Agregar producto al carrito de compras del portal web Demo Blaze
  @Shopping
  Scenario Outline: Agregar productos carrito
    Given Usuario se encuentra en la Web "<url>"
    When Usuario ingresa usuario y contraseña "<login>"
    And Usuario añade un producto al carrito
    Then Usuario valida la suma el precio de los productos con el total de carrito de compras

    Examples:
      | url | login |
      | 1   | 1     |
