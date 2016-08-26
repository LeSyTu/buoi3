package baitapbuoi3.bai1;

import java.io.Serializable;

public class Student implements Serializable {
	private String studentID;
	private String name;
	private int age;
	
	

	
	public Student(String studentID, String name, int age) {
		this.studentID = studentID;
		this.name = name;
		this.age = age;
	}
	public String getStudentID() {
		return studentID;
	}





	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}





	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		String result = this.studentID+ " ; " +  this.name + " ; " + this.age + "\r\n";
		return result;
	}
	
}