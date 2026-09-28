package com.tatf.swaglabs.modules.inicio;

import com.tatf.core.browser.IBrowser;

public class InicioPO {

    private final IBrowser browser;
    private final String btnEmail = "inputEmail";
    private final String btnContrasena = "inputPassword";
    private final String btnNombre = "inputFirstName";
    private final String btnApellido = "inputLastName";
    private final String btnConfirmarContra = "inputRepeatPassword";
    private final String btnPais = "inputCountry";


    public InicioPO(IBrowser browser) {
        this.browser = browser;
    }

    public void Login(String email, String password){
        browser.find().xpath("//*[@id=\"cardLogin\"]/div/div/div/div[1]/div[contains(text(),\"Iniciar sesión\")]")
                .click();
        browser.find().name(btnEmail).clear().write(email);
        browser.find().name(btnContrasena).clear().write(password);
        browser.find().xpath("//*[@id=\"formLogin\"]/div[3]/div[2]/button").click();

        browser.find().xpath("//*[@id=\"swal2-html-container\" and contains(text(),\"Sesión iniciada\")]");
        browser.find().xpath("//*[text()='OK']").click();
    }

    public void Registro(String nombre, String apellido, String email, String password, String pais){
        browser.find().xpath("//*[@id=\"wrapper\"]/ul/li/div[2]/a/span[text()=\"Registrarse\"]").click();
        browser.find().name(btnNombre).clear().write(nombre);
        browser.find().name(btnApellido).clear().write(apellido);
        browser.find().name(btnEmail).clear().write(email);
        browser.find().name(btnContrasena).clear().write(password);
        browser.find().name(btnConfirmarContra).clear().write(password);
        browser.find().name(btnPais).clear().write(pais);
        browser.find().id("btnRegister").click();
    }

    public void ReiniciarContrasena(String email, String newPassword){
        browser.find().xpath("//*[@id=\"cardLogin\"]/div/div/div/div[1]/div[contains(text(),\"Reiniciar contraseña\")]")
                .click();
        browser.find().name(btnEmail).clear().write(email);
        browser.find().name(btnContrasena).clear().write(newPassword);
        browser.find().name(btnConfirmarContra).clear().write(newPassword);
        browser.find().id("btnReset").click();
    }


}
