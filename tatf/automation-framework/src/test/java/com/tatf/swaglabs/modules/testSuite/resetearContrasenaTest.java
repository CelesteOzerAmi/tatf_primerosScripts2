package com.tatf.swaglabs.modules.testSuite;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.ingresarCES.task.IngresarCesTask;
import com.tatf.swaglabs.modules.login.task.LoginTask;
import com.tatf.swaglabs.modules.resetearContrasena.task.ResetearContrasenaTask;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class resetearContrasenaTest {
    IBrowser browser;
    IVerify verify;
    private IngresarCesTask ingresarCes;
    private LoginTask login;
    private ResetearContrasenaTask resetearContrasena;

    @BeforeEach
    public void setUp(){
        browser = BrowserFactory.getBrowser();
        verify = IVerify.create();
        this.ingresarCes = new IngresarCesTask(this.browser);
        this.login = new LoginTask(this.browser);
        this.resetearContrasena = new ResetearContrasenaTask(this.browser);
    }

    @AfterEach
    public void quit(){
        BrowserFactory.quitBrowser();
    }

    @ParameterizedTest(name = "{arguments}")
    @CsvSource({
            "yaniscorrea@gmail.com, Yanis Correa",
            "leonardoperez@gmail.com, Leonardo Perez",
            "marisa@gmail.com, Marisa"
    })
    public void resetearContrasena(String email, String nombreUsuario){
        // ingresar a ces //
        this.ingresarCes.ingresarCES();
        String newPassword = "´.*+AdminCES123NUEVAcontraseñaSegura+´.*";

        // reinicio de contraseña //
        this.resetearContrasena.ResetearContrasena(email, newPassword);

        // se verifica que se emita mensaje de Contraseña reiniciada. //
        this.resetearContrasena.VerificarConfirmacion();

        // inicio de sesión con datos actualizados //
        this.login.IniciarSesion(email, newPassword);
        this.login.VerificarConfirmacion();

        // se verifica que el usuario logueado coincida con los datos del admin creado //
        this.login.VerificarUsuario(nombreUsuario);
    }
}
