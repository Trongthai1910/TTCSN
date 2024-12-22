package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import entity.Sach;
import entity.TaiKhoan;
import entity.TheLoai;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class KhoSachNDView extends JPanel {

	private static final long serialVersionUID = 1L;
	private TaiKhoan taiKhoan;
	private DefaultTableModel model = new DefaultTableModel();
	private JPopupMenu popUp = new JPopupMenu();
	private JTextField tf_TimTenSach;
	private JTable tbl_dSSach;

	/**
	 * Create the panel.
	 */
	public KhoSachNDView(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan; 
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(255, 255, 255));
		add(toolBar, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Nhập tên sách: ");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(lblNewLabel);
		
		tf_TimTenSach = new JTextField();
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
		
		tbl_dSSach = new JTable();
		
		model.setColumnIdentifiers(new String[] {"Tên","Tác giả","Quốc gia","Số lượng"});
		
		model.setRowCount(0);
		
		ArrayList<Sach> dsSach = SachDAO.getInstance().selectedAll();
		for (Sach s : dsSach) {
			Object[] row = new Object[] {s.getTenSach(),s.getTenTacGia(),s.getQuocGia(),s.getSoLuongConLai(),};
			
			model.addRow(row);
			
		}
		model.fireTableDataChanged();
		tbl_dSSach.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane(tbl_dSSach);
		add(scrollPane, BorderLayout.CENTER);
		
		tbl_dSSach.setComponentPopupMenu(popUp);
		addPopup(tbl_dSSach, popUp);
		
		JMenuItem item_XemChiTiet = new JMenuItem("Xem chi tiết sách");
		item_XemChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDetail();
			}	
		});
		popUp.add(item_XemChiTiet);
		
		JSeparator separator_1 = new JSeparator();
		popUp.add(separator_1);
		
		
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
	public void search() {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Tên","Tác giả","Quốc gia","Số lượng"});
		
		model.setRowCount(0);
		
		if (!tf_TimTenSach.getText().equals("")) {
			ArrayList<Sach> dsSach = SachDAO.getInstance().selectedByPartName(tf_TimTenSach.getText());
			for (Sach s : dsSach) {
				Object[] row = new Object[] {s.getTenSach(),s.getTenTacGia(),s.getQuocGia(),s.getSoLuongConLai(),};
				
				model.addRow(row);
			}
		}
		else {
			ArrayList<Sach> dsSach = SachDAO.getInstance().selectedAll();
			for (Sach s : dsSach) {
				Object[] row = new Object[] {s.getTenSach(),s.getTenTacGia(),s.getQuocGia(),s.getSoLuongConLai(),};
				
				model.addRow(row);			
			}
		}
		model.fireTableDataChanged();
		tbl_dSSach.setModel(model);
	}
	public void bookDetail() {
		int selectedRow = tbl_dSSach.getSelectedRow();
		int selectedMaSach = Integer.parseInt(tbl_dSSach.getValueAt(selectedRow, 0).toString());
		Sach s = new Sach();
		s.setMaSach(selectedMaSach);
		s = SachDAO.getInstance().selectedById(s);
		ChiTietSachNDView cts = new ChiTietSachNDView(taiKhoan,s);
		cts.setVisible(true);
	}
	
}
