package view;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import model.HomeTown;
import model.Student;
import model.StudentManagementModel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.StudentManagementController;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class StudentManagementView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public StudentManagementModel model;
	private JTextField textField_StudentID;
	private final Box verticalBox = Box.createVerticalBox();
	private JTable table;
	public JTextField textField_ID;
	public JTextField textField_Name;
	public JTextField textField_Math;
	public JTextField textField_Physical;
	public JTextField textField_Chemistry;
	public JTextField textField_DateOfBirth;
	public JComboBox comboBox_Place_2;
	public ButtonGroup btn_gender;
	public JRadioButton rdbtn_Male;
	public JRadioButton rdbtn_Female;
	public JComboBox comboBox_Place_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagementView frame = new StudentManagementView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the frame. ToMinq17 14/10/2023 Road to big tech
	 * 
	 */
	public StudentManagementView() {
		//TODO: the function is too long and hard for another people to find exactly where to maintain

		this.model = new StudentManagementModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 630);

		ActionListener action = new StudentManagementController(this);
//JMenu Bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
//JMenu 
		JMenu menuFile = new JMenu("File");
		menuFile.setHorizontalAlignment(SwingConstants.LEFT);
		menuFile.setFont(new Font("Dialog", Font.PLAIN, 17));
		menuBar.add(menuFile);
//JMenu Item (Btn Open)
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setHorizontalAlignment(SwingConstants.LEFT);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuOpen);
//JMenu Item (Btn Close)
		JMenuItem menuClose = new JMenuItem("Close");
		menuClose.addActionListener(action);
		menuClose.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuClose);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);
//JMenu Item (Btn Exit)
		JMenuItem menuSave = new JMenuItem("Exit");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuSave);
//JMenu Item (Btn About)
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Dialog", Font.PLAIN, 17));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Dialog", Font.PLAIN, 15));
		menuAbout.add(menuAboutMe);
		menuBar.add(verticalBox);
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		Box horizontalBox = Box.createHorizontalBox();
		menuBar.add(horizontalBox);

		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPlace = new JLabel("Place");
		lblPlace.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPlace.setBounds(10, 11, 60, 29);
		contentPane.add(lblPlace);

		JLabel lblStudentid = new JLabel("Student ID");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentid.setBounds(214, 12, 75, 28);
		contentPane.add(lblStudentid);

		textField_StudentID = new JTextField();
		textField_StudentID.setBounds(288, 14, 101, 29);
		contentPane.add(textField_StudentID);
		textField_StudentID.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(action);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(399, 12, 81, 29);
		contentPane.add(btnSearch);

		comboBox_Place_1 = new JComboBox();
		ArrayList<HomeTown> listTowns = HomeTown.getProvinceList();
		comboBox_Place_1.addItem(" ");
		for (HomeTown homeTown : listTowns) {
			comboBox_Place_1.addItem(homeTown.getProvince());
		}
		comboBox_Place_1.setBounds(68, 14, 123, 29);
		contentPane.add(comboBox_Place_1);

		JLabel lblStudentList = new JLabel("Student List");
		lblStudentList.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStudentList.setBounds(10, 70, 88, 29);
		contentPane.add(lblStudentList);

		table = new JTable();
		table.setRowHeight(25);

		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Date", "Place", "Gender", "Math", "Physical", "Chemistry"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 96, 572, 205);
		contentPane.add(scrollPane);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 312, 568, 2);
		contentPane.add(separator_1);

		JLabel lblS = new JLabel("Student Information");
		lblS.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblS.setBounds(10, 312, 156, 29);
		contentPane.add(lblS);

		JLabel lbl_ID = new JLabel("Student ID");
		lbl_ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_ID.setBounds(10, 352, 75, 28);
		contentPane.add(lbl_ID);

		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(115, 352, 132, 29);
		contentPane.add(textField_ID);

		JLabel lbl_StudentName = new JLabel("Student Name");
		lbl_StudentName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_StudentName.setBounds(10, 388, 101, 28);
		contentPane.add(lbl_StudentName);

		textField_Name = new JTextField();
		textField_Name.setColumns(10);
		textField_Name.setBounds(115, 387, 132, 29);
		contentPane.add(textField_Name);

		JLabel lbl_Place = new JLabel("Home Town");
		lbl_Place.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Place.setBounds(10, 428, 101, 28);
		contentPane.add(lbl_Place);

		comboBox_Place_2 = new JComboBox();
		comboBox_Place_2.addItem(" ");
		for (HomeTown homeTown : listTowns) {
			comboBox_Place_2.addItem(homeTown.getProvince());
		}
		comboBox_Place_2.setBounds(115, 427, 132, 29);
		contentPane.add(comboBox_Place_2);

		JLabel lbl_DateOfBirth = new JLabel("Date Of Birth");
		lbl_DateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_DateOfBirth.setBounds(10, 468, 101, 28);
		contentPane.add(lbl_DateOfBirth);

		JLabel lbl_Gender = new JLabel("Gender");
		lbl_Gender.setFont(new Font("Dialog", Font.PLAIN, 15));
		lbl_Gender.setBounds(308, 352, 75, 28);
		contentPane.add(lbl_Gender);

		rdbtn_Male = new JRadioButton("Male");
		rdbtn_Male.setFont(new Font("Dialog", Font.PLAIN, 15));
		rdbtn_Male.setBounds(389, 355, 75, 23);
		contentPane.add(rdbtn_Male);

		rdbtn_Female = new JRadioButton("Female");
		rdbtn_Female.setFont(new Font("Dialog", Font.PLAIN, 15));
		rdbtn_Female.setBounds(469, 355, 109, 23);
		contentPane.add(rdbtn_Female);

