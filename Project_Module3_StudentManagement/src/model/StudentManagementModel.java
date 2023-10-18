package model;

import java.io.File;
import java.util.ArrayList;

public class StudentManagementModel {
	private ArrayList<Student> studentsList;
	private String choose;
	private String fileName;
	
	public StudentManagementModel() {
		this.studentsList = new ArrayList<Student>();
		this.choose = "";
		this.fileName = "";
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public StudentManagementModel(ArrayList<Student> studentsList) {
		this.studentsList = studentsList;
		
	}

	public ArrayList<Student> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(ArrayList<Student> studentsList) {
		this.studentsList = studentsList;
	}

	public void addStudent(Student student) {
		this.studentsList.add(student);
	}

	public void removeStudent(Student student) {
		this.studentsList.remove(student);
	}

	public void updateStudent(Student student) {
		this.studentsList.remove(student);
		this.studentsList.add(student);
	}

	public String getChoose() {
		return choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
	}

	public boolean checkExist(Student student) {
		//TODO: what if student array extend to 10 000 students, for loop will too slow as O(n), are there any way to solve
		for (Student st : studentsList) {
			if(st.getStudentID()== student.getStudentID()) {
				return true;
			}
		}
		return false;
	}

}
