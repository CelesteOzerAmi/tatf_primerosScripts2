package com.tatf.swaglabs.modules.registro.pom;

import com.tatf.core.browser.IBrowser;
import com.tatf.swaglabs.modules.registro.data.RegistroData;

public class RegistroPO {

    private final IBrowser browser;

    private final String btnRegistrarse = "//*[@id=\"cardLogin\"]//*[text()=\"Registrarse\"]";
    private final String btnEmail = "inputEmail";
    private final String btnContrasena = "inputPassword";
    private final String btnNombre = "inputFirstName";
    private final String btnApellido = "inputLastName";
    private final String btnConfirmarContra = "inputRepeatPassword";
    private final String btnPais = "inputCountry";
    private final String btnRegister = "btnRegister";
    private final String okButton = "//*[text()='OK']";
    private final String confirmacion = "//*[text()='Usuario creado.']";

    public RegistroPO(IBrowser browser) {
        this.browser = browser;
    }

    public void ClickRegistrarse(){
        this.browser.find().xpath(btnRegistrarse).click();
    }

    public String getTitle(String title) {
        return this.browser.find().className(title).getText();
    }

    public void IngresarNombre(String nombre) {
        this.browser.find().name(btnNombre).write(nombre);
    }

    public void IngresarApellido(String apellido) {
        this.browser.find().name(btnApellido).write(apellido);
    }

    public void IngresarEmail(String email) {
        this.browser.find().name(btnEmail).clear().write(email);
    }

    public void IngresarPassword(String password) {
        this.browser.find().name(btnContrasena).write(password);
    }

    public void ConfirmarPassword(String password) {
        this.browser.find().name(btnConfirmarContra).write(password);
    }

    public void IngresarPais(String pais) {
        this.browser.find().name(btnPais).write(pais);
    }

    public void ClickRegister() {
        this.browser.find().id(btnRegister).click();
    }

    public boolean VerificarConfirmacion(){
        return browser.find().xpath(confirmacion).isDisplayed();
    }

    public void AceptarConfirmacion(){
        this.browser.find().xpath(okButton).click();
    }

}
