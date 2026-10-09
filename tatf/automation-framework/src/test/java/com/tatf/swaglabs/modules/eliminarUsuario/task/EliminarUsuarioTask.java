package com.tatf.swaglabs.modules.eliminarUsuario.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.eliminarUsuario.pom.EliminarUsuarioPO;

public class EliminarUsuarioTask {
    private final IBrowser browser;
    private final EliminarUsuarioPO eliminarUsuario;

    public EliminarUsuarioTask(IBrowser browser) {
        this.browser = browser;
        this.eliminarUsuario = new EliminarUsuarioPO(this.browser);
    }

    public void EliminarUsuario(String email){
        this.eliminarUsuario.EliminarUsuario(email);
    }

    public void VerificarUsuarioEliminado(){
        IVerify.create().verifyTrue(this.eliminarUsuario.ConfirmacionUsuarioEliminado(), "Usuario no se pudo eliminar");
        this.eliminarUsuario.AceptarConfirmacion();
    }

    public void ValidarUsuarioEliminado(String testerEmail){
        IVerify.create().verifyTrue(this.eliminarUsuario.EncontrarUsuario(testerEmail), "Usuario no se eliminó");
    }
}
