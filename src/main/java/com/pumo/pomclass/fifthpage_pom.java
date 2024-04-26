package com.pumo.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fifthpage_pom
{
	
	@FindBy(xpath="(//img[@src='https://res.cloudinary.com/diutessme/image/upload/v1711711981/file_bjaw8x.jpg'])[3]")private WebElement Forever_52;

	@FindBy(xpath="(//img[@src='https://res.cloudinary.com/diutessme/image/upload/v1711712472/file_xbtyob.jpg'])") private WebElement Shopaarel_miracle_foundation ;

	@FindBy(xpath="(//img[@src='https://res.cloudinary.com/diutessme/image/upload/v1711712541/file_ijteha.webp'])[3]")private WebElement ForMatt_Look_Oil_Control_Waterproof_Pan_Cake;

	public fifthpage_pom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}     
	

	public WebElement Forever_52() throws InterruptedException
	{  
		Thread.sleep(3000);
        return Forever_52; 
	}
	
	
	public WebElement Shopaarel_miracle_foundation() throws InterruptedException
	{  
		Thread.sleep(3000);
		return Shopaarel_miracle_foundation;
	}
	
	public WebElement ForMatt_Look_Oil_Control_Waterproof_Pan_Cake() throws InterruptedException
	{  
		Thread.sleep(3000);
		return ForMatt_Look_Oil_Control_Waterproof_Pan_Cake;
	}
	
}
