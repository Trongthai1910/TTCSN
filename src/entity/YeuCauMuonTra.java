package entity;

import java.sql.Date;
import java.sql.Timestamp;

public class YeuCauMuonTra {
	private int maYeuCau;
	private String hinhThucMuon;
	private Timestamp thoiGianYeuCau;
	private String tinhTrang;
	private String hoTen;
	private String soDienThoai;
	private String email;
	private Sach sach;
	private TaiKhoan taiKhoan;
	
	public YeuCauMuonTra() {
	}
	public YeuCauMuonTra(int maYeuCau, String hinhThucMuon, Timestamp thoiGianYeuCau, String tinhTrang, String hoTen,
			String soDienThoai, String email, Sach sach, TaiKhoan taiKhoan) {
		super();
		this.maYeuCau = maYeuCau;
		this.hinhThucMuon = hinhThucMuon;
		this.thoiGianYeuCau = thoiGianYeuCau;
		this.tinhTrang = tinhTrang;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.sach = sach;
		this.taiKhoan = taiKhoan;
	}
	public YeuCauMuonTra(int maYeuCau) {
		this.maYeuCau = maYeuCau;
	}


	public int getMaYeuCau() {
		return maYeuCau;
	}

	public void setMaYeuCau(int maYeuCau) {
		this.maYeuCau = maYeuCau;
	}

	public String getHinhThucMuon() {
		return hinhThucMuon;
	}

	public void setHinhThucMuon(String hinhThucMuon) {
		this.hinhThucMuon = hinhThucMuon;
	}

	public Timestamp getThoiGianYeuCau() {
		return thoiGianYeuCau;
	}

	public void setThoiGianYeuCau(Timestamp thoiGianYeuCau) {
		this.thoiGianYeuCau = thoiGianYeuCau;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	@Override
	public String toString() {
		return "maYeuCau=" + maYeuCau + ", hinhThucMuon=" + hinhThucMuon + ", thoiGianYeuCau="
				+ thoiGianYeuCau + ", tinhTrang=" + tinhTrang + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + ", sach=" + sach.getTenSach() + ", maTaiKhoan = "+taiKhoan.getMaTaiKhoan();
	}
}
