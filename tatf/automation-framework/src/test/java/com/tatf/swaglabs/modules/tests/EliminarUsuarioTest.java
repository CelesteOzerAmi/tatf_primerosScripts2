package com.tatf.swaglabs.modules.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.eliminarUsuario.task.EliminarUsuarioTask;
import com.tatf.swaglabs.modules.ingresarCES.task.IngresarCesTask;
import com.tatf.swaglabs.modules.login.task.LoginTask;
import com.tatf.swaglabs.modules.verUsuarios.task.VerUsuariosTask;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EliminarUsuarioTest {
    IBrowser browser;
    IVerify verify;
    private IngresarCesTask ingresarCes;
    private LoginTask login;
    private EliminarUsuarioTask eliminarUsuario;
    private VerUsuariosTask menuLateral;

    @BeforeEach
    public void setUp(){
        browser = BrowserFactory.getBrowser("FIREFOX");
        verify = IVerify.create();
        this.ingresarCes = new IngresarCesTask(this.browser);
        this.login = new LoginTask(this.browser);
        this.eliminarUsuario = new EliminarUsuarioTask(this.browser);
        this.menuLateral = new VerUsuariosTask(this.browser);
    }

    @AfterEach
    public void quit(){
        BrowserFactory.quitBrowser();
    }

    @Tag("EliminarUsuario")
    @ParameterizedTest(name = "{arguments}")
    @ValueSource(strings = {"mariana@gmail.com", "dardo@gmail.com", "leonardoperez@gmail.com"})
    public void eliminarUsuario(String testerEmail){
        // ingresar a ces //
        this.ingresarCes.ingresarCES();

        // inicio de sesión con usuario admin //
        this.login.IniciarSesionAdmin();

        // ir a ver usuarios //
        this.menuLateral.VerUsuarios();

        // eliminar usuario //
        this.eliminarUsuario.EliminarUsuario(testerEmail);

        // se verifica que se emita mensaje de Usuario eliminado. //
        this.eliminarUsuario.VerificarUsuarioEliminado();

        // se busca email de usuario eliminado en el listado de usuarios y se verifica que no esté //
        this.eliminarUsuario.ValidarUsuarioEliminado(testerEmail);
    }

}
