package com.shbd.cors.util;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;

public class PropertiesUtilTest {

	@Test
	public void testGetJdbcProp() {
		Properties p1 = PropertiesUtil.getJdbcProp();
		Properties p2 = PropertiesUtil.getJdbcProp();
		System.out.println(p1==p2);
	}

}
