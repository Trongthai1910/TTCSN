package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.PhieuMuonSachDAO;
import DAO.SachDAO;
import entity.PhieuMuonSach;
import entity.Sach;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class DanhSachPhieuMuonAdminView extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model = new DefaultTableModel();
	private JPopupMenu popUp = new JPopupMenu();
	private JTable tbl_DSPhieuMuon;
	private JTextField tf_Tim;
	/**
	 * Create the panel.
	 */
	public DanhSachPhieuMuonAdminView() {
		setLayout(new BorderLayout(0, 0));
		
		tbl_DSPhieuMuon = new JTable();
		defaultInfor();
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btn_TatCa = new JButton("Tất cả phiếu");
		btn_TatCa.setBackground(new Color(192, 241, 238));
		btn_TatCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultInfor();
			}
		});
		btn_TatCa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btn_TatCa);
		
		JButton btn_TatCa_1 = new JButton("Phiếu sách đang mượn");
		btn_TatCa_1.setBackground(new Color(192, 241, 238));
		btn_TatCa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInUse();
			}
		});
		btn_TatCa_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btn_TatCa_1);
		
		JLabel lblNewLabel = new JLabel("Tìm mã phiếu: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(lblNewLabel);
		
		tf_Tim = new JTextField();
		tf_Tim.setBackground(new Color(250, 254, 220));
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
		tbl_DSPhieuMuon.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane(tbl_DSPhieuMuon);
		add(scrollPane, BorderLayout.CENTER);
		
		
		tbl_DSPhieuMuon.setComponentPopupMenu(popUp);
		addPopup(tbl_DSPhieuMuon, popUp);
		JMenuItem item1 = new JMenuItem("Chi tiết");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detail();
			}
		});
		popUp.add(item1);
	}
	public void defaultInfor() {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Mã phiếu","Hình thức mượn","Ngày mượn","Ngày trả","Trạng thái","Họ tên","Sách"});
		
		model.setRowCount(0);
		
		ArrayList<PhieuMuonSach> dSPhieuMuon = PhieuMuonSachDAO.getInstance().selectedAll();
		for (PhieuMuonSach pms : dSPhieuMuon) {
			Object[] row = new Object[] {pms.getMaPhieuMuon(),pms.getHinhThucMuon(),pms.getThoiGianMuon(),pms.getThoiGianTra(),pms.getTrangThai(),pms.getHoTen(),pms.getSach().getTenSach()};
			model.addRow(row);
		}
		model.fireTableDataChanged();
		tbl_DSPhieuMuon.setModel(model);
	}
	public void detail() { //chi tiết phiếu mượn
		int selectedRow = tbl_DSPhieuMuon.getSelectedRow();
		int selectedMaPhieu = Integer.parseInt(tbl_DSPhieuMuon.getValueAt(selectedRow, 0).toString());
		PhieuMuonSach pms = PhieuMuonSachDAO.getInstance().selectedById(new PhieuMuonSach(selectedMaPhieu));
		ChiTietPhieuMuonView ct = new ChiTietPhieuMuonView(pms);
		ct.setVisible(true);
		
	}
	private void bookInUse() {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Mã phiếu","Hình thức mượn","Ngày mượn","Ngày trả","Trạng thái","Họ tên","Sách"});
		
		model.setRowCount(0);
		
		ArrayList<PhieuMuonSach> dSPhieuMuon = PhieuMuonSachDAO.getInstance().selectedAllDangMuon();
		for (PhieuMuonSach pms : dSPhieuMuon) {
			Object[] row = new Object[] {pms.getMaPhieuMuon(),pms.getHinhThucMuon(),pms.getThoiGianMuon(),pms.getThoiGianTra(),pms.getTrangThai(),pms.getHoTen(),pms.getSach().getTenSach()};
			model.addRow(row);
		}
		model.fireTableDataChanged();
		tbl_DSPhieuMuon.setModel(model);
	}
	private void search() {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Mã phiếu","Hình thức mượn","Ngày mượn","Ngày trả","Trạng thái","Họ tên","Sách"});
		
		model.setRowCount(0);
		
		if(!tf_Tim.getText().equals("")) {
			int ma = Integer.parseInt(tf_Tim.getText());
			PhieuMuonSach pms = PhieuMuonSachDAO.getInstance().selectedById(new PhieuMuonSach(ma));
			Object[] row = new Object[] {pms.getMaPhieuMuon(),pms.getHinhThucMuon(),pms.getThoiGianMuon(),pms.getThoiGianTra(),pms.getTrangThai(),pms.getHoTen(),pms.getSach().getTenSach()};
			model.addRow(row);
		}
		else {
			ArrayList<PhieuMuonSach> dSPhieuMuon = PhieuMuonSachDAO.getInstance().selectedAll();
			for (PhieuMuonSach pms : dSPhieuMuon) {
				Object[] row = new Object[] {pms.getMaPhieuMuon(),pms.getHinhThucMuon(),pms.getThoiGianMuon(),pms.getThoiGianTra(),pms.getTrangThai(),pms.getHoTen(),pms.getSach().getTenSach()};
				model.addRow(row);
			}
		}
		model.fireTableDataChanged();
		tbl_DSPhieuMuon.setModel(model);
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

}
