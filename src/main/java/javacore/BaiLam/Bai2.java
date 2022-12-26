package javacore.BaiLam;

import java.util.Scanner;

public class Bai2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = -1;
		try {
			System.out.print("Nhap so dien : ");
			number = scanner.nextInt();
			// kiem tra dau vao
			if (number <= 0) {
				System.err.println("Du lieu dau vao khong hop le");
				return;
			}
			System.out.printf("Gia tien %.2f", getValue(number));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// xu ly logic
	public static float getValue(int input) {
		int tmp = (input - 50) / 50;
		int money = 1000 + tmp * 500;
		return input * money;
	}
//	public static float getValue(int input) {
//		float rs = 0;
//		if(input <=100) {
//			rs = input*1000;
//		}else if(input <=150) {
//			rs = input*1500;
//		}else {
//			rs = input*2000;
//		}
//		return rs;
//	}
}
