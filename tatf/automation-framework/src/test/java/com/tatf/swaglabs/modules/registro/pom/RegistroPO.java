package com.tatf.swaglabs.modules.registro.pom;

import com.tatf.core.browser.IBrowser;
import com.tatf.swaglabs.modules.registro.data.RegistroData;

public class RegistroPO {

    private final IBrowser browser;

    private final String btnRegistrarse = "//*[@id=\"wrapper\"]/ul/li/div[2]/a/span[text()=\"Registrarse\"]";
    private final String btnEmail = "inputEmail";
    private final String btnContrasena = "inputPassword";
    private final String btnNombre = "inputFirstName";
    private final String btnApellido = "inputLastName";
    private final String btnConfirmarContra = "inputRepeatPassword";
    private final String btnPais = "inputCountry";
    private final String btnRegister = "btnRegister";
    private final String okButton = "//*[text()='OK']";

    public RegistroPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickRegistrarse(){
        this.browser.find().xpath(btnRegistrarse).click();
    }

    public String getTitle(String title) {
        return this.browser.find().className(title).getText();
    }

    public void ingresarNombre(String nombre) {
        this.browser.find().name(btnNombre).write(nombre);
    }

    public void ingresarApellido(String apellido) {
        this.browser.find().name(btnApellido).write(apellido);
    }

    public void ingresarEmail(String email) {
        this.browser.find().name(btnEmail).clear().write(email);
    }

    public void ingresarPassword(String password) {
        this.browser.find().name(btnContrasena).write(password);
    }

    public void confirmarPassword(String password) {
        this.browser.find().name(btnConfirmarContra).write(password);
    }

    public void ingresarPais(String pais) {
        this.browser.find().name(btnPais).write(pais);
    }

    public void clickRegister() {
        this.browser.find().id(btnRegister).click();
    }

    public void verifyConfirm(){
        browser.find().xpath(RegistroData.confirmacion).isDisplayed();
    }

    public void clickConfirm(){
        this.browser.find().xpath(okButton).click();
    }

}
