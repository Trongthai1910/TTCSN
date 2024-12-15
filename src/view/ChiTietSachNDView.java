package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.YeuCauMuonTraDAO;
import entity.Sach;
import entity.TaiKhoan;
import entity.TheLoai;
import entity.YeuCauMuonTra;
import lib.Func;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;

public class ChiTietSachNDView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea ta_MoTa;
	private JLabel lbl_TenSach; 
	private JLabel lbl_TenTacGia;
	private JLabel lbl_TheLoai;
	private JLabel lbl_SoLuongConLai;
	private JLabel lbl_HinhAnh;
	private JLabel lbl_Gia;
	
	private TaiKhoan taiKhoan;
	private Sach sach;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChiTietSachView frame = new ChiTietSachView();
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
	public ChiTietSachNDView(TaiKhoan taiKhoan, Sach sach) {
		this.taiKhoan = taiKhoan;
		this.sach = sach;
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 593);
		setTitle("Chi tiết cuốn sách");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_HinhAnh = new JLabel();
		lbl_HinhAnh.setBounds(31, 115, 200, 259);
		lbl_HinhAnh.setIcon(Func.fittedIcon(lbl_HinhAnh, new ImageIcon(sach.getAnh())));;
		contentPane.add(lbl_HinhAnh);
		
		JLabel lblNewLabel = new JLabel("Thông tin chi tiết về cuốn sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 10, 355, 37);
		contentPane.add(lblNewLabel);
		
		lbl_TenSach = new JLabel(sach.getTenSach());
		lbl_TenSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_TenSach.setBounds(32, 69, 433, 36);
		contentPane.add(lbl_TenSach);
		
		lbl_TenTacGia = new JLabel("Tác giả: "+sach.getTenTacGia());
		lbl_TenTacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_TenTacGia.setBounds(270, 115, 276, 30);
		contentPane.add(lbl_TenTacGia);
		
		lbl_TheLoai = new JLabel("Thể loại: "+sach.getTheLoai().getTenTheLoai());
		lbl_TheLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_TheLoai.setBounds(270, 155, 276, 30);
		contentPane.add(lbl_TheLoai);
		
		JLabel lbl_QuocGia = new JLabel("Quốc gia: "+sach.getQuocGia());
		lbl_QuocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_QuocGia.setBounds(270, 195, 221, 30);
		contentPane.add(lbl_QuocGia);
		
		ta_MoTa = new JTextArea(sach.getMoTa());
		ta_MoTa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ta_MoTa.setLineWrap(true); // Thiết lập để wrap dòng
		ta_MoTa.setWrapStyleWord(true); // Wrap từng từ
		ta_MoTa.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(ta_MoTa);
		scrollPane.setBounds(270, 287, 221, 87);
		contentPane.add(scrollPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 57, 455, 2);
		contentPane.add(separator);
		
		lbl_SoLuongConLai = new JLabel("Số lượng còn lại: "+sach.getSoLuongConLai());
		lbl_SoLuongConLai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_SoLuongConLai.setBounds(270, 235, 221, 30);
		contentPane.add(lbl_SoLuongConLai);
		
		lbl_Gia = new JLabel("Giá: " + sach.getGia() + " VND");
		lbl_Gia.setForeground(new Color(255, 0, 128));
		lbl_Gia.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl_Gia.setBounds(270, 403, 221, 30);
		contentPane.add(lbl_Gia);
		
		JButton btnNewButton = new JButton("Yêu cầu mượn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayForm();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(290, 479, 139, 37);
		contentPane.add(btnNewButton);
		
		JButton btnVTrangCh = new JButton("Về trang chủ");
		btnVTrangCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVTrangCh.setBounds(123, 479, 139, 37);
		contentPane.add(btnVTrangCh);
		
		
	}
	private void displayForm() {
		FormYeuCauNDView f = new FormYeuCauNDView(sach,taiKhoan);
		f.setVisible(true);
	}
}
