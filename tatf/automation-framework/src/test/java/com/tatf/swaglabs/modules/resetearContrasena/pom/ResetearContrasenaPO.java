package com.tatf.swaglabs.modules.resetearContrasena.pom;

import com.tatf.core.browser.IBrowser;

public class ResetearContrasenaPO {
    private final IBrowser browser;

    private final String btnReiniciarContrasena = "//*[@id=\"cardLogin\"]//*[contains(text(),\"Reiniciar contraseña\")]";
    private final String btnEmail = "inputEmail";
    private final String btnContrasena = "inputPassword";
    private final String btnConfirmarContra = "inputRepeatPassword";
    private final String mensajeConfirmacion = "//*[@id=\"swal2-html-container\" and contains(text(),\"Contraseña reiniciada.\")]";
    private final String okButton = "//*[text()='OK']";

    public ResetearContrasenaPO(IBrowser browser) {
        this.browser = browser;
    }

    public void ClickResetear(){
        browser.find().xpath(btnReiniciarContrasena)
                .click();
    }

    public void IngresarEmail(String email){
        browser.find().name(btnEmail).clear().write(email);
    }

    public void IngresarNuevaContrasena(String nuevaContrasena){
        browser.find().name(btnContrasena).clear().write(nuevaContrasena);
        browser.find().name(btnConfirmarContra).clear().write(nuevaContrasena);
    }

    public void EjecutarCambio(){
        browser.find().id("btnReset").click();
    }

    public boolean Confirmacion(){
        return this.browser.find().xpath(mensajeConfirmacion).isDisplayed();
    }

    public void AceptarConfirmacion(){
        this.browser.find().xpath(okButton).click();
    }
}
