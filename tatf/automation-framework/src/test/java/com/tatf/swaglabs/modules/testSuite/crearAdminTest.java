package com.tatf.swaglabs.modules.testSuite;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.ingresarCES.task.IngresarCesTask;
import com.tatf.swaglabs.modules.login.task.LoginTask;
import com.tatf.swaglabs.modules.registro.task.RegistroTask;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class crearAdminTest {

    IBrowser browser;
    IVerify verify;
    private IngresarCesTask ingresarCes;
    private LoginTask login;
    private RegistroTask register;

    @BeforeEach
    public void setUp(){
        browser = BrowserFactory.getBrowser(true);
        verify = IVerify.create();
        this.ingresarCes = new IngresarCesTask(this.browser);
        this.login = new LoginTask(this.browser);
        this.register = new RegistroTask(this.browser);
    }

    @AfterEach
    public void quit(){
        BrowserFactory.quitBrowser();
    }

    @Test
    public void crearCuentaAdmin(){
        // ingresar a ces //
        this.ingresarCes.ingresarCES();

        // registro //
        String password = "yanisAdminCES123contraseñaSegura.";
        String email = "yanis@email.com";
        this.register.Registro("Yanis", "Correa", email, password, "Uruguay");

        // se verifica que exista mensaje de Usuario creado. //
        this.register.verifyConfirm();

        this.register.ConfirmRegister();

        // inicio de sesión con nueva cuenta //
        this.login.IniciarSesion(email, password);
        this.login.VerificarConfirmacion();

        // se verifica que el usuario logueado coincida con los datos del admin creado //
        this.login.VerificarUsuario();
    }
}