//		create group btn
		btn_gender = new ButtonGroup();
		btn_gender.add(rdbtn_Male);
		btn_gender.add(rdbtn_Female);

		JLabel lbl_MathScore = new JLabel("Math");
		lbl_MathScore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MathScore.setBounds(309, 388, 101, 28);
		contentPane.add(lbl_MathScore);

		textField_Math = new JTextField();
		textField_Math.setColumns(10);
		textField_Math.setBounds(399, 390, 132, 29);
		contentPane.add(textField_Math);

		JLabel lbl_PhysicalScore = new JLabel("Physical");
		lbl_PhysicalScore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_PhysicalScore.setBounds(309, 429, 101, 28);
		contentPane.add(lbl_PhysicalScore);

		textField_Physical = new JTextField();
		textField_Physical.setColumns(10);
		textField_Physical.setBounds(399, 430, 132, 29);
		contentPane.add(textField_Physical);

		JLabel lbl_ChemistryScore = new JLabel("Chemistry");
		lbl_ChemistryScore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_ChemistryScore.setBounds(309, 469, 101, 28);
		contentPane.add(lbl_ChemistryScore);

		textField_Chemistry = new JTextField();
		textField_Chemistry.setColumns(10);
		textField_Chemistry.setBounds(399, 470, 132, 29);
		contentPane.add(textField_Chemistry);

//		button add
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(action);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(10, 522, 88, 29);
		contentPane.add(btnAdd);

//		button delete
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(action);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(125, 522, 88, 29);
		contentPane.add(btnDelete);

//		button Update	
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(action);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(236, 522, 88, 29);
		contentPane.add(btnUpdate);

//		button save

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(action);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(354, 522, 88, 29);
		contentPane.add(btnSave);

//		button cancel

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(action);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(469, 522, 88, 29);
		contentPane.add(btnCancel);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(6, 57, 568, 2);
		contentPane.add(separator_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 507, 568, 2);
		contentPane.add(separator_1_1_1);

		textField_DateOfBirth = new JTextField();
		textField_DateOfBirth.setColumns(10);
		textField_DateOfBirth.setBounds(115, 467, 132, 29);
		contentPane.add(textField_DateOfBirth);

		JButton btnCancelSearch = new JButton("OK");
		btnCancelSearch.addActionListener(action);
		btnCancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelSearch.setBounds(490, 12, 88, 29);
		contentPane.add(btnCancelSearch);

		this.setVisible(true);
	}

