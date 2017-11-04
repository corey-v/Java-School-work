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
public class GoldAccountTest {
	
	private GoldAccount goldAcc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		goldAcc = new GoldAccount(0, "GA-1", 1.5);
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
	 * Positive test interest rate - Should change to 20
	 */
	@Test
	public void testGoldAccountInterestRatePositive() {
		goldAcc.setInterestRate(20);
		assertEquals(20, goldAcc.getInterestRate(), 0.0);
	}

}
