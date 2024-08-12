package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class OpenAccountPage {
	
	WebDriver driver;
	public OpenAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@ng-click='openAccount()']")
	WebElement accountopen;
	@FindBy(id="userSelect")
	WebElement customer;
	@FindBy(id="currency")
	WebElement currencyoption;
	@FindBy(xpath="//button[@type='submit']")
	WebElement process;
	public void OpenAccount()
	{
		accountopen.click();
	}
	public void choosecustomer(String firstname,String lastname)
	{
		
		Select customerchoice=new Select(customer);
		customerchoice.selectByVisibleText(firstname+" "+lastname);
	}
	public void chhosecurrency(String currency)
	{
		
		
		Select currencychoice=new Select(currencyoption);
		currencychoice.selectByVisibleText("Rupee");
	}
	public void processbutton()
	{
		process.click();
	}



}
