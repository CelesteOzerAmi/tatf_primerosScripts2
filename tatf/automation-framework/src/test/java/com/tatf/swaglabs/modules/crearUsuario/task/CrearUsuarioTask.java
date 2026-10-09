package com.tatf.swaglabs.modules.crearUsuario.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.swaglabs.modules.crearUsuario.data.CrearUsuarioData;
import com.tatf.swaglabs.modules.crearUsuario.pom.CrearUsuarioPO;
import com.tatf.swaglabs.modules.verUsuarios.pom.VerUsuariosPO;


public class CrearUsuarioTask {
    private final IBrowser browser;
    private final CrearUsuarioPO crearUsuario;
    private final VerUsuariosPO menuLateral;

    public CrearUsuarioTask(IBrowser browser) {
        this.browser = browser;
        this.crearUsuario = new CrearUsuarioPO(this.browser);
        this.menuLateral = new VerUsuariosPO(this.browser);
    }

    public void IrACrearUsuario(){
        this.crearUsuario.ClickCrearUsuarioTester();
    }

    public void VerificarTitulo(){
        IVerify.create().verify(CrearUsuarioData.titleCrearUsuario, this.crearUsuario.GetTitulo(), "Los títulos no coinciden");
    }

    public void CrearUsuarioTester(String nombre, String apellido, String email, String contrasena, String pais, String tipo){
        this.crearUsuario.IngresarNombre(nombre);
        this.crearUsuario.IngresarApellido(apellido);
        this.crearUsuario.IngresarEmail(email);
        this.crearUsuario.IngresarContrasena(contrasena);
        this.crearUsuario.SeleccionarPais(pais);
        this.crearUsuario.SeleccionarTipoTester(tipo);
        this.crearUsuario.ConfirmarCrearUsuario();
    }

    public void VerificarUsuarioCreado(){
        IVerify.create().verifyTrue(this.crearUsuario.ConfirmacionUsuarioCreado(), "Usuario no fue creado correctamente");
        this.crearUsuario.AceptarConfirmacion();
    }

    public void VerUsuarios(){
        this.menuLateral.VerUsuarios();
    }

    public void ValidarUsuarioCreado(String email){
        IVerify.create().verifyTrue(this.crearUsuario.BuscarUsuario(email), "Usuario no se encontró");
    }


}
