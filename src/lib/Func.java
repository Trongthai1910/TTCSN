package lib;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Func {
	public static boolean checkNumberForm(String s) {
		return s != null  && s.matches("\\d+");		
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
	
	public static void main(String[] args) {
		String s = "k";
		System.out.println(checkEmail(s));
	}
	
}
