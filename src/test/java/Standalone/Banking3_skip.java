package Standalone;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AddCustomerPage;
import PageObject.LoginPage;
import PageObject.OpenAccountPage;
import TestComponents.BaseTest;
import TestComponents.Textcontextsetup;

public class Banking3_skip {
	String firstname="AAKASH";
	String lastname="SINHA";
	String actualamount="1000";
	public LoginPage loginpage;
	public AddCustomerPage addcustomepage;
	public OpenAccountPage openaccountpage;
	Textcontextsetup textcontextsetup;
	public Banking3_skip(Textcontextsetup textcontextsetup)
	{
		this.textcontextsetup=textcontextsetup;
	}
	
	@Test(priority=1)
	public void LoginasBankManager()
	{
		loginpage=textcontextsetup.pageobjectmanager.getloginpage();
		loginpage.BankManagerLogin();
	}
	@Test(priority=2)
	public void addcustomer()
	{
		addcustomepage=textcontextsetup.pageobjectmanager.getaddcustomerpage();
		addcustomepage.AddCustomer();
		addcustomepage.FirstName("AAKASH");
		addcustomepage.LastName("SINHA");
		addcustomepage.setpostcode("700028");
		addcustomepage.addcustomerbutton();
		Alert alert=textcontextsetup.driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains("Customer added successfully"));
		alert.accept();

	}
	@Test(priority=3)
	public void openaccount()
	{
		openaccountpage=textcontextsetup.pageobjectmanager.getopenaccountpage();
		openaccountpage.OpenAccount();
		openaccountpage.choosecustomer("AAKASH","SINHA");
		openaccountpage.chhosecurrency("Rupee");
		openaccountpage.processbutton();
		Alert alert=textcontextsetup.driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains("Account created successfull"));
		alert.accept();



	}
}

