package com.pumo.pomclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pumo.utilityclass.BaseClass;

public class ProductPage extends BaseClass
{
	
	@FindBy(xpath=("//h4[text()=' In Stock ']")) private WebElement InStock ;

	@FindBy(xpath=("//select[@class='form-select form-select-sm']")) private WebElement Gram ;

	//@FindBy(xpath=("")) private WebElement ProductName ;
	
	@FindBy(xpath=("/html/body/app-root/app-product/div[1]/div/div[3]/div/div/select/option[2]")) private WebElement gr_no ;
	
	@FindBy(xpath="//button[@class='cart ng-star-inserted']") private WebElement AddCart ;

	@FindBy(xpath="//span[@class='cart ps-2']") private WebElement GotoCart ;
	


	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
//	public String verifyproductname()
//	{
//		String Pname=ProductName.getText();
//		return Pname;
//	}
	
	public String verifyproductInStock() throws InterruptedException
	{
		String Stock=InStock.getText();
		Thread.sleep(3000);
		return Stock;
	}
	
	public void SelectGram(String gr) throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated((By) Gram));
		Thread.sleep(4000);
		Select sel = new Select(Gram);
		sel.selectByVisibleText(gr);
	
			
	}
	
	public boolean selectedWeight() throws InterruptedException
	{
		boolean result=gr_no.isSelected();
		return result;
	}
	
	public boolean Clickon_AddTo_CartBtn() throws InterruptedException
	{
		AddCart.click();
		Thread.sleep(4000);
		
		boolean result = AddCart.isDisplayed();
		if(result)
		{
			System.out.println("Product added into cart successfully");
		}
		else
		{
			System.out.println("Product not added into cart");
		}
		return result;
		
		
	}
	
	public void Clickon_GoTo_CartBtn() throws InterruptedException
	{
		Thread.sleep(2000);
		GotoCart.click();
		Thread.sleep(4000);
	}
	
	
	
	
	
}
