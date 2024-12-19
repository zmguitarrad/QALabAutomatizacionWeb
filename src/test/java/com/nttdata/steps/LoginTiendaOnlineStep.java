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

    public void finalizarCompra() {
        WebElement boton = driver.findElement(LoginTiendapage.enviarButton);
        boton.click();

    }

    public void finalizarCompraTotal() {
        WebElement boton = driver.findElement(LoginTiendapage.finalizarcompraButton);
        boton.click();
    }

    public void validarTitulo() {
        WebElement botontitulo = driver.findElement(LoginTiendapage.validarTituloTexto);
        botontitulo.click();

    }

    public void validarPrecioTotal() {
        WebElement boton = driver.findElement(LoginTiendapage.ValidarPrecioTotalButton);
        boton.click();
    }

    public void validarError(String mensaje) {
        String tituloActual = driver.getTitle();
        Assert.assertEquals(
                tituloActual,
                mensaje,
                "Error: Error de autentificación."
        );
    }



    public void validarcategoria(String mensajeEsperado) {
        String tituloActual = driver.getTitle();
        Assert.assertEquals(
                tituloActual,
                mensajeEsperado,
                "Error: El título no coincide con el mensaje esperado."
        );
    }
}
