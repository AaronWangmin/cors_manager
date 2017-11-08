package com.shbd.cors.dao;

import java.util.List;

import com.shbd.cors.model.Province;

public interface IProvinceDao {
	public void add(Province province);	
	public void update(Province province);
	public void load(int id);	
	public void delete(int id);
	public List<Province> list();

}
