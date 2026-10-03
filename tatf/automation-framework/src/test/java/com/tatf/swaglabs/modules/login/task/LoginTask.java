package com.tatf.swaglabs.modules.login.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.login.data.LoginData;
import com.tatf.swaglabs.modules.login.pom.LoginPO;

public class LoginTask {
    private final IBrowser browser;
    private final LoginPO login;

    public LoginTask(IBrowser browser) {
        this.browser = browser;
        this.login = new LoginPO(this.browser);
    }

    public void verifyTitle(String title) {
        IVerify.create().verify(LoginData.TITLE, this.login.getTitle(), "El título no es el esperado.");
    }

    public void IniciarSesion(String email, String password) {
        this.login.clickIniciarSesion();
        this.login.ingresarEmail(email);
        this.login.ingresarPassword(password);
        this.login.clickLogin();
    }

    public void VerificarConfirmacion(){
        IVerify.create().verifyTrue(this.login.VerificarConfirmacion(),"Sesión no iniciada");
        this.login.AceptarConfirmacion();
    }

    public void VerificarUsuario(){
        IVerify.create().verifyTrue(this.login.UsuarioLogueado(), "Usuario no fue logueado correctamente");
    }
}
