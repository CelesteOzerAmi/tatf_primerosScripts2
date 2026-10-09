package com.tatf.swaglabs.modules.suites.porNavegador;

import com.tatf.swaglabs.modules.tests.CrearAdminTest;
import com.tatf.swaglabs.modules.tests.EliminarUsuarioTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CrearAdminTest.class, EliminarUsuarioTest.class})
public class SuiteFirefox {
}
