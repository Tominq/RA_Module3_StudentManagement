package test;

import javax.swing.UIManager;

import view.StudentManagementView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new StudentManagementView();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
}
