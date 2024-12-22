package view;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.border.TitledBorder;

import DAO.TaiKhoanDAO;
import entity.TaiKhoan;
import lib.Func;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class SuaThongTinNDView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tf_HoTen;
	private JTextField tf_Email;
	private JTextField tf_SoDienThoai;
	private JComboBox cbox_Ngay;
	private JComboBox cbox_Thang;
	private JComboBox cbox_Nam;
	private JTextArea ta_DiaChi;
	private TaiKhoan tk;

	/**
	 * Create the panel.
	 */
	public SuaThongTinNDView(TaiKhoan tk) {
		this.tk = tk;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin cá nhân");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(37, 23, 216, 49);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin c\u00E1 nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(37, 82, 603, 335);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 39, 108, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(31, 89, 108, 22);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(31, 139, 108, 22);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngày sinh: ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(31, 189, 108, 22);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Địa chỉ: ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(31, 239, 108, 22);
		panel.add(lblNewLabel_1_4);
		
		tf_HoTen = new JTextField(tk.getHoTen());
		tf_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_HoTen.setBounds(152, 39, 344, 23);
		panel.add(tf_HoTen);
		tf_HoTen.setColumns(10);
		
		tf_Email = new JTextField(tk.getEmail());
		tf_Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_Email.setColumns(10);
		tf_Email.setBounds(152, 89, 344, 23);
		panel.add(tf_Email);
		
		tf_SoDienThoai = new JTextField(tk.getSoDienThoai());
		tf_SoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_SoDienThoai.setColumns(10);
		tf_SoDienThoai.setBounds(152, 139, 344, 23);
		panel.add(tf_SoDienThoai);
		
		ta_DiaChi = new JTextArea(tk.getDiaChi());
		ta_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ta_DiaChi.setBounds(149, 240, 347, 59);
		panel.add(ta_DiaChi);
		
		cbox_Ngay = new JComboBox();
		cbox_Ngay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbox_Ngay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbox_Ngay.setBounds(174, 189, 52, 23);
		panel.add(cbox_Ngay);
		
		cbox_Thang = new JComboBox();
		cbox_Thang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbox_Thang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbox_Thang.setBounds(248, 189, 52, 23);
		panel.add(cbox_Thang);
		
		cbox_Nam = new JComboBox();
		cbox_Nam.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950"}));
		cbox_Nam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbox_Nam.setBounds(327, 189, 66, 23);
		panel.add(cbox_Nam);
		
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
		
		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btn_Luu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Luu.setBounds(213-80, 427, 85, 32);
		add(btn_Luu);
		
		JButton btn_XoaHet = new JButton("Xóa hết");
		btn_XoaHet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteForm();
			}
		});
		btn_XoaHet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_XoaHet.setBounds(333-80, 427, 85, 32);
		add(btn_XoaHet);

		JButton btn_VeMacDinh = new JButton("Về mặc định");
		btn_VeMacDinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailAccount();
			}
		});
		btn_VeMacDinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_VeMacDinh.setBounds(453-80, 427, 126, 32);
		add(btn_VeMacDinh);
	}
	private void deleteForm() {
		tf_HoTen.setText("");
		tf_Email.setText("");
		tf_SoDienThoai.setText("");
		ta_DiaChi.setText("");
	}
	private void update() {	
		if(tf_HoTen.getText().equals("") || !Func.checkNumberForm(tf_SoDienThoai.getText()) || !Func.checkEmail(tf_Email.getText()))  {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng");
		}
		else {
			tk.setHoTen(tf_HoTen.getText());
			tk.setEmail(tf_Email.getText());
			tk.setSoDienThoai(tf_SoDienThoai.getText());
			tk.setNgaySinh(Date.valueOf(cbox_Nam.getSelectedItem().toString()+"-"+cbox_Thang.getSelectedItem().toString()+"-"+cbox_Ngay.getSelectedItem().toString()));
			tk.setDiaChi(ta_DiaChi.getText());
			TaiKhoanDAO.getInstance().update(tk);
			JOptionPane.showMessageDialog(this, "Cập nhật thành công");
		}
	}
	private void detailAccount() {
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
}
