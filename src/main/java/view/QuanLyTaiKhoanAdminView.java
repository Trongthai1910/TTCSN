package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.SachDAO;
import DAO.TaiKhoanDAO;
import entity.Sach;
import entity.TaiKhoan;
import lib.Func;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.MenuItem;
import java.util.ArrayList;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Color;

public class QuanLyTaiKhoanAdminView extends JPanel {

	private static final long serialVersionUID = 1L;
	CardLayout c = new CardLayout(0,0);
	JPanel p_DSTaiKhoan = new JPanel();
	JPanel p_SuaTaiKhoan = new JPanel();
	private DefaultTableModel model = new DefaultTableModel();
	JTable tbl_DSTaiKhoan = new JTable();
	private JPopupMenu popUp = new JPopupMenu();
	private JTextField tf_TimKiemTaiKhoan;
	private JTextField tf_Email;
	private JTextField tf_SoDienThoai;
	private JLabel lbl_TenTaiKhoan;
	private JLabel lbl_MaTaiKhoan;
	private JComboBox cbox_Ngay;
	private JComboBox cbox_Thang;
	private JComboBox cbox_Nam;
	private JTextArea ta_DiaChi;
	private JTextField tf_HoTen;

	/**
	 * Create the panel.
	 */

	public QuanLyTaiKhoanAdminView() {
		setLayout(c);

		add(p_DSTaiKhoan, "p_DSTaiKhoan");
		p_DSTaiKhoan.setLayout(null);
		p_SuaTaiKhoan.setBackground(new Color(238, 255, 245));

		add(p_SuaTaiKhoan, "p_SuaTaiKhoan");
		p_SuaTaiKhoan.setLayout(null);

		// Sua Tai Khoan
		JLabel lblNewLabel_1 = new JLabel("Chỉnh sửa thông tin tài khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 10, 354, 47);
		p_SuaTaiKhoan.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mã tài khoản: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(231, 67, 97, 18);
		p_SuaTaiKhoan.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Tên tài khoản: ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(231, 102, 97, 18);
		p_SuaTaiKhoan.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Email: ");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(231, 203, 72, 18);
		p_SuaTaiKhoan.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Số điện thoại: ");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(231, 238, 97, 18);
		p_SuaTaiKhoan.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Ngày sinh: ");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1.setBounds(231, 274, 72, 18);
		p_SuaTaiKhoan.add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Địa chỉ: ");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_2.setBounds(231, 312, 72, 18);
		p_SuaTaiKhoan.add(lblNewLabel_2_1_1_1_2);

		lbl_MaTaiKhoan = new JLabel("");
		lbl_MaTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_MaTaiKhoan.setBounds(338, 67, 97, 18);
		p_SuaTaiKhoan.add(lbl_MaTaiKhoan);

		lbl_TenTaiKhoan = new JLabel("");
		lbl_TenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_TenTaiKhoan.setBounds(338, 102, 226, 18);
		p_SuaTaiKhoan.add(lbl_TenTaiKhoan);

		tf_Email = new JTextField();
		tf_Email.setBackground(new Color(250, 254, 220));
		tf_Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_Email.setBounds(339, 203, 274, 21);
		p_SuaTaiKhoan.add(tf_Email);
		tf_Email.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(231, 140, 382, 2);
		p_SuaTaiKhoan.add(separator_1);

		tf_SoDienThoai = new JTextField();
		tf_SoDienThoai.setBackground(new Color(250, 254, 220));
		tf_SoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_SoDienThoai.setColumns(10);
		tf_SoDienThoai.setBounds(338, 234, 226, 21);
		p_SuaTaiKhoan.add(tf_SoDienThoai);

		cbox_Ngay = new JComboBox();
		cbox_Ngay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbox_Ngay.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		cbox_Ngay.setBounds(338, 275, 43, 21);
		p_SuaTaiKhoan.add(cbox_Ngay);

		cbox_Thang = new JComboBox();
		cbox_Thang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbox_Thang.setModel(
				new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbox_Thang.setBounds(391, 275, 43, 21);
		p_SuaTaiKhoan.add(cbox_Thang);

		cbox_Nam = new JComboBox();
		cbox_Nam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbox_Nam.setModel(new DefaultComboBoxModel(new String[] { "2019", "2018", "2017", "2016", "2015", "2014",
				"2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001",
				"2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988",
				"1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975",
				"1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962",
				"1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950" }));
		cbox_Nam.setBounds(444, 275, 61, 21);
		p_SuaTaiKhoan.add(cbox_Nam);

		ta_DiaChi = new JTextArea();
		ta_DiaChi.setBackground(new Color(250, 254, 220));
		ta_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ta_DiaChi.setBounds(338, 311, 275, 82);
		p_SuaTaiKhoan.add(ta_DiaChi);

		JButton btn_QuayLai = new JButton("Quay lại");
		btn_QuayLai.setBackground(new Color(192, 241, 238));
		btn_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(QuanLyTaiKhoanAdminView.this, "p_DSTaiKhoan");
			}
		});
		btn_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_QuayLai.setBounds(64, 104, 116, 37);
		p_SuaTaiKhoan.add(btn_QuayLai);

