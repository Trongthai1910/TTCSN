package entity;

import java.util.List;

public class TheLoai {
	private int maTheLoai;
	private String tenTheLoai;
	private List<Sach> sach;
	public TheLoai(int maTheLoai, String tenTheLoai, List<Sach> sach) {
		this.maTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
		this.sach = sach;
	}
	public TheLoai() {
	}
	public TheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	public int getMaTheLoai() {
		return maTheLoai;
	}
	public void setMaTheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	public List<Sach> getSach() {
		return sach;
	}
	public void setSach(List<Sach> sach) {
		this.sach = sach;
	}
	@Override
	public String toString() {
		return "TheLoai [maTheLoai=" + maTheLoai + ", tenTheLoai=" + tenTheLoai + ", sach=" + sach + "]";
	}
	
}
