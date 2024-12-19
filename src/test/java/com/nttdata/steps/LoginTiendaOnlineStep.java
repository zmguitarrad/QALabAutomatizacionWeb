package com.nttdata.steps;

import com.nttdata.page.LoginTiendapage;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTiendaOnlineStep {
    WebDriver driver;
    public LoginTiendaOnlineStep(WebDriver driver){

        this.driver = driver;
        WebElement usuario;
    }
    public void ingresarUsuario(String usuario) {
        WebElement usuarioInput1 = driver.findElement(LoginTiendapage.userInput);
        usuarioInput1.sendKeys(usuario);
    }

    public void clickIniciosesion() {
        WebElement boton = driver.findElement(LoginTiendapage.iniciarSesion);
        boton.click();
    }
    public void typePassword(String clave) {
        WebElement usuarioInput1 = driver.findElement(LoginTiendapage.passInput);
        usuarioInput1.sendKeys(clave);
    }

    public void buttonIniciar() {
        WebElement boton = driver.findElement(LoginTiendapage.loginButton);
        boton.click();
    }

    public void escogerCategoria(String categoria) {
        WebElement categoriaInput = driver.findElement(LoginTiendapage.categoriaButton);
        categoriaInput.sendKeys(categoria);
        categoriaInput.click();
    }

    public void escogerSubcategoria(String subcategoria) {
        WebElement subcategoriaInput = driver.findElement(LoginTiendapage.subcategoriaButton);
        subcategoriaInput.sendKeys(subcategoria);
        subcategoriaInput.click();

    }

    public void elegirElemento() {
        WebElement botonElemento = driver.findElement(LoginTiendapage.clicElemento);
        botonElemento.click();
    }

    public void anadirelemento(int elemento) {
        WebElement addEle = driver.findElement(LoginTiendapage.addElemto);
        addEle.sendKeys(Keys.CONTROL + "a");
        addEle.sendKeys(Keys.BACK_SPACE);
        addEle.sendKeys(String.valueOf(elemento));
    }


    public void comprarElem() {
        WebElement boton = driver.findElement(LoginTiendapage.agregarCarrito);
        boton.click();
    }

//    public void confirmarValor() {
//        WebElement boton = driver.findElement(LoginTiendapage.validar);
//        boton.click();
//
//    }


    public void finalizarCompra() {
        WebElement boton = driver.findElement(LoginTiendapage.enviarButton);
        boton.click();

    }

//Scenario Usaurio y cntraseña invalido
    public void validarError(String mensaje) {
        Assert.assertTrue(driver.getTitle().contains("Error de autenticación."));



    }


    //Scenario usurio y clave correctos y categoria incorrecta
    public void escogerCategoriaAuto(String categoria) {
        Assert.assertTrue(driver.getTitle().contains("Auto"));

    }

}
