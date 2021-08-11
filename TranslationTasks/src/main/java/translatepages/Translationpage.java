package translatepages;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import excel.ReadExcel;

public class Translationpage 
{
	
	 public WebDriver driver;
	 public String result;
	 public Translationpage(WebDriver driver)
		{
			this.driver = driver;	
		}		 
	
	 @FindBy(xpath="//textarea[@role='combobox']") 
	  WebElement englishtext;
	 
	/* @FindBy(xpath="(//button[@data-disable-idom='true'])[3]") 
	WebElement translateclk;
	 
	 @FindBy(xpath="(//input[@placeholder='Search languages'])[2]")	 
	 WebElement serachspanish;*/
	
	 
	@Test(dataProvider = "fetch") 
	
	 
	 public Translationpage enterEngWord(String strtextinput,String strtextOutput,String result,int i) throws InterruptedException, IOException
	 {
		
	
		 englishtext.clear();		 
		 englishtext.sendKeys(strtextinput);
	    /*translateclk.click();
		 serachspanish.sendKeys("Spanish");
		serachspanish.sendKeys(Keys.ENTER);	*/
		
		
		 Thread.sleep(2000);
		// String translation = driver.findElement(By.xpath("//div[@class='J0lOec']")).getText();	
		 String translation= driver.findElement(By.xpath("(//span[@data-language-for-alternatives='es']//SPAN)[1]")).getText();
         Thread.sleep(2000);	
		
		
		System.out.println("Excel Output  : " +strtextOutput);
		System.out.println("Google Output : " +translation);
		
		 
		 File file =    new File("./data/input.xlsx");	
			
			FileInputStream inputfile  = new FileInputStream(file);
			XSSFWorkbook wb=new XSSFWorkbook(inputfile);
			XSSFSheet ws=wb.getSheet("Sheet1");		
			int rownum=ws.getLastRowNum();
			//System.out.println(i);
			 
			 if(strtextOutput.equalsIgnoreCase(translation))
		     {	
		    	 System.out.println("Both are Equal.");
		    	 System.out.println("Result : Pass");
		    	 System.out.println();
		    	ws.getRow(i).createCell(2).setCellValue("Pass");
		     }
		    else
		    {
		    	System.out.println("Both are Not Equal.");
		    	 System.out.println("Result : Fail");
		    	 System.out.println();
		    	ws.getRow(i).createCell(2).setCellValue("Fail");
		     
		    }
		   
			 
			FileOutputStream outputStream = new FileOutputStream(file);
	       wb.write(outputStream);
			
			
			
	     return this;
		 }
}	 
			 









	/* public void writeDataToExcel(String spanishText,String resultText ) throws IOException
	 {
		    
		 File file =    new File("./data/input.xlsx");	
	    // System.out.println(resultText + "   "+spanishText);
		 FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook excel = new XSSFWorkbook(fis);
			XSSFSheet ws = excel.getSheet("Sheet1");
			XSSFRow row = ws.getRow(1);
			XSSFCell cell =row.getCell(0);
			
			// rowcount
			int rowcount = ws.getLastRowNum();
			
			//cell count
			//int cellcount = ws.getRow(0).getLastCellNum();
			//String data[][] = new String[rowcount][cellcount];
			
			int writeRow=0;
			for(int i=1;i<=rowcount;i++)
			{				
					String excelText = ws.getRow(i).getCell(1).getStringCellValue();
					
				     if (excelText.equals(spanishText))
				     {
				    	
				    	 writeRow = i;
				         System.out.println(writeRow);
				    	 break;
				     }
				    	
			    }
			System.out.println(writeRow);
			writeRow++;
			System.out.println(writeRow);
			row = ws.getRow(writeRow);
			
				            // System.out.println("Creating cell for row  "+ writeRow + row.toString());
			
				            	// cell = row.createCell(2);
				           System.out.println("result"+resultText);
				            	// cell.setCellValue("result"+resultText);
				            	 ws.getRow(writeRow).createCell(2).setCellValue(resultText);
	              
				            
	     // Write the data back in the Excel file
				            FileOutputStream outputStream = new FileOutputStream(file);
				            excel.write(outputStream);
				            outputStream.close();
				           
	 }
		
		
	
	 
	
	 
	 }*/

