package com.pumo.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Select_Page
{
	
	@FindBy(xpath=("(//button[@type='button'])[6]")) private WebElement SecondPage ;

	@FindBy(xpath=("(//button[@type='button'])[7]")) private WebElement ThirdPage ;
 
	@FindBy(xpath=("(//button[@type='button'])[8]")) private WebElement FourthPage ;
	
	@FindBy(xpath=("(//button[@type='button'])[9]")) private WebElement fifthPage ;

	
	public Select_Page(WebDriver driver)
	{
		PageFactory.initElements(driver ,this);
	}
	
	
	public void Second_Page() throws InterruptedException
	{
		Thread.sleep(2000);
		SecondPage.click();
		Thread.sleep(4000);
	}
	
	public void Third_Page() throws InterruptedException
	{
		Thread.sleep(2000);
		ThirdPage.click();
		
	}
	
	public void Fourth_Page() throws InterruptedException
	{
		Thread.sleep(2000);
		FourthPage.click();
		
	}
	
	public void fifth_Page() throws InterruptedException
	{
		Thread.sleep(2000);
		fifthPage.click();
		
	}
	
	
}
