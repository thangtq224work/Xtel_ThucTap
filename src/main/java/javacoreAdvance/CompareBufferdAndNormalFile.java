package javacoreAdvance;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class CompareBufferdAndNormalFile {
	public static void main(String[] args) throws IOException {
		Date dateStart = new Date();
		FileInputStream fileInputStream = new FileInputStream("logo.png");
		int rs = -1;
		while ((rs = fileInputStream.read()) != -1) {
//			System.err.print(rs + "");
		}
		Date dateEnd = new Date();
		System.err.println("FileInputStream : " + (dateEnd.getTime() - dateStart.getTime()));
		Date dateStart2 = new Date();
		FileInputStream fileInputStream2 = new FileInputStream("logo2.png");
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream2);
		int rs2 = -1;
		while ((rs2 = bufferedInputStream.read()) != -1) {
//			System.err.print(rs + "");
		}
		Date dateEnd2 = new Date();
		fileInputStream.close();
		bufferedInputStream.close();
		System.err.println("BufferedInputStream : " + (dateEnd2.getTime() - dateStart2.getTime()));

		DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("D://demo.dat"));
		dataOutputStream.writeUTF("Xin chao cac ban");
		dataOutputStream.writeDouble(201.3);
		dataOutputStream.close();
		DataInputStream dataInputStream = new DataInputStream(new FileInputStream("D://demo.dat"));
		System.err.println(dataInputStream.readUTF());
		System.err.println(dataInputStream.readDouble());

		dataInputStream.close();
	}
}