//delete all form sfter click btn
	public void deleteForm() {
		// TODO Auto-generated method stub
		textField_ID.setText("");
		textField_Name.setText("");
		textField_StudentID.setText("");
		textField_DateOfBirth.setText("");
		textField_Math.setText("");
		textField_Physical.setText("");
		textField_Chemistry.setText("");
		comboBox_Place_2.setSelectedIndex(-1);
		btn_gender.clearSelection();
	}

	/*
	 * Logic CRUD in table swing
	 * 
	 * Frist: i write a method, to add a student's data to a row in table, to re-use
	 * code. Next: logic add and update table in all input fields. Next: method get
	 * selected Student, if user clicked the table, ang update button, get data from
	 * the table back to field.
	 */

	/*
	 * add a student's data to a row in table, to re-use code, data in JTable is
	 * called by model_table Data includes ID, name, province, date of birth, Math's
	 * score, Physical's score, Chemistry's score Add a new row with the student's
	 * information Use class DefaultTableModel to implement JTable method.
	 */

	public void addStudentToTable(Student student) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { student.getStudentID() + "", student.getStudentName(),
				student.getDayOfBirth().getDate() + "/" + (student.getDayOfBirth().getMonth() + 1) + "/"
						+ (student.getDayOfBirth().getYear() + 1900),
				student.getHomeTown().getProvince(), student.isGender() ? "Male" : "Female",
				student.getSubjectScore1() + "", student.getSubjectScore2() + "", student.getSubjectScore3()

		});
	}

	/*
	 * Logic add and update data in table, I check studentID, if exitsted, i go to
	 * method update, In logic update, get data from the table back to the input
	 * field.
	 */
	public void AddOrUpdateStudentInfor(Student student) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		// If the student dosen't exist, add them to the model and table
		if (!this.model.checkExist(student)) {
			this.model.addStudent(student);
			this.addStudentToTable(student);
		} else {
			// If the student exists, update their information in the model and table
			this.model.updateStudent(student);
			// Find the row corresponding to the studnet's ID and update the table values
			int countRow = model_table.getRowCount();
			for (int i = 0; i < countRow; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equalsIgnoreCase(student.getStudentID() + "")) {
					model_table.setValueAt(student.getStudentID() + "", i, 0);
					model_table.setValueAt(student.getStudentName() + "", i, 1);
					model_table.setValueAt(
							student.getDayOfBirth().getDate() + "/" + (student.getDayOfBirth().getMonth() + 1) + "/"
									+ (student.getDayOfBirth().getYear() + 1900),
							i, 2);
					model_table.setValueAt(student.getHomeTown().getProvince() + "", i, 3);
					model_table.setValueAt(student.isGender() ? "Male" : "Female", i, 4);
					model_table.setValueAt(student.getSubjectScore1() + "", i, 5);
					model_table.setValueAt(student.getSubjectScore2() + "", i, 6);
					model_table.setValueAt(student.getSubjectScore3() + "", i, 7);
				}
			}
		}
	}

//	logic get the selected student's information
	public Student getStudentSelected() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int indexRow = table.getSelectedRow();
		int studentID = Integer.valueOf(model_table.getValueAt(indexRow, 0) + "");
		String studentName = model_table.getValueAt(indexRow, 1) + "";
		HomeTown provinceName = HomeTown.getProvinceByName(model_table.getValueAt(indexRow, 3) + "");
		String dayOfBirthStr = model_table.getValueAt(indexRow, 2) + "";
		Date dayOfBirth = new Date(dayOfBirthStr);
		String textGender = model_table.getValueAt(indexRow, 4) + "";
		boolean gender = textGender.equalsIgnoreCase("Male");
		float mathScore = Float.valueOf(model_table.getValueAt(indexRow, 5) + "");
		float physicalScore = Float.valueOf(model_table.getValueAt(indexRow, 6) + "");
		float chemistryScore = Float.valueOf(model_table.getValueAt(indexRow, 7) + "");

		Student st = new Student(studentID, studentName, dayOfBirth, provinceName, gender, mathScore, physicalScore,
				chemistryScore);
		return st;
	}

// Display the selected stuadent's information in input fields
	public void showStudentInformationOnTable() {
		Student ts = getStudentSelected();
		this.textField_ID.setText(ts.getStudentID() + "");
		this.textField_Name.setText(ts.getStudentName());
		String tsDayOfBirth = ts.getDayOfBirth().getDate() + "/" + (ts.getDayOfBirth().getMonth() + 1) + "/"
				+ (ts.getDayOfBirth().getYear() + 1900);
		this.textField_DateOfBirth.setText(tsDayOfBirth);
		this.comboBox_Place_2.setSelectedItem(ts.getHomeTown().getProvince());
		if (ts.isGender()) {
			rdbtn_Male.setSelected(true);
		} else {
			rdbtn_Female.setSelected(true);
		}

		this.textField_Math.setText(ts.getSubjectScore1() + "");
		this.textField_Physical.setText(ts.getSubjectScore2() + "");
		this.textField_Chemistry.setText(ts.getSubjectScore3() + "");
	}

//Delete the selected student from the table
	public void deleteSelectedStudent() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int indexRow = table.getSelectedRow();
		int chose = JOptionPane.showConfirmDialog(this, "Want to delete, bro ?");
		if (chose == JOptionPane.YES_OPTION) {
			Student ts = getStudentSelected();
			this.model.removeStudent(ts);
			model_table.removeRow(indexRow);
		}
	}

