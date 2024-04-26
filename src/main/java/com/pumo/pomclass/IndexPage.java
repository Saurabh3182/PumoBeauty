package com.pumo.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pumo.utilityclass.BaseClass;


public class IndexPage extends BaseClass
{
	@FindBy(xpath="//span[text()='Close']") private WebElement close_button;

	@FindBy(xpath="(//h5/img)[1]") private WebElement logo;
	
	@FindBy(xpath="//a[@routerlink='/master/wishlist']") private WebElement Wishlist;

	@FindBy(xpath=("(//button[@type='submit'])[1]")) private WebElement Search_btn ;
	
	@FindBy(xpath=("//a[text()='pumobeauty@gmail.com']")) private WebElement Emailid ;

	@FindBy(xpath=("//a[text()='9833115938']")) private WebElement Mobileno ;
			
	@FindBy(xpath=("(//span[@class='ps-2 cart ng-star-inserted'])[1]")) private WebElement Loginbtn ;

			
			
			
	public IndexPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void Close_PopUp() throws InterruptedException
	{
		Thread.sleep(2000);
		close_button.click();
		Thread.sleep(2000);
	}
	
	public boolean Validate_Logo() throws InterruptedException
	{
		boolean result = logo.isDisplayed();
		if(result)
		{
			System.out.println("The Logo is Present/Displayed");
		}
		else
		{
			System.out.println("The Logo is not Present/Displayed");
		}
		
		//boolean result=logo.isDisplayed();
		return result;
//		Thread.sleep(3000);
//		return Actionclass.isDisplayed(driver, logo);		
	}
	
	
	public boolean Validate_Wishlist_btn() throws InterruptedException
	{
		boolean result = Wishlist.isDisplayed();
		if(result)
		{
			System.out.println("The Wishlist is Present/Displayed");
		}
		else
		{
			System.out.println("The element is not Present/Displayed");
		}
		return result;
	}
	
	
	public boolean Validate_Search_btn() throws InterruptedException
	{
		boolean result = Search_btn.isDisplayed();
		if(result)
		{
			System.out.println("The Search_btn is Present/Displayed");
		}
		else
		{
			System.out.println("The element is not Present/Displayed");
		}
		return result;
	}
	
	
	public String Verify_EmailId() throws InterruptedException
	{
		Thread.sleep(3000);
		String email=Emailid.getText();
		return email;
	}
	
	public String Verify_MobileNo() throws InterruptedException
	{
		Thread.sleep(3000);
		String mob =Mobileno.getText();
		return mob;
	}
	
	public void Click_On_LoginBtn() throws InterruptedException
	{
		Thread.sleep(2000);
		Loginbtn.click();
		Thread.sleep(2000);
     //   return new LoginPage(driver);	
	}

	
}
