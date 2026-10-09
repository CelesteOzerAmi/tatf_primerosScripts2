package com.tatf.swaglabs.modules.suites.porTipoUsuario;

import com.tatf.swaglabs.modules.tests.CrearUsuarioTesterTest;
import com.tatf.swaglabs.modules.tests.EliminarUsuarioTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CrearUsuarioTesterTest.class, EliminarUsuarioTest.class})
public class SuiteUsuarioTester {
}
