package com.tatf.swaglabs.modules.ingresarCES.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.ingresarCES.data.IngresarCesData;
import com.tatf.swaglabs.modules.ingresarCES.pom.IngresarCesPO;

public class IngresarCesTask {
    private final IBrowser browser;
    private final IngresarCesPO ingresarCesPO;


    public IngresarCesTask(IBrowser browser){
        this.browser = browser;
        this.ingresarCesPO = new IngresarCesPO(this.browser);
    }

    public void ingresarCES() {
        this.ingresarCesPO.IngresarCES();
        this.ingresarCesPO.IngresarHash();
        this.ingresarCesPO.AccederCES();
    }
}
