package com.pumo.pomclass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pumo.utilityclass.BaseClass;

public class LoginPage extends BaseClass
{
	@FindBy(xpath="//input[@data-placeholder='Mobile Number']") private WebElement Mobile_no ;

	@FindBy(xpath="//input[@data-placeholder='Password']") private WebElement Password ;
	
	@FindBy(xpath="//button[@type='submit']") private WebElement Submit ;

	@FindBy(xpath=("//img[@class='img-fluid']")) private WebElement LoginPage_Logo;
			
			
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	public void Validate_Mobile_no(String no) throws InterruptedException
	{
		boolean result = Mobile_no.isDisplayed();
		if(result)
		{
			System.out.println("Mobile number Entered Successfully");
		}
		else
		{
			System.out.println("Mobile_no not Entered Successfully");
		}
		
		//boolean result=logo.isDisplayed();
		//return result;
	
		Mobile_no.sendKeys(no);
		
	
	}
	
	
	public void Validate__Password_btn(String pass) throws InterruptedException
	{
		boolean result = Password.isDisplayed();
		if(result)
		{
			System.out.println("Password Entered Successfully");
		}
		else
		{
			System.out.println("Password not Entered Successfully");
		}
		
		//boolean result=logo.isDisplayed();
		//return result;
	
		Password.sendKeys(pass);
		
	
	}
	
	public boolean LoginPage_Logo() throws InterruptedException
	{
		Thread.sleep(3000);
		boolean logo=LoginPage_Logo.isDisplayed();
		return logo;
	}
	
	
	public void Click_On_SubmitBtn() throws InterruptedException
	{
		Submit.click();
		Thread.sleep(2000);
     //   return new LoginPage(driver);	
	}

	
}
