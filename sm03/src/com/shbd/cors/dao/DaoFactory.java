package com.shbd.cors.dao;

public class DaoFactory {
	public static IProvinceDao getProvinceDao() {
		return new ProvinceDao();
	}

}
