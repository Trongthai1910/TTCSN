package entity;

import java.sql.Date;
import java.sql.Timestamp;

public class PhieuMuonSach {
	private int maPhieuMuon;
	private String hinhThucMuon;
	private Timestamp thoiGianMuon;
	private Timestamp thoiGianTra;
	private int thoiGianSuDung;
	private String trangThai;
	private int soTienTheChap;
	private String hoTen;
	private String soDienThoai;
	private String email;
	private Sach sach;
	private TaiKhoan taiKhoan;
	
	public PhieuMuonSach() {
	}

	
	public PhieuMuonSach(int maPhieuMuon, String hinhThucMuon, Timestamp thoiGianMuon, Timestamp thoiGianTra,
			int thoiGianSuDung, String trangThai, int soTienTheChap, String hoTen, String soDienThoai,
			String email, Sach sach, TaiKhoan taiKhoan) {
		this.maPhieuMuon = maPhieuMuon;
		this.hinhThucMuon = hinhThucMuon;
		this.thoiGianMuon = thoiGianMuon;
		this.thoiGianTra = thoiGianTra;
		this.thoiGianSuDung = thoiGianSuDung;
		this.trangThai = trangThai;
		this.soTienTheChap = soTienTheChap;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.sach = sach;
		this.taiKhoan = taiKhoan;
	}
	public PhieuMuonSach(int maPhieuMuon) {
		this.maPhieuMuon = maPhieuMuon;
	}

	public int getMaPhieuMuon() {
		return maPhieuMuon;
	}

	public void setMaPhieuMuon(int maPhieuMuon) {
		this.maPhieuMuon = maPhieuMuon;
	}

	public String getHinhThucMuon() {
		return hinhThucMuon;
	}

	public void setHinhThucMuon(String hinhThucMuon) {
		this.hinhThucMuon = hinhThucMuon;
	}

	public Timestamp getThoiGianMuon() {
		return thoiGianMuon;
	}

	public void setThoiGianMuon(Timestamp thoiGianMuon) {
		this.thoiGianMuon = thoiGianMuon;
	}

	public Timestamp getThoiGianTra() {
		return thoiGianTra;
	}

	public void setThoiGianTra(Timestamp thoiGianTra) {
		this.thoiGianTra = thoiGianTra;
	}

	public int getThoiGianSuDung() {
		return thoiGianSuDung;
	}

	public void setThoiGianSuDung(int thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public int getSoTienTheChap() {
		return soTienTheChap;
	}

	public void setSoTienTheChap(int soTienTheChap) {
		this.soTienTheChap = soTienTheChap;
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


	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}


	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	
	@Override
	public String toString() {
		return "maPhieuMuon=" + maPhieuMuon + ", hinhThucMuon=" + hinhThucMuon + ", thoiGianMuon="
				+ thoiGianMuon + ", thoiGianTra=" + thoiGianTra + ", thoiGianSuDung=" + thoiGianSuDung + ", trangThai="
				+ trangThai + ", soTienTheChap=" + soTienTheChap + ", hoTen=" + hoTen
				+ ", soDienThoai=" + soDienThoai + ", email=" + email;
	}

	
}
