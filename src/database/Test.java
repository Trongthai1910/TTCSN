package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import DAO.*;
import entity.*;

import view.*;

public class Test {
	public static void main(String[] args) {
//		PhieuMuonSach pms = new PhieuMuonSach(25);
//		pms = PhieuMuonSachDAO.getInstance().selectedById(pms);
//		System.out.println(pms);
//		PhieuMuonSachDAO.getInstance().update(pms);
//		
//		pms = PhieuMuonSachDAO.getInstance().selectedById(pms);
//		System.out.println(pms);
		
		int m = SachDAO.getInstance().quantity();
		System.out.println(m);
		
	}
	private static void check(YeuCauMuonTra yc) {
		if (yc.getTaiKhoan().getMaTaiKhoan() == -1) {
			System.out.println("No account");
		}
		else {
			TaiKhoan tk = TaiKhoanDAO.getInstance().selectedById(yc.getTaiKhoan());
			System.out.println(tk);
		}
	}
}
