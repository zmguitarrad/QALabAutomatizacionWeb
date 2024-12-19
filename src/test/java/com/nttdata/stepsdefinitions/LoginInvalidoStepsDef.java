package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginTiendaOnlineStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;
import java.time.Duration;

public class LoginInvalidoStepsDef {
    private WebDriver driver;
    LoginTiendaOnlineStep tiendastep;
    WebDriverWait wait;

    private LoginTiendaOnlineStep inventorySteps(WebDriver driver) {
        return new LoginTiendaOnlineStep(driver);
    }

// Scenario: Login con un usuario invalido
    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/");
        screenShot();
    }

    @When("ingreso mi usuario {string} y clave {string}")
    public void ingresoMiUsuarioYClave(String usuario, String clave) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.clickIniciosesion();
        tiendastep.ingresarUsuario(usuario);
        tiendastep.typePassword(clave);
        tiendastep.buttonIniciar();

        screenShot();

    }

    @Then("muestra un mensaje de error {string}")
    public void muestraUnMensajeDeError(String mensaje) {
        tiendastep.validarError(mensaje);

    }

    @And("busco la categoria {string}")
    public void buscoLaCategoria(String categoria) {
       tiendastep.validarcategoria(categoria);
    }
}
