package com.shbd.cors.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shbd.cors.model.Company;
import com.shbd.cors.model.CorsException;
import com.shbd.cors.util.DBUtil;

public class CompanyDao implements ICompanyDao {

	@Override
	public void add(Company company) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select count(*) from t_company where name=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, company.getName());
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0)
					throw new CorsException("公司名已存在，不能添加");
			}
			sql = "insert into t_company values (null,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, company.getName());
			ps.setString(2, company.getAddress());
			ps.setInt(3, company.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}

	}

	@Override
	public void update(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	public Company load(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Company company = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select count(*) from t_company where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) <= 0) throw new CorsException("没有这个公司，请先添加公司！");
			}		
			
			sql = "select * from t_company where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				company = new Company(rs.getInt("id"), rs.getString("name"), 
						rs.getString("address"),rs.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}

		return company;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Company> list() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Company> companies = new ArrayList<Company>();
		try {
			con = DBUtil.getConnection();
			String sql = "select * from t_company";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Company company = new Company(rs.getInt("id"), rs.getString("name"), rs.getString("address"),
						rs.getInt("type"));
				companies.add(company);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}

		return companies;
	}

}
