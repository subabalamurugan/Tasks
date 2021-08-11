package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excel.ReadExcel;
import translatepages.Translationpage;

public class OutputTest extends BaseClass
{
	public int i=1;
	 
	 @Test(dataProvider ="fetch") 
		public  void runtranslate(String textinput,String textOutput,String result)throws InterruptedException, IOException
	    {  
		 Translationpage tpage= PageFactory.initElements(driver, Translationpage.class);
		
		 
		tpage.enterEngWord(textinput,textOutput,result,i);
		i++;
		
		
		
	}

}
