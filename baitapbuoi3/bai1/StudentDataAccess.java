package baitapbuoi3.bai1;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class StudentDataAccess {
	
	public static void writeToBinaryFile(List<Student> listStudent) throws IOException {
	ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new  FileOutputStream("D:\\Sinhvien19.txt"));
			oos.writeObject(listStudent);
			oos.close();
			
		} catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
			
	}
	
	public static List<Student> readFromBinaryFile(String path) throws IOException{
		ObjectInputStream ois = null;
		List<Student> listStudent = null;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
			Object obj = ois.readObject();
			listStudent = ( List<Student> )obj;
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return listStudent;
		
	}
	
	public static  void  writeToTextFile(List<Student> listStudent) throws IOException {
		FileWriter filewriter = new FileWriter("D:\\example.txt");
		BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
		
		String listContent;
		listContent = listStudent.toString();
		bufferedwriter.write(listContent);
		bufferedwriter.close();
		
	}
}
