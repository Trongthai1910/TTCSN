package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.PhieuMuonSachDAO;
import DAO.SachDAO;
import entity.PhieuMuonSach;
import entity.Sach;
import entity.TaiKhoan;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DanhSachPhieuMuonNDView extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable tbl_dSSach;
	private TaiKhoan taiKhoan;
	
	/**
	 * Create the panel.
	 */
	public DanhSachPhieuMuonNDView(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
		
		setLayout(new BorderLayout(0, 0));
		
		tbl_dSSach = new JTable();
		defaultInfor();
		
		JScrollPane scrollPane = new JScrollPane(tbl_dSSach);
		add(scrollPane, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Phiếu sách đang mượn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInUse();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btnNewButton);
		
		JButton btnTtCPhiu = new JButton("Tất cả phiếu mượn");
		btnTtCPhiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultInfor();
			}
		});
		btnTtCPhiu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btnTtCPhiu);
	}
	private void bookInUse() {	
		model.setColumnIdentifiers(new String[] {"Mã phiếu","Hình thức mượn","Sách","Thời gian mượn","Thời gian trả","Tiền thế chấp","Trạng thái"});
		
		model.setRowCount(0);
		
		ArrayList<PhieuMuonSach> lsu = PhieuMuonSachDAO.getInstance().selectedByTaiKhoanDangMuon(taiKhoan);
		for (PhieuMuonSach pms : lsu) {
			
			Object[] row = new Object[] {pms.getMaPhieuMuon(),pms.getHinhThucMuon(),pms.getSach().getTenSach(),pms.getThoiGianMuon(),pms.getThoiGianTra(),pms.getSoTienTheChap(),pms.getTrangThai()};
			
			model.addRow(row);
			
		}
		model.fireTableDataChanged();
		tbl_dSSach.setModel(model);
	}
	private void defaultInfor() {		
		model.setColumnIdentifiers(new String[] {"Mã phiếu","Hình thức mượn","Sách","Thời gian mượn","Thời gian trả","Tiền thế chấp","Trạng thái"});
		
		model.setRowCount(0);
		
		ArrayList<PhieuMuonSach> lsu = PhieuMuonSachDAO.getInstance().selectedByTaiKhoan(taiKhoan);
		for (PhieuMuonSach pms : lsu) {
			
			Object[] row = new Object[] {pms.getMaPhieuMuon(),pms.getHinhThucMuon(),pms.getSach().getTenSach(),pms.getThoiGianMuon(),pms.getThoiGianTra(),pms.getSoTienTheChap(),pms.getTrangThai()};
			
			model.addRow(row);
			
		}
		model.fireTableDataChanged();
		tbl_dSSach.setModel(model);
	}
}
