package com.tatf.swaglabs.modules.menuLateral.pom;

import com.tatf.core.browser.IBrowser;

public class MenuLateralPO {
    private final IBrowser browser;
    private final String title = "title";
    private final String btnEmail = "inputEmail";
    private final String btnContrasena = "inputPassword";
    private final String btnNombre = "inputFirstName";
    private final String btnApellido = "inputLastName";
    private final String btnPais = "inputCountry";
    private final String btnRegistro = "btnRegister";
    private final String btnCrearUsuarioTester = "//*[@id=\"cardLogin\"]//*[contains(text(),\"Crear usuario\")]";
    private final String btnConfirmar = "*//button[contains(text(),\"Sí\")]";
    private final String btnVerUsuarios = "//*[@id=\"wrapper\"]/ul/li/div[3]/a/span[contains(text(),\"Ver usuarios\")]";
    private final String mensajeUsuarioCreado = "//*[@id=\"swal2-html-container\" and contains(text(),\"Usuario creado.\")]";
    private final String btnOk = "//*[text()='OK']";
    private final String mensajeUsuarioEliminado = "//*[@id=\"swal2-html-container\" and contains(text(),\"Usuario eliminado.\")]";

    public MenuLateralPO(IBrowser browser) {
        this.browser = browser;
    }

    public String GetTitulo(){
        return this.browser.find().className(title).getText();
    }

    public void ClickCrearUsuarioTester(){
        this.browser.find().xpath(btnCrearUsuarioTester).click();
    }

    public void IngresarNombre(String nombre){
        this.browser.find().name(btnNombre).clear().write(nombre);
    }

    public void IngresarApellido(String apellido){
        this.browser.find().name(btnApellido).clear().write(apellido);
    }

    public void IngresarEmail(String email){
        this.browser.find().name(btnEmail).clear().write(email);
    }

    public void SeleccionarPais(String pais){
        this.browser.find().name(btnPais).selectText(pais);
    }

    public void IngresarContrasena(String contrasena){
        this.browser.find().name(btnContrasena).clear().write(contrasena);
    }

    public void SeleccionarTipoTester(String tipo){
        this.browser.find().id(tipo).click();
    }

    public void ConfirmarCrearUsuario(){
        this.browser.find().id(btnRegistro).click();
    }

    public boolean ConfirmacionUsuarioCreado(){
        return browser.find().xpath(mensajeUsuarioCreado).isDisplayed();
    }

    public void AceptarConfirmacion(){
        this.browser.find().xpath(btnOk).click();
    }

    public void VerUsuarios(){
        this.browser.find().xpath(btnVerUsuarios).click();
    }

    public void EliminarUsuario(String email){
        this.browser.find().id(email).click();
        this.browser.find().xpath(btnConfirmar).click();
    }

    public boolean BuscarUsuario(String email){
        return browser.find().id(email).isDisplayed();
    }

    public boolean ConfirmacionUsuarioEliminado(){
        return browser.find().xpath(mensajeUsuarioEliminado).isDisplayed();
    }

}
