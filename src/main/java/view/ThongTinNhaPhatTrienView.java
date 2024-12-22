package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class ThongTinNhaPhatTrienView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ThongTinNhaPhatTrienView() {
		setBounds(100, 100, 487, 468);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thư viện ABC");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(115, 48, 241, 54);
		contentPanel.add(lblNewLabel);
		
		JLabel lblPhtTrinBi = new JLabel("Phát triển bới nhóm 11");
		lblPhtTrinBi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhtTrinBi.setBounds(89, 324, 241, 54);
		contentPanel.add(lblPhtTrinBi);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 312, 395, 2);
		contentPanel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("src\\\\resource\\\\iconDauSach.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(37, 48, 55, 54);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ThongTinNhaPhatTrienView.this.setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
