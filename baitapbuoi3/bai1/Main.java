package baitapbuoi3.bai1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static String name;
	static int age;
	static String address;
	static String studentID;
	static Scanner input = new Scanner(System.in);
	static StudentManager studentManager = new StudentManager();
	static StudentDataAccess studentDataAccess = new StudentDataAccess();

	public static void main(String[] args) throws IOException {

		// StudentManager sm = new StudentManager();
		//
		// sm.getListStudent().add(student1);
		// sm.getListStudent().add(student2);
		//// List<Student> listStudent = new ArrayList<Student>();
		//// listStudent.add(student1);
		//// listStudent.add(student2);
		//
		//
		//
		//
		//
		// StudentDataAccess sda = new StudentDataAccess();
		// //sda.writeToBinaryFile(sm.getListStudent());
		// System.out.println(sda.readFromBinaryFile("D:\\Sinhvien4.txt"));

		while (true) {
			System.out.println("------------------Menu-----------------");
			System.out.println("1. Thêm mới sinh viên ");
			System.out.println("2. Xóa sinh viên theo Mã sinh viên");
			System.out.println("3. Sửa thông tin sinh viên theo mã sinh viên");
			System.out.println("4. Ghi danh sách sinh viên vào file Binary");
			System.out.println("5. Đọc danh sách sinh viên từ file binary");
			System.out.println("6. Ghi danh sách sinh viên vào file text");
			System.out.println("8. Hiển thị danh sách sinh viên");
			System.out.println("9. Thoát");
			System.out.println("Chọn: ");

			int choose;

			try {
				choose = input.nextInt();

				switch (choose) {
				case 1:
					addStudent();
					break;
				case 2:
					deleteStudent();
					break;
				case 3:
					editStudent();
					break;
				case 4:
					writeToBinaryFile();
					break;
				case 5:
					readToBinaryFile();
					break;
				case 6:
					writeToTextFile();
					break;

				case 8:
					listStudents();
					break;
				case 9:
					break;
				default:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Nhập sai! Nhập lại!");
				input.nextLine();
			}

		}
	}

	public static void addStudent() {
		input.nextLine();
		System.out.println("Nhập mã sinh viên: ");
		studentID = input.nextLine();

		System.out.println("Nhập họ và tên: ");
		name = input.nextLine();

		System.out.println("Nhập tuổi: ");
		while (true) {
			try {
				age = input.nextInt();
				if (studentManager.addStudent(new Student(studentID, name, age))) {
					System.out.println("Thêm thành công!");
				} else {
					System.out.println("Thêm thất bại!");
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Nhập tuổi không đúng định dạng! Nhập lại!");
				input.nextLine();
			}
		}
	}

	public static void editStudent() {
		input.nextLine();
		System.out.println("Nhập mã sinh viên cần sửa: ");
		studentID = input.nextLine();

		System.out.println("Nhập tên mới: ");
		name = input.nextLine();

		System.out.println("Nhap tuổi: ");

		try {
			age = input.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("Nhap sai định dạng, Nhập lại!");
			input.nextLine();
		}
		if (studentManager.EditStudent(studentID, name, age)) {
			System.out.println("Sửa thành công!");
		} else {
			System.out.println("Sửa thất bại!");
		}

	}

	public static void deleteStudent() {
		input.nextLine();
		System.out.println("Nhập mã sinh viên cần xóa: ");
		studentID = input.nextLine();

		if (studentManager.DeleteStudent(studentID)) {
			System.out.println("Xóa thành công!");
		} else {
			System.out.println("Xóa thất bại!");
		}

	}

	public static void listStudents() {
		System.out.println(studentManager.toString());
	}

	public static void writeToTextFile() {
		try {
			StudentDataAccess.writeToTextFile(studentManager.getListStudent());
			System.out.println("Ghi File thành công!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void writeToBinaryFile() {
		try {
			StudentDataAccess.writeToBinaryFile(studentManager.getListStudent());
			System.out.println("Ghi File thành công!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readToBinaryFile() {
		try {
			System.out.println(StudentDataAccess.readFromBinaryFile("D:\\Sinhvien19.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
