package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;
	public AddCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@ng-click='addCust()']")
	WebElement addcustomer;
	@FindBy(xpath="//input[@ng-model='fName']")
	WebElement firstName;
	@FindBy(xpath="//input[@ng-model='lName']")
	WebElement lastName;
	@FindBy(xpath="//input[@ng-model='postCd']")
	WebElement postCode;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	public void AddCustomer()
	{
		addcustomer.click();
	}

	public void FirstName(String fname)
	{
		firstName.sendKeys(fname);
	}

	public void LastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	public void setpostcode(String postcode)
	{
		postCode.sendKeys(postcode);
	}
	public void addcustomerbutton()
	{
		submit.click();
	}

}
