package DAO;

import entity.Quyen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import entity.Quyen;

public class QuyenDAO implements DAOInterface<Quyen> {

	public static QuyenDAO getInstance() {
		return new QuyenDAO();
	}
	
	@Override
	public int insert(Quyen t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO quyen(tenQuyen) VALUES (?);";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setString(1, t.getTenQuyen());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Quyen t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE FROM quyen WHERE tenQuyen = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setString(1, t.getTenQuyen());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Quyen t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE quyen SET ");
			sql.append("tenQuyen = ?, ");
			sql.append("WHERE maQuynen = ?;");
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setString(1, t.getTenQuyen());
			pre.setInt(2, t.getMaQuyen());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Quyen> selectedAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Quyen selectedById(Quyen t) {
		Quyen q = new Quyen();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM quyen WHERE maQuyen = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setInt(1,t.getMaQuyen());
			
			ResultSet rs = pre.executeQuery();
			
			if (rs.next()) {
				q.setMaQuyen(rs.getInt("maQuyen"));
				q.setTenQuyen(rs.getString("tenQuyen"));
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}

	@Override
	public ArrayList<Quyen> selectedByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int quantity() {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT COUNT(maQuyen) AS soluong FROM quyen;";
			
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
