package store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Person {

	protected String ID;
	protected String firstName;
	protected String lastName;
	protected String email;

	public Person() {
		ID = "0000X";
		firstName = "name";
		lastName = "lastname";
		email = "email@xxx.com ";

	}

	public Person(String a, String b, String c, String d) {
		try {
			setID(a);
			setFirstName(b);
			setLastName(c);
			setEmail(d);
		} catch (PersonException e) {
			System.out.println("Unable to create the new person");
			e.printStackTrace();
		}
	}

	public void setID(String a) throws PersonException {
		if (a.length() > 15)
			throw new PersonException("The id can't be longer than 15 characters");
		else
			this.ID = a;
	}

	public void setFirstName(String s) throws PersonException {
		if (s.length() > 10)
			throw new PersonException("The first name can't be longer than 10 characters");
		else
			this.firstName = s;
	}

	public void setLastName(String s) throws PersonException {
		if (s.length() > 10)
			throw new PersonException("The last name can't be longer than 10 characters");
		else
			this.lastName = s;
	}

	public void setEmail(String s) throws PersonException {
		if (s.length() > 20)
			throw new PersonException("The email can't be longer than 20 characters");
		else
			this.lastName = s;
	}

	public String getID() {
		return this.ID;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void fromString(String[] a) {
		try {
			setID(a[0]);
			setFirstName(a[1]);
			setLastName(a[2]);
			setEmail(a[3]);
		} catch (PersonException e) {
			System.out.println("Unable to modify the person");
			e.printStackTrace();
		}
	}

	public String toString() {
		String b = ID + " | " + firstName + " | " + lastName + " | " + email + "\n";
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

	public Person readKeyboard() throws PersonException {
		Person p = new Person();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the id");
		p.setID(in.nextLine());

		System.out.println("Enter the first name");
		String a = in.nextLine();
		p.setFirstName(a);

		System.out.println("Enter the last name");
		String b = in.nextLine();
		p.setLastName(b);

		System.out.println("Enter the email");
		String c = in.nextLine();
		p.setEmail(c);

		return p;

	}

	public Person readFile() throws PersonException{
		Person p=new Person();
		Scanner in = new Scanner(System.in);
		System.out.print("\n Enter the name of the file to be read: ");
		String filename = in.nextLine();
		File toberead = new File(filename);

		String[] x = new String[7];
		Scanner in2 = null;
		try {
			in2 = new Scanner(toberead);
			while (in2.hasNextLine()) {
				Scanner in3 = new Scanner(in2.nextLine());
				for (int i = 0; i < 7; i++) {
					if (in3.hasNext())
						x[i] = in3.next();
				}
			}
		
				p.setID(x[0]);
				p.setFirstName(x[2]);
				p.setLastName(x[4]);
				p.setEmail(x[6]);
				System.out.println("The new person was read successfully. ");
			
		}catch(FileNotFoundException e){
			System.out.println("Couldn't find the specified file, please make sure you include the file extension.");
		}

	return p;
}

}
