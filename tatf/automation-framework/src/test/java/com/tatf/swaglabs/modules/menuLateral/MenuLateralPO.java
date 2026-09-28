package com.tatf.swaglabs.modules.menuLateral;

import com.tatf.core.browser.IBrowser;

public class MenuLateralPO {
    private final IBrowser browser;
    private final String btnEmail = "inputEmail";
    private final String btnContrasena = "inputPassword";
    private final String btnNombre = "inputFirstName";
    private final String btnApellido = "inputLastName";
    private final String btnPais = "inputCountry";
    private final String btnRegistro = "btnRegister";

    public MenuLateralPO(IBrowser browser) {
        this.browser = browser;
    }

    public void CrearUsuarioTester(String nombre, String apellido, String email,
                                   String password, String pais, String tipo){
        browser.find().xpath("//*[@id=\"cardLogin\"]/div/div/div/div[1]/div[contains(text(),\"Crear usuario\")]")
                .click();
        browser.find().name(btnNombre).clear().write(nombre);
        browser.find().name(btnApellido).clear().write(apellido);
        browser.find().name(btnEmail).clear().write(email);
        browser.find().name(btnPais).selectText(pais);
        browser.find().name(btnContrasena).clear().write(password);
        browser.find().id(tipo).click();
        browser.find().id(btnRegistro).click();
    }

    public void VerUsuarios(){
        browser.find().xpath("//*[@id=\"wrapper\"]/ul/li/div[3]/a/span[contains(text(),\"Ver usuarios\")]")
                .click();
    }

    public void EliminarUsuario(String email){
        browser.find().id(email).click();
        browser.find().xpath("*//button[contains(text(),\"Sí\")]").click();
    }
}
