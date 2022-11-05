package banking_system;

import java.util.*;

public final class main_menu {
	public static  String[][] accounts = create_accoun.accounts;
	public static void main_menu(String...args) {
		try (// TODO Auto-generated constructor stub
		Scanner input = new Scanner(System.in)) {
			// TODO Auto-generated method stub
			print("\t\tMAIN MENU");
			print("Select one of the following options: ");
			print("\tA. New Client: ");
			print("\tB. Login with email and pin");
			print("\tC. Exit");
			print("Enter Your Option: ");
			String option = input.next();
			if(option.equals("A") || option.equals("a")) {
				banking_system.create_account.main(args);
				print("Login if accounts creation was successfull");
				main_menu();
				
			}else if (option.equals("B") || option.equals("b")) {
				String password = input.nextLine();
				print("Enter your Email");
				String Email = input.nextLine();
				print("Enter Your Password");
				password = input.nextLine();
				if (login.login_(Email,password)) {
					print("WELCOME");
					print("Choose one of the following options");
					print("\t1. View account and balance");
					print("\t2. Widthraw amount.");
					print("\t3. Deposit amount.");
					print("\t4. Open account");
					print("\t5. Close Account");
					print("Enter Your Option Here: ");
					option = input.nextLine();
					if(option.equals("1") || option.contains("ne")) {
						if (check_for_account.check_for_account(Email)) {
							print("Acount Details Being Processed");
							String[] d = accounts[check_for_account.locate()];
							print("These details were captured: Name: "+d[0]+" "+d[1]+" Phone: "+d[2]+" Date Of Birth: "+d[3]+" Address: "+d[4]+" Email: "+d[5]+" Account Balance: " + "$"+d[6]);
						}else {
							print("Account Invalid or Not Found");
						}
						
					}else if(option.equals("2") || option.contains("wo")) {
						print("Enter the amount you wish to widthraw: ");
						int amount = input.nextInt();
						if(deposit_widthraw.widthraw(amount,Email)) {
							print("The transaction of amount "+amount+" to this account was successful. New balance: "+deposit_widthraw.balance);
						}else {
							print("Failed to widthraw your amount");
						}
					}
					else if(option.equals("3") || option.contains("ree")) {
						print("Enter the amount you wish to deposit: ");
						int amount = input.nextInt();
						if(deposit_widthraw.deposit(amount,Email)) {
							print("The transaction of amount "+amount+" to this account was successful. New balance: "+deposit_widthraw.balance);
						}else {
							print("Failed to deposit your amount");
						}
					}
					else if(option.equals("4") || option.contains("our")) {
						print("You are openning your account.");
						
						if(open_close.open(Email)) {
							print("This account was activated successfully.");
						}else {
							print("Failed to activate your account");
						}
					}
					else if(option.equals("5") || option.contains("ive")) {
						print("You are openning your account.");
						
						if(open_close.close(Email)) {
							print("This account was deactivated successfully.");
						}else {
							print("Failed to deactivate your account");
						}
					}
					else {
						print("Invalid option");
					}
					
				}
				
			}else if (option.equals("C") || option.equals("c")) {
				print("System Exitting");
				System.exit(0);
				
			}else {
				print("Invalid option. Try again");
				main_menu();
			}
		}
	}

	public static void main(String[] args) {
		main_menu();
		
	}
	static void print(String...args) {
		if (args.length == 1) {
			for (int i = 0; i < args.length; i++) {
				String val = args[i];
				System.out.println(val);
			}
		}else {
			for (int i = 0; i < args.length; i++) {
				String val = args[i];
				System.out.print(val);
			}
			System.out.println();
		}
	}

}
