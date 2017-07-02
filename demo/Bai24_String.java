package javademo.demo;

//String, toString, StringBuffer, StringBuilder

import java.util.Locale;

public class Bai24_String {

	public static void main(String[] args) {
		String str = "I love my family, bố mẹ của tôi";
		System.out.println("str = " + str);

		// Lấy từ vị trí số 2 đến cuối cùng của chuỗi
		System.out.println("str.subtring(2) = " + str.substring(2));

		// Lấy từ vị trí số 2 đến vị trí số 6 của chuỗi
		System.out.println("str.subtring(2,6) = " + str.substring(2, 6));

		System.out.println("str.toLowerCase = "
				+ str.toLowerCase(Locale.ENGLISH));

		System.out.println("str.toUpperCase = "
				+ str.toUpperCase(Locale.ENGLISH));

		// Chuyển đổi từ chuỗi thành mảng ký tự
		char arr[] = str.toCharArray();
		System.out.print("arr[i] = ");
		for (int i = 0; i < str.length(); i++) {
			System.out.print(arr[i] + " ");
		}

		// Chuyển đổi từ mảng ký tự thành chuỗi
		char ch[] = { 'I', ' ', 'L', 'O', 'V', 'E', ' ', 'Y', 'O', 'U' };
		String str1 = new String(ch);
		System.out.println("");
		System.out.println("str1 = String(ch) : " + str1);
	}
}
