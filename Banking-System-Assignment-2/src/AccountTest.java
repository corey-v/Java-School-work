import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author a00918598 Corey Valentyne
 *
 */
public class AccountTest {
	
	private Account chequingAcc;
	private Account savingsAcc;
	private Account goldAcc;
	
	/**
     * Default constructor for test class AccountTest
     */
	public AccountTest() {
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		chequingAcc = new ChequingAccount(100,"CA-1", true);
		savingsAcc = new SavingsAccount(200, "SA-1", true);
		goldAcc = new GoldAccount(0, "GA-1", true, 1.5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Positive test - check for correct balance
	 */
	@Test
	public void testConstructorOneParameter() {
		assertEquals(100.0, chequingAcc.getBalance(), 0.0);
	}
	
	/**
	 * Positive test - check for correct balance
	 */
	@Test
	public void testConstructorTwoParameters() {
		assertEquals(200, savingsAcc.getBalance(), 0.0);
	}
	
	/**
	 * Positive test - check for correct balance
	 */
	@Test
	public void testConstructorThreeParameters() {
		assertEquals(0, goldAcc.getBalance(), 0.0);
	}
	
	/**
	 * Positive test - check for interest rate set
	 */
	@Test
	public void testGoldAccountConstructorInterestRate() {
		assertEquals(1.5, goldAcc.getInterestRate(), 0.0);
	}
	
	/**
	 * Negative test - balance should never be negative
	 */
	/*@Test
	public void testConstructiveNegativeTest() {
		ChequingAccount ca1 = new ChequingAccount(-200, "ca-3", true);
		assertEquals(0.0, ca1.getBalance(), 0.0);
	}*/
	
	/**
	 * Positive test deposit - balance should increase
	 */
	@Test
	public void testDepositPositive() {
		chequingAcc.addToBalance(320);
		assertEquals(420, chequingAcc.getBalance(), 0.0);
	}
	
	/**
	 * Negative test deposit - balance should not change
	 */
	@Test
	public void testDepositNegative() {
		chequingAcc.addToBalance(-400);
		assertEquals(100, chequingAcc.getBalance(), 0.0);
	}
	
	/**
	 * Positive test withdraw - balance should reduce
	 */
	@Test
	public void testWithdrawPositive() {
		chequingAcc.subtractFromBalance(30);
		assertEquals(68.8, chequingAcc.getBalance(), 0.0);
	}
	
	/**
	 * Negative test withdraw - balance should not change
	 */
	@Test
	public void testWithdrawNegativeOverBalance() {
		chequingAcc.subtractFromBalance(300);
		assertEquals(100, chequingAcc.getBalance(), 0.0);
	}
	
	/**
	 * Negative test withdraw - balance should not change
	 */
	@Test
	public void testWithdrawNegativeAmount() {
		chequingAcc.subtractFromBalance(-20);
		assertEquals(100, chequingAcc.getBalance(), 0.0);
	}
	
	/**
	 * Positive test withdraw - balance should reduce
	 */
	@Test
	public void testWithdrawIntoOverdraft() {
		goldAcc.subtractFromBalance(200);
		assertEquals(-200, goldAcc.getBalance(), 0.0);
	}
	
	/**
	 * Positive test account number - account number should be GA-1
	 */
	@Test
	public void testAccountNumberConstructor() {
		assertEquals("GA-1", goldAcc.getAccountNumber());
	}
	
	/**
	 * Positive test account number - account number should change
	 */
	@Test
	public void testAccountNumberPositive() {
		savingsAcc.setAccountNumber("SA-72");
		assertEquals("SA-72", savingsAcc.getAccountNumber());
	}
	
	/**
	 * Negative test account number - account number should not change
	 */
	@Test
	public void testAccountNumberNegative() {
		chequingAcc.setAccountNumber(null);
		assertEquals("CA-1", chequingAcc.getAccountNumber());
	}
	
	/**
	 * Positive test active - should be true
	 */
	@Test
	public void testActiveConstructor() {
		assertEquals(true, chequingAcc.getActive());
	}
	
	/**
	 * Positive test active - should change to false
	 */
	@Test
	public void testActivePositive() {
		chequingAcc.setActive(false);
		assertEquals(false, chequingAcc.getActive());
	}
	
	/**
	 * Positive test numberOfCheques - should increment
	 */
	@Test
	public void testNumberOfChequesPositive() {
		chequingAcc.subtractFromBalance(20);
		assertEquals(1, chequingAcc.getNumberOfCheques());
	}
	
	/**
	 * Positive test for setting cheques - should change to 5
	 */
	@Test
	public void testSetNumberOfChequesPositive() {
		chequingAcc.setNumberOfCheques(5);
		assertEquals(5, chequingAcc.getNumberOfCheques());
	}
	
	/**
	 * Negative test numberOfCheques - should stay at 0
	 */
	@Test
	public void testSetNumberOfChequesNegative() {
		chequingAcc.setNumberOfCheques(-4);
		assertEquals(0, chequingAcc.getNumberOfCheques());
	}
	
	/**
	 * Positive test savings account active - Account should change to deactivated
	 */
	@Test
	public void testSavingsAcctDeactivationPositive() {
		savingsAcc.subtractFromBalance(120);
		assertEquals(false, savingsAcc.getActive());
	}
	
	/**
	 * Negative test savings account active - Account should stay active
	 */
	@Test
	public void testSavingsAcctDeactivationNegative() {
		savingsAcc.subtractFromBalance(30);
		assertEquals(true, savingsAcc.getActive());
	}
	
	/**
	 * Positive test interest rate - Should change to 20
	 */
	@Test
	public void testGoldAccountInterestRatePositive() {
		goldAcc.setInterestRate(20);
		assertEquals(20, goldAcc.getInterestRate(), 0.0);
	}
	
}
