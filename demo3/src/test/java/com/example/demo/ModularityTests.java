package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModularityTests {

	ApplicationModules modules = ApplicationModules.of(Application.class);

	@Test
	void verifiesModularStructure() {
		modules.verify();
	}

	// @Test
	// void createModuleDocumentation() {
	// 	ApplicationModules modules = ApplicationModules.of(Application.class);
	// 	new Documenter(modules)
	// 			.writeDocumentation()
	// 			.writeIndividualModulesAsPlantUml();
	// }
}