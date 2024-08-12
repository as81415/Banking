package TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObject.Pageobjectmanager;

public class Textcontextsetup {

	public WebDriver driver;
	public BaseTest basetest;
	public Pageobjectmanager pageobjectmanager;
	
	public Textcontextsetup() throws IOException
	{
		basetest=new BaseTest();
		pageobjectmanager =new Pageobjectmanager(basetest.WebdriverMananager());
	}
}
