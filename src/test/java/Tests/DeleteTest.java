package Tests;

import org.testng.annotations.Test;

import PageObject.CustomerLoginPage;
import PageObject.DeleteCustomerPage;
import PageObject.LoginPage;
import TestComponents.BaseTest;
import utility.ReadXLSdata;

public class DeleteTest extends BaseTest {
	
	@Test(dataProviderClass = ReadXLSdata.class, dataProvider ="bvtdata")
	public void deletecustomer(String firstname, String lastname, String postcode)
	{
		CustomerLoginPage CP=new CustomerLoginPage(driver);
		CP.home();
		LoginPage LP=new LoginPage(driver);
		LP.BankManagerLogin();
		DeleteCustomerPage DP=new DeleteCustomerPage(driver);
		DP.customers();
		DP.deletecustomer(postcode);
	}
	

}
