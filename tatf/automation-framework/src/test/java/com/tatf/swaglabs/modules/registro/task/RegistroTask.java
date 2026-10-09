package com.tatf.swaglabs.modules.registro.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.registro.data.RegistroData;
import com.tatf.swaglabs.modules.registro.pom.RegistroPO;

public class RegistroTask {
    private final IBrowser browser;
    private final RegistroPO registro;

    public RegistroTask(IBrowser browser) {
        this.browser = browser;
        this.registro = new RegistroPO(this.browser);
    }

    public void Registro(String nombre, String apellido, String email, String password, String pais){
        this.registro.ClickRegistrarse();
        this.registro.IngresarNombre(nombre);
        this.registro.IngresarApellido(apellido);
        this.registro.IngresarEmail(email);
        this.registro.IngresarPassword(password);
        this.registro.ConfirmarPassword(password);
        this.registro.IngresarPais(pais);
        this.registro.ClickRegister();
    }

    public void VerificarConfirmacion(){
        IVerify.create().verifyTrue(this.registro.VerificarConfirmacion(), "Usuario no fue creado correctamente");
        this.registro.AceptarConfirmacion();
    }

}
