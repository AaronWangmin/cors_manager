package com.shbd.cors.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.shbd.cors.model.Company;

public class CompanyDaoTest {
	ICompanyDao cd = DaoFactory.getCompanyDao();

	@Test
	public void testAdd() {
//		Company company = new Company(1,"上海北斗","上海市",0);
		Company company = new Company(2,"辽宁北斗","沈阳市",0);
		cd.add(company);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoad() {
		Company company = cd.load(1);
		System.out.println(company);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testList() {
		List<Company> companies = new ArrayList<Company>();
		companies = cd.list();
		for(Company c : companies) {
			System.out.println(c);
		}
	}

}
