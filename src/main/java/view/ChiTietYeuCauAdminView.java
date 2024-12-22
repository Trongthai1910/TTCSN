package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.PhieuMuonSachDAO;
import DAO.SachDAO;
import DAO.YeuCauMuonTraDAO;
import entity.PhieuMuonSach;
import entity.Sach;
import entity.TaiKhoan;
import entity.YeuCauMuonTra;
import lib.Func;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChiTietYeuCauAdminView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private YeuCauMuonTra yc;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChiTietYeuCauMuonAdminView frame = new ChiTietYeuCauMuonAdminView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ChiTietYeuCauAdminView(YeuCauMuonTra yc) {
		this.yc = yc;
		TaiKhoan tk = yc.getTaiKhoan();
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Chi tiết yêu cầu mượn sách");
		setBounds(100, 100, 715, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chi tiết yêu cầu mượn sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 10, 318, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_AnhSach = new JLabel("");
		lbl_AnhSach.setBounds(44, 67, 143, 198);
		ImageIcon icon = new ImageIcon(yc.getSach().getAnh());
		int labelWidth = lbl_AnhSach.getWidth();
        int labelHeight = lbl_AnhSach.getHeight();
        Image image = icon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        lbl_AnhSach.setIcon(scaledIcon);
		contentPane.add(lbl_AnhSach);
		
		JLabel lbl_TenSach = new JLabel("Sách: "+yc.getSach().getTenSach());
		lbl_TenSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_TenSach.setBounds(208, 67, 415, 30);
		contentPane.add(lbl_TenSach);
		
		JLabel lbl_HoTen = new JLabel("Họ tên: "+yc.getHoTen());
		lbl_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_HoTen.setBounds(208, 158, 415, 30);
		contentPane.add(lbl_HoTen);
		
		JLabel lbl_SoDT = new JLabel("Số điện thoại: "+yc.getSoDienThoai());
		lbl_SoDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_SoDT.setBounds(208, 198, 360, 30);
		contentPane.add(lbl_SoDT);
		
		JLabel lbl_Email = new JLabel("Email: "+yc.getEmail());
		lbl_Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Email.setBounds(208, 238, 360, 30);
		contentPane.add(lbl_Email);
		
		JLabel lbl_TienTheChap = new JLabel("Tiền thế chấp: "+yc.getSach().getGia()+" VND");
		lbl_TienTheChap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_TienTheChap.setBounds(153, 345, 415, 30);
		contentPane.add(lbl_TienTheChap);
		
		JLabel lbl_ThoiGianYeuCau = new JLabel("Thời gian yêu cầu: "+Func.PrintDateTime(yc.getThoiGianYeuCau()));
		lbl_ThoiGianYeuCau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_ThoiGianYeuCau.setBounds(208, 278, 415, 30);
		contentPane.add(lbl_ThoiGianYeuCau);
		
		JButton btn_Tao = new JButton("Tạo phiếu mượn");
		btn_Tao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceptRequest();
			}
		});
		btn_Tao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Tao.setBounds(170, 415, 158, 30);
		contentPane.add(btn_Tao);
		
		JButton btn_Xoa = new JButton("Xóa yêu cầu");
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Xoa.setBounds(359, 415, 158, 30);
		contentPane.add(btn_Xoa);
		
		JLabel lbl_HinhThucMuon = new JLabel("Hình thức mượn: "+yc.getHinhThucMuon());
		lbl_HinhThucMuon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_HinhThucMuon.setBounds(208, 107, 415, 30);
		contentPane.add(lbl_HinhThucMuon);
	}
	public void acceptRequest() {
		
		PhieuMuonSach pms = new PhieuMuonSach();
		pms.setSach(yc.getSach());
		pms.setEmail(yc.getEmail());
		pms.setHoTen(yc.getHoTen());
		pms.setHinhThucMuon(yc.getHinhThucMuon());
		pms.setSoDienThoai(yc.getSoDienThoai());
		
		if (yc.getTaiKhoan().getMaTaiKhoan() == -1) {
			PhieuMuonSachDAO.getInstance().insert(pms);
		}
		else {
			pms.setTaiKhoan(yc.getTaiKhoan());
			PhieuMuonSachDAO.getInstance().insertWithTaiKhoan(pms);
		}
		
		SachDAO.getInstance().minusOne(pms.getSach());
		YeuCauMuonTraDAO.getInstance().delete(yc);
		JOptionPane.showMessageDialog(contentPane, "Đã duyệt yêu cầu thành công");
		setVisible(false);
		
	}
}
