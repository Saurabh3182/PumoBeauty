package com.pumo.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pumo.utilityclass.BaseClass;

public class Cart_Page extends BaseClass
{
	@FindBy(xpath="/html/body/app-root/app-addtocart/div/div/div[1]/div/div[2]/div/div/div[2]/h5/span") private WebElement Product_price1 ;
	
	@FindBy(xpath="(/html/body/app-root/app-addtocart/div/div/div[1]/div/div[2]/div/div/div[2]/h5/span)[2]") private WebElement Product_price2 ;

	@FindBy(xpath="/html/body/app-root/app-addtocart/div/div/div[1]/div/div[2]/div/div/div[2]/p") private WebElement Product_quantity1 ;

	@FindBy(xpath="(/html/body/app-root/app-addtocart/div/div/div[1]/div/div[2]/div/div/div[2]/p)[2]") private WebElement Product_quantity2 ;

	@FindBy(xpath="/html/body/app-root/app-addtocart/div/div/div[1]/div/div[3]/h4/span") private WebElement Sub_total ;
	
	@FindBy(xpath="/html/body/app-root/app-addtocart/div/div/div[2]/div/div[3]/h4/span") private WebElement total ;
	
	@FindBy(xpath="(//button[@type='button'])[4]") private WebElement Proceed_to_checkout ;
	
	@FindBy(xpath="/html/body/app-root/app-addtocart/div/div/div[1]/div/div[2]/div/div/div[1]/div[2]/span/button[2]") private WebElement Add_quantity ;
	
	@FindBy(xpath="/html/body/app-root/app-addtocart/div/div/div[1]/div/div[2]/div/div/div[1]/div[2]/span/button[1]") private WebElement Sub_quantity ;
	
	@FindBy(xpath="(//button[@type='button'])[3]") private WebElement Remove_btn1 ;
	
	@FindBy(xpath="(//button[@type='button'])[4]") private WebElement Remove_btn2 ;

   
	public Cart_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}     
	
	
	
	public void Proceed_to_checkout() throws InterruptedException
	{
		Thread.sleep(3000);
		//return Proceed_to_checkout;
		Proceed_to_checkout.click();
	}
	
	public String Product_quantity1() throws InterruptedException
	{
		Thread.sleep(3000);
		String quant=Product_quantity1.getText();
		return quant;
	}
	
	
	public String Product_price1() throws InterruptedException
	{
		Thread.sleep(3000);
		String Pr=Product_price1.getText();
		return Pr;
	}
	

	public String Product_quantity2() throws InterruptedException
	{
		Thread.sleep(3000);
		String quant=Product_quantity2.getText();
		return quant;
	}
	
	public String Product_price2() throws InterruptedException
	{
		Thread.sleep(3000);
		String Pr=Product_price2.getText();
		return Pr;
	}
	
	
	public String Sub_total() throws InterruptedException
	{
		Thread.sleep(3000);
		String email=Sub_total.getText();
		return email;
	}
	
	public String total() throws InterruptedException
	{
		Thread.sleep(3000);
		String email=total.getText();
		return email;
	}
	
	
	public void Add_quantity() throws InterruptedException
	{
		Thread.sleep(3000);
		Add_quantity.click();
		
	}
	
	public void Sub_quantity() throws InterruptedException
	{
		Thread.sleep(3000);
		Sub_quantity.click();
		
	}
	
	public void Remove_btn1() throws InterruptedException
	{
		Thread.sleep(3000);
		boolean result = Remove_btn1.isDisplayed();
		if(result)
		{
			System.out.println("Product Remove");
		}
		else
		{
			System.out.println("Product Not Remove");
		}
		Remove_btn1.click();
		
	}

	public void Remove_btn2() throws InterruptedException
	{
		Thread.sleep(3000);
		boolean result = Remove_btn2.isDisplayed();
		if(result)
		{
			System.out.println("Product Remove");
		}
		else
		{
			System.out.println("Product Not Remove");
		}
		
		Remove_btn2.click();
	}

}
