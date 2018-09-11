package com.tpgenielogiciel.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.tpgenielogiciel.control.Utilisatcontrole;

class LoginFailTest {
	
	Utilisatcontrole n =new Utilisatcontrole();
    int val = n.utiliexist("adama", "sow");

	@Test
	void testFail() {
		assertEquals(val, 0);
	}

}
