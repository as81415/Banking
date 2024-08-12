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

import TestComponents.BaseTest;

public class Banking extends BaseTest{
	String firstname="AAKASH";
	String lastname="SINHA";
	String actualamount="1000";
	String postcode="700028";
	@Test(priority=1)
	public void LoginasBankManager()
	{
		driver.findElement(By.xpath("//button[@ng-click='manager()']")).click();
	}
	@Test(priority=2)
	public void addcustomer()
	{
		driver.findElement(By.xpath("//button[@ng-click='addCust()']")).click();
		driver.findElement(By.xpath("//input[@ng-model='fName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@ng-model='lName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@ng-model='postCd']")).sendKeys(postcode);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains("Customer added successfully"));
		alert.accept();

	}
	@Test(priority=3)
	public void openaccount()
	{
		driver.findElement(By.xpath("//button[@ng-click='openAccount()']")).click();
		WebElement customer=driver.findElement(By.id("userSelect"));
		Select customerchoice=new Select(customer);
		customerchoice.selectByVisibleText(firstname+" "+lastname);
		WebElement currency=driver.findElement(By.id("currency"));
		Select currencychoice=new Select(currency);
		currencychoice.selectByVisibleText("Rupee");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains("Account created successfull"));
		alert.accept();


	}
	@Test(priority=4)
	public void customerlogin()
	{
		driver.findElement(By.xpath("//button[@ng-click='home()']")).click();
		driver.findElement(By.xpath("//button[@ng-click='customer()']")).click();
		WebElement customer=driver.findElement(By.id("userSelect"));
		Select customerchoice=new Select(customer);
		customerchoice.selectByVisibleText(firstname+" "+lastname);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Test(priority=5)
	public void deposit()
	{

		driver.findElement(By.xpath("//button[@ng-click='deposit()']")).click();
		driver.findElement(By.xpath("//input[@ng-model='amount']")).sendKeys(actualamount);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String depositmsg=driver.findElement(By.xpath("//span[@ng-show='message']")).getText();
		System.out.println(depositmsg);
		Assert.assertTrue(depositmsg.equals("Deposit Successful"));
		String expectedamount=driver.findElement(By.xpath("(//strong[@class='ng-binding'])[2]")).getText();
		System.out.println(expectedamount);
		Assert.assertEquals(actualamount,expectedamount);

	}
	@Test(priority=6)
	public void withdraw() throws InterruptedException 
	{

		driver.findElement(By.xpath("//button[@ng-click='withdrawl()']")).click();
		/*WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='amount']")));*/
		Thread.sleep(5000);
		String actualwithdrawnamount="500";
		driver.findElement(By.xpath("//input[@ng-model='amount']")).sendKeys(actualwithdrawnamount);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String withdrawlmsg=driver.findElement(By.xpath("//span[@ng-show='message']")).getText();
		System.out.println(withdrawlmsg);
		Assert.assertTrue(withdrawlmsg.equals("Transaction successful"));
		String expectedwithdrawlamount=driver.findElement(By.xpath("(//strong[@class='ng-binding'])[2]")).getText();
		System.out.println(expectedwithdrawlamount);
		//Assert.assertEquals(actualwithdrawnamount,expectedwithdrawlamount);


	}


	@Test(priority=7)
	public void deletecustomer() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@ng-click='home()']")).click();
		driver.findElement(By.xpath("//button[@ng-click='manager()']")).click();
		driver.findElement(By.xpath("//button[@ng-click='showCust()']")).click();

		WebElement search=driver.findElement(By.xpath("//input[@ng-model='searchCustomer']"));
		search.sendKeys(postcode);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='deleteCust(cust)']")));
		driver.findElement(By.xpath("//button[@ng-click='deleteCust(cust)']")).click();
		System.out.println("Customer is deleted");
		search.clear();
		

	}
	/*if(customernames.equalsIgnoreCase(firstname+" "+lastname))
			{
				System.out.println("Customer is not deleted");
				break;
			}*/






}


