package com.bot.frontend.Steps;
import com.bot.frontend.pageobject.Login.LoginPageObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends LoginPageObject {
    /*------------------------------------------------------------------------------------------------------*/
    @Given("^Usuario se encuentra en la Web \"([^\"]*)\"$")
    public void usuarioSeEncuentraEnLaWeb(String casoPrueba) throws Throwable {
        LoginPageObject.ingresoALaUrlDemoblaze(casoPrueba);
        //LoginPageObject.cargarWeb();
    }
    /*------------------------------------------------------------------------------------------------------*/
    @When("^Usuario ingresa usuario y contraseña \"([^\"]*)\"$")
    public void usuarioIngresaUsuarioYContraseña(String credencialesLogin) throws Throwable {
        LoginPageObject.ingresoDatosLogin(credencialesLogin);
    }
    /*------------------------------------------------------------------------------------------------------*/

    @Then("^Usuario da clic en el boton Log in y se verifica acceso$")
    public void usuarioDaClicEnElBotonLogInYSeVerificaAcceso() throws Throwable {
        LoginPageObject.verificarAccesoLogin();
    }




}
