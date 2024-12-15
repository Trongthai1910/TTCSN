package view;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import DAO.SachDAO;
import DAO.TaiKhoanDAO;
import DAO.TheLoaiDAO;
import entity.Sach;
import entity.TaiKhoan;
import entity.TheLoai;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class QuanLyTheLoaiAdminView extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable tbl_DSTheLoai = new JTable();
	private JPopupMenu popUp = new JPopupMenu();
	private JTextField tf_Tim;
	private CardLayout c = new CardLayout(0,0);
	private JPanel p_ThemTheLoai = new JPanel();
	private JPanel p_DSTheLoai = new JPanel();
	private JTextField tf_TenTLMoi;

	/**
	 * Create the panel.
	 */
	public QuanLyTheLoaiAdminView() {
		//layout 
		setLayout(c);
		
		add(p_DSTheLoai, "p_DSTheLoai");
		p_DSTheLoai.setLayout(null);

		add(p_ThemTheLoai, "p_ThemTheLoai");
		p_ThemTheLoai.setLayout(null);
			
		
		//p_ThemTheLoai
		JLabel lblNewLabel_1 = new JLabel("Thêm thể loại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(34, 32, 196, 34);
		p_ThemTheLoai.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00EAm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 76, 391, 131);
		p_ThemTheLoai.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập tên thể loại:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(32, 20, 127, 34);
		panel.add(lblNewLabel_2);
		
		tf_TenTLMoi = new JTextField();
		tf_TenTLMoi.setColumns(10);
		tf_TenTLMoi.setBounds(32, 74, 320, 34);
		panel.add(tf_TenTLMoi);
		
		JButton btnNewButton_2 = new JButton("Quay về");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(QuanLyTheLoaiAdminView.this, "p_DSTheLoai");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(82, 217, 93, 36);
		p_ThemTheLoai.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Lưu");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewGen();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1.setBounds(261, 217, 93, 36);
		p_ThemTheLoai.add(btnNewButton_2_1);
		
		
		//p_DSTheLoai
		p_DSTheLoai.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		p_DSTheLoai.add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("Thêm thể loại");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(QuanLyTheLoaiAdminView.this, "p_ThemTheLoai");
			}
		});
		btnNewButton_1.setBackground(new Color(192, 241, 238));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Tất cả thể loại");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultInfor();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBackground(new Color(192, 241, 238));
		toolBar.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("Tìm tên thể loại: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(lblNewLabel);
		
		tf_Tim = new JTextField();
		tf_Tim.setBackground(new Color(250, 254, 220));
		tf_Tim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(tf_Tim);
		tf_Tim.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBackground(new Color(192, 241, 238));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btnNewButton);

		tbl_DSTheLoai = new JTable();
		
		defaultInfor();
		
		JScrollPane scrollPane = new JScrollPane(tbl_DSTheLoai);
		p_DSTheLoai.add(scrollPane, BorderLayout.CENTER);
		
		tbl_DSTheLoai.setComponentPopupMenu(popUp);
		addPopup(tbl_DSTheLoai, popUp);
		
		JMenuItem btn_XoaTL = new JMenuItem("Xóa thể loại");
		btn_XoaTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		popUp.add(btn_XoaTL);
		
		//show
		c.show(this, "p_DSTheLoai");
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
	private void defaultInfor() {
		model.setColumnIdentifiers(
				new String[] { "Mã", "Tên thể loại", "Số đầu sách"});
		model.setRowCount(0);
		ArrayList<TheLoai> dSTheLoai = TheLoaiDAO.getInstance().selectedAll();
		for (TheLoai tl : dSTheLoai) {
			int quan = SachDAO.getInstance().quantityByTheLoai(tl);
			Object[] row = new Object[] {tl.getMaTheLoai(), tl.getTenTheLoai(),quan};

			model.addRow(row);

		}
		model.fireTableDataChanged();
		tbl_DSTheLoai.setModel(model);
	}
	private void search() { //hàm tìm theo 1 phần tên
		model = new DefaultTableModel();
		model.setColumnIdentifiers(
				new String[] {"Mã", "Tên thể loại", "Số đầu sách"});
		model.setRowCount(0);
		if (!tf_Tim.getText().equals("")) {
			ArrayList<TheLoai> dSTheLoai = TheLoaiDAO.getInstance().selectedByPartName(tf_Tim.getText());
			for (TheLoai tl : dSTheLoai) {
				int quan = SachDAO.getInstance().quantityByTheLoai(tl);
				Object[] row = new Object[] {tl.getMaTheLoai(), tl.getTenTheLoai(),quan};
				model.addRow(row);
			}

		} else {
			ArrayList<TheLoai> dSTheLoai = TheLoaiDAO.getInstance().selectedAll();
			for (TheLoai tl : dSTheLoai) {
				int quan = SachDAO.getInstance().quantityByTheLoai(tl);
				Object[] row = new Object[] {tl.getMaTheLoai(), tl.getTenTheLoai(),quan};
				model.addRow(row);
			}
		}
		model.fireTableDataChanged();
		tbl_DSTheLoai.setModel(model);
	}
	private void delete() { //xóa thể loại
		Object[] options = {"Có", "Không"};
        int choice = JOptionPane.showOptionDialog(this, "Bạn có muốn xóa", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (choice == JOptionPane.YES_OPTION) {
    		int selectedRow = tbl_DSTheLoai.getSelectedRow();
    		int selectedMaTL = Integer.parseInt(tbl_DSTheLoai.getValueAt(selectedRow, 0).toString());
    		TheLoai tl = new TheLoai(selectedMaTL);
    		TheLoaiDAO.getInstance().selectedById(tl);
    		TheLoaiDAO.getInstance().delete(tl);
    		JOptionPane.showMessageDialog(this, "Xóa thành công");
    		defaultInfor();
        }
	}
	private void addNewGen() { //thêm 1 thể loại mới
		if (tf_TenTLMoi.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thể loại");
		}
		else {
			TheLoai tl = new TheLoai();
			tl.setTenTheLoai(tf_TenTLMoi.getText());
			TheLoaiDAO.getInstance().insert(tl);
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			c.show(this, "p_DSTheLoai");
		}
	}
//	private 
}
