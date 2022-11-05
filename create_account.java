/**
 * 
 */
package banking_system;
import java.time.*;
import java.util.*;
import java.util.regex.*;

/**
 * @author venom
 *
 */
class create_account{
	public static void main(String[] args) {
		create_accoun new_account = new create_accoun();
		new_account.create_account();
		System.out.println(new_account);
		
	}
};
class create_accoun {
	protected static String[][] accounts = new String[100000][8];
	private Scanner input = new Scanner(System.in);
	private String email_regex = "^(.+)@(.+)$";
	private Float Balance[] = new Float[100000];
	private String[] returned_d = new String[8];
	private Boolean return_feed = true;
	private Pattern email_pattern = Pattern.compile(email_regex);
	void create_account() {
		
		print("Please Input Your Details Correctly To Create An Account: ");
		print("Enter First Name: ");
		String FirstName = input.nextLine();
		print("Enter Second Name: ");
		String SecondName = input.nextLine();
		print("Enter Phone Number: ");
		String PhoneNumber = input.nextLine();
		print("Enter Your Year of Birth: ");
		int year = input.nextInt();
		print("Enter Your Month of Birth: ");
		int month = input.nextInt();
		print("Enter Your Day of Birth: ");
		int day = input.nextInt();
		String vin = input.nextLine();
		print("Enter Address: ");
		String MyAddress = input.nextLine();
		print("Enter Your Email: ");
		String Email = input.nextLine();
		print("Enter your password: ");
		String Password = input.nextLine();
		print("Enter the Amount Depositted: ");
		Float Deposit = input.nextFloat();
		
		LocalDate date = LocalDate.of(year,month,day);
		Matcher email_matcher = email_pattern.matcher(Email);
		for (int i = 0; i<accounts.length;i++) {
		if(accounts[i][5]==null) {
		if (email_matcher.matches()) {
			if (deposit_val(Deposit)) {
			Balance[i]=Deposit;
			String[] details = {FirstName,SecondName,PhoneNumber,date.toString(),MyAddress,Email,Float.toString(Deposit),Password};
			accounts[i] = details;
			String[] d = accounts[i];
			returned_d = d;
			//print("This details have been captured: ",d[0]+" ",d[1]+" ",d[2]+" ",d[3]+" ",d[4]+" " , "$"+Float.toString(Deposit));
			}else {
				return_feed = false;
				print("Minimum deposit returned false");
			}
		}else {
			return_feed = false;
			print("The email"," "+Email," is invalid. Try again");
		}

			break;
		
		}else {
			continue;
		}
		}
		
	}
	
	private boolean deposit_val(Float Deposit) {
		return (Deposit>=5);
	}
	
	private void print(String...args) {
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
	@Override
	public String toString() {
		String[] d = this.returned_d;
		if (this.return_feed) {
		return "This details have been captured: Name: "+d[0]+" "+d[1]+" Phone: "+d[2]+" Date Of Birth: "+d[3]+" Address: "+d[4]+" Email: "+d[5]+" Account Balance: " + "$"+d[6];
		}else {
			return "The account was not created";
		}
	}

}
