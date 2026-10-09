package com.tatf.swaglabs.modules.suites.porOperacion;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("tests")
@IncludeTags("EliminarUsuario")
public class SuiteEliminarUsuario {
}
