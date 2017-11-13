package com.shbd.cors.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shbd.cors.model.Province;

public class ProvinceDaoTest {
	
	
	IProvinceDao provincDao = DaoFactory.getProvinceDao();
	

	@Test
	public void testAdd() {
		Province p = new Province(2,"±±¾©");
		provincDao.add(p);
		
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoad() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testList() {
		List<Province> provinces = new ArrayList<Province>();
		provinces = provincDao.list();
		for(Province p : provinces) {
			System.out.println(p.getId() + ":" + p.getName());
		}
	}

}
