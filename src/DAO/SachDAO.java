package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import entity.Quyen;
import entity.Sach;
import entity.TaiKhoan;
import entity.TheLoai;

public class SachDAO implements DAOInterface<Sach> {
	
	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int insert(Sach t) { //thêm sách
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO sach(tenSach,anh,tenTacGia,quocGia,maTheLoai,soLuongConLai,moTa,gia) VALUES (?,?,?,?,?,?,?,?);";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setString(1, t.getTenSach());
			pre.setString(2,t.getAnh());
			pre.setString(3, t.getTenTacGia());
			pre.setString(4, t.getQuocGia());
			pre.setInt(5,t.getTheLoai().getMaTheLoai());
			pre.setInt(6, t.getSoLuongConLai());
			pre.setString(7, t.getMoTa());
			pre.setInt(8, t.getGia());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Sach t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE sach SET xoa = 1 WHERE tenSach = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql);		
			pre.setString(1, t.getTenSach());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Sach t) { //update theo mã sách
		try {
			Connection con = JDBCUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE sach SET ");
			sql.append("tenSach = ?, ");
			sql.append("anh = ?, ");
			sql.append("tenTacGia = ?, ");
			sql.append("quocGia = ?, ");
			sql.append("soLuongConLai = ?, ");
			sql.append("moTa = ?, ");
			sql.append("maTheLoai = ?, ");
			sql.append("gia = ? ");
			sql.append("WHERE maSach = ?;");
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setString(1, t.getTenSach());
			pre.setString(2,t.getAnh());
			pre.setString(3, t.getTenTacGia());
			pre.setString(4, t.getQuocGia());
			pre.setInt(5, t.getSoLuongConLai());
			pre.setString(6, t.getMoTa());
			pre.setInt(7, t.getTheLoai().getMaTheLoai());
			pre.setInt(8, t.getGia());
			pre.setInt(9, t.getMaSach());
			
			int check = pre.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Sach> selectedAll() { //duyệt danh sách sách
		ArrayList<Sach> list = new ArrayList<Sach>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM sach WHERE xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				Sach temp = new Sach();
				temp.setMaSach(rs.getInt("maSach"));
				temp.setTenSach(rs.getString("tenSach"));
				temp.setAnh(rs.getString("anh"));
				temp.setTenTacGia(rs.getString("tenTacGia"));
				temp.setQuocGia(rs.getString("quocGia"));
				temp.setSoLuongConLai(rs.getInt("soLuongConLai"));
				temp.setMoTa(rs.getString("moTa"));
				
				TheLoai theLoai = new TheLoai();
				theLoai.setMaTheLoai(rs.getInt("maTheLoai"));
				theLoai = TheLoaiDAO.getInstance().selectedById(theLoai);
				
				temp.setGia(rs.getInt("gia"));
				
				temp.setTheLoai(theLoai);
				list.add(temp);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void minusOne(Sach t) { //trừ một quyển sách theo id
		t = SachDAO.getInstance().selectedById(t);
		t.setSoLuongConLai(t.getSoLuongConLai()-1);
		SachDAO.getInstance().update(t);
	}
	
	public Sach searchByName(Sach t) {
		Sach s = new Sach();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM sach WHERE tenSach = ? AND xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setString(1,t.getTenSach());
			
			ResultSet rs = pre.executeQuery();
			
			if (rs.next()) {
				s.setMaSach(rs.getInt("maSach"));
				s.setTenSach(rs.getString("tenSach"));
				s.setAnh(rs.getString("anh"));
				s.setTenTacGia(rs.getString("tenTacGia"));
				s.setQuocGia(rs.getString("quocGia"));
				s.setSoLuongConLai(rs.getInt("soLuongConlai"));
				s.setMoTa(rs.getString("moTa"));
				
				TheLoai theLoai = new TheLoai();
				theLoai.setMaTheLoai(rs.getInt("maTheLoai"));
				theLoai = TheLoaiDAO.getInstance().selectedById(theLoai);
				s.setTheLoai(theLoai);
				
				s.setGia(rs.getInt("gia"));
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	@Override
	public Sach selectedById(Sach t) { //lấy sách theo ID
		Sach s = new Sach();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM sach WHERE maSach = ? AND xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setInt(1,t.getMaSach());
			
			ResultSet rs = pre.executeQuery();
			
			if (rs.next()) {
				s.setMaSach(rs.getInt("maSach"));
				s.setTenSach(rs.getString("tenSach"));
				s.setAnh(rs.getString("anh"));
				s.setTenTacGia(rs.getString("TenTacGia"));
				s.setQuocGia(rs.getString("quocGia"));
				s.setSoLuongConLai(rs.getInt("soLuongConlai"));
				s.setMoTa(rs.getString("moTa"));
				
				TheLoai theLoai = new TheLoai();
				theLoai.setMaTheLoai(rs.getInt("maTheLoai"));
				theLoai = TheLoaiDAO.getInstance().selectedById(theLoai);
				s.setTheLoai(theLoai);
				
				s.setGia(rs.getInt("gia"));
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public boolean existedName(Sach t) { //kiểm tra tên sách đã tồn tại chưa
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM sach WHERE tenSach = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setString(1,t.getTenSach());
			
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
	public ArrayList<Sach> selectedByPartName(String str) { //tìm theo một phần tên
		ArrayList<Sach> list = new ArrayList<Sach>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM sach WHERE tenSach LIKE ? AND xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());	
			pre.setString(1,"%"+str+"%");
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				Sach temp = new Sach();
				temp.setMaSach(rs.getInt("maSach"));
				temp.setTenSach(rs.getString("tenSach"));
				temp.setAnh(rs.getString("anh"));
				temp.setTenTacGia(rs.getString("tenTacGia"));
				temp.setQuocGia(rs.getString("quocGia"));
				temp.setSoLuongConLai(rs.getInt("soLuongConLai"));
				temp.setMoTa(rs.getString("moTa"));
				
				TheLoai theLoai = new TheLoai();
				theLoai.setMaTheLoai(rs.getInt("maTheLoai"));
				theLoai = TheLoaiDAO.getInstance().selectedById(theLoai);
				
				temp.setGia(rs.getInt("gia"));
				
				temp.setTheLoai(theLoai);
				list.add(temp);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Sach> selectedByPartNameAndGen(String str, String tl) { //tìm theo một phần tên và thể loại
		ArrayList<Sach> list = new ArrayList<Sach>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM sach WHERE tenSach LIKE ? AND maTheLoai = ? AND xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());	
			pre.setString(1,"%"+str+"%");
			pre.setString(2, tl);
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				Sach temp = new Sach();
				temp.setMaSach(rs.getInt("maSach"));
				temp.setTenSach(rs.getString("tenSach"));
				temp.setAnh(rs.getString("anh"));
				temp.setTenTacGia(rs.getString("tenTacGia"));
				temp.setQuocGia(rs.getString("quocGia"));
				temp.setSoLuongConLai(rs.getInt("soLuongConLai"));
				temp.setMoTa(rs.getString("moTa"));
				
				TheLoai theLoai = new TheLoai();
				theLoai.setMaTheLoai(rs.getInt("maTheLoai"));
				theLoai = TheLoaiDAO.getInstance().selectedById(theLoai);
				
				temp.setGia(rs.getInt("gia"));
				
				temp.setTheLoai(theLoai);
				list.add(temp);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Sach> selectedByGen(String str, String tl) { //tìm theo một phần tên và thể loại
		ArrayList<Sach> list = new ArrayList<Sach>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM sach WHERE maTheLoai = ? AND xoa = 0;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());	
			pre.setString(1,"%"+str+"%");
			pre.setString(2, tl);
		
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				Sach temp = new Sach();
				temp.setMaSach(rs.getInt("maSach"));
				temp.setTenSach(rs.getString("tenSach"));
				temp.setAnh(rs.getString("anh"));
				temp.setTenTacGia(rs.getString("tenTacGia"));
				temp.setQuocGia(rs.getString("quocGia"));
				temp.setSoLuongConLai(rs.getInt("soLuongConLai"));
				temp.setMoTa(rs.getString("moTa"));
				
				TheLoai theLoai = new TheLoai();
				theLoai.setMaTheLoai(rs.getInt("maTheLoai"));
				theLoai = TheLoaiDAO.getInstance().selectedById(theLoai);
				
				temp.setGia(rs.getInt("gia"));
				
				temp.setTheLoai(theLoai);
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
	public ArrayList<Sach> selectedByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int quantity() {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT COUNT(maSach) AS soluong FROM sach WHERE xoa = 0;";
			
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
	public int quantityBook() {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT SUM(soLuongConLai) AS soluong FROM sach WHERE xoa = 0;";
			
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
	public int quantityByTheLoai(TheLoai tl) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT COUNT(maSach) AS soluong FROM sach WHERE xoa = 0 AND maTheLoai = ?;";
			
			PreparedStatement pre = con.prepareStatement(sql.toString());		
			pre.setInt(1,tl.getMaTheLoai());
			
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
