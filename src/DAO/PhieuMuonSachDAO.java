package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import database.JDBCUtil;
import entity.PhieuMuonSach;
import entity.Quyen;
import entity.Sach;
import entity.TaiKhoan;

public class PhieuMuonSachDAO implements DAOInterface<PhieuMuonSach> {

	public static PhieuMuonSachDAO getInstance() {
		return new PhieuMuonSachDAO();
	}
	
	@Override
	public int insert(PhieuMuonSach t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO phieumuonsach(maSach, hinhThucMuon, hoTen, email, soDienThoai, soTienTheChap) VALUES (?,?,?,?,?,?);";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setInt(1, t.getSach().getMaSach());
			pre.setString(2, t.getHinhThucMuon());
			pre.setString(3, t.getHoTen());
			pre.setString(4, t.getEmail());
			pre.setString(5, t.getSoDienThoai());
			pre.setInt(6, t.getSach().getGia());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int insertByTaiKhoan(PhieuMuonSach t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO phieumuonsach(maSach, hinhThucMuon, hoTen, email, soDienThoai, soTienTheChap, maTaiKhoan) VALUES (?,?,?,?,?,?,?);";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setInt(1, t.getSach().getMaSach());
			pre.setString(2, t.getHinhThucMuon());
			pre.setString(3, t.getHoTen());
			pre.setString(4, t.getEmail());
			pre.setString(5, t.getSoDienThoai());
			pre.setInt(6,  t.getSach().getGia());
			pre.setInt(7, t.getTaiKhoan().getMaTaiKhoan());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int delete(PhieuMuonSach t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE FROM phieumuonsach WHERE maPhieuMuon = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setInt(1, t.getMaPhieuMuon());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(PhieuMuonSach t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE phieumuonsach SET ");
			sql.append("trangThai = \"đã trả\", ");
			sql.append("thoiGianTra = ? ");
			sql.append("WHERE maPhieuMuon = ?;");
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			pre.setInt(2,t.getMaPhieuMuon());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<PhieuMuonSach> selectedAll() {
		ArrayList<PhieuMuonSach> list = new ArrayList<PhieuMuonSach>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM phieumuonsach";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				PhieuMuonSach temp = new PhieuMuonSach();
				temp.setMaPhieuMuon(rs.getInt("maPhieuMuon"));
				temp.setHinhThucMuon(rs.getString("hinhThucMuon"));
				temp.setThoiGianMuon(rs.getTimestamp("thoiGianMuon"));
				temp.setThoiGianTra(rs.getTimestamp("thoiGianTra"));
				temp.setTrangThai(rs.getString("trangThai"));
				temp.setThoiGianSuDung(rs.getInt("thoiGianSuDung"));
				temp.setHoTen(rs.getString("hoTen"));
				temp.setEmail(rs.getString("email"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setSoTienTheChap(rs.getInt("soTienTheChap"));
				
				Sach tempSach = new Sach();
				tempSach.setMaSach(rs.getInt("maSach"));
				tempSach = SachDAO.getInstance().selectedById(tempSach);
				temp.setSach(tempSach);
				
				
				list.add(temp);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<PhieuMuonSach> selectedAllDangMuon() {
		ArrayList<PhieuMuonSach> list = new ArrayList<PhieuMuonSach>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM phieumuonsach WHERE trangThai = 'đang mượn'";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				PhieuMuonSach temp = new PhieuMuonSach();
				temp.setMaPhieuMuon(rs.getInt("maPhieuMuon"));
				temp.setHinhThucMuon(rs.getString("hinhThucMuon"));
				temp.setThoiGianMuon(rs.getTimestamp("thoiGianMuon"));
				temp.setThoiGianTra(rs.getTimestamp("thoiGianTra"));
				temp.setTrangThai(rs.getString("trangThai"));
				temp.setThoiGianSuDung(rs.getInt("thoiGianSuDung"));
				temp.setHoTen(rs.getString("hoTen"));
				temp.setEmail(rs.getString("email"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setSoTienTheChap(rs.getInt("soTienTheChap"));
				
				Sach tempSach = new Sach();
				tempSach.setMaSach(rs.getInt("maSach"));
				tempSach = SachDAO.getInstance().selectedById(tempSach);
				temp.setSach(tempSach);
				
				
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
	public PhieuMuonSach selectedById(PhieuMuonSach t) {
		PhieuMuonSach temp = new PhieuMuonSach();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM phieumuonsach WHERE maPhieuMuon = ?";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());
			pre.setInt(1,t.getMaPhieuMuon());
		
			ResultSet rs = pre.executeQuery();
			
			if(rs.next()) {
				temp.setMaPhieuMuon(rs.getInt("maPhieuMuon"));
				temp.setHinhThucMuon(rs.getString("hinhThucMuon"));
				temp.setThoiGianMuon(rs.getTimestamp("thoiGianMuon"));
				temp.setThoiGianTra(rs.getTimestamp("thoiGianTra"));
				temp.setTrangThai(rs.getString("trangThai"));
				temp.setThoiGianSuDung(rs.getInt("thoiGianSuDung"));
				temp.setHoTen(rs.getString("hoTen"));
				temp.setEmail(rs.getString("email"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setSoTienTheChap(rs.getInt("soTienTheChap"));
				
				Sach tempSach = new Sach();
				tempSach.setMaSach(rs.getInt("maSach"));
				tempSach = SachDAO.getInstance().selectedById(tempSach);
				temp.setSach(tempSach);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	public ArrayList<PhieuMuonSach> selectedByTaiKhoan(TaiKhoan tk) {
		ArrayList<PhieuMuonSach> list = new ArrayList<PhieuMuonSach>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM phieumuonsach WHERE maTaiKhoan = ?";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setInt(1, tk.getMaTaiKhoan());
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				PhieuMuonSach temp = new PhieuMuonSach();
				temp.setMaPhieuMuon(rs.getInt("maPhieuMuon"));
				temp.setHinhThucMuon(rs.getString("hinhThucMuon"));
				temp.setThoiGianMuon(rs.getTimestamp("thoiGianMuon"));
				temp.setThoiGianTra(rs.getTimestamp("thoiGianTra"));
				temp.setTrangThai(rs.getString("trangThai"));
				temp.setThoiGianSuDung(rs.getInt("thoiGianSuDung"));
				temp.setHoTen(rs.getString("hoTen"));
				temp.setEmail(rs.getString("email"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setSoTienTheChap(rs.getInt("soTienTheChap"));
				
				Sach tempSach = new Sach();
				tempSach.setMaSach(rs.getInt("maSach"));
				tempSach = SachDAO.getInstance().selectedById(tempSach);
				temp.setSach(tempSach);
					
				
				list.add(temp);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<PhieuMuonSach> selectedByTaiKhoanDangMuon(TaiKhoan tk) {
		ArrayList<PhieuMuonSach> list = new ArrayList<PhieuMuonSach>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM phieumuonsach WHERE maTaiKhoan = ? AND trangThai = 'đang mượn'";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setInt(1, tk.getMaTaiKhoan());
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				PhieuMuonSach temp = new PhieuMuonSach();
				temp.setMaPhieuMuon(rs.getInt("maPhieuMuon"));
				temp.setHinhThucMuon(rs.getString("hinhThucMuon"));
				temp.setThoiGianMuon(rs.getTimestamp("thoiGianMuon"));
				temp.setThoiGianTra(rs.getTimestamp("thoiGianTra"));
				temp.setTrangThai(rs.getString("trangThai"));
				temp.setThoiGianSuDung(rs.getInt("thoiGianSuDung"));
				temp.setHoTen(rs.getString("hoTen"));
				temp.setEmail(rs.getString("email"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setSoTienTheChap(rs.getInt("soTienTheChap"));
				
				Sach tempSach = new Sach();
				tempSach.setMaSach(rs.getInt("maSach"));
				tempSach = SachDAO.getInstance().selectedById(tempSach);
				temp.setSach(tempSach);
					
				
				list.add(temp);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<PhieuMuonSach> selectedInUse(TaiKhoan tk) {
		ArrayList<PhieuMuonSach> list = new ArrayList<PhieuMuonSach>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM phieumuonsach WHERE trangThai = 'đang mượn'";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setInt(1, tk.getMaTaiKhoan());
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				PhieuMuonSach temp = new PhieuMuonSach();
				temp.setMaPhieuMuon(rs.getInt("maPhieuMuon"));
				temp.setHinhThucMuon(rs.getString("hinhThucMuon"));
				temp.setThoiGianMuon(rs.getTimestamp("thoiGianMuon"));
				temp.setThoiGianTra(rs.getTimestamp("thoiGianTra"));
				temp.setTrangThai(rs.getString("trangThai"));
				temp.setThoiGianSuDung(rs.getInt("thoiGianSuDung"));
				temp.setHoTen(rs.getString("hoTen"));
				temp.setEmail(rs.getString("email"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setSoTienTheChap(rs.getInt("soTienTheChap"));
				
				Sach tempSach = new Sach();
				tempSach.setMaSach(rs.getInt("maSach"));
				tempSach = SachDAO.getInstance().selectedById(tempSach);
				temp.setSach(tempSach);
					
				
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
	public ArrayList<PhieuMuonSach> selectedByCondition(String condition) {
		
		return null;
	}

	@Override
	public int quantity() {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT COUNT(maPhieuMuon) AS soluong FROM phieumuonsach;";
			
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
	public int quantityBookInUse() {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT COUNT(maPhieuMuon) AS soluong FROM phieumuonsach WHERE trangThai = \"đang mượn\";";
			
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
