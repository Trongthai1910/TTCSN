package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import DAO.SachDAO;
import DAO.TheLoaiDAO;
import entity.Sach;
import entity.TheLoai;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class TrangChuKhachView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_TenSach;
	private JComboBox<String> cbox_TheLoai;
	private JTable tbl_DSSach;
	private DefaultTableModel model = new DefaultTableModel();
	private JPopupMenu popUp = new JPopupMenu();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TrangChuKhachView frame = new TrangChuKhachView();
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
	public TrangChuKhachView() {
		setTitle("Trang chủ khách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Cài đặt");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOut();
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("Thông tin");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Thông tin thư viện");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Thể loại: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(lblNewLabel_1);
		
		cbox_TheLoai = new JComboBox<String>();
		cbox_TheLoai.addItem("Tất cả thể loại");
		ArrayList<TheLoai> tl = TheLoaiDAO.getInstance().selectedAll();
		for (TheLoai t:tl) {
			cbox_TheLoai.addItem(t.getTenTheLoai());
		}
		cbox_TheLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(cbox_TheLoai);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm sách theo tên: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(lblNewLabel);
		
		tf_TenSach = new JTextField();
		tf_TenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(tf_TenSach);
		tf_TenSach.setColumns(10);
		
		JButton btn_Tim = new JButton("Tìm kiếm");
		btn_Tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btn_Tim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btn_Tim);
		
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
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tbl_DSSach.setComponentPopupMenu(popUp);
		addPopup(tbl_DSSach, popUp);
		
		JMenuItem item1 = new JMenuItem("Chi tiết");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDetail();
			}
		});
		JMenuItem item2 = new JMenuItem("Mượn");
		
		popUp.add(item1);
		
		JSeparator separator1 = new JSeparator();
		popUp.add(separator1);
		popUp.add(item2);
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
	private void search() {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Mã","Tên","Tác giả","Thể loại","Quốc gia","Số lượng","Giá"});
		
		model.setRowCount(0);
		
		if (cbox_TheLoai.getSelectedItem().toString().equals("Tất cả thể loại"))
		if (!tf_TenSach.getText().equals("")) {
			ArrayList<Sach> dsSach = SachDAO.getInstance().selectedByPartName(tf_TenSach.getText());
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
	private void defaultInfor() {
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
	private void bookDetail() {
		int selectedRow = tbl_DSSach.getSelectedRow();
		int selectedMaSach = Integer.parseInt(tbl_DSSach.getValueAt(selectedRow, 0).toString());
		Sach s = new Sach();
		s = SachDAO.getInstance().selectedById(new Sach(selectedMaSach));
		ChiTietSachKhachView cts = new ChiTietSachKhachView(s);
		cts.setVisible(true);
	}
	private void logOut() {
		DangNhapView dnv = new DangNhapView();
		dnv.setVisible(true);
		this.setVisible(false);
	}
}
