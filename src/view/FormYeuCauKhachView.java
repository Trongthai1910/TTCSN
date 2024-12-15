package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import DAO.PhieuMuonSachDAO;
import DAO.YeuCauMuonTraDAO;
import entity.PhieuMuonSach;
import entity.Sach;
import entity.YeuCauMuonTra;
import lib.Func;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormYeuCauKhachView extends JFrame {

	private static final long serialVersionUID = 1L;
	private Sach s;
	
	private JPanel contentPane;
	private JTextField tf_HoTen;
	private JTextField tf_Email;
	private JTextField tf_SDT;
	private JRadioButton rd_MangDi;
	private JRadioButton rd_TaiCho;
	private ButtonGroup gr = new ButtonGroup();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormYeuCauKhachView frame = new FormYeuCauKhachView();
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
	public FormYeuCauKhachView(Sach s) {
		this.s = s;
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Form", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(29, 54, 461, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Anh = new JLabel("");
		lbl_Anh.setBounds(24, 25, 95, 132);
		ImageIcon icon_Anh = new ImageIcon(s.getAnh());
		icon_Anh = Func.fittedIcon(lbl_Anh, icon_Anh);
		lbl_Anh.setIcon(icon_Anh);
		lbl_Anh.setFont(new Font("Tahoma", Font.PLAIN, 14));

		panel.add(lbl_Anh);
		
		JLabel lbl1 = new JLabel("Sách: ");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl1.setBounds(129, 25, 45, 23);
		panel.add(lbl1);
		
		JLabel lbl_TenSach = new JLabel(s.getTenSach());
		lbl_TenSach.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_TenSach.setBounds(129, 58, 322, 36);
		panel.add(lbl_TenSach);
		
		rd_MangDi = new JRadioButton("Mượn mang đi");
		rd_MangDi.setSelected(true);
		rd_MangDi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rd_MangDi.setBounds(129, 154, 129, 21);
		panel.add(rd_MangDi);
		
		rd_TaiCho = new JRadioButton("Mượn đọc tại chỗ");
		rd_TaiCho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rd_TaiCho.setBounds(266, 154, 146, 21);
		panel.add(rd_TaiCho);
		
		gr.add(rd_MangDi);
		gr.add(rd_TaiCho);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(24, 200, 52, 23);
		panel.add(lblNewLabel_1);
		
		tf_HoTen = new JTextField();
		tf_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_HoTen.setBounds(86, 200, 298, 23);
		panel.add(tf_HoTen);
		tf_HoTen.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(24, 244, 52, 23);
		panel.add(lblNewLabel_1_1);
		
		tf_Email = new JTextField();
		tf_Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_Email.setColumns(10);
		tf_Email.setBounds(86, 244, 298, 23);
		panel.add(tf_Email);
		
		JLabel lblNewLabel_1_2 = new JLabel("SDT: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(24, 290, 52, 23);
		panel.add(lblNewLabel_1_2);
		
		tf_SDT = new JTextField();
		tf_SDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_SDT.setColumns(10);
		tf_SDT.setBounds(86, 290, 298, 23);
		panel.add(tf_SDT);
		
		JLabel btn_Tien = new JLabel("Tiền thế chấp: "+s.getGia());
		btn_Tien.setForeground(new Color(255, 0, 128));
		btn_Tien.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Tien.setBounds(86, 336, 314, 23);
		panel.add(btn_Tien);
		
		JLabel lblHnhThcMn = new JLabel("Hình thức mượn: ");
		lblHnhThcMn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHnhThcMn.setBounds(129, 113, 142, 23);
		panel.add(lblHnhThcMn);
		
		JButton btn_Gui = new JButton("Gửi yêu cầu");
		btn_Gui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeRequest();
			}
		});
		btn_Gui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Gui.setBounds(183, 455, 139, 35);
		contentPane.add(btn_Gui);
		
		JLabel lblNewLabel = new JLabel("Phiếu điền thông tin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(29, 10, 260, 34);
		contentPane.add(lblNewLabel);
	}
	private void makeRequest() {
		YeuCauMuonTra yc = new YeuCauMuonTra();
		yc.setSach(s);
		if (tf_HoTen.getText().equals("") || tf_Email.getText().equals("") || tf_SDT.getText().equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập hết các trường dữ liệu");
		}
		else if (!Func.checkNumberForm(tf_SDT.getText()) || !Func.checkEmail(tf_Email.getText())) {
			JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đúng định dạng");
		}
		else {
			yc.setHoTen(tf_HoTen.getText());
			yc.setEmail(tf_Email.getText());
			yc.setSoDienThoai(tf_SDT.getText());
			if (rd_MangDi.isSelected()) {
				yc.setHinhThucMuon("Mang đi");
			}
			else if (rd_TaiCho.isSelected()) {
				yc.setHinhThucMuon("Tại chỗ");
			}
			YeuCauMuonTraDAO.getInstance().insert(yc);
			JOptionPane.showMessageDialog(contentPane, "Đã gửi yêu cầu thành công");
			setVisible(false);
		}
		
	}
}
