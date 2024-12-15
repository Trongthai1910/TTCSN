package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import database.JDBCUtil;
import entity.Quyen;
import entity.Sach;
import entity.TaiKhoan;
import entity.TheLoai;
import entity.YeuCauMuonTra;

public class YeuCauMuonTraDAO implements DAOInterface<YeuCauMuonTra> {

	public static YeuCauMuonTraDAO getInstance() {
		return new YeuCauMuonTraDAO();
	}
	
	@Override
	public int insert(YeuCauMuonTra t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO yeucaumuontra(hinhThucMuon, maSach, hoTen, email, soDienThoai) VALUES (?,?,?,?,?);";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setString(1, t.getHinhThucMuon());
			pre.setInt(2, t.getSach().getMaSach());
			pre.setString(3, t.getHoTen());
			pre.setString(4, t.getEmail());
			pre.setString(5, t.getSoDienThoai());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int insertByTaiKhoan(YeuCauMuonTra t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO yeucaumuontra(hinhThucMuon, maSach, hoTen, email, soDienThoai, maTaiKhoan) VALUES (?,?,?,?,?,?);";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setString(1, t.getHinhThucMuon());
			pre.setInt(2, t.getSach().getMaSach());
			pre.setString(3, t.getHoTen());
			pre.setString(4, t.getEmail());
			pre.setString(5, t.getSoDienThoai());
			pre.setInt(6, t.getTaiKhoan().getMaTaiKhoan());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int delete(YeuCauMuonTra t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE FROM yeucaumuontra WHERE mayeucau = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setInt(1, t.getMaYeuCau());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(YeuCauMuonTra t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE yeucaumuontra SET ");
			sql.append("tinhTrang = 'đã duyệt' ");
			sql.append("WHERE maYeuCau = ?;");
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setInt(1,t.getMaYeuCau());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<YeuCauMuonTra> selectedAll() {
		ArrayList<YeuCauMuonTra> list = new ArrayList<YeuCauMuonTra>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM yeucaumuontra";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				YeuCauMuonTra yc = new YeuCauMuonTra();
				yc.setMaYeuCau(rs.getInt("maYeuCau"));
				yc.setHinhThucMuon(rs.getString("hinhThucMuon"));
				yc.setThoiGianYeuCau(rs.getTimestamp("thoiGianYeuCau"));
				yc.setTinhTrang(rs.getString("tinhTrang"));
				yc.setHoTen(rs.getString("hoTen"));
				yc.setEmail(rs.getString("email"));
				yc.setSoDienThoai(rs.getString("soDienThoai"));
				
				Sach s = new Sach();
				s.setMaSach(rs.getInt("maSach"));
				s = SachDAO.getInstance().selectedById(s);
				yc.setSach(s);
				
				TaiKhoan tk = new TaiKhoan();
				tk.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
				yc.setTaiKhoan(tk);
				
				list.add(yc);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public YeuCauMuonTra selectedById(YeuCauMuonTra t) {
		YeuCauMuonTra yc = new YeuCauMuonTra();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM yeucaumuontra WHERE maYeuCau = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setInt(1, t.getMaYeuCau());
		
			ResultSet rs = pre.executeQuery();
			
			if(rs.next()) {
				yc.setMaYeuCau(rs.getInt("maYeuCau"));
				yc.setHinhThucMuon(rs.getString("hinhThucMuon"));
				yc.setThoiGianYeuCau(rs.getTimestamp("thoiGianYeuCau"));
				yc.setTinhTrang(rs.getString("tinhTrang"));
				yc.setHoTen(rs.getString("hoTen"));
				yc.setEmail(rs.getString("email"));
				yc.setSoDienThoai(rs.getString("soDienThoai"));
				
				Sach s = new Sach();
				s.setMaSach(rs.getInt("maSach"));
				s = SachDAO.getInstance().selectedById(s);
				yc.setSach(s);
				
				TaiKhoan tk = new TaiKhoan();
				tk.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
				yc.setTaiKhoan(tk);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yc;
	}

	@Override
	public ArrayList<YeuCauMuonTra> selectedByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean checkExistedAccount(YeuCauMuonTra yc) {
		return yc.getTaiKhoan() == null;
	}
	@Override
	public int quantity() {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT COUNT(maYeuCau) AS soluong FROM yeucaumuontra;";
			
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
