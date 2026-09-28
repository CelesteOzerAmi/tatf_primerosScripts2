package com.tatf.swaglabs.modules.testSuite;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.menuLateral.MenuLateralPO;
import com.tatf.swaglabs.modules.ingresarCES.IngresarCesPO;
import com.tatf.swaglabs.modules.inicio.InicioPO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class crearUsuarioTesterTest {

    IBrowser browser;
    IVerify verify;
    private IngresarCesPO ingresarCes;
    private InicioPO ingresar;
    private MenuLateralPO administrarUsuarios;

    @BeforeEach
    public void setUp(){
        browser = BrowserFactory.getBrowser(true);
        verify = IVerify.create();
        this.ingresarCes = new IngresarCesPO(this.browser);
        this.ingresar = new InicioPO(this.browser);
        this.administrarUsuarios = new MenuLateralPO(this.browser);
    }

    @AfterAll
    public static void quit(){
        BrowserFactory.quitBrowser();
    }

    @Test
    public void crearUsuarioTester(){
        // ingresar a ces //
        this.ingresarCes.IngresarCES();

        // inicio de sesión con usuario admin //
        this.ingresar.Login("yaniscorrea@gmail.com", "12345");

        // crear usuario tester //
        String testerEmail = "juan@email.com";
        this.administrarUsuarios.CrearUsuarioTester("Juan", "Perez", testerEmail,
                "JuanPerezTester123.", "Uruguay", "testerJunior");

        // se verifica que exista mensaje de Usuario creado. //
        boolean usuarioCreado = browser.find().xpath("//*[@id=\"swal2-html-container\" and contains(text(),\"Usuario creado.\")]")
                .isDisplayed();
        verify.verifyTrue(usuarioCreado, "Usuario no fue creado correctamente");

        browser.find().xpath("//*[text()='OK']").click();

        // ver usuarios //
        this.administrarUsuarios.VerUsuarios();

        // se verifica que el email del usuario creado se encuentre en el listado //
        boolean testerCreado = browser.find().xpath("//*[@id=\"bodyTable\"]/*/td[contains(text(),\"juan@email.com\")]")
                .isDisplayed();
        verify.verifyTrue(testerCreado, "Usuario no se ve registrado");
    }
}
