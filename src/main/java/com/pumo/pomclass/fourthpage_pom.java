package com.pumo.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fourthpage_pom
{
	
	@FindBy(xpath="(//img[@src='https://res.cloudinary.com/diutessme/image/upload/v1711710368/file_ta7cfh.jpg'])")private WebElement HANDAIYAN_4_Colors_Matte;

	@FindBy(xpath="(//img[@src='https://res.cloudinary.com/diutessme/image/upload/v1711710622/file_df5tup.jpg'])[3]") private WebElement SWISS_BEAUTY_Matte_Lip_Pallete ;


	public fourthpage_pom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}     
	

	public WebElement HANDAIYAN_4_Colors_Matte() throws InterruptedException
	{  
		Thread.sleep(3000);
        return HANDAIYAN_4_Colors_Matte; 
	}
	
	
	public WebElement SWISS_BEAUTY_Matte_Lip_Pallete() throws InterruptedException
	{  
		Thread.sleep(3000);
		return SWISS_BEAUTY_Matte_Lip_Pallete;
	}

	
	

}
