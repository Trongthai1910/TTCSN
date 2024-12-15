package entity;

import java.util.List;

public class Sach {
	private int maSach;
	private String tenSach;
	private String anh;
	private String tenTacGia;
	private String quocGia;
	private int soLuongConLai;
	private String moTa;
	private TheLoai theLoai;
	private int gia;
	private List<PhieuMuonSach> phieuMuonSach;
	private List<YeuCauMuonTra> yeuCauMuonTra;
	
	public Sach() {
	}

	public Sach(int maSach, String tenSach, String anh, String tenTacGia, String quocGia, int soLuongConLai, String moTa, TheLoai theLoai, int gia, List<PhieuMuonSach> phieuMuonSach, List<YeuCauMuonTra> yeuCauMuonTra) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.anh = anh;
		this.tenTacGia = tenTacGia;
		this.quocGia = quocGia;
		this.soLuongConLai = soLuongConLai;
		this.moTa = moTa;
		this.theLoai = theLoai;
		this.gia = gia;
		this.phieuMuonSach = phieuMuonSach;
		this.yeuCauMuonTra = yeuCauMuonTra;
	}
	public Sach(int maSach) {
		this.maSach = maSach;
	}
	public Sach(String tenSach) {
		this.tenSach = tenSach;
	}

	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public int getSoLuongConLai() {
		return soLuongConLai;
	}

	public void setSoLuongConLai(int soLuongConLai) {
		this.soLuongConLai = soLuongConLai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public TheLoai getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
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
	
	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	@Override
	public String toString() {
		return "maSach=" + maSach + ", tenSach=" + tenSach + ", anh=" + anh + ", tenTacGia=" + tenTacGia
				+ ", quocGia=" + quocGia + ", soLuongConLai=" + soLuongConLai + ", moTa=" + moTa + ", theLoai="
				+ theLoai.getMaTheLoai() + ", gia=" + gia;
	}
	
}