//	action add
	public void actionAdd() {
	    try {
	        // Get data from all fields
	        int studentID = Integer.parseInt(this.textField_ID.getText());
	        if (studentID <= 0) {
	            throw new IllegalArgumentException("Invalid student ID. Please enter a positive integer.");
	        }

	        String studentName = this.textField_Name.getText();
	        if (studentName.isEmpty()) {
	            throw new IllegalArgumentException("Student name cannot be empty.");
	        }

	        int homeTown = this.comboBox_Place_2.getSelectedIndex() - 1;
	        if (homeTown < 0) {
	            throw new IllegalArgumentException("Please select a province.");
	        }
	        HomeTown province = HomeTown.getProvinceById(homeTown);

	        String dateOfBirthStr = this.textField_DateOfBirth.getText();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
	        Date dayOfBirth = null;
	        try {
	            dayOfBirth = dateFormat.parse(dateOfBirthStr);
	        } catch (ParseException e) {
	            throw new IllegalArgumentException("Invalid date format. Please enter date in dd/MM/yy format.");
	        }

	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(dayOfBirth);
	        int year = calendar.get(Calendar.YEAR);
	        if (year <= 1975) {
	            throw new IllegalArgumentException("Invalid year of birth. Year must be greater than 1975.");
	        }

	        boolean gender = true;
	        if (this.rdbtn_Male.isSelected()) {
	            gender = true;
	        } else if (this.rdbtn_Female.isSelected()) {
	            gender = false;
	        } else {
	            throw new IllegalArgumentException("Please select a gender.");
	        }

	        float mathScore = Float.parseFloat(this.textField_Math.getText());
	        if (mathScore < 0 || mathScore > 10) {
	            throw new IllegalArgumentException("Invalid math score. Score must be between 0 and 10.");
	        }

	        float physicalScore = Float.parseFloat(this.textField_Physical.getText());
	        if (physicalScore < 0 || physicalScore > 10) {
	            throw new IllegalArgumentException("Invalid physical score. Score must be between 0 and 10.");
	        }

	        float chemistryScore = Float.parseFloat(this.textField_Chemistry.getText());
	        if (chemistryScore < 0 || chemistryScore > 10) {
	            throw new IllegalArgumentException("Invalid chemistry score. Score must be between 0 and 10.");
	        }

	        Student student = new Student(studentID, studentName, dayOfBirth, province, gender, mathScore, physicalScore,
	                chemistryScore);
	        this.AddOrUpdateStudentInfor(student);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for ID and scores.", "Error", JOptionPane.ERROR_MESSAGE);
	    } catch (IllegalArgumentException e) {
	        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

//	action search
	public void actionSearch() {
		// call method cancel search
		this.actionReRenderData();
		// TODO Auto-generated method stub
		int homeTown = this.comboBox_Place_1.getSelectedIndex() - 1;
		String studentIDSearch = this.textField_StudentID.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int countRow = table.getRowCount();

		Set<Integer> deleteIDStudent = new TreeSet<Integer>();

		if (homeTown >= 0) {
			HomeTown selectedHometown = HomeTown.getProvinceById(homeTown);
			System.out.println("provience name: " + selectedHometown);
			for (int i = 0; i < countRow; i++) {
				String provinceName = model_table.getValueAt(i, 3) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!provinceName.equalsIgnoreCase(selectedHometown.getProvince())) {
					deleteIDStudent.add(Integer.valueOf(id));
				}
			}
		}

		if (studentIDSearch.length() > 0) {
			for (int i = 0; i < countRow; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(studentIDSearch)) {
					deleteIDStudent.add(Integer.valueOf(id));
				}
			}
		}

		for (Integer idNeedDelete : deleteIDStudent) {
			System.out.println("id cần xóa: " + idNeedDelete);
			countRow = table.getRowCount();
			for (int i = 0; i < countRow; i++) {
				String idInTable = model_table.getValueAt(i, 0) + "";
				if (idInTable.equals(idNeedDelete.toString())) {
					System.out.println("Deleted");
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

//	logic cancel search, and reset data in table, re render data
	public void actionReRenderData() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int countRow = table.getRowCount();
			if (countRow == 0) {
				break;
			} else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		for (Student st : this.model.getStudentsList()) {
			this.addStudentToTable(st);
		}
	}

//	logic action about me
	public void actionAbout() {
		JOptionPane.showMessageDialog(this, "So, don't quit. Bro! ");
	}

//Menu button Eixt progaram
	public void actionExitApp() {
		int chose = JOptionPane.showConfirmDialog(this, "Want to exit, bro?", "CLose", JOptionPane.YES_NO_OPTION);
		if (chose == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

// save file
	public void saveFile(String path) {
		try {
			this.model.setFileName(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Student st : this.model.getStudentsList()) {
				oos.writeObject(st);
			}
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	menu open file
	private void openFile(File file) {
		ArrayList<Student> stList = new ArrayList<Student>();
		try {
			this.model.setFileName(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student st = null;
			while ((st = (Student) ois.readObject()) != null) {
				stList.add(st);
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.model.setStudentsList(stList);
	}
// menu close and save file

	public void actionCloseAndSave() {
		if (this.model.getFileName().length() > 0) {
			// If the file name is already set, save the file using the existing name
			saveFile(this.model.getFileName());
		} else {
			// If the file name is not set, prompt the user to choose a file location to
			// save
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

//Menu open file in computer
	public void actionOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			actionReRenderData();
		}
	}
}