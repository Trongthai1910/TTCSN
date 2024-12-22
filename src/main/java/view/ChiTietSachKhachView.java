package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import entity.Sach;
import lib.Func;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChiTietSachKhachView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Sach s;
	private JTextArea ta_MoTa;
	private JLabel lbl_TenSach; 
	private JLabel lbl_TenTacGia;
	private JLabel lbl_TheLoai;
	private JLabel lbl_SoLuongConLai;
	private JLabel lbl_HinhAnh;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChiTietSachKhachView frame = new ChiTietSachKhachView();
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
	public ChiTietSachKhachView(Sach s) {
		this.s = s;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 557);
		setTitle("Chi tiết cuốn sách");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_HinhAnh = new JLabel();
		lbl_HinhAnh.setBounds(31, 115, 233, 312);
		lbl_HinhAnh.setIcon(Func.fittedIcon(lbl_HinhAnh, new ImageIcon(s.getAnh())));;
		contentPane.add(lbl_HinhAnh);
		
		JLabel lblNewLabel = new JLabel("Thông tin chi tiết về cuốn sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 10, 355, 37);
		contentPane.add(lblNewLabel);
		
		lbl_TenSach = new JLabel(s.getTenSach());
		lbl_TenSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_TenSach.setBounds(32, 69, 433, 36);
		contentPane.add(lbl_TenSach);
		
		lbl_TenTacGia = new JLabel("Tác giả: "+s.getTenTacGia());
		lbl_TenTacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_TenTacGia.setBounds(305, 115, 221, 30);
		contentPane.add(lbl_TenTacGia);
		
		lbl_TheLoai = new JLabel("Thể loại: "+s.getTheLoai().getTenTheLoai());
		lbl_TheLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_TheLoai.setBounds(305, 155, 221, 30);
		contentPane.add(lbl_TheLoai);
		
		JLabel lbl_QuocGia = new JLabel("Quốc gia: "+s.getQuocGia());
		lbl_QuocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_QuocGia.setBounds(305, 195, 221, 30);
		contentPane.add(lbl_QuocGia);
		
		ta_MoTa = new JTextArea(s.getMoTa());
		ta_MoTa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ta_MoTa.setLineWrap(true); // Thiết lập để wrap dòng
		ta_MoTa.setWrapStyleWord(true); // Wrap từng từ
		ta_MoTa.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(ta_MoTa);
		scrollPane.setBounds(305, 287, 221, 87);
		contentPane.add(scrollPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 57, 455, 2);
		contentPane.add(separator);
		
		lbl_SoLuongConLai = new JLabel("Số lượng còn lại: "+s.getSoLuongConLai());
		lbl_SoLuongConLai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_SoLuongConLai.setBounds(305, 235, 221, 30);
		contentPane.add(lbl_SoLuongConLai);
		
		JLabel lbl_Gia = new JLabel("Giá: " + s.getGia() +" VND");
		lbl_Gia.setForeground(new Color(255, 0, 128));
		lbl_Gia.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Gia.setBounds(305, 384, 221, 32);
		contentPane.add(lbl_Gia);
		
		JButton btnNewButton = new JButton("Yêu cầu mượn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s.getSoLuongConLai() <= 0) {
					JOptionPane.showMessageDialog(ChiTietSachKhachView.this, "Không còn sách trong kho");
				}
				else
					displayForm();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(244, 449, 139, 37);
		contentPane.add(btnNewButton);
		
		JButton btnVTrangCh = new JButton("Về trang chủ");
		btnVTrangCh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVTrangCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVTrangCh.setBounds(77, 449, 139, 37);
		contentPane.add(btnVTrangCh);
	}
	private void displayForm() {
		FormYeuCauKhachView f = new FormYeuCauKhachView(s);
		f.setVisible(true);
	}
}
