package com.pumo.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pumo.utilityclass.BaseClass;

public class SecondPageProduct extends BaseClass
{
	
	@FindBy(xpath="(//img[@src='https://res.cloudinary.com/diutessme/image/upload/v1711708462/file_ws3pcm.jpg'])[3]")private WebElement Imagic36_Eyeshadow;

	@FindBy(xpath="(//img[@src='https://res.cloudinary.com/diutessme/image/upload/v1711707971/file_u0qepq.webp'])[3]") private WebElement DElanciTenderPalette ;

	
	public SecondPageProduct(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}     
	

	public WebElement Imagic36_Eyeshadow() throws InterruptedException
	{  
		Thread.sleep(3000);
        return Imagic36_Eyeshadow; 
	}
	
	
	public WebElement DElanciTenderPalette() throws InterruptedException
	{  
		Thread.sleep(3000);
		return DElanciTenderPalette;
	}
	
}
