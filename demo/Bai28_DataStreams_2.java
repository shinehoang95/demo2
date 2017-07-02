package javademo.demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Bai28_DataStreams_2 {
	public static void main(String[] args) throws IOException {
		SV28 sv = new SV28();
		sv.file = new File("C:\\Users/PC/Desktop/java/JavaBasic/student28.txt");
		if (sv.file.exists()) {
			sv.readSV28();
		} else
			sv.writeSV28();
		System.out.print("Done");
	}
}

class SV28 {
	private String ten;
	private int namSinh;
	private double diemTB;
	DataOutputStream dos;
	DataInputStream dis;
	File file;
	Scanner k = new Scanner(System.in);

	public void readSV28() throws IOException {
		try {
			dis = new DataInputStream(new FileInputStream(
					"C:\\Users/PC/Desktop/java/JavaBasic/student28.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			ten = dis.readUTF();
			System.out.println("Student's name : " + ten);
			namSinh = dis.readInt();
			System.out.println("Student's year of birth : " + namSinh);
			diemTB = dis.readDouble();
			System.out.println("Student's grade point average : " + diemTB);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dis.close();

	}

	public void writeSV28() throws IOException {
		try {
			dos = new DataOutputStream(new FileOutputStream(
					"C:\\Users/PC/Desktop/java/JavaBasic/student28.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.print("Enter the name of student : ");
			ten = k.nextLine();
			dos.writeUTF(ten);
			System.out.print("Enter the year of birth of student : ");
			namSinh = k.nextInt();
			dos.writeInt(namSinh);
			System.out.print("Enter the grade point average of student : ");
			diemTB = k.nextDouble();
			dos.writeDouble(diemTB);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dos.close();
	}
}