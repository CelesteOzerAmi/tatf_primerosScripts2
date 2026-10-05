package com.tatf.swaglabs.modules.login.pom;

import com.tatf.core.browser.IBrowser;
import com.tatf.swaglabs.modules.login.data.LoginData;

public class LoginPO {
    private final IBrowser browser;
    private final String iniciarSesionbtn = "//*[@id=\"cardLogin\"]//*[contains(text(),\"Iniciar sesión\")]";
    private final String title = "login";
    private final String btnEmail = "inputEmail";
    private final String btnContrasena = "inputPassword";
    private final String loginButton = "//*[@id=\"formLogin\"]//button[contains(text(),\"Iniciar Sesión\")]";
    private final String confirmationButton = "//*[@id=\"swal2-html-container\" and contains(text(),\"Sesión iniciada\")]";
    private final String okButton = "//*[text()='OK']";

    public LoginPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickIniciarSesion(){
        this.browser.find().xpath(iniciarSesionbtn).click();
    }

    public String getTitle() {
        return this.browser.find().className(title).getText();
    }

    public void ingresarEmail(String email) {
        this.browser.find().name(btnEmail).clear().write(email);
    }

    public void ingresarPassword(String password) {
        this.browser.find().name(btnContrasena).write(password);
    }

    public void clickLogin() {
        this.browser.find().xpath(loginButton).click();
    }

    public boolean VerificarConfirmacion(){
        return browser.find().xpath(confirmationButton).isDisplayed();
    }

    public void AceptarConfirmacion(){
        this.browser.find().xpath(okButton).click();
    }

    public boolean getUsuarioLogueado(String nombreUsuario) {
        return this.browser.find().xpath(String.format("//a[contains(normalize-space(), '%s')]", nombreUsuario)).isDisplayed();
    }
}
