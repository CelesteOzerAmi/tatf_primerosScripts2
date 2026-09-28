package com.tatf.swaglabs.modules.ingresarCES;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;

public class IngresarCesPO {
    private final IBrowser browser;
    private final static String linkCES = "http://cestore.ces.com.uy/adminces/";
    private final static String hash = "3)ea60e0be3ba12c6ecd%7297868%5c4";

    public IngresarCesPO(IBrowser browser) {
        this.browser = browser;
    }

    public void IngresarCES(){
        browser.interaction().navigateTo(linkCES);
        browser.wait("#pass");
        Element passwordInput = browser.find().id("pass");
        passwordInput.clear()
                .write(hash);
        browser.find().xpath("//*[@id=\"loginForm\"]/div[2]/button").click();
    }

}