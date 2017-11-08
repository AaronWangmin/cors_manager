package com.shbd.cors.dao;

public class DaoFactory {
	IProvinceDao getProvinceDao() {
		return new ProvinceDao();
	}

}
