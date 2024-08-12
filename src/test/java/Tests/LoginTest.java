package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import TestComponents.BaseTest;
import utility.ReadXLSdata;

public class LoginTest extends BaseTest{
	@Test(priority=1)
	public void LoginasBankManager()
	{
		//LoginPage LP=new LoginPage(driver);
		LoginPage LP=new LoginPage(driver);
		LP.BankManagerLogin();
	}

}
