package com.tatf.swaglabs.modules.verUsuarios.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.swaglabs.modules.verUsuarios.pom.VerUsuariosPO;

public class VerUsuariosTask {

    private final IBrowser browser;
    private final VerUsuariosPO menuLateral;

    public VerUsuariosTask(IBrowser browser) {
        this.browser = browser;
        this.menuLateral = new VerUsuariosPO(this.browser);
    }


    public void VerUsuarios(){
        this.menuLateral.VerUsuarios();
    }

}
