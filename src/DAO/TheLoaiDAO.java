package DAO;

import entity.Quyen;
import entity.Sach;
import entity.TaiKhoan;
import entity.TheLoai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;

public class TheLoaiDAO implements DAOInterface<TheLoai> {

	public static TheLoaiDAO getInstance() {
		return new TheLoaiDAO();
	}
	
	@Override
	public int insert(TheLoai t) { //thêm một thể loại
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO theloai(tenTheLoai) VALUES (?);";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setString(1, t.getTenTheLoai());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(TheLoai t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE theloai SET xoa = 1 WHERE maTheLoai = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setInt(1, t.getMaTheLoai());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(TheLoai t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE theloai SET ");
			sql.append("tenTheLoai = ?, ");
			sql.append("WHERE maTheLoai= ? AND xoa = 0;");
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setString(1, t.getTenTheLoai());
			pre.setInt(2, t.getMaTheLoai());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<TheLoai> selectedAll() {
		ArrayList<TheLoai> list = new ArrayList<TheLoai>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM theloai WHERE xoa = 0";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				TheLoai temp = new TheLoai();
				temp.setMaTheLoai(rs.getInt("maTheLoai"));
				temp.setTenTheLoai(rs.getString("tenTheLoai"));
				list.add(temp);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public TheLoai selectedById(TheLoai t) {
		TheLoai tl = new TheLoai();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM theloai WHERE maTheLoai = ? AND xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setInt(1,t.getMaTheLoai());
			
			ResultSet rs = pre.executeQuery();
			
			if (rs.next()) {
				tl.setMaTheLoai(rs.getInt("maTheLoai"));
				tl.setTenTheLoai(rs.getString("tenTheLoai"));
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tl;
	}
	public TheLoai selectedByName(TheLoai t) { //tìm thể loại theo tên
		TheLoai tl = new TheLoai();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM theloai WHERE tenTheLoai = ? AND xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setString(1,t.getTenTheLoai());
			
			ResultSet rs = pre.executeQuery();
			
			if (rs.next()) {
				tl.setMaTheLoai(rs.getInt("maTheLoai"));
				tl.setTenTheLoai(rs.getString("tenTheLoai"));
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tl;
	}
	public ArrayList<TheLoai> selectedByPartName(String str) { //tìm theo một phần tên
		ArrayList<TheLoai> list = new ArrayList<TheLoai>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM theLoai WHERE tenTheLoai LIKE ? AND xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());	
			pre.setString(1,"%"+str+"%");
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				TheLoai temp = new TheLoai();
				temp.setMaTheLoai(rs.getInt("maTheLoai"));
				temp.setTenTheLoai(rs.getString("tenTheLoai"));
				list.add(temp);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public ArrayList<TheLoai> selectedByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int quantity() {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT COUNT(maTheLoai) AS soluong FROM theloai WHERE xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			
			ResultSet rs = pre.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("soluong");
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


}
