package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import excel.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	
	public FirefoxDriver driver;
	//public ChromeDriver driver;
	 
	 @BeforeTest
	 public void initialize() throws IOException{
	 
		    //WebDriverManager.chromedriver().setup();
		    WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		    //System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");			 
			//driver = new ChromeDriver();		
			driver.manage().window().maximize();       
            driver.get("https://translate.google.com/");          
           // driver.findElement(By.xpath("//button[@id='i9']/span[3]")).click();
            driver.findElement(By.xpath("//div[@class='akczyd'][1]//button[@data-language-code='en']")).click();
			driver.findElement(By.xpath("//div[@class='akczyd'][2]//button[@data-language-code='es']")).click();
           
	 
	 }
	 @DataProvider(name="fetch")
	  public String[][] fetchdata() throws IOException
	  {
		String excelFileName="input";
	  	ReadExcel obj=new ReadExcel(); 		        
	  	String[][] excelRead=obj.excelRead(excelFileName);
	  	return excelRead;
	  }
	 @AfterTest
	
	 public void postcondition()
	    {
	        //driver.quit();
	    }
}
