package com.bot.frontend.Steps;

import com.bot.frontend.pageobject.Login.HomePrincipalPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class HomePrincipalSteps extends HomePrincipalPageObject {

    /*------------------------------------------------------------------------------------------------------*/
    @And("^Usuario añade un producto al carrito$")
    public void usuarioAñadeUnProductoAlCarrito() throws Throwable {
        agregarProductosCarrito();
    }
    /*------------------------------------------------------------------------------------------------------*/

    @Then("^Usuario valida la suma el precio de los productos con el total de carrito de compras$")
    public void usuarioValidaLaSumaElPrecioDeLosProductosConElTotalDeCarritoDeCompras() throws Exception {
        verificaPrcios();

    }


}
