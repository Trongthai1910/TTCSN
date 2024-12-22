package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DAO.PhieuMuonSachDAO;
import DAO.SachDAO;
import DAO.TaiKhoanDAO;
import DAO.YeuCauMuonTraDAO;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TrangChuNguoiQuanTri extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	//dasboard
	private JLabel lbl_SoDauSach = new JLabel();
	private JLabel lbl_SoLuongSach = new JLabel();
	private JLabel lbl_SoSachDangMuon = new JLabel();
	private JLabel lbl_ConTrongTV = new JLabel();
	private JLabel lbl_SoTaiKhoan = new JLabel();
	private JLabel lbl_SoYeuCau = new JLabel();


	/**
	 * Create the frame.
	 */
	public TrangChuNguoiQuanTri() {
		setTitle("Trang chủ người quản trị");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		
		contentPane = new JPanel(); //contentpane
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar(); //menubar
		setJMenuBar(menuBar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP); //tabbed pane
		tabbedPane.setBounds(0, 67, 990, 622);
		contentPane.add(tabbedPane);
		
		JToolBar toolBar = new JToolBar(); //toolbar
		toolBar.setBackground(new Color(238, 255, 245));
		toolBar.setBounds(0, 0, 1000, 68);
		contentPane.add(toolBar);
		
		//menubar
		JMenu mnNewMenu = new JMenu("Tài khoản");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Thông tin cá nhân");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOut();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Thông tin");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Thông tin nhà phát triển");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThongTinNhaPhatTrienView tt = new ThongTinNhaPhatTrienView();
				tt.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu_1.add(mntmNewMenuItem_1);


		
		//toolbar 
		JButton btn_YeuCau = new JButton("Yêu cầu mượn sách");
		btn_YeuCau.setBackground(new Color(192, 241, 238));
		btn_YeuCau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_YeuCau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		toolBar.add(btn_YeuCau);
		
		JButton btn_KhoSach = new JButton("Kho sách");
		btn_KhoSach.setBackground(new Color(192, 241, 238));
		btn_KhoSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_KhoSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		toolBar.add(btn_KhoSach);
		
		JButton btn_TheLoai = new JButton("Quản lý thể loại");
		btn_TheLoai.setBackground(new Color(192, 241, 238));
		btn_TheLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_TheLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		toolBar.add(btn_TheLoai);
		
		JButton btn_TaiKhoan = new JButton("Quản lý tài khoản");
		btn_TaiKhoan.setBackground(new Color(192, 241, 238));
		btn_TaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_TaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		toolBar.add(btn_TaiKhoan);
		
		JButton btn_PhieuMuon = new JButton("Phiếu mượn sách");
		btn_PhieuMuon.setBackground(new Color(192, 241, 238));
		btn_PhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_PhieuMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		toolBar.add(btn_PhieuMuon);
		
		
		//tabbed pane
		//Dashboard
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 255, 245));
		dashboardRefresh();
		tabbedPane.addTab("Dashboard", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thư viện ABCXYZ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(124, 35, 224, 43);
		panel.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(58, 94, 770, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\main\\resources\\iconDauSach.png"));
		lblNewLabel_1.setBounds(75, 120, 54, 67);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("src\\main\\resources\\iconSoSach.png"));
		lblNewLabel_1_1.setBounds(279, 120, 54, 67);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("src\\main\\resources\\iconDangMuon.png"));
		lblNewLabel_1_1_1.setBounds(474, 120, 60, 67);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon("src\\main\\resources\\iconUser.png"));
		lblNewLabel_1_1_1_1.setBounds(75, 291, 85, 67);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel(""); 
		lblNewLabel_1_1_1_1_3.setIcon(new ImageIcon("src\\main\\resources\\iconConLai.png"));
		lblNewLabel_1_1_1_1_3.setBounds(695, 120, 85, 67);
		panel.add(lblNewLabel_1_1_1_1_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon("src\\main\\resources\\iconDauSach.png"));
		lblNewLabel_1_2.setBounds(60, 11, 54, 67);
		panel.add(lblNewLabel_1_2);
		
		JButton btn_Dashboard = new JButton("Làm mới Dashboard");
		btn_Dashboard.setBackground(new Color(192, 241, 238));
		btn_Dashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardRefresh();
			}
		});
		btn_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Dashboard.setBounds(647, 35, 181, 38);
		panel.add(btn_Dashboard);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(58, 437, 770, 2);
		panel.add(separator_1_1);
		
		lbl_SoDauSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_SoDauSach.setBounds(50, 197, 110, 17);
		panel.add(lbl_SoDauSach);
		
		lbl_SoLuongSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_SoLuongSach.setBounds(238, 197, 139, 17);
		panel.add(lbl_SoLuongSach);
		
		lbl_SoSachDangMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_SoSachDangMuon.setBounds(419, 197, 181, 17);
		panel.add(lbl_SoSachDangMuon);
		
		lbl_ConTrongTV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ConTrongTV.setBounds(628, 197, 181, 17);
		panel.add(lbl_ConTrongTV);
		
		lbl_SoTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_SoTaiKhoan.setBounds(50, 368, 110, 17);
		panel.add(lbl_SoTaiKhoan);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1.setIcon(new ImageIcon("src\\main\\resources\\iconYeuCau.png"));
		lblNewLabel_1_1_1_1_1.setBounds(263, 291, 85, 67);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		lbl_SoYeuCau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_SoYeuCau.setBounds(238, 368, 139, 17);
		panel.add(lbl_SoYeuCau);
		
		
		//tab1
		DanhSachYeuCauAdminView tab1 = new DanhSachYeuCauAdminView();
		tab1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Yêu cầu mượn sách", null, tab1, null);
		
		
		//tab2
		QuanLySachAdminView dSSach = new QuanLySachAdminView();
		tabbedPane.addTab("Kho sách", null, dSSach, null);
	
		
		//tab3
		QuanLyTheLoaiAdminView dSTheLoai = new QuanLyTheLoaiAdminView();
		tabbedPane.addTab("Danh sách thể loại", null, dSTheLoai, null);
		
		
		//tab4
		QuanLyTaiKhoanAdminView dSTaiKhoan = new QuanLyTaiKhoanAdminView();
		tabbedPane.addTab("Danh sách tài khoản", null, dSTaiKhoan, null);
		
		
		//tab5
		DanhSachPhieuMuonAdminView dSPhieuMuon = new DanhSachPhieuMuonAdminView();
		tabbedPane.addTab("Phiếu mượn", null, dSPhieuMuon, null);
		
	}
	private void dashboardRefresh() {
		int[] sl = new int[] {SachDAO.getInstance().quantity(), SachDAO.getInstance().quantityBook(), PhieuMuonSachDAO.getInstance().quantityBookInUse(),
				TaiKhoanDAO.getInstance().quantity(), YeuCauMuonTraDAO.getInstance().quantity()};
		lbl_SoDauSach.setText("Số đầu sách: " + sl[0]);
		lbl_SoLuongSach.setText("Số lượng sách: " + sl[1]);
		lbl_SoSachDangMuon.setText("Số sách đang mượn: " + sl[2]);
		lbl_ConTrongTV.setText("Số sách còn lại: " + (sl[1]-sl[2]));
		lbl_SoTaiKhoan.setText("Số tài khoản: " + sl[3]);
		lbl_SoYeuCau.setText("Số yêu cầu: " + sl[4]);
	}
	private void logOut() {
		DangNhapView dnv = new DangNhapView();
		dnv.setVisible(true);
		this.setVisible(false);
	}
}
