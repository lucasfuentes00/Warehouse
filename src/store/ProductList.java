package store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Arrays;

public class ProductList {

	protected double totalCost;
	protected double totalPrice;
	protected double totalBenefit;
	protected ArrayList<StockableProduct> list;

	public ProductList() {
		list = new ArrayList<StockableProduct>();
		setTotalCost();
		setTotalPrice();
		setTotalBenefit();

	}

	public ProductList(ArrayList<StockableProduct> list) {
		setList(list);
		setTotalCost();
		setTotalPrice();
		setTotalBenefit();
	}

	public void setList(ArrayList<StockableProduct> list) {
		this.list = list;
	}

	public void setTotalCost() {
		this.totalCost = calculateCost();
	}
	
	public void setTotalCost(double cost) {
		this.totalCost = cost;
	}

	public void setTotalPrice() {
		this.totalPrice = calculatePrice();
	}
	
	public void setTotalPrice(double price) {
		this.totalPrice = price;
	}

	public void setTotalBenefit() {
		this.totalBenefit = totalPrice-totalCost;
	}

	public ArrayList<StockableProduct> getList() {
		return this.list;
	}

	public double getTotalCost() {
		return this.totalCost;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public double getTotalBenefit() {
		return this.totalBenefit;
	}

	public double calculateCost() {
		double x = 0;
		for (StockableProduct a : list) {
			x = x + a.getCostPerUnit() * a.getNumUnits();
		}
		return x;
	}

	public double calculatePrice() {
		double x = 0;
		for (StockableProduct a : list) {
			x = x + a.getPricePerUnit() * a.getNumUnits();
		}
		return x;
	}

	public double calculateBenefit() {
		double x = 0;
		x = calculatePrice() - calculateCost();

		return x;
	}

	public StockableProduct mostExpensiveProduct() {
		StockableProduct expensive = new StockableProduct();
		for (StockableProduct a : list) {
			if (a.getPricePerUnit() > expensive.getPricePerUnit())
				expensive = a;

		}
		return expensive;
	}

	public StockableProduct cheapestProduct() {
		StockableProduct cheap = new StockableProduct();
		cheap.setPricePerUnit(100000);
		StockableProduct[] a = new StockableProduct[list.size()];
		list.toArray(a);

		for (int i = 0; i < a.length; i++) {
			if ((a[i].getPricePerUnit() < cheap.getPricePerUnit()) && (a[i].getPricePerUnit() != 0))
				cheap = a[i];

		}
		return cheap;
	}
	
	public void fromString(String[] s) {
		
		totalCost= Double.parseDouble(s[0]);
		totalPrice = Double.parseDouble(s[1]);
		totalBenefit = Double.parseDouble(s[2]);
		
		
		for(int i=3;i<s.length;i++) {
			StockableProduct p =new StockableProduct();
			String[ ] product = new String[20];
			product = s[i].split("\\s+");
			p.fromString(product);
			insertProduct(p);
		}
		
	
	}

	public String[] toString1() {
		String f = String.valueOf(totalCost);
		String g = String.valueOf(totalPrice);
		String h = String.valueOf(totalBenefit);
		StockableProduct[] a = new StockableProduct[list.size()];
		list.toArray(a);

		String[] result = new String[list.size() + 3];
		result[0] = f;
		result[1] =  g;
		result[2] =  h;
		for (int i = 3; i < result.length; i++) {
			result[i] = a[i - 3].toString();
		}

		return result;

	}

	public void toScreen() {
		String[] p = this.toString1();
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
	}
	
	public void insertProduct(StockableProduct p) {
		list.add(p);
		setTotalCost();
		setTotalPrice();
		setTotalBenefit();
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
				String[] p = this.toString1();
				for (int i = 0; i < p.length; i++) {
					writer.newLine();
					writer.write(p[i]);
					
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
				String[] p = this.toString1();
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

	public ProductList readKeyboard() {
		Scanner i = new Scanner(System.in);

		System.out.print("Let's create the products for the new list: \n");
		String option = " ";
		boolean q1 = false;
		

		do {
			StockableProduct a = new StockableProduct();
			a = a.readKeyboard();

			list.add(a);

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

		return this;

	}

	public ProductList readFile() {

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

			setTotalCost(Double.parseDouble(f[0]));
			setTotalPrice(Double.parseDouble(f[1]));
			setTotalBenefit();
			
			for(int i=3;i<f.length;i++) {
				StockableProduct p =new StockableProduct();
				String[ ] product = new String[20];
				product = f[i].split("\\s+");
				p.fromString(product);
				this.list.add(p);
			}
			
			
			System.out.println("The new product list was read successfully. ");

		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find the specified file, please make sure you include the file extension.");

		}
		return this;

	}
}
