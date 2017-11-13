package com.shbd.cors.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shbd.cors.model.CorsException;
import com.shbd.cors.model.Province;
import com.shbd.cors.util.DBUtil;

public class ProvinceDao implements IProvinceDao {

	@Override
	public void add(Province province) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			con = DBUtil.getConnection();
			String sql = "select count(*) from t_province where name=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, province.getName());
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) > 0) throw new CorsException("要添加的省已经存在，不能添加");
			}
			sql = "insert into t_province values (null,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, province.getName());
			ps.executeUpdate();				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		
		
	
	}

	@Override
	public void update(Province province) {
		
	}

	@Override
	public Province load(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Province province = null;		
		try {
			con = DBUtil.getConnection();
			String sql = "select * from t_province where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				province = new Province();
				province.setId(rs.getInt("id"));
				province.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return province;	
				
	}

	@Override
	public void delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;		
		con = DBUtil.getConnection();
		String sql = "delete from t_province where id=?";		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	}

	@Override
	public List<Province> list() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Province> provinces = new ArrayList<Province>();
		Province province = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from t_province";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				province = new Province();
				province.setId(rs.getInt("id"));
				province.setName(rs.getString("name"));
				provinces.add(province);				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return provinces;
	}

}
