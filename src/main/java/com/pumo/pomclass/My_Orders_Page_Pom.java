package com.pumo.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_Orders_Page_Pom 
{
	

	@FindBy(xpath="//span[text()='RATE NOW']")private WebElement RATE_NOW;

	@FindBy(xpath="(//span[@tabindex='0'])[4]") private WebElement Rating ;

	@FindBy(xpath="(//textarea[@formcontrolname='review'])[1]")private WebElement Add_Description;
	
	@FindBy(xpath="(//button[text()='Add Review'])[1]")private WebElement Add_Reviw;
	

	
	
	public My_Orders_Page_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}     
	
	
	
	
	public void ClickOn_RATE_NOW() throws InterruptedException
	{  
		Thread.sleep(3000);
		RATE_NOW.click();
	}
	
	
	public void Give_Rating() throws InterruptedException
	{  
		Thread.sleep(3000);
		Rating.click();
	}
	
	
	public void Add_Description() throws InterruptedException
	{  
		Thread.sleep(3000);
		Add_Description.sendKeys("Good");
	}
	
	
	public void ClickOn_Add_Reviw() throws InterruptedException
	{  
		Thread.sleep(3000);
		Add_Reviw.click();
	}

}
