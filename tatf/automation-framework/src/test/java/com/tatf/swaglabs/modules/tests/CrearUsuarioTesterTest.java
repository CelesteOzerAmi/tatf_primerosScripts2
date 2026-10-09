package com.tatf.swaglabs.modules.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.crearUsuario.task.CrearUsuarioTask;
import com.tatf.swaglabs.modules.ingresarCES.task.IngresarCesTask;
import com.tatf.swaglabs.modules.login.task.LoginTask;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CrearUsuarioTesterTest {

    IBrowser browser;
    IVerify verify;
    private IngresarCesTask ingresarCes;
    private LoginTask login;
    private CrearUsuarioTask crearUsuario;

    @BeforeEach
    public void setUp(){
        browser = BrowserFactory.getBrowser();
        verify = IVerify.create();
        this.ingresarCes = new IngresarCesTask(this.browser);
        this.login = new LoginTask(this.browser);
        this.crearUsuario = new CrearUsuarioTask(this.browser);
    }

    @AfterEach
    public void quit(){
        BrowserFactory.quitBrowser();
    }

    @Tag("RegistroUsuario")
    @ParameterizedTest(name = "{0}, {1}")
    @CsvFileSource(
            resources = "/datos_crearUsuarioTesterTest.csv",
            useHeadersInDisplayName = true
    )
    public void crearUsuarioTester(String nombre, String apellido, String testerEmail, String password, String pais, String rol){
        // ingresar a ces //
        this.ingresarCes.ingresarCES();

        // inicio de sesión con usuario admin //
        this.login.IniciarSesionAdmin();

        // crear usuario tester //
        this.crearUsuario.IrACrearUsuario();
        this.crearUsuario.VerificarTitulo();
        this.crearUsuario.CrearUsuarioTester(nombre, apellido, testerEmail, password, pais, rol);

        // se verifica que exista mensaje de Usuario creado. //
        this.crearUsuario.VerificarUsuarioCreado();

        // ver usuarios //
        this.crearUsuario.VerUsuarios();

        // se verifica que el email del usuario creado se encuentre en el listado //
        this.crearUsuario.ValidarUsuarioCreado(testerEmail);
    }
}
