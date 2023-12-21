package store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Provider{

	private int taxNumber;
	private String name;
	private String taxAdress;
	private Person contactPerson;

	public Provider() {
		setTaxNumber(00000);
		setName("provider name ");
		setTaxAdress("tax adress");
		setContactPerson(new Person());

	}

	public Provider(int a, String b, String c, Person d) {
		this.setTaxNumber(a);
		this.setName(b);
		this.setTaxAdress(c);
		this.setContactPerson(d);
	}

	public int getTaxNumber() {
		return this.taxNumber;
	}

	public String getName() {
		return this.name;
	}

	public String getTaxAdress() {
		return this.taxAdress;
	}

	public Person getContactPerson() {
		return this.contactPerson;
	}

	public void setTaxNumber(int a) {
		try {
			this.taxNumber = a;
		} catch (java.lang.Error e) {
			System.out.println("Invalid input");
		}
	}

	public void setName(String a) {
		this.name = a;
	}

	public void setTaxAdress(String a) {
		this.taxAdress = a;
	}

	public void setContactPerson(Person a) {
		this.contactPerson = a;
	}

	public void fromString(String[] s) {
		setTaxNumber(Integer.parseInt(s[0]));
		setName(s[1]);
		setTaxAdress(s[2]);
		String[] a = { s[3], s[4], s[5], s[6] };
		contactPerson.fromString(a);

	}

	public String toString() {
		String a = String.valueOf(taxNumber);
		String b = contactPerson.toString();

		return a + " | " + name + " | " + taxAdress + " | " + b;
	}

	public void toScreen() {
		System.out.println(this.toString());
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
			}
		}
	}

	public Provider readKeyboard() throws PersonException {
		
		Provider result = new Provider();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the tax number");
		result.setTaxNumber(in.nextInt());

		System.out.println("Enter the name");
		String a = in.next();
		result.setName(a);

		System.out.println("Enter the tax adress");
		String b = in.next();
		result.setTaxAdress(b);

		result.setContactPerson(this.contactPerson.readKeyboard());
		
		return result;
	}

	public Provider readFile() throws PersonException{
		Scanner in = new Scanner(System.in);
		System.out.print("\n Enter the name of the file to be read: ");
		String filename = in.nextLine();
		File toberead = new File(filename);

		Provider p = new Provider();
		String[] x = new String[13];
		Scanner in2 = null;
		try {
			in2 = new Scanner(toberead);
			while (in2.hasNextLine()) {
				Scanner in3 = new Scanner(in2.nextLine());
				for (int i = 0; i < 13; i++) {
					if (in3.hasNext())
						x[i] = in3.next();
				}
			}

			setTaxNumber(Integer.parseInt(x[0]));
			setName(x[2]);
			setTaxAdress(x[4]);
			
			String[] person = {x[6] ,x[8], x[10], x[12] };
			this.contactPerson.fromString(person);
			
			System.out.println("The new provider was read successfully. ");
			
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find the specified file, please make sure you include the file extension");
		}
		
		return p;
	}

}
