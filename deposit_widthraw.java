package banking_system;

class deposit_widthraw {
	private static  String[][] accounts = create_accoun.accounts;
	protected static String Email = "";
	protected static String balance = "";
	private static int amount = 0;
	private static Boolean return_ = false;
	
	public deposit_widthraw(int money, String email) {
		// TODO Auto-generated constructor stub
		Email = email;
		amount = money;
	}
	
	
	public static Boolean widthraw(int money, String email) {
		Email = email;
		amount = money;
		for(int i = 0; i<accounts.length;i++) {
			balance = accounts[i][6];
			int bal = Integer.valueOf(balance);
			String valid_email = accounts[i][5];
			if (valid_email!=null) {
			if(valid_email.equals(Email) && amount< Integer.valueOf(accounts[i][6])) {
				accounts[i][6] = Integer.toString(bal-amount);
				balance = Integer.toString(bal-amount);
				return_ =true;
				break;
			}
			}else {
				return_ =false;
				break;
			}
		}
		return return_;
	}
	public static Boolean deposit(int money, String email) {
		Email = email;
		amount = money;
		for(int i = 0; i<accounts.length;i++) {
			balance = accounts[i][6];
			int bal = Integer.valueOf(balance);
			String valid_email = accounts[i][5];
			if (valid_email!=null) {
			if(valid_email.equals(Email) && amount>0) {
				accounts[i][6] = Integer.toString(bal+amount);
				balance = Integer.toString(bal+amount);
				return_ =true;
				break;
			}
			}else {
				return_ =false;
				break;
			}
		}
		return return_;
	}
	@Override
	public String toString() {
		if (deposit_widthraw.return_) {
			return "The transaction of amount "+amount+" to this account was successful. New balance: "+balance;
		}
		else {
			return "Transaction not successful";
		}
	}

}