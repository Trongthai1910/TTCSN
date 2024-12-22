package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.ImageIcon;

public class TrangChuNguoiDoc extends JFrame {

	private TaiKhoan taiKhoan;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TrangChuNguoiDoc frame = new TrangChuNguoiDoc(taiKhoan);
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
	public TrangChuNguoiDoc(TaiKhoan taiKhoan) {
		
		this.taiKhoan = taiKhoan;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Trang chủ");
		setBounds(100, 100, 868, 678);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cài đặt");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cài đặt tài khoản");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOut();
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Thông tin");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Thông tin thư viện");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Thông tin nhà phát triển");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThongTinNhaPhatTrienView tt = new ThongTinNhaPhatTrienView();
				tt.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_TenTaiKhoan = new JLabel();
		lbl_TenTaiKhoan.setText(taiKhoan.getTenTaiKhoan());
		lbl_TenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_TenTaiKhoan.setBounds(80, 10, 220, 47);
		contentPane.add(lbl_TenTaiKhoan);
		
		
		//layout bên dưới menu
		JPanel p_Body = new JPanel();
		p_Body.setBounds(10, 76, 834, 541);
		contentPane.add(p_Body);
		p_Body.setLayout(null);
		
		JPanel p_Menu = new JPanel();
		p_Menu.setBounds(0, 0, 834, 43);
		p_Body.add(p_Menu);
		p_Menu.setLayout(new GridLayout(0, 3, 1, 0));
		
		JPanel p_Body2 = new JPanel();
		p_Body2.setBounds(0, 42, 834, 498);
		p_Body.add(p_Body2);
		CardLayout p_body2_layout = new CardLayout(0, 0);
		p_Body2.setLayout(p_body2_layout);
		
		//các card layout
		KhoSachNDView p_KhoSach = new KhoSachNDView(taiKhoan);
		p_Body2.add(p_KhoSach, "p_KhoSach");
		
		SuaThongTinNDView p_SuaThongTin = new SuaThongTinNDView(taiKhoan);
		p_Body2.add(p_SuaThongTin, "p_SuaThongTin");
		
		DanhSachPhieuMuonNDView p_LichSuMuonSach = new DanhSachPhieuMuonNDView(taiKhoan);
		p_Body2.add(p_LichSuMuonSach, "p_LichSuMuonSach");
		
		p_body2_layout.show(p_Body2, "p_KhoSach");
		
		//xử lý nút
		JButton btn_KhoSach = new JButton("Kho sách");
		btn_KhoSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_body2_layout.show(p_Body2,"p_KhoSach");
			}
		});
		btn_KhoSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_Menu.add(btn_KhoSach);
		
		JButton btn_YeuCauMuonSach = new JButton("Sửa thông tin");
		btn_YeuCauMuonSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_body2_layout.show(p_Body2,"p_SuaThongTin");
			}
		});
		btn_YeuCauMuonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_Menu.add(btn_YeuCauMuonSach);
		
		JButton btn_LichSuMuonSach = new JButton("Lịch sử mượn sách");
		btn_LichSuMuonSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_body2_layout.show(p_Body2,"p_LichSuMuonSach");
			}
		});
		btn_LichSuMuonSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_Menu.add(btn_LichSuMuonSach);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon("src\\main\\resources\\iconUser.png"));
		lblNewLabel_1_1_1_1.setBounds(10, 10, 62, 56);
		contentPane.add(lblNewLabel_1_1_1_1);
		
	}
	private void logOut() {
		DangNhapView dnv = new DangNhapView();
		dnv.setVisible(true);
		this.setVisible(false);
	}
}
