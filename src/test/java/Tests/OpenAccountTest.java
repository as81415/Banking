package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.OpenAccountPage;
import TestComponents.BaseTest;
import utility.ReadXLSdata;

public class OpenAccountTest extends BaseTest {
	@Test(dataProviderClass = ReadXLSdata.class, dataProvider ="bvtdata")
	public void openaccount(String firstname, String lastname, String postcode)
	{
	OpenAccountPage OP = new OpenAccountPage(driver);
	OP.OpenAccount();
	OP.choosecustomer(firstname,lastname);
	OP.chhosecurrency("Rupee");
	OP.processbutton();
	Alert alert=driver.switchTo().alert();
	System.out.println(alert.getText());
	Assert.assertTrue(alert.getText().contains("Account created successfull"));
	alert.accept();

}
}
