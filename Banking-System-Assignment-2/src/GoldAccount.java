/**
 * 
 */

/**
 * @author a00918598 Corey Valentyne
 *
 */
public class GoldAccount extends Account{
	
	private double interestRate;
	private boolean inOverdraft;
	private final double FEE = 0.15;
	private final double OVERDRAFT_AMT = -300;
	
	/**
	 * Default constructor for class GoldAccount
	 */
	public GoldAccount() {
		super();
	}
	
	/**
	 * 
	 * @param balance A double for the balance to initialize
	 * @param accountNumber A String for the accountNumber to initialize
	 * @param active A boolean for whether the account is active
	 * @param interestRate a double for the interestRate to initialize
	 */
	public GoldAccount(double balance, String accountNumber, boolean active, double interestRate) {
		super(balance, accountNumber, active);
		setInterestRate(interestRate);
	}

	/**
	 * @return the interestRate as a double
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * @param interestRate A double for the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
		if(interestRate > 0) {
			this.interestRate = interestRate;
		}
	}
	
	/**
	 * @param amount A double to add to the balance
	 */
	public void addToBalance(double amount) {
		if(amount > 0) {
			double newBalance = getBalance() + amount;
			setBalance(newBalance);
			addTransactionInfo(" - deposit: $" + amount);
			if(getBalance() > 0) {
				inOverdraft = false;
			}
		}
	}
	
	/**
	 * @param amount A double to subtract from the balance
	 */
	public void subtractFromBalance(double amount) {
		if(amount>0) {
			double currentBalance = getBalance();
			if(currentBalance - amount >= OVERDRAFT_AMT) {
				setBalance(currentBalance - amount);
				addTransactionInfo(" - withdrawal: $" + amount);
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GoldAccount [interestRate=" + interestRate + ", inOverdraft=" + inOverdraft + ", toString()="
				+ super.toString() + "]";
	}

	
	
	
}
