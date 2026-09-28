package com.tatf.swaglabs.modules.testSuite;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.ingresarCES.IngresarCesPO;
import com.tatf.swaglabs.modules.inicio.InicioPO;
import com.tatf.swaglabs.modules.menuLateral.MenuLateralPO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class eliminarUsuarioTest {
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
    public void eliminarUsuario(){
        // ingresar a ces //
        this.ingresarCes.IngresarCES();

        // inicio de sesión con usuario admin //
        this.ingresar.Login("yaniscorrea@gmail.com", "12345");

        // ir a ver usuarios //
        this.administrarUsuarios.VerUsuarios();

        // eliminar usuario //
        this.administrarUsuarios.EliminarUsuario("mariana@gmail.com");

        // se verifica que se emita mensaje de Usuario eliminado. //
        boolean usuarioEliminado = browser.find().xpath("//*[@id=\"swal2-html-container\" and contains(text(),\"Usuario eliminado.\")]").isDisplayed();
        verify.verifyTrue(usuarioEliminado, "Usuario no se pudo eliminar");

        browser.find().xpath("//*[text()='OK']").click();

        // se busca email de usuario eliminado en el listado de usuarios y se verifica que no esté //
        boolean usuarioExiste = !browser.find().xpathList("//*[@id=\"bodyTable\"]/*/td[contains(text(),\"mariana@gmail.com\")]").isEmpty();
        verify.verifyFalse(usuarioExiste, "El usuario 'mariana@gmail.com' sigue presente en la tabla.");
    }

}
