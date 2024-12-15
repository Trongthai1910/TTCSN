package DAO;

import entity.Quyen;
import entity.TaiKhoan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Timestamp;

import database.JDBCUtil;
import entity.TaiKhoan;

public class TaiKhoanDAO implements DAOInterface<TaiKhoan> {
	
	public static TaiKhoanDAO getInstance() {
		return new TaiKhoanDAO();
	}

	@Override
	public int insert(TaiKhoan t) { //hàm tạo 1 tài khoản mới (uc đăng ký)
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO taikhoan(tenTaiKhoan,matKhau,hoTen,email,soDienThoai) VALUES (?,MD5(?),?,?,?);";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setString(1, t.getTenTaiKhoan());
			pre.setString(2, t.getMatKhau());
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

	@Override
	public int delete(TaiKhoan t) { //xóa mềm một tk theo mã tk
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE taikhoan SET xoa = 1 WHERE maTaiKhoan = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setInt(1, t.getMaTaiKhoan());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(TaiKhoan t) { //sửa thông tin tk theo tên
		try {
			Connection con = JDBCUtil.getConnection();
			
			StringBuilder sql = new StringBuilder(); 
			sql.append("UPDATE taikhoan SET ");
			sql.append("hoTen = ?, ");
			sql.append("email = ?, ");
			sql.append("soDienThoai = ?, ");
			sql.append("ngaySinh = ?, ");
			sql.append("diaChi = ? ");
			sql.append("WHERE tenTaiKhoan = ?;");
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setString(1, t.getHoTen());
			pre.setString(2, t.getEmail());
			pre.setString(3, t.getSoDienThoai());
			pre.setDate(4, t.getNgaySinh());
			pre.setString(5, t.getDiaChi());
			pre.setString(6, t.getTenTaiKhoan());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<TaiKhoan> selectedAll() { //duyệt tất cả
		ArrayList<TaiKhoan> list = new ArrayList<TaiKhoan>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM TaiKhoan WHERE xoa = 0";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				TaiKhoan temp = new TaiKhoan();
				temp.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
				temp.setTenTaiKhoan(rs.getString("tenTaiKhoan"));
				temp.setHoTen(rs.getString("hoTen"));
				temp.setMatKhau(rs.getString("matKhau"));
				temp.setEmail(rs.getString("email"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setNgaySinh(rs.getDate("ngaySinh"));
				temp.setDiaChi(rs.getString("diaChi"));
				
				Quyen quyen = new Quyen();
				quyen.setMaQuyen(rs.getInt("maQuyen"));
				temp.setQuyen(quyen);
				list.add(temp);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<TaiKhoan> selectedAllUser() { //duyệt tất cả tài khoản quyền người đọc
		ArrayList<TaiKhoan> list = new ArrayList<TaiKhoan>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM TaiKhoan WHERE maQuyen <> 1 AND xoa = 0";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				TaiKhoan temp = new TaiKhoan();
				temp.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
				temp.setTenTaiKhoan(rs.getString("tenTaiKhoan"));
				temp.setHoTen(rs.getString("hoTen"));
				temp.setMatKhau(rs.getString("matKhau"));
				temp.setEmail(rs.getString("email"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setNgaySinh(rs.getDate("ngaySinh"));
				temp.setDiaChi(rs.getString("diaChi"));
				
				Quyen quyen = new Quyen();
				quyen.setMaQuyen(rs.getInt("maQuyen"));
				temp.setQuyen(quyen);
				list.add(temp);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean existedName(TaiKhoan t) { //kiểm tra tên tài khoản đã tồn tại chưa
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM TaiKhoan WHERE tenTaiKhoan = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setString(1,t.getTenTaiKhoan());
			
			ResultSet rs = pre.executeQuery();
			
			if (rs.next()) {
				return true;
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkAccount(TaiKhoan t) { //kiểm tra đăng nhập (uc đăng nhập)
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT tenTaiKhoan, matKhau FROM TaiKhoan WHERE tenTaiKhoan = ? AND matKhau = MD5(?) AND xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setString(1,t.getTenTaiKhoan());
			pre.setString(2,t.getMatKhau());
			
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				return true;
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public TaiKhoan searchByName(TaiKhoan t) { //tìm kiếm theo tên tài khoản
		TaiKhoan tk = new TaiKhoan();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM TaiKhoan WHERE tenTaiKhoan = ? AND xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setString(1,t.getTenTaiKhoan());
			
			ResultSet rs = pre.executeQuery();
			
			if (rs.next()) {
				tk.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
				tk.setTenTaiKhoan(rs.getString("tenTaiKhoan"));
				tk.setMatKhau(rs.getString("matKhau"));
				tk.setEmail(rs.getString("email"));
				tk.setSoDienThoai(rs.getString("soDienThoai"));
				tk.setNgaySinh(rs.getDate("ngaySinh"));
				tk.setDiaChi(rs.getString("diaChi"));
				tk.setHoTen(rs.getString("hoTen"));
				
				Quyen quyen = new Quyen();
				quyen.setMaQuyen(rs.getInt("maQuyen"));
				quyen = QuyenDAO.getInstance().selectedById(quyen);
				tk.setQuyen(quyen);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tk;
	}
	
	@Override
	public TaiKhoan selectedById(TaiKhoan t) { //trả về tài khoản theo Id
		TaiKhoan tk = new TaiKhoan();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM TaiKhoan WHERE maTaiKhoan = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setInt(1,t.getMaTaiKhoan());
			
			ResultSet rs = pre.executeQuery();
			
			if (rs.next()) {
				tk.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
				tk.setTenTaiKhoan(rs.getString("tenTaiKhoan"));
				tk.setMatKhau(rs.getString("matKhau"));
				tk.setEmail(rs.getString("email"));
				tk.setSoDienThoai(rs.getString("soDienThoai"));
				tk.setNgaySinh(rs.getDate("ngaySinh"));
				tk.setDiaChi(rs.getString("diaChi"));
				tk.setHoTen(rs.getString("hoTen"));
				
				Quyen quyen = new Quyen();
				quyen.setMaQuyen(rs.getInt("maQuyen"));
				tk.setQuyen(quyen);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tk;
	}

	@Override
	public ArrayList<TaiKhoan> selectedByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public int quantity() { //trả về số lượng tài khoản người đọc
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT COUNT(maTaiKhoan) AS soluong FROM taikhoan WHERE xoa = 0 AND maQuyen = 2;";
			
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
