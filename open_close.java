/**
 * 
 */
package banking_system;

/**
 * @author venom
 *
 */
class open_close {

	/**
	 * 
	 */
	private static  String[][] accounts = create_accoun.accounts;
	protected static String Email = "";
	protected static String balance = "";
	private static int amount = 0;
	private static Boolean return_ = false;
	
	public open_close(String email) {
		// TODO Auto-generated constructor stub
		Email= email;
	}
	public static Boolean open(String Email_) {
		Email = Email_;
		for(int i = 0; i<accounts.length;i++) {
			balance = accounts[i][6];
			int bal = Integer.valueOf(balance);
			amount = Integer.valueOf(accounts[i][6]);
			String valid_email = accounts[i][5];
			if (valid_email!=null) {
			if(valid_email.equals(Email) && amount>=5) {
				balance = Integer.toString(bal);
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
	public static Boolean close(String Email_) {
		Email = Email_;
		for(int i = 0; i<accounts.length;i++) {
			balance = accounts[i][6];
			int bal = Integer.valueOf(balance);
			String valid_email = accounts[i][5];
			if (valid_email!=null) {
			if(valid_email.equals(Email)) {
				balance = Integer.toString(bal);
				accounts[i][5] = null;
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
		if (open_close.return_) {
			return "The recent change to this account was successful.";
		}
		else {
			return "Change not successful";
		}
	}
}
