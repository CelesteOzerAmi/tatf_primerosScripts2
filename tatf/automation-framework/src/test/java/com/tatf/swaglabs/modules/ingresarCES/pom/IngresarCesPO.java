package com.tatf.swaglabs.modules.ingresarCES.pom;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;
import com.tatf.swaglabs.modules.ingresarCES.data.IngresarCesData;


public class IngresarCesPO {
    private final IBrowser browser;
    private final String title = "logo";
    private final String loginBtn = "//*[@id=\"loginForm\"]/div[2]/button";

    public IngresarCesPO(IBrowser browser) {
        this.browser = browser;
    }

    public String getTitle(){
        return this.browser.find().className(title).getText();
    }

    public void IngresarCES(){
        browser.interaction().navigateTo(IngresarCesData.linkCES);
        browser.wait("#pass");
    }

    public void IngresarHash(){
        Element passwordInput = browser.find().id("pass");
        passwordInput.clear()
                .write(IngresarCesData.hash);
    }

    public void AccederCES(){
        browser.find().xpath(loginBtn).click();
    }

}