package com.tatf.swaglabs.modules.testSuite;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.ingresarCES.IngresarCesPO;
import com.tatf.swaglabs.modules.inicio.InicioPO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class resetearContrasenaTest {
    IBrowser browser;
    IVerify verify;
    private IngresarCesPO ingresarCes;
    private InicioPO ingresar;

    @BeforeEach
    public void setUp(){
        browser = BrowserFactory.getBrowser(true);
        verify = IVerify.create();
        this.ingresarCes = new IngresarCesPO(this.browser);
        this.ingresar = new InicioPO(this.browser);
    }

    @AfterAll
    public static void quit(){
        BrowserFactory.quitBrowser();
    }

    @Test
    public void resetearContrasena(){
        // ingresar a ces //
        this.ingresarCes.IngresarCES();

        String email = "yaniscorrea@gmail.com";
        String newPassword = "mariaAdminCES123NUEVAcontraseñaSegura.";

        // reinicio de contraseña //
        this.ingresar.ReiniciarContrasena(email, newPassword);

        // se verifica que se emita mensaje de Contraseña reiniciada. //
        boolean contrasenaReiniciada = browser.find().xpath("//*[@id=\"swal2-html-container\" and contains(text(),\"Contraseña reiniciada.\")]").isDisplayed();
        verify.verifyTrue(contrasenaReiniciada, "Contraseña no se reinició correctamente");

        browser.find().xpath("//*[text()='OK']").click();

        // inicio de sesión con datos actualizados //
        this.ingresar.Login(email, newPassword);

        // se verifica que el usuario logueado coincida con los datos del admin //
        boolean usuarioLogueado = browser.find().xpath("//*[@id=\"content\"]/nav/ul/li/div/div/a[contains(text(),\"Yanis  Correa\")]").isDisplayed();
        verify.verifyTrue(usuarioLogueado,  "Usuario no fue logueado correctamente");
    }
}
