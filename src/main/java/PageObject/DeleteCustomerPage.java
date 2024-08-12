package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteCustomerPage {
	WebDriver driver;
	public DeleteCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@ng-click='showCust()']")
    WebElement customerlist;
	/*@FindBy(xpath="//table[@class='table table-bordered table-striped']/tbody/tr")
	List<WebElement> customersrow;
	@FindBy(xpath="//table[//table[@class='table table-bordered table-striped']/thead/tr/td")
	List<WebElement> customerscolumn;*/
	@FindBy(xpath="//input[@ng-model='searchCustomer']")
    WebElement searchpostcode;
	@FindBy(xpath="//button[@ng-click='deleteCust(cust)']")
    WebElement delete;
	By deletewait=By.xpath("//button[@ng-click='deleteCust(cust)']");
	public void customers()
	{
		//driver.findElement(By.xpath("//button[@ng-click='home()']")).click();
		//driver.findElement(By.xpath("//button[@ng-click='manager()']")).click();
		customerlist.click();
	}
	public void deletecustomer(String postcode) 
	{
		
		searchpostcode.sendKeys(postcode);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(deletewait));
		delete.click();
		System.out.println("Customer is deleted");
		//searchpostcode.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		searchpostcode.clear();
		
	}
		
}
