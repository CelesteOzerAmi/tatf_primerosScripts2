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

    public void VerificarUsuario(String nombreUsuario){
        IVerify.create().verifyTrue(this.login.getUsuarioLogueado(nombreUsuario), "Usuario no fue logueado correctamente");
    }
}
