package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pageobjectmanager{
	public WebDriver driver;
	public LoginPage loginpage;
	public AddCustomerPage addcustomepage;
	public OpenAccountPage openaccountpage;
	public Pageobjectmanager(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public LoginPage getloginpage()
	{
		loginpage=new LoginPage(driver);
		return loginpage;
	}
	public AddCustomerPage getaddcustomerpage()
	{
		addcustomepage=new AddCustomerPage(driver);
		return addcustomepage;
	}
	public OpenAccountPage getopenaccountpage()
	{
		openaccountpage=new OpenAccountPage(driver);
		return openaccountpage;
	}
	

}
