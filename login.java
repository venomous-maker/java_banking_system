package banking_system;

class login {
	private static  String[][] accounts = create_accoun.accounts;
	protected static String Email = "";
	protected static String balance = "";
	private static String password="";
	private static Boolean return_ = false;
	public static  Boolean login_(String email, String Password) {
		// TODO Auto-generated constructor stub
		Email = email
				;
		for(int i = 0; i<accounts.length;i++) {
			//int bal = Integer.valueOf(balance);
			password = accounts[i][7];
			String valid_email = accounts[i][5];
			if (valid_email!=null) {
			if(valid_email.equals(Email) && password.equals(Password)) {
				//balance = Integer.toString(bal);
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
		return Boolean.toString(login.return_);
	}

}
