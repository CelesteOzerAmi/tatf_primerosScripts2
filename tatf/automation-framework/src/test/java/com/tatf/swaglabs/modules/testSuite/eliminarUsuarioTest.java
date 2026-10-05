package com.tatf.swaglabs.modules.testSuite;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.ingresarCES.task.IngresarCesTask;
import com.tatf.swaglabs.modules.login.task.LoginTask;
import com.tatf.swaglabs.modules.menuLateral.task.MenuLateralTask;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class eliminarUsuarioTest {
    IBrowser browser;
    IVerify verify;
    private IngresarCesTask ingresarCes;
    private LoginTask login;
    private MenuLateralTask menuLateral;

    @BeforeEach
    public void setUp(){
        browser = BrowserFactory.getBrowser();
        verify = IVerify.create();
        this.ingresarCes = new IngresarCesTask(this.browser);
        this.login = new LoginTask(this.browser);
        this.menuLateral = new MenuLateralTask(this.browser);
    }

    @AfterEach
    public void quit(){
        BrowserFactory.quitBrowser();
    }

    @ParameterizedTest(name = "{arguments}")
    @ValueSource(strings = {"mariana@gmail.com", "dardo@gmail.com", "yaniscorrea@gmail.com"})
    public void eliminarUsuario(String testerEmail){
        // ingresar a ces //
        this.ingresarCes.ingresarCES();

        // inicio de sesión con usuario admin //
        this.login.IniciarSesion("yaniscorrea@gmail.com", "12345");
        this.login.VerificarConfirmacion();

        // ir a ver usuarios //
        this.menuLateral.VerUsuarios();

        // eliminar usuario //
        this.menuLateral.EliminarUsuario(testerEmail);

        // se verifica que se emita mensaje de Usuario eliminado. //
        this.menuLateral.VerificarUsuarioEliminado();

        // se busca email de usuario eliminado en el listado de usuarios y se verifica que no esté //
        this.menuLateral.ValidarUsuarioEliminado(testerEmail);
    }

}
