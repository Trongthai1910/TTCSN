package entity;

import java.util.List;

public class Quyen {
	private int maQuyen;
	private String tenQuyen;
	private List<TaiKhoan> taiKhoan;
	
	public Quyen() {
	}

	public Quyen(int maQuyen, String tenQuyen, List<TaiKhoan> taiKhoan) {
		this.maQuyen = maQuyen;
		this.tenQuyen = tenQuyen;
		this.taiKhoan = taiKhoan;
	}
	public Quyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}
	public int getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public List<TaiKhoan> getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(List<TaiKhoan> taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Override
	public String toString() {
		return "Quyen [maQuyen=" + maQuyen + ", tenQuyen=" + tenQuyen + ", taiKhoan=" + taiKhoan + "]";
	}
	
}
