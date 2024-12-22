package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.TaiKhoanDAO;
import entity.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class DangNhapView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_tenTaiKhoan;
	private JPasswordField pf_matKhau;
	private JLabel lbl_canhBao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapView frame = new DangNhapView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhapView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Đăng nhập");
		setBounds(100, 100, 412, 581);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(128, 113, 158, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên tài khoản:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 158, 92, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(45, 242, 92, 17);
		contentPane.add(lblNewLabel_1_1);
		
		tf_tenTaiKhoan = new JTextField();
		tf_tenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_tenTaiKhoan.setBounds(45, 191, 317, 30);
		contentPane.add(tf_tenTaiKhoan);
		tf_tenTaiKhoan.setColumns(10);
		
		pf_matKhau = new JPasswordField();
		pf_matKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pf_matKhau.setBounds(45, 278, 317, 30);
		contentPane.add(pf_matKhau);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username, password;
				username = tf_tenTaiKhoan.getText();
				password = pf_matKhau.getText();
				
				TaiKhoan tk = new TaiKhoan();
				tk.setTenTaiKhoan(username);
				tk.setMatKhau(password);
				if(TaiKhoanDAO.getInstance().checkAccount(tk)) {
					JOptionPane.showMessageDialog(contentPane,"Đăng nhập thành công");
					tk = TaiKhoanDAO.getInstance().searchByName(tk);
					if(tk.getQuyen().getMaQuyen() == 1) {
						
						TrangChuNguoiQuanTri tc = new TrangChuNguoiQuanTri();
						tc.setVisible(true);
						setVisible(false);
					}
					else if (tk.getQuyen().getMaQuyen() == 2) {
						TrangChuNguoiDoc tc = new TrangChuNguoiDoc(tk);
						tc.setVisible(true);
						setVisible(false);
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane,"Tài khoản hoặc mật khẩu không chính xác, vui lòng nhập lại");
					lbl_canhBao.setText("Nhấn \"Đăng ký\" nếu chưa có tài khoản");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(45, 403, 145, 41);
		contentPane.add(btnNewButton);
		
		JButton btnngK = new JButton("Đăng ký");
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangKyView dangKyView = new DangKyView();
				dangKyView.setVisible(true);
				setVisible(false);
			}
		});
		btnngK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnngK.setBounds(257, 403, 103, 41);
		contentPane.add(btnngK);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(45, 380, 317, 2);
		contentPane.add(separator);
		
		lbl_canhBao = new JLabel("");
		lbl_canhBao.setForeground(new Color(255, 128, 128));
		lbl_canhBao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_canhBao.setBounds(45, 331, 317, 22);
		contentPane.add(lbl_canhBao);
		
		JButton btnVoViT = new JButton("Vào với tư cách khách");
		btnVoViT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuKhachView tc = new TrangChuKhachView();
				setVisible(false);
				tc.setVisible(true);
			}
		});
		btnVoViT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoViT.setBounds(45, 472, 317, 41);
		contentPane.add(btnVoViT);
		
		JLabel lblHThngTh = new JLabel("Hệ thống thư viện ABC");
		lblHThngTh.setForeground(new Color(0, 128, 255));
		lblHThngTh.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblHThngTh.setBounds(32, 48, 345, 35);
		contentPane.add(lblHThngTh);
		
	}
	
}
