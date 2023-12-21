package store;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StockableProduct extends Product {
	protected int id;
	

	protected int numUnits;
	protected double costPerUnit;
	protected double pricePerUnit;
	
	
	

	public StockableProduct( int id, String name, String brand, char category, boolean isContable, String units,
			int numUnits, double costPerUnit, double pricePerUnit) {
		super(name,brand, category, isContable, units);
		
		this.id = id;
		this.numUnits = numUnits;
		this.costPerUnit = costPerUnit;
		this.pricePerUnit = pricePerUnit;

	}

	public StockableProduct() {
		brand = "";
		category = ' ';
		isCountable = false;
		units = "";
		id = 0;
		name = "";
		numUnits = 0;
		costPerUnit = 0;
		pricePerUnit = 0;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String i) {
		this.name = i;
	}

	public int getNumUnits() {
		return numUnits;
	}

	public void setNumUnits(int numUnits) {
		this.numUnits = numUnits;
	}

	public double getCostPerUnit() {
		return costPerUnit;
	}

	public void setCostPerUnit(double double1) {
		this.costPerUnit = double1;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public void fromString(String[] a) {
		if (a.length < 17)
			System.out.println("Need 9  arguments for a stockable: id, name, brand, isCountable, category,  units, numUnits, cosrPerUnit, pricePerUnit. ");
		else {
			
			
			setId(Integer.parseInt(a[0]));
			setName(a[2]);
			setBrand(a[4]);
			setIsCountable(a[6].equals("true"));
			setCategory(a[8].charAt(0));
			setUnit(a[10]);
			setNumUnits(Integer.parseInt(a[12]));
			setCostPerUnit(Double.parseDouble(a[14]));
			setPricePerUnit(Double.parseDouble(a[16]));
		}
	}

	public String toString() {
		String b = id+ " | " + name+ " | "+ brand + " | " + isCountable + " | " +category+ " | " +units+ " | " +numUnits+ " | " +costPerUnit+ " | " +pricePerUnit;
		return b;
	}

	public void toScreen() {
		System.out.print(this.toString());
	}

	public void toFile() {
		Scanner in = new Scanner(System.in);
		System.out.print("\n Enter the name of the file: ");
		String filename = in.nextLine();
		in.close();

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

	public StockableProduct readKeyboard() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the id ");
		setId(in.nextInt());

		System.out.println("Enter the  name");
		String a = in.next();
		setName(a);

		System.out.println("Enter the brand");
		String b = in.next();
		setBrand(b);
		
		System.out.println("Enter the isCountable");
		String d = in.next();
		setIsCountable(d.equals("true"));
		
		
		
		System.out.println("Enter the category");
		String s=in.next();
		setCategory(s.charAt(0));
		
		
		System.out.println("Enter the unit");
		String e = in.next();
		setUnit(e);
		
		System.out.println("Enter the number of units");
		String r = in.next();
		setNumUnits(Integer.parseInt(r));
		
		System.out.println("Enter the costPerUnit");
		String g = in.next();
		setCostPerUnit(Double.parseDouble(g));
		
		System.out.println("Enter the pricePerUnit");
		String h = in.next();
		setPricePerUnit(Double.parseDouble(h));
		
		
		
		return this;
		

	}	

	public StockableProduct readFile() {
		
		Scanner in = new Scanner(System.in);
		System.out.print("\n Enter the name of the file to be read: ");
		String filename = in.nextLine();
		File toberead = new File(filename);
		StockableProduct result=new StockableProduct();

		String[] x = new String[17];
		Scanner in2 = null;
		try {
			in2 = new Scanner(toberead);
			while (in2.hasNextLine()) {
				Scanner in3 = new Scanner(in2.nextLine());
				for (int i = 0; i < 17; i++) {
					if (in3.hasNext())
						x[i] = in3.next();
				}
			}

			result.setId(Integer.parseInt(x[0]));
			result.setName(x[2]);
			result.setBrand(x[4]);
			char c1 = x[6].charAt(0);
			result.setCategory(c1);
			boolean x6 = x[8].equals("true");
			result.setIsCountable(x6);
			result.setUnit(x[10]);
			result.setNumUnits(Integer.parseInt(x[12]));
			result.setPricePerUnit(Double.parseDouble(x[14]));
			result.setCostPerUnit(Double.parseDouble(x[16]));
			System.out.println("The new stockable product was read successfully. ");

		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find the specified file, please make sure you include the file extension.");
			
		}
		return result;
	
	}
	
}


