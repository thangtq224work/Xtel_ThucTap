package javacoreAdvance.BaiLam;

import java.util.Scanner;
import java.util.Timer;

import javacoreAdvance.BaiLam.model.MyThreadB2;

public class Bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Timer timer = new Timer();
		MyThreadB2 b2 = new MyThreadB2(n, timer);
		timer.schedule(b2, 0, n * 1000);
	}
}
