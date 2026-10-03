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

    public void verifyTitle(String title) {
        IVerify.create().verify(RegistroData.title, this.registro.getTitle(title), "El título no es el esperado.");
    }

    public void verifyConfirm(){
        this.registro.verifyConfirm();
    }

    public void Registro(String nombre, String apellido, String email, String password, String pais){
        this.registro.clickRegistrarse();
        this.registro.ingresarNombre(nombre);
        this.registro.ingresarApellido(apellido);
        this.registro.ingresarEmail(email);
        this.registro.ingresarPassword(password);
        this.registro.confirmarPassword(password);
        this.registro.ingresarPais(pais);
        this.registro.clickRegister();
    }

    public void ConfirmRegister(){
        this.registro.clickConfirm();
    }

}
