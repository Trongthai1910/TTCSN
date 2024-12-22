package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.SachDAO;
import DAO.TaiKhoanDAO;
import DAO.TheLoaiDAO;
import entity.Sach;
import entity.TaiKhoan;
import entity.TheLoai;
import lib.Func;

import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class QuanLySachAdminView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	//panel tổng
	private CardLayout c;
	private JPanel p_DSSach = new JPanel();
	private JPanel p_SuaSach = new JPanel();
	private JPanel p_ThemSach = new JPanel();
	//panel danh sách cuốn sách
	private JTable tbl_DSSach;
	private DefaultTableModel model = new DefaultTableModel();
	private JPopupMenu popUp = new JPopupMenu();
	private JTextField tf_TimTenSach;
	//panel thêm sách mới
	private JTextField tf_TenSachMoi; //tên sách mới
	private JTextField tf_TenTacGiaMoi; //tên tác giả mới
	private JTextField tf_QuocGiaMoi; //qg mới
	private JLabel lbl_AnhMoi; //ảnh mới
	private ImageIcon iconAnhMoi; //icon ảnh mới
	private JTextArea ta_MoTaMoi; //mô tả mới
	private JComboBox<String> cbox_TheLoaiMoi; //thể loại mới
	private JFormattedTextField tf_SoLuongMoi; //số lượng mới
	private JFormattedTextField tf_GiaMoi; //giá mới
	//panel sửa thông tin sách
	private JTextField tf_TenSach; //tf sửa tên sách
	private JLabel lbl_Anh; //label ảnh
	private ImageIcon iconAnh; //icon ảnh
	private JComboBox<String> cbox_TheLoai; //cbox sửa thể loại
	private JTextField tf_TenTacGia; //sửa tên tác giả
	private JTextField tf_QuocGia;//sửa quốc gia
	private JFormattedTextField tf_SoLuong; //sửa số lượng
	private JTextArea ta_MoTa;
	private JFormattedTextField tf_Gia; //sửa giá
	
	

	/**
	 * Create the panel.
	 */
	public QuanLySachAdminView() {
		c = new CardLayout();
		
		setLayout(c);
		
		add(p_DSSach, "p_DSSach");
		p_DSSach.setLayout(null);
		p_SuaSach.setBackground(new Color(238, 255, 245));

		add(p_SuaSach, "p_SuaSach");
		p_SuaSach.setLayout(null);
		p_ThemSach.setBackground(new Color(238, 255, 245));
		
		add(p_ThemSach,"p_ThemSach");
		p_ThemSach.setLayout(null);
		
		
		//thêm sách mới
		JLabel lblNewLabel_1_1 = new JLabel("Thêm sách mới");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(42, 10, 285, 39);
		p_ThemSach.add(lblNewLabel_1_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(52, 59, 573, 2);
		p_ThemSach.add(separator_2_1);
		
		lbl_AnhMoi = new JLabel("");
		lbl_AnhMoi.setBounds(62, 71, 245, 367);
		p_ThemSach.add(lbl_AnhMoi);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tên sách: ");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(390, 71, 72, 22);
		p_ThemSach.add(lblNewLabel_2_2);
		
		tf_TenSachMoi = new JTextField();
		tf_TenSachMoi.setBackground(new Color(250, 254, 220));
		tf_TenSachMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_TenSachMoi.setColumns(10);
		tf_TenSachMoi.setBounds(390, 102, 341, 32);
		p_ThemSach.add(tf_TenSachMoi);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Tác giả: ");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(390, 154, 55, 22);
		p_ThemSach.add(lblNewLabel_2_1_2);
		
		tf_TenTacGiaMoi = new JTextField();
		tf_TenTacGiaMoi.setBackground(new Color(250, 254, 220));
		tf_TenTacGiaMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_TenTacGiaMoi.setColumns(10);
		tf_TenTacGiaMoi.setBounds(447, 144, 284, 32);
		p_ThemSach.add(tf_TenTacGiaMoi);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Thể loại: ");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_2.setBounds(390, 198, 72, 22);
		p_ThemSach.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Quốc gia: ");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_2.setBounds(390, 235, 72, 22);
		p_ThemSach.add(lblNewLabel_2_1_1_1_2);
		
		tf_QuocGiaMoi = new JTextField();
		tf_QuocGiaMoi.setBackground(new Color(250, 254, 220));
		tf_QuocGiaMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_QuocGiaMoi.setColumns(10);
		tf_QuocGiaMoi.setBounds(497, 230, 172, 32);
		p_ThemSach.add(tf_QuocGiaMoi);
		
		cbox_TheLoaiMoi = new JComboBox<String>();
		cbox_TheLoaiMoi.setBackground(new Color(250, 254, 220));
		ArrayList<TheLoai> theLoai = TheLoaiDAO.getInstance().selectedAll();
		for (TheLoai tl : theLoai) {
			cbox_TheLoaiMoi.addItem(tl.getTenTheLoai());
		}
		cbox_TheLoaiMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbox_TheLoaiMoi.setBounds(497, 186, 208, 34);
		p_ThemSach.add(cbox_TheLoaiMoi);
		
		JLabel lblNewLabel_2_1_1_1_1_2 = new JLabel("Mô tả:");
		lblNewLabel_2_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_2.setBounds(390, 320, 72, 22);
		p_ThemSach.add(lblNewLabel_2_1_1_1_1_2);
		
		ta_MoTaMoi = new JTextArea();
		ta_MoTaMoi.setBackground(new Color(250, 254, 220));
		ta_MoTaMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ta_MoTaMoi.setBounds(390, 352, 341, 86);
		p_ThemSach.add(ta_MoTaMoi);
		
		JButton btn_ThemAnhMoi = new JButton("Thêm ảnh");
		btn_ThemAnhMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getImageFileNewBook();
			}
		});
		btn_ThemAnhMoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_ThemAnhMoi.setBounds(62, 471, 112, 32);
		p_ThemSach.add(btn_ThemAnhMoi);
		
		JButton btn_Them = new JButton("Thêm");
		btn_Them.setBackground(new Color(192, 241, 238));
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewBook();
			}
		});
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Them.setBounds(336, 534, 103, 32);
		p_ThemSach.add(btn_Them);
		
		JButton btn_XoaHetFormTao = new JButton("Xóa hết");
		btn_XoaHetFormTao.setBackground(new Color(192, 241, 238));
		btn_XoaHetFormTao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteFormNew();
			}
		});
		btn_XoaHetFormTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_XoaHetFormTao.setBounds(454, 534, 103, 32);
		p_ThemSach.add(btn_XoaHetFormTao);
		
		
		JButton btn_HuyTao = new JButton("Hủy");
		btn_HuyTao.setBackground(new Color(192, 241, 238));
		btn_HuyTao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultInfor();
			}
		});
		btn_HuyTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_HuyTao.setBounds(218, 534, 103, 32);
		p_ThemSach.add(btn_HuyTao);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Số lượng: ");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(390, 280, 72, 22);
		p_ThemSach.add(lblNewLabel_2_1_1_1_1_1_1);
		
		tf_SoLuongMoi = new JFormattedTextField();
		tf_SoLuongMoi.setBackground(new Color(250, 254, 220));
		tf_SoLuongMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_SoLuongMoi.setBounds(497, 276, 89, 35);
		p_ThemSach.add(tf_SoLuongMoi);
		
		tf_GiaMoi = new JFormattedTextField();
		tf_GiaMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_GiaMoi.setBackground(new Color(250, 254, 220));
		tf_GiaMoi.setBounds(497, 469, 172, 35);
		p_ThemSach.add(tf_GiaMoi);
		
		JLabel lblNewLabel_2_1_1_1_1_2_1 = new JLabel("Giá: ");
		lblNewLabel_2_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_2_1.setBounds(390, 482, 72, 22);
		p_ThemSach.add(lblNewLabel_2_1_1_1_1_2_1);
		
		
		//p_SuaSach
		JLabel lblNewLabel_1 = new JLabel("Chỉnh sửa thông tin sách");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 10, 285, 39);
		p_SuaSach.add(lblNewLabel_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 59, 573, 2);
		p_SuaSach.add(separator_2);
		
		lbl_Anh = new JLabel("");
		lbl_Anh.setBounds(50, 71, 245, 367);
		p_SuaSach.add(lbl_Anh);
		
		JLabel lblNewLabel_2 = new JLabel("Tên sách: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(358, 71, 72, 22);
		p_SuaSach.add(lblNewLabel_2);
		
		tf_TenSach = new JTextField();
		tf_TenSach.setBackground(new Color(250, 254, 220));
		tf_TenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_TenSach.setBounds(358, 102, 341, 32);
		p_SuaSach.add(tf_TenSach);
		tf_TenSach.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tác giả: ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(358, 154, 55, 22);
		p_SuaSach.add(lblNewLabel_2_1);
		
		tf_TenTacGia = new JTextField();
		tf_TenTacGia.setBackground(new Color(250, 254, 220));
		tf_TenTacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_TenTacGia.setColumns(10);
		tf_TenTacGia.setBounds(415, 144, 284, 32);
		p_SuaSach.add(tf_TenTacGia);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Thể loại: ");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(358, 198, 72, 22);
		p_SuaSach.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Quốc gia: ");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(358, 235, 72, 22);
		p_SuaSach.add(lblNewLabel_2_1_1_1);
		
		tf_QuocGia = new JTextField();
		tf_QuocGia.setBackground(new Color(250, 254, 220));
		tf_QuocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_QuocGia.setColumns(10);
		tf_QuocGia.setBounds(465, 230, 172, 32);
		p_SuaSach.add(tf_QuocGia);
		
		cbox_TheLoai = new JComboBox<String>();
		cbox_TheLoai.setBackground(new Color(250, 254, 220));
		cbox_TheLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		for (TheLoai tl : theLoai) {
			cbox_TheLoai.addItem(tl.getTenTheLoai());
		}
		cbox_TheLoai.setBounds(465, 186, 207, 34);
		p_SuaSach.add(cbox_TheLoai);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Mô tả:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1.setBounds(358, 320, 72, 22);
		p_SuaSach.add(lblNewLabel_2_1_1_1_1);
		
		ta_MoTa = new JTextArea();
		ta_MoTa.setBackground(new Color(250, 254, 220));
		ta_MoTa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ta_MoTa.setBounds(358, 352, 341, 86);
		p_SuaSach.add(ta_MoTa);
		
		JButton btn_ThemAnh = new JButton("Thêm ảnh");
		btn_ThemAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getImageFile();
			}
		});
		btn_ThemAnh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_ThemAnh.setBounds(50, 463, 112, 32);
		p_SuaSach.add(btn_ThemAnh);
		
		JButton btn_CapNhat = new JButton("Cập nhật");
		btn_CapNhat.setBackground(new Color(192, 241, 238));
		btn_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btn_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_CapNhat.setBounds(265, 530, 103, 32);
		p_SuaSach.add(btn_CapNhat);
		
		JButton btn_XoaHet = new JButton("Xóa hết");
		btn_XoaHet.setBackground(new Color(192, 241, 238));
		btn_XoaHet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteForm();
			}
		});
		btn_XoaHet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_XoaHet.setBounds(383, 530, 103, 32);
		p_SuaSach.add(btn_XoaHet);
		
		JButton btnVMcnh = new JButton("Về mặc định");
		btnVMcnh.setBackground(new Color(192, 241, 238));
		btnVMcnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDetail();
			}
		});
		btnVMcnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVMcnh.setBounds(496, 530, 112, 32);
		p_SuaSach.add(btnVMcnh);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBackground(new Color(192, 241, 238));
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultInfor();
			}
		});
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHuy.setBounds(147, 530, 103, 32);
		p_SuaSach.add(btnHuy);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Số lượng: ");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_1.setBounds(358, 280, 72, 22);
		p_SuaSach.add(lblNewLabel_2_1_1_1_1_1);
		
		tf_SoLuong = new JFormattedTextField();
		tf_SoLuong.setBackground(new Color(250, 254, 220));
		tf_SoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_SoLuong.setBounds(465, 276, 89, 35);
		p_SuaSach.add(tf_SoLuong);
		
		tf_Gia = new JFormattedTextField();
		tf_Gia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_Gia.setBackground(new Color(250, 254, 220));
		tf_Gia.setBounds(465, 461, 172, 35);
		p_SuaSach.add(tf_Gia);
		
		JLabel lblNewLabel_2_1_1_1_1_3 = new JLabel("Giá:");
		lblNewLabel_2_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_3.setBounds(358, 474, 72, 22);
		p_SuaSach.add(lblNewLabel_2_1_1_1_1_3);
		
		
		
		
		//p_DSSach
		p_DSSach.setLayout(new BorderLayout(0,0));
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(240, 240, 240));
		p_DSSach.add(toolBar, BorderLayout.NORTH);
		
		JButton btn_TatCaSach = new JButton("Tất cả sách");
		btn_TatCaSach.setBackground(new Color(192, 241, 238));
		btn_TatCaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultInfor();
			}
		});
		
		JButton btnNewButton = new JButton("Thêm sách mới");
		btnNewButton.setBackground(new Color(192, 241, 238));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewBookForm();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btnNewButton);
		btn_TatCaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btn_TatCaSach);
		
		JLabel lblNewLabel = new JLabel("Nhập tên sách: ");
		lblNewLabel.setBackground(new Color(192, 241, 238));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(lblNewLabel);
		
		tf_TimTenSach = new JTextField();
		tf_TimTenSach.setBackground(new Color(250, 254, 220));
		tf_TimTenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(tf_TimTenSach);
		tf_TimTenSach.setColumns(10);
		
		JButton btn_Tim = new JButton("Tìm");
		btn_Tim.setBackground(new Color(192, 241, 238));
		btn_Tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btn_Tim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btn_Tim);
		
		//bảng
		tbl_DSSach = new JTable();
		
		model.setColumnIdentifiers(new String[] {"Mã","Tên","Tác giả","Thể loại","Quốc gia","Số lượng","Giá"});
		
		model.setRowCount(0);
		
		ArrayList<Sach> dsSach = SachDAO.getInstance().selectedAll();
		for (Sach s : dsSach) {
			Object[] row = new Object[] {s.getMaSach(), s.getTenSach(),s.getTenTacGia(),s.getTheLoai().getTenTheLoai(),s.getQuocGia(),s.getSoLuongConLai(),s.getGia()};
			
			model.addRow(row);
			
		}
		model.fireTableDataChanged();
		tbl_DSSach.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane(tbl_DSSach);
		p_DSSach.add(scrollPane, BorderLayout.CENTER);
		
		tbl_DSSach.setComponentPopupMenu(popUp);
		addPopup(tbl_DSSach, popUp);
		
		JMenuItem item1 = new JMenuItem("Chi tiết");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDetail();
			}
		});
		JMenuItem item2 = new JMenuItem("Xóa sách");
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmDeleteDialog();
			}
		});
		
		popUp.add(item1);
		
		
		JSeparator separator1 = new JSeparator();
		popUp.add(separator1);
		popUp.add(item2);

		
		//show
		c.show(this,"p_DSSach");
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	public void search() { //Tìm kiếm sách theo 1 phần tên
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Mã","Tên","Tác giả","Thể loại","Quốc gia","Số lượng","Giá"});
		
		model.setRowCount(0);
		
		if (!tf_TimTenSach.getText().equals("")) {
			ArrayList<Sach> dsSach = SachDAO.getInstance().selectedByPartName(tf_TimTenSach.getText());
			for (Sach s : dsSach) {
				Object[] row = new Object[] {s.getMaSach(), s.getTenSach(),s.getTenTacGia(),s.getTheLoai().getTenTheLoai(),s.getQuocGia(),s.getSoLuongConLai(),s.getGia()};
				
				model.addRow(row);
			}
		}
		else {
			defaultInfor();
		}
		model.fireTableDataChanged();
		tbl_DSSach.setModel(model);
	}

	public void defaultInfor() { //hiển thị danh sách tất cả cuốn sách
		c.show(this, "p_DSSach");
		model.setColumnIdentifiers(new String[] {"Mã","Tên","Tác giả","Thể loại","Quốc gia","Số lượng","Giá"});
		model.setRowCount(0);
		
		ArrayList<Sach> dsSach = SachDAO.getInstance().selectedAll();
		for (Sach s : dsSach) {
			Object[] row = new Object[] {s.getMaSach(), s.getTenSach(),s.getTenTacGia(),s.getTheLoai().getTenTheLoai(),s.getQuocGia(),s.getSoLuongConLai(),s.getGia()};
			model.addRow(row);
		}
		model.fireTableDataChanged();
		tbl_DSSach.setModel(model);
	}
	
	//Hàm cho form sửa:
	public void bookDetail() { //Hiển thị chi tiết thông tin cuốn sách và chỉnh sửa trên form
		int selectedRow = tbl_DSSach.getSelectedRow();
		int selectedMaSach = Integer.parseInt(tbl_DSSach.getValueAt(selectedRow, 0).toString());
		Sach s = new Sach();
		s.setMaSach(selectedMaSach);
		s = SachDAO.getInstance().selectedById(s);
		//hiển thị
		tf_TenSach.setText(s.getTenSach());
		tf_TenTacGia.setText(s.getTenTacGia());
		tf_QuocGia.setText(s.getQuocGia());
		ta_MoTa.setText(s.getMoTa());
		ta_MoTa.setLineWrap(true); // Thiết lập để wrap dòng
		ta_MoTa.setWrapStyleWord(true); // Wrap từng từ
		tf_SoLuong.setText(s.getSoLuongConLai()+"");
		tf_Gia.setText(s.getGia()+"");
		int n = cbox_TheLoai.getItemCount();
		for(int i = 0; i<n; i++) {
			if (cbox_TheLoai.getItemAt(i).equals(s.getTheLoai().getTenTheLoai())) {
				cbox_TheLoai.setSelectedIndex(i);
				break;
			}
		}		
		iconAnh = new ImageIcon(s.getAnh());
		lbl_Anh.setIcon(Func.fittedIcon(lbl_Anh, iconAnh));
        
        c.show(this,"p_SuaSach");
	}
	public void getImageFile() { //set ảnh cho form sửa
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("anh","jpg", "png");
		fc.setFileFilter(filter);
		fc.setMultiSelectionEnabled(false);
		
		int x = fc.showDialog(this, "Chọn");
		if (x == fc.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			iconAnh = new ImageIcon(f.toString());
	        Image image = iconAnh.getImage().getScaledInstance(lbl_Anh.getWidth(), lbl_Anh.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon scaledIcon = new ImageIcon(image);
	        lbl_Anh.setIcon(scaledIcon);
		}
	}
	public void update() { //update thông tin cuốn sách hiển thị trên form sửa
		int selectedRow = tbl_DSSach.getSelectedRow();
		int selectedMaSach = Integer.parseInt(tbl_DSSach.getValueAt(selectedRow, 0).toString());
		Sach s = new Sach();
		s.setMaSach(selectedMaSach);
		s = SachDAO.getInstance().selectedById(s);
		
		s.setAnh(iconAnh.getDescription());
		s.setTenSach(tf_TenSach.getText());
		s.setTenTacGia(tf_TenTacGia.getText());
		s.setMoTa(ta_MoTa.getText());
		s.setQuocGia(tf_QuocGia.getText());		
		if (tf_TenSach.getText().equals("") || !Func.checkNumberForm(tf_SoLuong.getText()) || !Func.checkNumberForm(tf_Gia.getText())) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đung định dạng");
		}
		else {
			s.setSoLuongConLai(Integer.parseInt(tf_SoLuong.getText()));
			s.setGia(Integer.parseInt(tf_Gia.getText()));
			TheLoai tl = new TheLoai();
			tl.setTenTheLoai(cbox_TheLoai.getSelectedItem().toString());
			tl = TheLoaiDAO.getInstance().selectedByName(tl);
			s.setTheLoai(tl);
			SachDAO.getInstance().update(s);
			JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			defaultInfor();
		}
	}
	public void deleteForm() { //xóa form sửa
		tf_TenSach.setText("");
		tf_TenTacGia.setText("");
		ta_MoTa.setText("");
		tf_QuocGia.setText("");
	}
	
	//hàm cho form tạo 
	public void addNewBook() { //thêm cuốn sách vào csdl
		Sach s = new Sach();
		s.setTenSach(tf_TenSachMoi.getText());
		s.setTenTacGia(tf_TenTacGiaMoi.getText());
		s.setMoTa(ta_MoTaMoi.getText());
		s.setQuocGia(tf_QuocGiaMoi.getText());
		s.setAnh(iconAnhMoi.getDescription());
		if (tf_TenSachMoi.getText().equals("") || !Func.checkNumberForm(tf_SoLuongMoi.getText()) || !Func.checkNumberForm(tf_GiaMoi.getText())) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đung định dạng");
		}
		else {
			s.setSoLuongConLai(Integer.parseInt(tf_SoLuongMoi.getText()));
			s.setGia(Integer.parseInt(tf_GiaMoi.getText()));
			TheLoai tl = new TheLoai();
			tl.setTenTheLoai(cbox_TheLoaiMoi.getSelectedItem().toString());
			tl = TheLoaiDAO.getInstance().selectedByName(tl);
			s.setTheLoai(tl);
			SachDAO.getInstance().insert(s);
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			defaultInfor();
			deleteFormNew();
		}
	}
	public void addNewBookForm() { //hiển thị form tạo sách
		c.show(this,"p_ThemSach");
	}
	public void getImageFileNewBook() { //set ảnh cho form tạo sách mới
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("anh","jpg", "png");
		fc.setFileFilter(filter);
		fc.setMultiSelectionEnabled(false);
		int x = fc.showDialog(this, "Chọn");
		if (x == fc.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			iconAnhMoi = new ImageIcon(f.toString());
			lbl_AnhMoi.setIcon(Func.fittedIcon(lbl_AnhMoi, iconAnhMoi));
		}
	}
	public void deleteFormNew() { //xóa form thêm mới
		tf_TenSachMoi.setText("");
		tf_TenTacGiaMoi.setText("");
		ta_MoTaMoi.setText("");
		tf_QuocGiaMoi.setText("");
		tf_SoLuongMoi.setText("");
	}
    public void confirmDeleteDialog() { //hàm xác nhận xóa sách và thực hiện xóa
        Object[] options = {"Có", "Không"};
        int choice = JOptionPane.showOptionDialog(this, "Bạn có muốn xóa", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (choice == JOptionPane.YES_OPTION) {
    		int selectedRow = tbl_DSSach.getSelectedRow();
    		int selectedMaSach = Integer.parseInt(tbl_DSSach.getValueAt(selectedRow, 0).toString());
    		Sach s = new Sach();
    		s.setMaSach(selectedMaSach);
    		s = SachDAO.getInstance().selectedById(s);	
    		SachDAO.getInstance().delete(s);
    		JOptionPane.showMessageDialog(this, "Xóa thành công");
    		defaultInfor();
        }
    }
}