		JButton btn_Xoa = new JButton("Xóa");
		btn_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteForm();
			}	
		});
		btn_Xoa.setBackground(new Color(192, 241, 238));
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Xoa.setBounds(64, 168, 116, 37);
		p_SuaTaiKhoan.add(btn_Xoa);

		JButton btn_VeMacDinh = new JButton("Về mặc định");
		btn_VeMacDinh.setBackground(new Color(192, 241, 238));
		btn_VeMacDinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountDetail();
			}
		});
		btn_VeMacDinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_VeMacDinh.setBounds(64, 250, 116, 37);
		p_SuaTaiKhoan.add(btn_VeMacDinh);

		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}	
		});
		btn_Luu.setBackground(new Color(192, 241, 238));
		btn_Luu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Luu.setBounds(64, 320, 116, 37);
		p_SuaTaiKhoan.add(btn_Luu);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Họ và tên: ");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_2.setBounds(231, 164, 72, 18);
		p_SuaTaiKhoan.add(lblNewLabel_2_1_1_2);
		
		tf_HoTen = new JTextField();
		tf_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_HoTen.setColumns(10);
		tf_HoTen.setBackground(new Color(250, 254, 220));
		tf_HoTen.setBounds(338, 165, 274, 21);
		p_SuaTaiKhoan.add(tf_HoTen);

		
		
		// DSTaiKhoan
		p_DSTaiKhoan.setLayout(new BorderLayout(0, 0));

		model.setColumnIdentifiers(
				new String[] { "Mã", "Tên tài khoản", "Họ tên", "Email", "Điện thoại", "Ngày sinh", "Địa chỉ" });
		model.setRowCount(0);
		ArrayList<TaiKhoan> dSTaiKhoan = TaiKhoanDAO.getInstance().selectedAllUser();
		for (TaiKhoan tk : dSTaiKhoan) {
			Object[] row = new Object[] { tk.getMaTaiKhoan(), tk.getTenTaiKhoan(), tk.getHoTen(), tk.getEmail(), tk.getSoDienThoai(), tk.getNgaySinh(), tk.getDiaChi() };

			model.addRow(row);

		}
		model.fireTableDataChanged();
		tbl_DSTaiKhoan.setModel(model);
		JScrollPane scrollPane = new JScrollPane(tbl_DSTaiKhoan);
		p_DSTaiKhoan.add(scrollPane, BorderLayout.CENTER);

		tbl_DSTaiKhoan.setComponentPopupMenu(popUp);
		addPopup(tbl_DSTaiKhoan, popUp);

		JMenuItem item1 = new JMenuItem("Chi tiết");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountDetail();
			}	
		});
		JMenuItem item2 = new JMenuItem("Xóa tài khoản");
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmDeleteDialog();
			}	
		});

		popUp.add(item1);

		JSeparator separator = new JSeparator();
		popUp.add(separator);
		popUp.add(item2);

		JToolBar toolBar = new JToolBar();
		p_DSTaiKhoan.add(toolBar, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Tìm tên tài khoản:  ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(lblNewLabel);

		tf_TimKiemTaiKhoan = new JTextField();
		tf_TimKiemTaiKhoan.setBackground(new Color(250, 254, 220));
		tf_TimKiemTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(tf_TimKiemTaiKhoan);
		tf_TimKiemTaiKhoan.setColumns(10);

		JButton btn_Tim = new JButton("Tìm");
		btn_Tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchName();
			}	
		});
		btn_Tim.setBackground(new Color(192, 241, 238));
		btn_Tim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btn_Tim);

		// show
		c.show(this, "p_DSTaiKhoan");
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

	private void accountDetail() { //chi tiết tài khoản
		c.show(this, "p_SuaTaiKhoan");
		int selectedRow = tbl_DSTaiKhoan.getSelectedRow();
		int selectedMaTaiKhoan = Integer.parseInt(tbl_DSTaiKhoan.getValueAt(selectedRow, 0).toString());
		TaiKhoan tk = new TaiKhoan();
		tk.setMaTaiKhoan(selectedMaTaiKhoan);
		tk = TaiKhoanDAO.getInstance().selectedById(tk);
		lbl_MaTaiKhoan.setText(tk.getMaTaiKhoan() + "");
		lbl_TenTaiKhoan.setText(tk.getTenTaiKhoan());
		tf_HoTen.setText(tk.getHoTen());
		tf_Email.setText(tk.getEmail());
		tf_SoDienThoai.setText(tk.getSoDienThoai());
		ta_DiaChi.setText(tk.getDiaChi());
		int ngay = cbox_Ngay.getItemCount(), thang = cbox_Thang.getItemCount(), nam = cbox_Nam.getItemCount();
		for (int i = 0; i < ngay; i++) {
			int temp = Integer.parseInt(cbox_Ngay.getItemAt(i).toString());
			if (temp == tk.getNgaySinh().getDate()) {
				cbox_Ngay.setSelectedIndex(i);
				break;
			}
		}
		for (int i = 0; i < thang; i++) {
			int temp = Integer.parseInt(cbox_Thang.getItemAt(i).toString());
			if (temp == tk.getNgaySinh().getMonth() + 1) {
				cbox_Thang.setSelectedIndex(i);
				break;
			}
		}
		for (int i = 0; i < nam; i++) {
			int temp = Integer.parseInt(cbox_Nam.getItemAt(i).toString());
			if (temp == tk.getNgaySinh().getYear() + 1900) {
				cbox_Nam.setSelectedIndex(i);
				break;
			}
		}
	}
	private void searchName() { //tìm theo tên
		model = new DefaultTableModel();
		model.setColumnIdentifiers(
				new String[] { "Mã", "Tên tài khoản", "Họ tên", "Email", "Điện thoại", "Ngày sinh", "Địa chỉ" });
		model.setRowCount(0);
		if (!tf_TimKiemTaiKhoan.getText().equals("")) {
			TaiKhoan tk = new TaiKhoan();
			tk.setTenTaiKhoan(tf_TimKiemTaiKhoan.getText());
			tk = TaiKhoanDAO.getInstance().searchByName(tk);
			Object[] row = new Object[] { tk.getMaTaiKhoan(), tk.getTenTaiKhoan(), tk.getHoTen(), tk.getEmail(),
					tk.getSoDienThoai(), tk.getNgaySinh(), tk.getDiaChi() };

			model.addRow(row);

		} else {
			ArrayList<TaiKhoan> dSTaiKhoan = TaiKhoanDAO.getInstance().selectedAllUser();
			for (TaiKhoan tk : dSTaiKhoan) {
				Object[] row = new Object[] { tk.getMaTaiKhoan(), tk.getTenTaiKhoan(), tk.getEmail(),
						tk.getSoDienThoai(), tk.getNgaySinh(), tk.getDiaChi() };
				model.addRow(row);
			}
		}
		model.fireTableDataChanged();
		tbl_DSTaiKhoan.setModel(model);
	}
	private void deleteForm() { //xóa form
		tf_Email.setText("");
		tf_SoDienThoai.setText("");
		ta_DiaChi.setText("");
	}
	private void update() { //sửa thông tin vào csdl
		int selectedRow = tbl_DSTaiKhoan.getSelectedRow();
		int selectedMaTaiKhoan = Integer.parseInt(tbl_DSTaiKhoan.getValueAt(selectedRow, 0).toString());
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setMaTaiKhoan(selectedMaTaiKhoan);
		taiKhoan = TaiKhoanDAO.getInstance().selectedById(taiKhoan);
		
		if(tf_HoTen.getText().equals("") || !Func.checkNumberForm(tf_SoDienThoai.getText()) || !Func.checkEmail(tf_Email.getText()))  {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng");
		}
		else {
			taiKhoan.setHoTen(tf_HoTen.getText());
			taiKhoan.setEmail(tf_Email.getText());
			taiKhoan.setSoDienThoai(tf_SoDienThoai.getText());
			taiKhoan.setNgaySinh(Date.valueOf(cbox_Nam.getSelectedItem().toString()+"-"+cbox_Thang.getSelectedItem().toString()+"-"+cbox_Ngay.getSelectedItem().toString()));
			taiKhoan.setDiaChi(ta_DiaChi.getText());
			TaiKhoanDAO.getInstance().update(taiKhoan);
			JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			defaultInfor();
			c.show(this, "p_DSTaiKhoan");
		}
	}
	private void defaultInfor() { //hiển thị ds tk
		model = new DefaultTableModel();
		model.setColumnIdentifiers(
				new String[] { "Mã", "Tên tài khoản", "Họ tên", "Email", "Điện thoại", "Ngày sinh", "Địa chỉ" });
		model.setRowCount(0);
		ArrayList<TaiKhoan> dSTaiKhoan = TaiKhoanDAO.getInstance().selectedAllUser();
		for (TaiKhoan tk : dSTaiKhoan) {
			Object[] row = new Object[] { tk.getMaTaiKhoan(), tk.getTenTaiKhoan(), tk.getHoTen(), tk.getEmail(),
					tk.getSoDienThoai(), tk.getNgaySinh(), tk.getDiaChi() };
			model.addRow(row);
		}
		model.fireTableDataChanged();
		tbl_DSTaiKhoan.setModel(model);
	}
	private void confirmDeleteDialog() { //hàm xác nhận xóa tài khoản và thực hiện xóa
        Object[] options = {"Có", "Không"};
        int choice = JOptionPane.showOptionDialog(this, "Bạn có muốn xóa", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (choice == JOptionPane.YES_OPTION) {
    		int selectedRow = tbl_DSTaiKhoan.getSelectedRow();
    		int selectedMaTaiKhoan = Integer.parseInt(tbl_DSTaiKhoan.getValueAt(selectedRow, 0).toString());
    		TaiKhoan taiKhoan = new TaiKhoan();
    		taiKhoan.setMaTaiKhoan(selectedMaTaiKhoan);
    		taiKhoan = TaiKhoanDAO.getInstance().selectedById(taiKhoan);
    		TaiKhoanDAO.getInstance().delete(taiKhoan);
    		JOptionPane.showMessageDialog(this, "Xóa tài khoản thành công");
    		defaultInfor();
        }
    }
}
