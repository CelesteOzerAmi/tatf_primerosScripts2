package com.tatf.swaglabs.modules.menuLateral.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.login.pom.LoginPO;
import com.tatf.swaglabs.modules.menuLateral.data.MenuLateralData;
import com.tatf.swaglabs.modules.menuLateral.pom.MenuLateralPO;

public class MenuLateralTask {

    private final IBrowser browser;
    private final MenuLateralPO menuLateral;

    public MenuLateralTask(IBrowser browser) {
        this.browser = browser;
        this.menuLateral = new MenuLateralPO(this.browser);
    }

    public void IrACrearUsuario(){
        this.menuLateral.ClickCrearUsuarioTester();
    }

    public void VerificarTitulo(){
        IVerify.create().verify(MenuLateralData.titleCrearUsuario, this.menuLateral.GetTitulo(), "Los títulos no coinciden");
    }

    public void CrearUsuarioTester(String nombre, String apellido, String email, String contrasena, String pais, String tipo){
        this.menuLateral.IngresarNombre(nombre);
        this.menuLateral.IngresarApellido(apellido);
        this.menuLateral.IngresarEmail(email);
        this.menuLateral.IngresarContrasena(contrasena);
        this.menuLateral.SeleccionarPais(pais);
        this.menuLateral.SeleccionarTipoTester(tipo);
        this.menuLateral.ConfirmarCrearUsuario();
    }

    public void VerificarUsuarioCreado(){
        IVerify.create().verifyTrue(this.menuLateral.ConfirmacionUsuarioCreado(), "Usuario no fue creado correctamente");
        this.menuLateral.AceptarConfirmacion();
    }

    public void VerUsuarios(){
        this.menuLateral.VerUsuarios();
    }

    public void ValidarUsuarioCreado(String email){
        IVerify.create().verifyTrue(this.menuLateral.BuscarUsuario(email), "Usuario no se encontró");
    }

    public void EliminarUsuario(String email){
        this.menuLateral.EliminarUsuario(email);
    }

    public void VerificarUsuarioEliminado(){
        IVerify.create().verifyTrue(this.menuLateral.ConfirmacionUsuarioEliminado(), "Usuario no se pudo eliminar");
        this.menuLateral.AceptarConfirmacion();
    }

    public void ValidarUsuarioEliminado(){
        IVerify.create().verifyTrue(this.menuLateral.EncontrarUsuario(), "Usuario no se eliminó");
    }
}
