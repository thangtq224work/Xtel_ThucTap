package javacore.BaiLam;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Bai1 {
	public static void main(String[] args) throws Exception {
		int count = 0;
		int rs = getNumber();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Nhap so ban chon ");
			// kiem tra dieu kien
			if (scanner.nextInt() == rs) {
				System.out.println("Nhap dung ");
				break;
			}
			count++;
		} while (count < 5);
	}

	// doc du lieu tu file
	public static int getNumber() throws Exception {
		try {
			FileInputStream fileOutputStream = new FileInputStream(new File("data.txt"));
			String rs = "";
			int hasNext = -1;
			while ((hasNext = fileOutputStream.read()) != -1) {
				rs += (char) hasNext;
			}
			return Integer.parseInt(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

}
