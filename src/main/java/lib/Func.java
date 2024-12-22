package lib;

import java.awt.Image;
import java.sql.Timestamp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Func {
	public static boolean checkNumberForm(String s) {
		return s != null && s.matches("\\d+");
	}

	public static ImageIcon fittedIcon(JLabel lbl, ImageIcon icon) {
		int labelWidth = lbl.getWidth();
		int labelHeight = lbl.getHeight();
		Image image = icon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		return new ImageIcon(image);
	}

	public static boolean checkEmail(String s) {
		return s.endsWith("@gmail.com");
	}

	public static String PrintDateTime(Timestamp st) {
		if (st == null) {
			return "";
		}
		String time = + st.getDate() + "-" + (st.getMonth() + 1) + "-" + (st.getYear() + 1900) + " " + st.getHours() + ":" + st.getMinutes();
		return time;
	}

	public static String PrintTime(Timestamp st) {
		if (st == null) {
			return "";
		}
		String time = st.getDate() + "-" + (st.getMonth() + 1) + "-" + (st.getYear() + 1900);
		return time;
	}

	public static void main(String[] args) {
		String s = "k";
		System.out.println(checkEmail(s));
	}

}
