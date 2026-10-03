package com.tatf.swaglabs.modules.resetearContrasena.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.resetearContrasena.pom.ResetearContrasenaPO;

public class ResetearContrasenaTask {
    private final IBrowser browser;
    private final ResetearContrasenaPO resetearContrasena;

    public ResetearContrasenaTask(IBrowser browser) {
        this.browser = browser;
        this.resetearContrasena = new ResetearContrasenaPO(this.browser);
    }


    public void ResetearContrasena(String email, String nuevaContrasena){
        this.resetearContrasena.ClickResetear();
        this.resetearContrasena.IngresarEmail(email);
        this.resetearContrasena.IngresarNuevaContrasena(nuevaContrasena);
        this.resetearContrasena.EjecutarCambio();
    }

    public void VerificarConfirmacion(){
        IVerify.create().verifyTrue(this.resetearContrasena.Confirmacion(), "Contraseña no se reinició correctamente");

        this.resetearContrasena.AceptarConfirmacion();
    }
}
