package com.a00918598.driver;
import java.util.HashMap;

import com.a00918598.data.BankCustomer;

/**
 * @author A00918598 Corey Valentyne
 *
 */
public interface ReporterInterface {

	void displayByCode(HashMap<String, BankCustomer> records, String prefix);
	
	void displayAllCodes(HashMap<String, BankCustomer> records);
	
	void displayInactiveCodes(HashMap<String, BankCustomer> records);

}
