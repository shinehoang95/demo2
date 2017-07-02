package javademo.demo;

import java.util.Scanner;

public class Bai24_String_2 {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		String[] str = null;
		int i;
		boolean found = false;
		Students24 st = new Students24();
		i = st.inputNumber();
		str = new String[i];
		System.out.println("Enter the full name of student ");
		for (int j = 0; j < str.length; j++) {
			System.out.print("Student [" + (j + 1) + "] : ");
			str[j] = st.inputName();
		}
		System.out.println("The people have Nguyen in the last name : ");
		for (int j = 0; j < str.length; j++) {
			if (str[j].trim().toUpperCase().substring(0, 6).equals("NGUYEN")) {
				System.out.println(str[j].trim());
				found = true;
			}
		}
		if (!found) {
			System.out.print("Sorry ! Nobody has Nguyen in the last name");
		}
		k.close();
	}
}

class Students24 {
	Scanner k = new Scanner(System.in);

	protected String name;

	public String inputName() {
		name = k.nextLine();
		return name;
	}

	public int inputNumber() {
		System.out.print("Enter the number of students : ");
		boolean continueLoop = true;
		int i = 0;
		while (continueLoop) {
			try {
				String st1 = null;
				st1 = k.nextLine();
				i = Integer.valueOf(st1).intValue();
//				i = k.nextInt();
				if (i > 0)
					continueLoop = false;
				else
					throw new IllegalArgumentException(
							"The number of students is greater than 0 !");
			} catch (Exception e) {
				System.out.println("Error : " + e);
			}
		}
		return i;
	}
}