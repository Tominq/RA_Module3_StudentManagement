package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.HomeTown;
import model.Student;
import view.StudentManagementView;

public class StudentManagementController implements ActionListener {
	public StudentManagementView view;

	public StudentManagementController(StudentManagementView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "You clicked: " + actionCommand);

		// btn add, after click add, clear all field.
		if (actionCommand.equalsIgnoreCase("Add")) {
			this.view.deleteForm();
			this.view.model.setChoose("Add");
		} else if (actionCommand.equalsIgnoreCase("Save")) {
			try {
				this.view.actionAdd();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (actionCommand.equalsIgnoreCase("Update")) {
			this.view.showStudentInformationOnTable();
		} else if (actionCommand.equalsIgnoreCase("Delete")) {
			this.view.deleteSelectedStudent();
		} else if (actionCommand.equalsIgnoreCase("Cancel")) {
			this.view.deleteForm();
		} else if (actionCommand.equalsIgnoreCase("Search")) {
			this.view.actionSearch();
		} else if (actionCommand.equalsIgnoreCase("OK")) {
			this.view.actionReRenderData();
		} else if (actionCommand.equalsIgnoreCase("About Me")) {
			this.view.actionAbout();
		} else if (actionCommand.equalsIgnoreCase("Exit")) {
			this.view.actionExitApp();
		} else if (actionCommand.equalsIgnoreCase("Close")) {
			this.view.actionCloseAndSave();
		} else if (actionCommand.equalsIgnoreCase("Open")) {
			this.view.actionOpenFile();
		}
	}
}