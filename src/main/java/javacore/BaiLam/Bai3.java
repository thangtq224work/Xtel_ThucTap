package javacore.BaiLam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Bai3 {
	static FileInputStream fileOutputStream = null;

	public static void main(String[] args) {

		String data = getData();
		String datas[] = data.split(" ");
		int numberArr[] = new int[datas.length];
		for (int i = 0; i < datas.length; i++) {
			numberArr[i] = Integer.parseInt(datas[i]);
		}
		for (int i : numberArr) {
			System.err.print(i);
		}
		System.err.println();
		quickSort(numberArr, 0, numberArr.length - 1);
		for (int i : numberArr) {
			System.err.print(i + " -");
		}
	}

	public static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static int partition(int arr[], int low, int high) {
		int p = arr[high];
		int i = low - 1;
		for (int j = low; j < arr.length; j++) {
			if (arr[j] < p) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}

	public static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int p = partition(arr, low, high);

			quickSort(arr, low, p - 1);
			quickSort(arr, p + 1, high);

		}
	}

	public static String getData() {
		try {
			fileOutputStream = new FileInputStream(new File("input.txt"));
			String rs = "";
			int hasNext = -1;
			while ((hasNext = fileOutputStream.read()) != -1) {
				rs += (char) hasNext;
			}
			fileOutputStream.close();
			return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}
}
