package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import PageObject.LoginPage;

public class BaseTest {
	public static WebDriver driver;
	@BeforeSuite
	public WebDriver WebdriverMananager() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		prop.load(fis);
		String url=prop.getProperty("url");
		String browser=prop.getProperty("browser");
		if(driver==null)
		{
		if(browser.equalsIgnoreCase("chrome"))
		{

			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();

		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(url);
		}
		return driver;
		

	}
	public String getScreenshot(String testcaseName,WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(src,file);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
	}
	

	
	@AfterSuite
	public void teardown()
	{
		driver.close();
	}
}
