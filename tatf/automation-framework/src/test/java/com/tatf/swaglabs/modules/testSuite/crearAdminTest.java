package com.tatf.swaglabs.modules.testSuite;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.ingresarCES.task.IngresarCesTask;
import com.tatf.swaglabs.modules.login.task.LoginTask;
import com.tatf.swaglabs.modules.registro.task.RegistroTask;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class crearAdminTest {

    IBrowser browser;
    IVerify verify;
    private IngresarCesTask ingresarCes;
    private LoginTask login;
    private RegistroTask register;

    @BeforeEach
    public void setUp(){
        browser = BrowserFactory.getBrowser();
        verify = IVerify.create();
        this.ingresarCes = new IngresarCesTask(this.browser);
        this.login = new LoginTask(this.browser);
        this.register = new RegistroTask(this.browser);
    }

    @AfterEach
    public void quit(){
        BrowserFactory.quitBrowser();
    }

    @ParameterizedTest(name = "{0}{1}")
    @CsvFileSource(
            resources = "/datos_crearAdminTest.csv",
            useHeadersInDisplayName = true
    )
    public void crearCuentaAdmin(String nombre, String apellido, String email, String password, String pais){
        // ingresar a ces //
        this.ingresarCes.ingresarCES();

        // registro //
        this.register.Registro(nombre, apellido, email, password, pais);

        // se verifica que exista mensaje de Usuario creado. //
        this.register.verifyConfirm();

        this.register.ConfirmRegister();

        // inicio de sesión con nueva cuenta //
        this.login.IniciarSesion(email, password);
        this.login.VerificarConfirmacion();

        // se verifica que el usuario logueado coincida con los datos del admin creado //
        String nombreUsuario = nombre.concat(" " + apellido);
        this.login.VerificarUsuario(nombreUsuario);
    }
}