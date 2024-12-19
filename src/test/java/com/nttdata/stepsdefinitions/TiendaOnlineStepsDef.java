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
        screenShot();
        tiendastep.buttonIniciar();

    }


    @When("navego a la categoria {string} y subcategoria {string}")
    public void navego_a_la_categoria_y_subcategoria(String categoria, String subcategoria) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.escogerCategoria(categoria);
        tiendastep.escogerSubcategoria(subcategoria);
        screenShot();
        tiendastep.elegirElemento();

    }
//se pudo solucionar utilizando Thread.sleep (aunque no es permitido)
    @And("agrego {int} unidades del primer producto al carrito")
    public void agrego_unidades_del_primer_producto_al_carrito(int elemento) throws InterruptedException{
        tiendastep = new LoginTiendaOnlineStep(driver);
        tiendastep.anadirelemento(elemento);
        screenShot();
        tiendastep.comprarElem();
        Thread.sleep(1000);


    }

    @Then("valido en el popup la confirmacion del producto agregado")
    public void valido_en_el_popup_la_confirmacion_del_producto_agregado() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        screenShot();
        tiendastep.finalizarCompra();

    }

    @When("finalizo la compra")
    public void finalizo_la_compra() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        screenShot();
        tiendastep.finalizarCompraTotal();


    }

    @Then("valido el titulo de la pagina del carrito")
    public void valido_el_titulo_de_la_pagina_del_carrito() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        tiendastep.validarTitulo();
        screenShot();


    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvo_a_validar_el_calculo_de_precios_en_el_carrito() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        tiendastep.validarPrecioTotal();
        screenShot();

    }




}
