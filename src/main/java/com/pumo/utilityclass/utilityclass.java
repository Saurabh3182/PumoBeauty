package com.pumo.utilityclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class utilityclass
{  
	WebDriver driver;
	
	public utilityclass(WebDriver driver)
	{
        this.driver = driver;
    }
	
	@Test
	public static String getdatafromPF(String Keys) throws IOException
	{                                             
		
//     FileInputStream file=new FileInputStream("C:\\Users\\91832\\eclipse-workspace\\Selenum\\src\\Propertyfile.properties");
		
	   FileInputStream file=new FileInputStream("D:\\TEstingSetUP\\EclipseWorkPlace\\pumo\\Property.properties");
		
		Properties Prop=new Properties();

		Prop.load(file);
		
		String values=Prop.getProperty(Keys);
		
		return values;
		
		
	}
	
	@Test
	public static String getdatafromExcel(int Rowindex , int Cellindex) throws EncryptedDocumentException, IOException
	{
		    FileInputStream file = new FileInputStream("D:\\saurabh.xlsx");
		    String value = WorkbookFactory.create(file).getSheet("Sheet1").getRow(Rowindex).getCell(Cellindex).getStringCellValue();
		    return value;

		
	}
	

	@Test
	public static void takeScreenShot(WebDriver driver,int Testid) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		
		//File destination=new File("C:\\Users\\Saurabh\\02Nov22-eclipse-workspace\\Final_script\\ScreenShots\\."+Testid+".jpg");		
		File destination=new File("D:\\TEstingSetUP\\EclipseWorkPlace\\final_pumo\\ScreenShots\\."+Testid+".jpg");
	
		
		FileHandler.copy(source, destination);
		
		
	}
	
	public static String takeSSInExtend(WebDriver driver,String Testid) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		
		String destination = System.getProperty("user.dir")+"\\test-output\\Screenshot\\."+ Testid +".jpg";
		
	//	File destination=new File("D:\\TEstingSetUP\\Screenshot\\."+Testid+".jpg");
	    File filedestination= new File(destination);
	    try{
	    	
	    	FileUtils.copyFile(source, filedestination);
	    }
	    catch(Exception e)
	    {
	    	e.getMessage();
	    }
		return destination;
	}
	
	
	
	   public void Actionclass(WebElement ele) throws InterruptedException
	   {
		   
		   Actions act = new Actions(driver);
	         act.doubleClick(ele).perform();
			
	 		Thread.sleep(2000);
	   }
	    
       public void scroll(WebElement ele)
       {
    	
    	   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",ele);    
    	   	      
           ((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
    	   
    	    
       }
	   
	   
	   
     
       

}
