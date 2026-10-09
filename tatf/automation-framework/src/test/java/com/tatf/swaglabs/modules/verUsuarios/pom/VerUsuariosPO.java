package com.tatf.swaglabs.modules.verUsuarios.pom;

import com.tatf.core.browser.IBrowser;

public class VerUsuariosPO {
    private final IBrowser browser;
    private final String btnVerUsuarios = "//*[@id=\"cardLogin\"]//*[contains(text(),\"Ver usuarios\")]";

    public VerUsuariosPO(IBrowser browser) {
        this.browser = browser;
    }


    public void VerUsuarios(){
        this.browser.find().xpath(btnVerUsuarios).click();
    }

}
