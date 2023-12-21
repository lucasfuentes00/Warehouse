

import java.util.Scanner;

public class warehouse {

	public static void submenu(String s) {
		System.out.println("------Manage " + s + " ------\n");
		System.out.println("++1.-Insert " + s);
		System.out.println("++2.-Remove " + s);
		System.out.println("++3.-Modify " + s);
		System.out.println("++4.-Search " + s);
		System.out.println("++0.-Exit\n");

	}

	
	public static void submenuone() {
		System.out.println("\n \n Create new store");

		Scanner input = new Scanner(System.in);
		String option = "hi";
		do {
			System.out.print("\n Press enter to go back ");
			option = input.nextLine();
			if (option.isEmpty()) {
				mainmenu();
			}
		} while (option != "");
	}

	public static void submenu2() {
		submenu("stock");
		String menu = "stock";
		Scanner input = new Scanner(System.in);

		System.out.print("Select an option \n");
		int x = -1;
		x = input.nextInt();
		x = inputcheck(x);

		switch (x) {
		case 0:
			mainmenu();
			break;
		case 1:
			System.out.println("Insert " + menu + " method");
			break;
		case 2:
			System.out.println("Remove " + menu + " method");
			break;
		case 3:
			System.out.println("Modify " + menu + " method");
			break;
		case 4:
			System.out.println("Search " + menu + " method");
			;
			break;
		}

	}

	public static void submenu3() {
		submenu("orders(To process)");
		String menu = "orders(To process)";
		Scanner input = new Scanner(System.in);

		System.out.print("Select an option \n");
		int x = -1;
		x = input.nextInt();
		x = inputcheck(x);

		switch (x) {
		case 0:
			mainmenu();
			break;
		case 1:
			System.out.println("Insert " + menu + " method");
			break;
		case 2:
			System.out.println("Remove " + menu + " method");
			break;
		case 3:
			System.out.println("Modify " + menu + " method");
			break;
		case 4:
			System.out.println("Search " + menu + " method");
			;
			break;
		}

	}

	public static void submenu4() {
		submenu("orders(Processed)");
		String menu = "orders(Processed)";

		Scanner input = new Scanner(System.in);

		System.out.print("Select an option \n");
		int x = -1;
		x = input.nextInt();
		x = inputcheck(x);

		switch (x) {
		case 0:
			mainmenu();
			break;
		case 1:
			System.out.println("Insert " + menu + " method");
			break;
		case 2:
			System.out.println("Remove " + menu + " method");
			break;
		case 3:
			System.out.println("Modify " + menu + " method");
			break;
		case 4:
			System.out.println("Search " + menu + " method");
			;
			break;
		}

	}

	public static void submenu5() {
		submenu("clients");
		String menu = "clients";

		Scanner input = new Scanner(System.in);

		System.out.print("Select an option \n");
		int x = -1;
		x = input.nextInt();
		x = inputcheck(x);

		switch (x) {
		case 0:
			mainmenu();
			break;
		case 1:
			System.out.println("Insert " + menu + " method");
			break;
		case 2:
			System.out.println("Remove " + menu + " method");
			break;
		case 3:
			System.out.println("Modify " + menu + " method");
			break;
		case 4:
			System.out.println("Search " + menu + " method");
			;
			break;
		}

	}

	public static void submenu6() {
		submenu("providers");
		String menu = "providers";

		Scanner input = new Scanner(System.in);

		System.out.print("Select an option \n");
		int x = -1;
		x = input.nextInt();
		x = inputcheck(x);

		switch (x) {
		case 0:
			mainmenu();
			break;
		case 1:
			System.out.println("Insert " + menu + " method");
			break;
		case 2:
			System.out.println("Remove " + menu + " method");
			break;
		case 3:
			System.out.println("Modify " + menu + " method");
			break;
		case 4:
			System.out.println("Search " + menu + " method");
			;
			break;
		}

	}

	public static void submenu7() {
		submenu("employees");
		String menu = "employees";

		Scanner input = new Scanner(System.in);

		System.out.print("Select an option \n");
		int x = -1;
		x = input.nextInt();
		x = inputcheck(x);

		switch (x) {
		case 0:
			mainmenu();
			break;
		case 1:
			System.out.println("Insert " + menu + " method");
			break;
		case 2:
			System.out.println("Remove " + menu + " method");
			break;
		case 3:
			System.out.println("Modify " + menu + " method");
			break;
		case 4:
			System.out.println("Search " + menu + " method");
			;
			break;
		}

	}

	public static void menuEight() {
		System.out.println("\n \nStore name: ");
		System.out.println("Stock cost: ");
		System.out.println("Stock benefit: ");

		Scanner input = new Scanner(System.in);
		String option = "hi";
		do {
			System.out.print("\n Press enter to go back ");
			option = input.nextLine();
			if (option.isEmpty()) {
				mainmenu();
			}
		} while (option != "");

	}

	public static void menuNine() {
		System.out.println("TESTING \n");


		
		
		
		Scanner input = new Scanner(System.in);
		String option = "hi";
		do {
			System.out.print("\n Press enter to go back to the main menu:");
			if(input.hasNextLine())
				option = input.nextLine();
			if (option.isEmpty()) {
				mainmenu();
			}
		} while (option != "");

	}

	public static void mainmenu() {

		System.out.println("------Main menu--------\n");
		System.out.println(" Store info: ");
		System.out.println("    Store name: ");
		System.out.println("    Stock cost: ");
		System.out.println("    Stock benefit: \n \n ");

		System.out.println("1.-Create store");
		System.out.println("2.-Manage stock");
		System.out.println("3.-Manage orders(To process)");
		System.out.println("4.-Manage orders(Processed)");
		System.out.println("5.-Manage clients");
		System.out.println("6.-Manage providers");
		System.out.println("7.-Manage employees");
		System.out.println("8.-Print store info");
		System.out.println("9.-Testing");
		System.out.println("0.-Exit \n \n");

		Scanner input = new Scanner(System.in);
		int option = 0;
		System.out.print("Select an option \n");
		option = input.nextInt();

		switch (option) {
		case 0:
			System.exit(0);
			break;
		case 1:
			submenuone();
			break;
		case 2:
			submenu2();
			break;
		case 3:
			submenu3();
			break;
		case 4:
			submenu4();
			break;
		case 5:
			submenu5();
			break;
		case 6:
			submenu6();
			break;
		case 7:
			submenu7();
			break;
		case 8:
			menuEight();
			break;
		case 9:
			menuNine();
			break;

		}
	}

	public static int inputcheck(int a) {
		Scanner in = new Scanner(System.in);

		int a1 = a;
		while ((a1 != 0) && (a1 != 1) && (a1 != 2) && (a1 != 3) && (a1 != 4)) {
			System.err.println("Invalid input");
			a1 = in.nextInt();
		}

		return a1;

	}

	public static void main(String[] args) {
		mainmenu();
	}
}
