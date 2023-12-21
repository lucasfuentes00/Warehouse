package store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Product {
	protected String name;
	protected String brand;
	protected char category;
	protected boolean isCountable;
	protected String units;

	public Product(String name, String brand, char category, boolean isCountable, String units) {
		setName(name);
		this.brand = brand;
		this.category = category;
		this.isCountable = isCountable;
		this.units = units;
	}

	public Product(String brand, char category, boolean isCountable, String units) {
		this.brand = brand;
		this.category = category;
		this.isCountable = isCountable;
		this.units = units;
	}

	public Product() {
		name = "";
		brand = "";
		category = ' ';
		isCountable = false;
		units = "";

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public char getCategory() {
		return category;
	}

	public void setCategory(char category) {
		Scanner in0 = new Scanner(System.in);
		String s;
		char c2= category;
			if ((c2 == 'f') || (c2 == 's') || (c2 == 'e') || (c2 == 'm')) {
				
				
			} else {
			System.out.println("Choose between f (food),s (supplies),e (equipment),m (miscelaneus):");
			s = in0.next();
			c2 = s.charAt(0);}

		this.category = c2;
	}

	public boolean getIsCountable() {
		return isCountable;
	}

	public void setIsCountable(boolean isCountable) {
		this.isCountable = isCountable;
	}

	public String getUnits() {
		return units;
	}

	public void setUnit(String units) {
		this.units = units;
	}

	public void fromString(String[] a) {
		if (a.length < 7)
			System.out.println("Need 6 arguments for a product: id, name, brand, category, isContable, unit .");
		else {
			setName(a[0]);
			setBrand(a[1]);
			char c = a[3].charAt(0);
			setCategory(c);
			boolean is = a[4].equals("true");
			setIsCountable(is);
			setUnit(a[5]);
		}
	}

	public String toString() {
		String b = name + " | " + brand + " | " + category + " | " + isCountable + " | " + units;
		return b;
	}

	public void toScreen() {
		System.out.print(this.toString());
	}

	public void toFile() {
		Scanner in = new Scanner(System.in);
		System.out.print("\n Enter the name of the file: ");
		String filename = in.nextLine();

		File myObj = new File(filename);
		if (myObj.exists()) {

			try {

				BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
				writer.newLine();
				writer.write(this.toString());
				writer.close();
				System.out.println("Successfully wrote to the file in: ");
				System.out.println(myObj.getAbsolutePath());
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		} else {
			try {
				FileWriter writer = new FileWriter(myObj);
				writer.write(this.toString());
				writer.write("\n");
				writer.close();
				System.out.println("Successfully wrote to the file in: ");
				System.out.println(myObj.getAbsolutePath());
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}

	public Product readKeyboard() {
		Scanner in = new Scanner(System.in);
		String s1;
		Product s0 = new Product();
		
		
		System.out.println("Enter the name");
		
		s1 = in.nextLine();

		
		s0.setName(s1);

		System.out.println("Enter the brand");
		String a = in.nextLine();
		s0.setBrand(a);
		;

		System.out.println("Enter the category");

		String s;
		char c2;
		boolean q1 = true;
		do {
			System.out.println("Choose between f,s,e,m:");
			s = in.next();
			c2 = s.charAt(0);
			if ((c2 == 'f') || (c2 == 's') || (c2 == 'e') || (c2 == 'm')) {
				q1 = false;
			} else
				q1 = true;

		} while (q1);
		s0.setCategory(s.charAt(0));

		System.out.println("Enter the isCountable");
		String c = in.next();
		s0.setIsCountable(c.equals("true"));

		System.out.println("Enter the units");
		String u = in.next();
		s0.setUnit(u);
		return s0;

	}

	public Product readFile() {
		Scanner in = new Scanner(System.in);
		System.out.print("\n Enter the name of the file to be read: ");
		String filename = in.nextLine();
		File toberead = new File(filename);
		Product s1 = new Product();
		String[] x = new String[9];
		Scanner in2 = null;
		try {
			in2 = new Scanner(toberead);
			while (in2.hasNextLine()) {
				Scanner in3 = new Scanner(in2.nextLine());
				for (int i = 0; i < 9; i++) {
					if (in3.hasNext())
						x[i] = in3.next();
				}
			}

			
			s1.setName(x[0]);
			s1.setBrand(x[2]);
			char c1 = x[4].charAt(0);
			s1.setCategory(c1);
			boolean x6 = x[6].equals("true");
			s1.setIsCountable(x6);
			s1.setUnit(x[8]);
			System.out.println("The new product was read successfully. ");

		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find the specified file, please make sure you include the file extension.");

		}
		return s1;
	}
}

