package javacore.BaiLam;

import java.util.Scanner;

import javacore.BaiLam.dao.StudentDao;
import javacore.BaiLam.dao.impl.StudentDaoimpl;
import javacore.BaiLam.model.Student;

public class Bai4 {
	public static void main(String[] args) {
		StudentDao dao = new StudentDaoimpl();
		Scanner sc = new Scanner(System.in);
		boolean condition = true;
		do {
			System.out.println("-----------------");
			System.out.print("Tiep tuc nhap sinh vien (y/n) ?");
			if ("n".equals(sc.nextLine())) {
				break;
			}
			Student student = new Student();
			student = getData(student, dao, sc);
			dao.save(student);
		} while (condition);

	}

	public static Student getData(Student student, StudentDao dao, Scanner scanner) {
		boolean check = true;
		do {
			System.out.print("Nhap ten : ");
			String input = scanner.nextLine();

			if (!dao.isExists(input)) {
				student.setName(input);
				check = false;
			} else {
				System.out.print("Sinh vien da ton tai \n");
			}
		} while (check);
		check = !check;
		System.out.print("Nhap que quan :");
		student.setHometown(scanner.nextLine());
		do {
			System.out.print("Nhap tuoi :");
			try {
				int input = Integer.parseInt(scanner.nextLine());
				student.setAge(input);
				check = false;
			} catch (Exception e) {
			}
		} while (check);
		check = !check;
		do {

			System.out.print("Nhap gioi tinh (1- Nam | 0 - Nu) :");

			try {
				int input = Integer.parseInt(scanner.nextLine());
				if (input == 1 || input == 0) {
					student.setGender(input == 1 ? true : false);
					check = false;
				}
			} catch (Exception e) {
			}
		} while (check);

		return student;
	}
}
