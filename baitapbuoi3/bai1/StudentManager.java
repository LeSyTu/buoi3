package baitapbuoi3.bai1;

import java.util.ArrayList;

public class StudentManager {
	private String name;
	ArrayList<Student> listStudent = new ArrayList<>();
	
	
	public StudentManager() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Student> getListStudent() {
		return listStudent;
	}
	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}
	
	public boolean addStudent(Student s) {
		listStudent.add(s);
		return true;
	}
	
	public boolean EditStudent(String studentID,  String newName, int newAge) {
		for(int i = 0; i < listStudent.size(); i++) {
			if(listStudent.get(i).getStudentID().equals(studentID)) {
				listStudent.get(i).setName(newName);
				listStudent.get(i).setAge(newAge);
				return true;
			}
		}
		return false;
	}
	
	public boolean DeleteStudent(String studentID) {
		for(int i = 0; i < listStudent.size();i++) {
			if(listStudent.get(i).getStudentID().equals(studentID)) {
				listStudent.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String all = "";
		for(int i = 0; i < listStudent.size();i++) {
			all += listStudent.get(i).toString()+"\r\n";
		}
		return all;
	}
	
	
	
	
}
