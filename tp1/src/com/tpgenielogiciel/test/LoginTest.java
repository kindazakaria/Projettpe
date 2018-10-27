package com.tpgenielogiciel.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.tpgenielogiciel.control.Utilisatcontrole;


class LoginTest {
	
	Utilisatcontrole n =new Utilisatcontrole();
    int val = n.utiliexist("adama", "sow");
  
	//@Test
	//void test() {
	//	assertNotSame(val, 43);
	//}
	
	@Test
	void testFail() {
		assertEquals(val, 43);
	}

}
