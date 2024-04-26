package com.pumo.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Thirdpage_pom
{
	
	@FindBy(xpath="(//img[@src='https://res.cloudinary.com/diutessme/image/upload/v1711709925/file_c07ayh.jpg'])[3]")private WebElement UCANBE_Versatility_Shaping;

	@FindBy(xpath="(//img[@src='https://res.cloudinary.com/diutessme/image/upload/v1711708732/file_wcxnfi.webp'])[3]") private WebElement Lakyoubeauty25 ;


	public Thirdpage_pom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}     
	

	public WebElement UCANBE_Versatility_Shaping() throws InterruptedException
	{  
		Thread.sleep(3000);
        return UCANBE_Versatility_Shaping; 
	}
	
	
	public WebElement Lakyoubeauty30() throws InterruptedException
	{  
		Thread.sleep(3000);
		return Lakyoubeauty25;
	}
	

}
