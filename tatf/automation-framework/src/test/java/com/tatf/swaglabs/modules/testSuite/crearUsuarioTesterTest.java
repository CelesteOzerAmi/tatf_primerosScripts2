package com.tatf.swaglabs.modules.testSuite;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.ingresarCES.task.IngresarCesTask;
import com.tatf.swaglabs.modules.login.task.LoginTask;
import com.tatf.swaglabs.modules.menuLateral.task.MenuLateralTask;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class crearUsuarioTesterTest {

    IBrowser browser;
    IVerify verify;
    private IngresarCesTask ingresarCes;
    private LoginTask login;
    private MenuLateralTask menuLateral;

    @BeforeEach
    public void setUp(){
        browser = BrowserFactory.getBrowser(true);
        verify = IVerify.create();
        this.ingresarCes = new IngresarCesTask(this.browser);
        this.login = new LoginTask(this.browser);
        this.menuLateral = new MenuLateralTask(this.browser);
    }

    @AfterAll
    public static void quit(){
        BrowserFactory.quitBrowser();
    }

    @Test
    public void crearUsuarioTester(){
        // ingresar a ces //
        this.ingresarCes.ingresarCES();

        // inicio de sesión con usuario admin //
        this.login.IniciarSesion("yaniscorrea@gmail.com", "12345");
        this.login.VerificarConfirmacion();

        // crear usuario tester //
        String testerEmail = "juan@email.com";
        this.menuLateral.IrACrearUsuario();
        this.menuLateral.VerificarTitulo();
        this.menuLateral.CrearUsuarioTester("Juan", "Perez", testerEmail,
                "JuanPerezTester123.", "Uruguay", "testerJunior");

        // se verifica que exista mensaje de Usuario creado. //
        this.menuLateral.VerificarUsuarioCreado();

        // ver usuarios //
        this.menuLateral.VerUsuarios();

        // se verifica que el email del usuario creado se encuentre en el listado //
        this.menuLateral.ValidarUsuarioCreado(testerEmail);
    }
}
