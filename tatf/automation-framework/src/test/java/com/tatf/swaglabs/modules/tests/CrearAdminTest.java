package com.tatf.swaglabs.modules.tests;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.ingresarCES.task.IngresarCesTask;
import com.tatf.swaglabs.modules.login.task.LoginTask;
import com.tatf.swaglabs.modules.registro.task.RegistroTask;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CrearAdminTest {

    IBrowser browser;
    IVerify verify;
    private IngresarCesTask ingresarCes;
    private LoginTask login;
    private RegistroTask registro;

    @BeforeEach
    public void setUp(){
        browser = BrowserFactory.getBrowser("FIREFOX");
        verify = IVerify.create();
        this.ingresarCes = new IngresarCesTask(this.browser);
        this.login = new LoginTask(this.browser);
        this.registro = new RegistroTask(this.browser);
    }

    @AfterEach
    public void quit(){
        BrowserFactory.quitBrowser();
    }

    @Tag("RegistroUsuario")
    @ParameterizedTest(name = "{0}{1}")
    @CsvFileSource(
            resources = "/datos_crearAdminTest.csv",
            useHeadersInDisplayName = true
    )
    public void CrearCuentaAdmin(String nombre, String apellido, String email, String password, String pais){
        // ingresar a ces //
        this.ingresarCes.ingresarCES();

        // registro //
        this.registro.Registro(nombre, apellido, email, password, pais);

        // se verifica que exista mensaje de Usuario creado. //
        this.registro.VerificarConfirmacion();

        // inicio de sesión con nueva cuenta //
        this.login.IniciarSesion(email, password);
        this.login.VerificarConfirmacion();

        // se verifica que el usuario logueado coincida con los datos del admin creado //
        String nombreUsuario = nombre.concat(" " + apellido);
        this.login.VerificarUsuario(nombreUsuario);
    }
}