package com.pumo.pomclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProd_Pom
{
	@FindBy(xpath="(//input[@type='search'])[1]")private WebElement Search_Prod;

	@FindBy(xpath="(//button[@type='submit'])[1]") private WebElement Search_Btn ;

	//INSHINE Absolute Matte No Transfer Lipstick
	@FindBy(xpath="(//span[contains(text(),'INSHINE Absolute Matte')])[1]") private WebElement INSHINE_Lipstick ;

	//lakyou beauty 25 Color Multi Lip Palette - 24g
	@FindBy(xpath="//span[text()=' lakyou beauty 25 Color Multi Lip Palette - 24g ']") private WebElement lakyou_beauty_25 ;

    //Europe Girl Blusher palette
	@FindBy(xpath="//span[text()=' Europe Girl Blusher palette ']") private WebElement Europe_Girl_Blusher_palette ;
	
    //SWISS BEAUTY Matte Lip Pallete, Multicolor-02, 12g
	@FindBy(xpath="//span[text()=' SWISS BEAUTY Matte Lip Pallete, Multicolor-02, 12g ']") private WebElement SWISS_BEAUTY_Matte_Lip ;

    //Matt Look Oil Control Waterproof Pan Cake 
	@FindBy(xpath="//img[contains(@alt,'Matt Look Oil')]") private WebElement Matt_Look_Oil ;

	@FindBy(xpath="//div[@role='listbox']//mat-option/descendant::span[@class='mat-option-text']") private List<WebElement> Prod_dyanamic_WebElements ;


	String inshine="INSHINE Absolute Matte No Transfer Lipstick";
	
	
	public SearchProd_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}     
	
	
	public void INSHINE_Lipstick() throws InterruptedException
	{  
		Search_Prod.sendKeys("INSHINE Absolute Matte No Transfer Lipstick");
		
          Thread.sleep(2000);
	}	

	public void lakyou_beauty_25() throws InterruptedException
	{  
		Search_Prod.sendKeys("lakyou beauty 25 Color Multi Lip Palette - 24g");
		
          Thread.sleep(2000);
	}
	
	public void Europe_Girl_Blusher_palette() throws InterruptedException
	{  
		Search_Prod.sendKeys("Europe Girl Blusher palette");
		
          Thread.sleep(2000);
	}
	
	public void SWISS_BEAUTY_Matte_Lip() throws InterruptedException
	{  
		Search_Prod.sendKeys("SWISS BEAUTY Matte Lip Pallete, Multicolor-02, 12g");
		
          Thread.sleep(2000);
	}
	
	public List<WebElement> Prod_dyanamic_WebElements()
	{
		return Prod_dyanamic_WebElements;
	}
	
		
	
    public void click_On_Search_Elements(List<WebElement> Elements,String xyz) throws InterruptedException     
    {
     //    System.out.println("total search  -> "+Elements.size());
         
         Thread.sleep(5000);
		   
		   for(int i=0;i<Elements.size();i++)
		   {
			 //  System.out.println(Elements.get(i).getText());
			   if(Elements.get(i).getText().contains(xyz))
			   {
				   Elements.get(i).click();
				   break;
			   }
		   }
		
	}
	
}
