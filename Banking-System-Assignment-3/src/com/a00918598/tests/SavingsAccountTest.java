package com.a00918598.tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.a00918598.data.SavingsAccount;

/**
 * 
 */

/**
 * @author a00918598 Corey Valentyne
 *
 */
public class SavingsAccountTest {
	
	private SavingsAccount savingsAcc;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		savingsAcc = new SavingsAccount(200, "SA-1");
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
	public void testConstructorTwoParameters() {
		assertEquals(200, savingsAcc.getBalance(), 0.0);
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

}
