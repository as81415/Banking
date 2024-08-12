package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CustomerLoginPage {
	WebDriver driver;
	public CustomerLoginPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@ng-click='home()']")
	WebElement homepage;
	@FindBy(xpath="//button[@ng-click='customer()']")
	WebElement customerlogin;
	@FindBy(id="userSelect")
	WebElement customer;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	@FindBy(xpath="//button[@ng-click='deposit()']")
	WebElement Depositbutton;
	@FindBy(xpath="//input[@ng-model='amount']")
	WebElement amountbutton;
	@FindBy(xpath="//span[@ng-show='message']")
	WebElement showmessage;
	@FindBy(xpath="(//strong[@class='ng-binding'])[2]")
	WebElement expected;
	@FindBy(xpath="//button[@ng-click='withdrawl()']")
	WebElement withdrawlbutton;
	public void home()
	{
		homepage.click();
	}
	public void customerloginpage()
	{
		customerlogin.click();
	}
	public void choosecustomer(String firstname,String lastname)
	{
		
		Select customerchoice=new Select(customer);
		customerchoice.selectByVisibleText(firstname+" "+lastname);
	}
	public void login()
	{
		loginbutton.click();
	}
	public void deposit()
	{
		Depositbutton.click();
	}
	public void amount(String amount)
	{
		amountbutton.sendKeys(amount);
	}
	public String showmsg()
	{
		return showmessage.getText();
		
	}
	public String expectedamount()
	{
		return expected.getText();
	}
	public void withdrawl()
	{
		withdrawlbutton.click();
	}
	
}
