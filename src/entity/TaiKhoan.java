package entity;

import java.sql.Date;
import java.util.List;

public class TaiKhoan {
	private int maTaiKhoan;
	private String tenTaiKhoan;
	private String matKhau;
	private String hoTen;
	private String email;
	private String soDienThoai;
	private Date ngaySinh;
	private String diaChi;
	private Quyen quyen;
	private List<PhieuMuonSach> phieuMuonSach;
	private List<YeuCauMuonTra> yeuCauMuonTra;
	

	public TaiKhoan() {
	}
	public TaiKhoan(int maTaiKhoan, String tenTaiKhoan, String matKhau, String hoTen, String email, String soDienThoai,
			Date ngaySinh, String diaChi, Quyen quyen, List<PhieuMuonSach> phieuMuonSach,
			List<YeuCauMuonTra> yeuCauMuonTra) {
		this.maTaiKhoan = maTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.quyen = quyen;
		this.phieuMuonSach = phieuMuonSach;
		this.yeuCauMuonTra = yeuCauMuonTra;
	}
	public TaiKhoan(String tenTaiKhoan, String matKhau) {
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}
	public TaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}
	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Quyen getQuyen() {
		return quyen;
	}
	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}
	public List<PhieuMuonSach> getPhieuMuonSach() {
		return phieuMuonSach;
	}
	public void setPhieuMuonSach(List<PhieuMuonSach> phieuMuonSach) {
		this.phieuMuonSach = phieuMuonSach;
	}
	public List<YeuCauMuonTra> getYeuCauMuonTra() {
		return yeuCauMuonTra;
	}
	public void setYeuCauMuonTra(List<YeuCauMuonTra> yeuCauMuonTra) {
		this.yeuCauMuonTra = yeuCauMuonTra;
	}
	@Override
	public String toString() {
		return "Mã: " + maTaiKhoan + ", tên tk: " + tenTaiKhoan + ", mk: " + matKhau
				+ " họ tên: " + hoTen + ", email: " + email + ", số dt: " + soDienThoai + ", ngày sinh: " + ngaySinh + ", địa chỉ: " + diaChi
				+ ", mã quyền: " + quyen.getMaQuyen();
	}	
	
}
