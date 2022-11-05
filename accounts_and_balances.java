/**
 * 
 */
package banking_system;

import java.util.Scanner;

/**
 * @author venom
 *
 */
class accounts_and_balances {
	/**
	 * @param args
	 */
	//private static create_accoun account_details = new create_accoun();
	public static  String[][] accounts = create_accoun.accounts;
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			print("Checking For user account: ");
			print("Input your account's email: ");
			String Email = input.nextLine();
			if (banking_system.check_for_account.check_for_account(Email)) {
				print("Acount Details Being Processed");
				String[] d = accounts[banking_system.check_for_account.locate()];
				print("These details were captured: Name: "+d[0]+" "+d[1]+" Phone: "+d[2]+" Date Of Birth: "+d[3]+" Address: "+d[4]+" Email: "+d[5]+" Account Balance: " + "$"+d[6]);
			}else {
				print("Account Invalid or Not Found");
			}
		}
		
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

};
class check_for_account{
	private static String[][] accounts = create_accoun.accounts;
	private static Boolean check_email = false;
	private static int i = 0;
	public static Boolean check_for_account(String Email) {
		for(i = 0; i<accounts.length;i++) {
			String valid_email = accounts[i][5];
			if (valid_email!=null) {
			if(valid_email.equals(Email)) {
				check_email=true;
				break;
			}
			}else {
				break;
			}
		}
		return check_email;
	}

	public static Integer locate() {
		return check_for_account.i;
	}
	//@Override
	public String toSting() {
		Boolean check_email = check_for_account.check_email;
		return Boolean.toString(check_email);
	}
}

