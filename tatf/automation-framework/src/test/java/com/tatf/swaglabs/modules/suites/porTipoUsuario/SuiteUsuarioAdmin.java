package com.tatf.swaglabs.modules.suites.porTipoUsuario;

import com.tatf.swaglabs.modules.tests.CrearAdminTest;
import com.tatf.swaglabs.modules.tests.ResetearContrasenaTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CrearAdminTest.class, ResetearContrasenaTest.class})
public class SuiteUsuarioAdmin {
}
