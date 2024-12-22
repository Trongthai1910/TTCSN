package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.PhieuMuonSachDAO;
import entity.PhieuMuonSach;
import lib.Func;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;

public class ChiTietPhieuMuonView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PhieuMuonSach pms;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChiTietPhieuMuonView frame = new ChiTietPhieuMuonView();
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
	public ChiTietPhieuMuonView(PhieuMuonSach pms) {
		this.pms = pms;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Chi tiết phiếu mượn sách");
		setBounds(100, 100, 714, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_AnhSach = new JLabel("");
		lbl_AnhSach.setBounds(39, 124, 177, 230);
		ImageIcon icon = Func.fittedIcon(lbl_AnhSach, new ImageIcon(pms.getSach().getAnh()));
		lbl_AnhSach.setIcon(icon);
        
		contentPane.add(lbl_AnhSach);
		
		JLabel lbl_TenSach = new JLabel("Sách: "+pms.getSach().getTenSach());
		lbl_TenSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_TenSach.setBounds(237, 124, 415, 30);
		contentPane.add(lbl_TenSach);
		
		JLabel lbl_HoTen = new JLabel("Họ tên: "+pms.getHoTen());
		lbl_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_HoTen.setBounds(237, 215, 415, 30);
		contentPane.add(lbl_HoTen);
		
		JLabel lbl_SoDT = new JLabel("Số điện thoại: "+pms.getSoDienThoai());
		lbl_SoDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_SoDT.setBounds(237, 255, 360, 30);
		contentPane.add(lbl_SoDT);
		
		JLabel lbl_Email = new JLabel("Email: "+pms.getEmail());
		lbl_Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Email.setBounds(237, 295, 360, 30);
		contentPane.add(lbl_Email);
		
		JLabel lbl_TienTheChap = new JLabel();
		if (pms.getHinhThucMuon().equals( "Mang đi")) {
			lbl_TienTheChap.setText("Tiền thế chấp: "+pms.getSoTienTheChap()+" VND");
		}
		else {
			lbl_TienTheChap.setText("Tiền thế chấp: 0 VND");
		}
		lbl_TienTheChap.setForeground(new Color(255, 0, 128));
		lbl_TienTheChap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_TienTheChap.setBounds(237, 418, 345, 30);
		contentPane.add(lbl_TienTheChap);
		
		JLabel lbl_ThoiGianYeuCau = new JLabel("Thời gian tạo phiếu: "+Func.PrintDateTime(pms.getThoiGianMuon()));
		lbl_ThoiGianYeuCau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_ThoiGianYeuCau.setBounds(237, 335, 415, 30);
		contentPane.add(lbl_ThoiGianYeuCau);
		
		JLabel lbl_HinhThucMuon = new JLabel("Hình thức mượn: "+pms.getHinhThucMuon());
		lbl_HinhThucMuon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_HinhThucMuon.setBounds(237, 164, 415, 30);
		contentPane.add(lbl_HinhThucMuon);
		
		JLabel lblNewLabel = new JLabel("Chi tiết phiếu mượn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(39, 24, 370, 39);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 73, 623, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Xác nhận trả sách");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirm();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(254, 527, 162, 39);
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(65, 475, 582, 2);
		contentPane.add(separator_1);
		
		JLabel lbl_ThoiGianYeuCau_1 = new JLabel();
		if (pms.getHinhThucMuon().equals( "Mang đi")) {
			lbl_ThoiGianYeuCau_1.setText("Thời gian mượn: 7 ngày");
		}
		else {
			lbl_ThoiGianYeuCau_1.setText("Thời gian mượn: Trong ngày");
		}
		lbl_ThoiGianYeuCau_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_ThoiGianYeuCau_1.setBounds(237, 375, 415, 30);
		contentPane.add(lbl_ThoiGianYeuCau_1);
		
//		JLabel lblNewLabel_1 = new JLabel("Số tiền hoàn trả lại: ");
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblNewLabel_1.setBounds(65, 487, 344, 26);
//		contentPane.add(lblNewLabel_1);
	}
	private void confirm() {
		int re = JOptionPane.showConfirmDialog(contentPane, "Xác nhận trả","Xác nhận",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(re == JOptionPane.YES_OPTION ) {
			PhieuMuonSachDAO.getInstance().update(pms);
			JOptionPane.showMessageDialog(contentPane, "Đã xác nhận trả sách");
			setVisible(false);
		}
	}
}
