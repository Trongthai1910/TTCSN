package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.TaiKhoanDAO;
import entity.TaiKhoan;
import lib.Func;

import javax.swing.JSeparator;

public class DangKyView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_tenTaiKhoan;
	private JPasswordField pf_matKhau;
	private JPasswordField pf_xacnhan;
	private JTextField tf_HoTen;
	private JTextField tf_Email;
	private JTextField tf_SoDienThoai;

	/**
	 * Create the frame.
	 */
	public DangKyView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Đăng ký");
		setBounds(100, 100, 409, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng ký");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(129, 10, 132, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên tài khoản: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(36, 69, 98, 17);
		contentPane.add(lblNewLabel_1);
		
		tf_tenTaiKhoan = new JTextField();
		tf_tenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_tenTaiKhoan.setBounds(82, 98, 233, 25);
		contentPane.add(tf_tenTaiKhoan);
		tf_tenTaiKhoan.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(36, 133, 98, 17);
		contentPane.add(lblNewLabel_1_1);
		
		pf_matKhau = new JPasswordField();
		pf_matKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pf_matKhau.setBounds(82, 160, 233, 25);
		contentPane.add(pf_matKhau);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Xác nhận mật khẩu:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(36, 195, 138, 17);
		contentPane.add(lblNewLabel_1_1_1);
		
		pf_xacnhan = new JPasswordField();
		pf_xacnhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pf_xacnhan.setBounds(82, 222, 233, 25);
		contentPane.add(pf_xacnhan);
		
		JButton btnNewButton = new JButton("Đăng ký");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangKy();
			}
		});
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(82, 459, 98, 37);
		contentPane.add(btnNewButton);
		
		JButton btnngNhp = new JButton("Đăng nhập");
		btnngNhp.setBackground(new Color(128, 255, 255));
		btnngNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhapView dangNhapView = new DangNhapView();
				dangNhapView.setVisible(true);
				setVisible(false);
			}
		});
		btnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnngNhp.setBounds(190, 458, 125, 38);
		contentPane.add(btnngNhp);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 446, 311, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1_2 = new JLabel("Họ và tên: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(36, 257, 98, 17);
		contentPane.add(lblNewLabel_1_2);
		
		tf_HoTen = new JTextField();
		tf_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_HoTen.setColumns(10);
		tf_HoTen.setBounds(82, 286, 233, 25);
		contentPane.add(tf_HoTen);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Email: ");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(36, 321, 67, 17);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số điện thoại: ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(36, 383, 138, 17);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		tf_Email = new JTextField();
		tf_Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_Email.setColumns(10);
		tf_Email.setBounds(82, 348, 233, 25);
		contentPane.add(tf_Email);
		
		tf_SoDienThoai = new JTextField();
		tf_SoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_SoDienThoai.setColumns(10);
		tf_SoDienThoai.setBounds(82, 410, 233, 25);
		contentPane.add(tf_SoDienThoai);
	}
	private boolean checkFormDK() {
		if (tf_tenTaiKhoan.getText().equals("") || pf_matKhau.getText().equals("") || pf_xacnhan.getText().equals("")) {
			return false;
		}
		if (tf_HoTen.getText().equals("") || !Func.checkNumberForm(tf_SoDienThoai.getText()) || !Func.checkEmail(tf_Email.getText())) {
			return false;
		}
		return true;
		
	}
	private void dangKy() {
		if (!checkFormDK()) {
			JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập thông tin đúng định dạng");
		}
		else if (!pf_matKhau.getText().equals(pf_xacnhan.getText())) { 
			JOptionPane.showMessageDialog(contentPane, "Mật khẩu và xác nhận mật khẩu không trùng khớp");
		}
		else if (TaiKhoanDAO.getInstance().existedName(new TaiKhoan(tf_tenTaiKhoan.getText(),pf_matKhau.getText()))) {
			JOptionPane.showMessageDialog(contentPane, "Tên tài khoản trên đã tồn tại");
		}
		else {
			TaiKhoan tk = new TaiKhoan();
			tk.setTenTaiKhoan(tf_tenTaiKhoan.getText());
			tk.setHoTen(tf_HoTen.getText());
			tk.setEmail(tf_Email.getText());
			tk.setSoDienThoai(tf_SoDienThoai.getText());
			tk.setMatKhau(pf_matKhau.getText());
			TaiKhoanDAO.getInstance().insert(tk);
			JOptionPane.showMessageDialog(contentPane, "Đăng ký tài khoản thành công");
			DangNhapView dn = new DangNhapView();
			setVisible(false);
			dn.setVisible(true);
		}
	}
}
 