package Tests;

import org.openqa.selenium.Alert;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AddCustomerPage;

import TestComponents.BaseTest;
import utility.ReadXLSdata;

public class AddCustomerTest extends BaseTest {
	@Test(dataProviderClass = ReadXLSdata.class, dataProvider ="bvtdata")
	public void addcustomer(String firstname, String lastname, String postcode)
	{
		
		AddCustomerPage ACP=new AddCustomerPage(driver);
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

}
