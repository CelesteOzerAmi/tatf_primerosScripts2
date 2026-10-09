package com.tatf.swaglabs.modules.eliminarUsuario.pom;

import com.tatf.core.browser.IBrowser;

public class EliminarUsuarioPO {
    private final IBrowser browser;
    private final String btnConfirmar = "*//button[contains(text(),\"Sí\")]";
    private final String btnVerUsuarios = "//*[@id=\"cardLogin\"]//*[contains(text(),\"Ver usuarios\")]";
    private final String mensajeUsuarioEliminado = "//*[@id=\"swal2-html-container\" and contains(text(),\"Usuario eliminado.\")]";
    private final String btnOk = "//*[text()='OK']";


    public EliminarUsuarioPO(IBrowser browser) {
        this.browser = browser;
    }

    public void VerUsuarios(){
        this.browser.find().xpath(btnVerUsuarios).click();
    }

    public void EliminarUsuario(String email){
        this.browser.find().id(email).click();
        this.browser.find().xpath(btnConfirmar).click();
    }

    public boolean EncontrarUsuario(String testerEmail){
        return this.browser.find().xpathList(String.format("//*[@id=\"bodyTable\"]/*/td[contains(text(),'%s')]", testerEmail)).isEmpty();
    }

    public boolean ConfirmacionUsuarioEliminado(){
        return browser.find().xpath(mensajeUsuarioEliminado).isDisplayed();
    }

    public void AceptarConfirmacion(){
        this.browser.find().xpath(btnOk).click();
    }
}
