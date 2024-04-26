package com.pumo.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout
{
	@FindBy(xpath="(//a[text()='Home'])[1]") private WebElement Homebtn ;

	@FindBy(xpath="//a[@role='button']") private WebElement drop_down ;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[7]") private WebElement logout ;
	
	
	public Logout(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}



	public void Homebtn() throws InterruptedException
	{
		Thread.sleep(6000);
		Homebtn.click();	
	}
	
	public void drop_down() throws InterruptedException
	{
		Thread.sleep(2000);
		drop_down.click();	
	}

	public void logout() throws InterruptedException
	{
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(4000);		
	}

}
