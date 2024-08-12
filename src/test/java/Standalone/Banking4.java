package Standalone;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.AddCustomerPage;
import PageObject.CustomerLoginPage;
import PageObject.DeleteCustomerPage;
import PageObject.LoginPage;
import PageObject.OpenAccountPage;
import TestComponents.BaseTest;
import utility.ReadXLSdata;

public class Banking4 extends BaseTest{
	/*String firstname="AAKASH";
	String lastname="SINHA";
	String actualamount="1000";
	String postcode="700028";*/
	public LoginPage LP;
	public AddCustomerPage ACP;
	public OpenAccountPage OP;
	public DeleteCustomerPage DP;
	public CustomerLoginPage CP;
	
	@Test(priority=1)
	public void LoginasBankManager()
	{
		LP=new LoginPage(driver);
		LP.BankManagerLogin();
	}

	@Test(priority=2,dataProviderClass = ReadXLSdata.class, dataProvider ="bvtdata")
	public void addcustomer(String firstname, String lastname, String postcode)
	{
		ACP=new AddCustomerPage(driver);
		ACP.AddCustomer();
		ACP.FirstName(firstname);
		ACP.LastName(lastname);
		ACP.setpostcode(postcode);
		ACP.addcustomerbutton();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains("Customer added successfully"));
		alert.accept();

	}
	@Test(priority=3,dataProviderClass = ReadXLSdata.class, dataProvider ="bvtdata")
	public void openaccount(String firstname, String lastname, String currency)
	{
		OP=new OpenAccountPage(driver);
		OP.OpenAccount();
		OP.choosecustomer(firstname,lastname);
		OP.chhosecurrency(currency);
		OP.processbutton();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains("Account created successfull"));
		alert.accept();



	}
	@Test(priority=4,dataProviderClass = ReadXLSdata.class, dataProvider ="bvtdata")
	public void customerlogin(String firstname, String lastname,String actualamount,String withdrawnamount) throws InterruptedException
	{
		CP=new CustomerLoginPage(driver);
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
		/*WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='amount']")));*/
		Thread.sleep(5000);
		
		CP.amount(withdrawnamount);
		CP.login();
		String withdrawlmsg=CP.showmsg();
		System.out.println(withdrawlmsg);
		Assert.assertTrue(withdrawlmsg.equals("Transaction successful"));
		String expectedwithdrawlamount=CP.expectedamount();
		System.out.println(expectedwithdrawlamount);
		//Assert.assertEquals(withdrawnamount,expectedwithdrawlamount);


	}


	
	@Test(priority=5,dataProviderClass = ReadXLSdata.class, dataProvider ="bvtdata")
	public void deletecustomer(String firstname, String lastname, String postcode)
	{
		CP.home();
		LP.BankManagerLogin();
		DP=new DeleteCustomerPage(driver);
		DP.customers();
		DP.deletecustomer(postcode);
	}
	

}

