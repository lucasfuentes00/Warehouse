package store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreManager {

	private String name;
	private double stockCost;
	private double stockBenefit;
	private ProductList stock;
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setStockCost(double stockCost) {
		this.stockCost=stockCost;
	}
	
	public void setStockBenefit(double stockBenefit) {
		this.stockBenefit=stockBenefit;
	}
	
	public void setStock(ProductList s) {
		this.stock=s;
	}
	
	public void setStockBenefit() {
		this.stockBenefit=stock.calculateBenefit();
	}
	
	public void setStockCost() {
		this.stockCost=stock.calculateCost();
	}
	public String getName() {
		return this.name;
	}
	
	public double getStockCost() {
		return this.stockCost;
	}
	public double getStockBenefit() {
		return this.stockBenefit;
	}
	
	public void insertProduct(StockableProduct p) {
		this.stock.insertProduct(p);
	}
	
	public StoreManager() {
		name="";
		stockCost= 0;
		stockBenefit =0;
		stock = new ProductList();
	}
	
	public StoreManager(String name, double stockCost, double stockBenefit, ProductList stock) {
		setName(name);
		setStockCost(stockCost);
		setStockBenefit(stockBenefit);
		setStock(stock);
	}
	
	public String[] toString1() {
		String[] p = stock.toString1();
		p[1]=p[0];
		p[0]=name;
		
		return p;
		}
	
	public void fromString(String[] s) {
		setName(s[0]);
		setStockCost(Double.valueOf(s[1]));
		setStockBenefit(Double.valueOf(s[2]));
		
		for(int i=3;i<s.length;i++) {
			StockableProduct p =new StockableProduct();
			String[ ] product = new String[20];
			product = s[i].split("\\s+");
			p.fromString(product);
			insertProduct(p);
		}
		
	}

	public void toScreen() {
		String[]a= toString1();
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
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
				String[] p = this.toString1();
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
	
	public StoreManager readKeyboard() {
		Scanner n = new Scanner(System.in);
		System.out.println("Enter the name of the store: ");
		setName(n.nextLine());
		
		stock.readKeyboard();
		this.setStockCost();
		this.setStockBenefit();

		return this;
	}

	public StoreManager readFile() {
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

			setName(f[0]);
			setStockCost(Double.parseDouble(f[1]));
			setStockBenefit(Double.parseDouble(f[2]));
			
			for(int i=3;i<f.length;i++) {
				StockableProduct p =new StockableProduct();
				String[ ] product = new String[20];
				product = f[i].split("\\s+");
				p.fromString(product);
				this.stock.insertProduct(p);
			}
			
			
			System.out.println("The new store stock was read successfully. ");

		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find the specified file, please make sure you include the file extension.");

		}
		return this;
		
	}
}
