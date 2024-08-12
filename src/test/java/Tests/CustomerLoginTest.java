package Tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CustomerLoginPage;
import PageObject.OpenAccountPage;
import TestComponents.BaseTest;
import utility.ReadXLSdata;

public class CustomerLoginTest extends BaseTest {
	@Test(dataProviderClass = ReadXLSdata.class, dataProvider ="bvtdata")
	public void customerlogin(String firstname, String lastname,String actualamount,String withdrawnamount) throws InterruptedException
	{
		
		CustomerLoginPage CP=new CustomerLoginPage(driver);
		CP.home();
		CP.customerloginpage();
		CP.choosecustomer(firstname, lastname);
		CP.login();
		
	//Verify Deposit
		CP.deposit();
		CP.amount(actualamount);
		CP.login();
		
		String depositmsg=CP.showmsg();
		System.out.println(depositmsg);
		Assert.assertTrue(depositmsg.equals("Deposit Successful"));
		String expectedamount=CP.expectedamount();
		System.out.println(expectedamount);
		Assert.assertEquals(actualamount,expectedamount);


		//Verify Withdrawl
		CP.withdrawl();
		Thread.sleep(5000);
		CP.amount(withdrawnamount);
		CP.login();
		String withdrawlmsg=CP.showmsg();
		System.out.println(withdrawlmsg);
		Assert.assertTrue(withdrawlmsg.equals("Transaction successful"));
		String expectedwithdrawlamount=CP.expectedamount();
		System.out.println(expectedwithdrawlamount);
}
}
