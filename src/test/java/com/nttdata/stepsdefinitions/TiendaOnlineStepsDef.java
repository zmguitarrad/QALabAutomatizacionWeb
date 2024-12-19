package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginTiendaOnlineStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class TiendaOnlineStepsDef {
    private WebDriver driver;
    LoginTiendaOnlineStep tiendastep;
    WebDriverWait wait;

    private LoginTiendaOnlineStep inventorySteps(WebDriver driver) {
        return new LoginTiendaOnlineStep(driver);
    }


    @Given("estoy en la pagina de la tienda")
    public void estoy_en_la_pagina_de_la_tienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void me_logueo_con_mi_usuario_y_clave(String usuario, String clave) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.clickIniciosesion();
        tiendastep.ingresarUsuario(usuario);
        tiendastep.typePassword(clave);
        tiendastep.buttonIniciar();

        screenShot();
    }


    @When("navego a la categoria {string} y subcategoria {string}")
    public void navego_a_la_categoria_y_subcategoria(String categoria, String subcategoria) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.escogerCategoria(categoria);
        tiendastep.escogerSubcategoria(subcategoria);
        tiendastep.elegirElemento();
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agrego_unidades_del_primer_producto_al_carrito(int elemento) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.anadirelemento(elemento);
        screenShot();

    }

    @Then("valido en el popup la confirmacion del producto agregado")
    public void valido_en_el_popup_la_confirmacion_del_producto_agregado() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        tiendastep.comprarElem();

        screenShot();
    }

//    @When("finalizo la compra")
//    public void finalizo_la_compra() {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        tiendastep.finalizarCompra();
//        screenShot();
//
//    }

    @Then("valido el titulo de la pagina del carrito")
    public void valido_el_titulo_de_la_pagina_del_carrito() {

    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvo_a_validar_el_calculo_de_precios_en_el_carrito() {

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


    //Scenario usurio y clave correctos y categoria incorrecta
    @And("busco la categoria {string}")
    public void buscoLaCategoria(String categoria) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.escogerCategoriaAuto(categoria);
        screenShot();
    }

}
