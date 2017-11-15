package com.shbd.cors.dao;

import java.util.List;

import com.shbd.cors.model.Company;

public interface ICompanyDao {
	public void add(Company company);
	public void update(Company company);
	public Company load(int id);
	public void delete(int id);
	public List<Company> list();

}
