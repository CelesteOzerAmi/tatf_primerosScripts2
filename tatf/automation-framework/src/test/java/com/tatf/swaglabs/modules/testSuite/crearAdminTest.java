package com.tatf.swaglabs.modules.testSuite;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.ingresarCES.IngresarCesPO;
import com.tatf.swaglabs.modules.inicio.InicioPO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class crearAdminTest {

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
    public void crearCuentaAdmin(){
        // ingresar a ces //
        this.ingresarCes.IngresarCES();

        // registro //
        String password = "mariaAdminCES123contraseñaSegura.";
        String email = "maria@email.com";
        this.ingresar.Registro("Maria", "Martinez", email, password, "Uruguay");

        // se verifica que exista mensaje de Usuario creado. //
        boolean usuarioCreado = browser.find().xpath("//*[text()='Usuario creado.']").isDisplayed();
        verify.verifyTrue(usuarioCreado, "Usuario no fue creado correctamente");

        browser.find().xpath("//*[text()='OK']").click();

        // inicio de sesión con nueva cuenta //
        this.ingresar.Login(email, password);

        // se verifica que el usuario logueado coincida con los datos del admin creado //
        boolean usuarioLogueado = browser.find().xpath("//*[@id=\"content\"]/nav/ul/li/div/div/a[contains(text(),\"Maria  Martinez\")]").isDisplayed();
        verify.verifyTrue(usuarioLogueado, "Usuario no fue logueado correctamente");
    }
}