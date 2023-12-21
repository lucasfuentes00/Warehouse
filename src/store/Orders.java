package store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Orders extends ProductList {

	protected int orderId;
	private static int counter = 0;
	protected Person client;
	protected Person employee;

	public Orders(ArrayList<StockableProduct> list, Person client, Person employee) {
		super(list);
		counter++;
		orderId = counter;
		setClient(client);
		setEmployee(employee);
		
	}

	public Orders() {
		
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setClient(Person client) {
		this.client=client;
	}
	
	public Person getClient() {
		return this.client;
	}
	
	public void setEmployee(Person employee) {
		this.employee=employee;
	}
	
	public Person getEmployee() {
		return this.employee;
	}

	public void fromString(String[] a) {

		setOrderId(Integer.parseInt(a[0]));
		totalCost= Double.parseDouble(a[1]);
		totalPrice = Double.parseDouble(a[2]);
		totalBenefit = Double.parseDouble(a[3]);
		
		
		for(int i=4;i<a.length;i++) {
			StockableProduct p =new StockableProduct();
			String[ ] product = new String[20];
			product = a[i].split("\\s+");
			p.fromString(product);
			insertProduct(p);
		}
		
		
	}

	public String[] toString2() {
		String f = String.valueOf(totalCost);
		String g = String.valueOf(totalPrice);
		String h = String.valueOf(totalBenefit);
		String j = String.valueOf(orderId);
		StockableProduct[] a = new StockableProduct[list.size()];
		list.toArray(a);

		String[] result = new String[list.size() + 4];
		result[0] = j;
		result[1] = f;
		result[2] = g;
		result[3] = h;
		for (int i = 4; i < result.length; i++) {
			result[i] = a[i - 4].toString();
		}

		return result;
	}

	public void toScreen() {
		String[] p = this.toString2();
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
	}

	public void toFile() {
		Scanner in = new Scanner(System.in);
		System.out.print("\n Enter the name of the file: ");
		String filename = in.next();
		in.close();

		File myObj = new File(filename);
		if (myObj.exists()) {

			try {

				BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
				String[] p = this.toString2();
				writer.newLine();
				for (int i = 0; i < p.length; i++) {
					writer.write(p[i]);
					writer.newLine();
				}
				writer.close();
				System.out.println("Successfully wrote to the file in: ");
				System.out.println(myObj.getAbsolutePath());
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		} else {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
				String[] p = this.toString2();
				for (int i = 0; i < p.length; i++) {
					writer.write(p[i]);
					writer.newLine();
				}
				writer.close();
				System.out.println("Successfully wrote to the file in: ");
				System.out.println(myObj.getAbsolutePath());
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}

	public Orders readFile() {
		Scanner in = new Scanner(System.in);
		System.out.print("\n Enter the name of the file to be read: ");
		String filename = in.next();
		File toberead = new File(filename);
		ArrayList<String> scan = new ArrayList<String>();

		Scanner in2 = null;
		try {
			in2 = new Scanner(toberead);
			
				while (in2.hasNextLine()) {
					scan.add(in2.nextLine());
				}
			
			String[] f = new String[scan.size()];
			f = scan.toArray(f);

			this.fromString(f);
			
			
			
			System.out.println("The new order was read successfully. ");

		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find the specified file, please make sure you include the file extension.");

		}
		return this;

	}

	public Orders readKeyboard() {
		Scanner i = new Scanner(System.in);
		ProductList l = new ProductList();
		int in2 = 0;

		System.out.print("Let's create the products for the new order: \n");
		String option = " ";
		boolean q1 = false;

		do {
			StockableProduct a = new StockableProduct();
			a.readKeyboard();

			insertProduct(a);

			System.out.println("Press enter to introduce a new product or select 1 to finish the list: \n");
			option = i.nextLine();
			if (option.isEmpty()) {
				q1 = true;
			} else
				q1 = false;

		} while (q1);

		setTotalCost();
		setTotalPrice();
		setTotalBenefit();
		System.out.println("set id");
		in2 = i.nextInt();
		setOrderId(in2);

		return this;
	}

}
