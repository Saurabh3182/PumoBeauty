package com.pumo.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.pumo.utilityclass.BaseClass;

public class place_order extends BaseClass
{
	@FindBy(xpath="//input[@id='flexRadioDefault1']") private WebElement radio_btn ;

	@FindBy(xpath="/html/body/app-root/app-placeorder/div/div/div/div[3]/div[3]/div[2]/select") private WebElement Select_method_btn ;

	@FindBy(xpath="/html/body/app-root/app-placeorder/div/div/div/div[3]/div[2]/button") private WebElement COD ;

	
	
	
	public place_order(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}    

	

	public void select_radio_btn() throws InterruptedException
	{
		 Thread.sleep(1000);
		radio_btn.click();
        Thread.sleep(1000);
				
	}
	
	public void Select_payment_method() throws InterruptedException
	{
		Select sel1=new Select(Select_method_btn);
	    sel1.selectByVisibleText("Cash on delivery");
	    Thread.sleep(6000);
	}
	

	public void COD() throws InterruptedException
	{
	
		COD.click();
		
		boolean result = COD.isDisplayed();
		if(result)
		{
			System.out.println("click on Cash on Delivery");
		}
		else
		{
			System.out.println("enable to Cash on Delivery");
		}
		
		Thread.sleep(5000);
		
	}
	
	
	
}
