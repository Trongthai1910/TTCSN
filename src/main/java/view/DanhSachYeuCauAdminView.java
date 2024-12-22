package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.PhieuMuonSachDAO;
import DAO.SachDAO;
import DAO.TaiKhoanDAO;
import DAO.YeuCauMuonTraDAO;
import entity.PhieuMuonSach;
import entity.TaiKhoan;
import entity.YeuCauMuonTra;
import lib.Func;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DanhSachYeuCauAdminView extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model = new DefaultTableModel();
	JTable tbl_DSYeuCau = new JTable();
	private JPopupMenu popUp = new JPopupMenu();

	/**
	 * Create the panel.
	 */
	public DanhSachYeuCauAdminView() {		
		setLayout(new BorderLayout(0, 0));
		model.setColumnIdentifiers(
				new String[] {"Mã yêu cầu","Sách","Hình thức mượn","Thời gian yêu cầu","Họ tên","Email","Số điện thoại","Tình trạng"});
		model.setRowCount(0);
		ArrayList<YeuCauMuonTra> dSYeuCau = YeuCauMuonTraDAO.getInstance().selectedAll();
		for (YeuCauMuonTra yc : dSYeuCau) {
			Object[] row = new Object[] {yc.getMaYeuCau(),yc.getSach().getTenSach(),yc.getHinhThucMuon(),Func.PrintDateTime(yc.getThoiGianYeuCau()),yc.getHoTen(),yc.getEmail(),yc.getSoDienThoai(),yc.getTinhTrang()};

			model.addRow(row);

		}
		model.fireTableDataChanged();
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btn_Tatca = new JButton("Tất cả yêu cầu");
		btn_Tatca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultInfor();
			}
		});
		btn_Tatca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btn_Tatca);
		
		
		tbl_DSYeuCau.setModel(model);
		JScrollPane scrollPane = new JScrollPane(tbl_DSYeuCau);
		add(scrollPane, BorderLayout.CENTER);
		
		tbl_DSYeuCau.setComponentPopupMenu(popUp);
		addPopup(tbl_DSYeuCau, popUp);
		
		JMenuItem item_Duyet = new JMenuItem("Duyệt");
		item_Duyet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailRequest();
			}
		});
		JMenuItem item_TuChoi = new JMenuItem("Từ chối");
//		item2.addActionListener(controller);

		popUp.add(item_Duyet);

		JSeparator separator = new JSeparator();
		popUp.add(separator);
		popUp.add(item_TuChoi);
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
	public void detailRequest() {
		int selectedRow = tbl_DSYeuCau.getSelectedRow();
		int selectedMaYeuCau = Integer.parseInt(tbl_DSYeuCau.getValueAt(selectedRow, 0).toString());
		YeuCauMuonTra yc = YeuCauMuonTraDAO.getInstance().selectedById(new YeuCauMuonTra(selectedMaYeuCau));
		ChiTietYeuCauAdminView ct = new ChiTietYeuCauAdminView(yc);
		ct.setVisible(true);
	}
	public void defaultInfor() {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(
				new String[] {"Mã yêu cầu","Sách","Hình thức mượn","Thời gian yêu cầu","Họ tên","Email","Số điện thoại","Tình trạng"});
		model.setRowCount(0);
		ArrayList<YeuCauMuonTra> dSYeuCau = YeuCauMuonTraDAO.getInstance().selectedAll();
		for (YeuCauMuonTra yc : dSYeuCau) {
			Object[] row = new Object[] {yc.getMaYeuCau(),yc.getSach().getTenSach(),yc.getHinhThucMuon(),Func.PrintDateTime(yc.getThoiGianYeuCau()),yc.getHoTen(),yc.getEmail(),yc.getSoDienThoai(),yc.getTinhTrang()};

			model.addRow(row);
		}
		model.fireTableDataChanged();
		tbl_DSYeuCau.setModel(model);
	}
}
