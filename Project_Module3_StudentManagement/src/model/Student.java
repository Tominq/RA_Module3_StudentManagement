package model;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Student implements Serializable{
    private int studentID;
    private String studentName;
    private Date dayOfBirth;
    private HomeTown homeTown;
    private boolean gender;
    private float subjectScore1, subjectScore2, subjectScore3;

    public Student() {

    }

    public Student(int studentID, String studentName, Date dayOfBirth, HomeTown homeTown, boolean gender,
			float subjectScore1, float subjectScore2, float subjectScore3) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.dayOfBirth = dayOfBirth;
		this.homeTown = homeTown;
		this.gender = gender;
		this.subjectScore1 = subjectScore1;
		this.subjectScore2 = subjectScore2;
		this.subjectScore3 = subjectScore3;
	}



	public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public HomeTown getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(HomeTown homeTown) {
        this.homeTown = homeTown;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getSubjectScore1() {
        return subjectScore1;
    }

    public void setSubjectScore1(float subjectScore1) {
        this.subjectScore1 = subjectScore1;
    }

    public float getSubjectScore2() {
        return subjectScore2;
    }

    public void setSubjectScore2(float subjectScore2) {
        this.subjectScore2 = subjectScore2;
    }

    public float getSubjectScore3() {
        return subjectScore3;
    }

    public void setSubjectScore3(float subjectScore3) {
        this.subjectScore3 = subjectScore3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", homeTown=" + homeTown +
                ", dayOfBirth=" + dayOfBirth +
                ", gender=" + gender +
                ", subjectScore1=" + subjectScore1 +
                ", subjectScore2=" + subjectScore2 +
                ", subjectScore3=" + subjectScore3 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getStudentID() == student.getStudentID() && isGender() == student.isGender() && Float.compare(getSubjectScore1(), student.getSubjectScore1()) == 0 && Float.compare(getSubjectScore2(), student.getSubjectScore2()) == 0 && Float.compare(getSubjectScore3(), student.getSubjectScore3()) == 0 && Objects.equals(getStudentName(), student.getStudentName()) && Objects.equals(getHomeTown(), student.getHomeTown()) && Objects.equals(getDayOfBirth(), student.getDayOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentID(), getStudentName(), getHomeTown(), getDayOfBirth(), isGender(), getSubjectScore1(), getSubjectScore2(), getSubjectScore3());
    }
}
