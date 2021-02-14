package servlet;

import java.util.Date;

public class Student {

	private Integer id;
	private String name;
	private String gender;
	private String grade;
	private Date createDate;
	
	//shift+alt+s o
	public Student(Integer id, String name, String gender, String grade, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.grade = grade;
		this.createDate = createDate;
	}
	//shift+alt+s r
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", grade=" + grade + ", createDate="
				+ createDate + "]";
	}
	
}
