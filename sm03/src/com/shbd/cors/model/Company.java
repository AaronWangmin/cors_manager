package com.shbd.cors.model;

public class Company {
	private int id;
	private String name;
	private String address;
	/**
	 * 公司类型： 0：分公司, 1：基准所在场地的公司（如，场地业主）
	 * 
	 */
	private int type;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int id, String name, String address, int type) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + ", type=" + type + "]";
	}
	
	

}
