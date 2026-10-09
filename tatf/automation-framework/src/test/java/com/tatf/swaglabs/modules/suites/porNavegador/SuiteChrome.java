package com.tatf.swaglabs.modules.suites.porNavegador;

import com.tatf.swaglabs.modules.tests.CrearUsuarioTesterTest;
import com.tatf.swaglabs.modules.tests.ResetearContrasenaTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CrearUsuarioTesterTest.class, ResetearContrasenaTest.class})
public class SuiteChrome {
}
