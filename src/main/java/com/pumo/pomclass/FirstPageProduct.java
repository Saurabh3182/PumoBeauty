package com.pumo.pomclass;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pumo.utilityclass.BaseClass;



public class FirstPageProduct extends BaseClass
{
	@FindBy(xpath="(//img[@src='https://res.cloudinary.com/diutessme/image/upload/v1711706344/file_cf23es.jpg'])[3]")private WebElement Hair_Lacquer_Spray;
	
	@FindBy(xpath="(//img[@src='https://res.cloudinary.com/diutessme/image/upload/v1711705995/file_lj77dv.webp'])[3]") private WebElement Eyebrow_Pencil ;
			
	
	
	
	public FirstPageProduct(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}     
	
	
	public void Eyebrow_Pencil() throws InterruptedException
	{  
		Thread.sleep(3000);
		Eyebrow_Pencil.click();
	}
	
	
	public void Hair_Lacquer_Spray() throws InterruptedException
	{  
		Thread.sleep(3000);
		Hair_Lacquer_Spray.click();
	}
	
	

}
