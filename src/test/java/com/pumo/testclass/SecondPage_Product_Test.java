package com.pumo.testclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pumo.pomclass.Cart_Page;
import com.pumo.pomclass.FirstPageProduct;
import com.pumo.pomclass.IndexPage;
import com.pumo.pomclass.LoginPage;
import com.pumo.pomclass.Logout;
import com.pumo.pomclass.ProductPage;
import com.pumo.pomclass.SecondPageProduct;
import com.pumo.pomclass.Select_Page;
import com.pumo.utilityclass.BaseClass;
import com.pumo.utilityclass.utilityclass;

public class SecondPage_Product_Test extends BaseClass
{
	
	IndexPage In ;
	int Testid; 
	LoginPage LP;
	Logout LG;	
    ProductPage PP;
    Cart_Page CRT;
	FirstPageProduct Pone;
	SecondPageProduct PSecond;
    Select_Page SelPage;
	utilityclass utility;
    
    
	@BeforeMethod
	public void login() throws InterruptedException, IOException
	{
		
		System.out.println("************************Second_Page Product Testing Start*********************************");
	//	initialize("chrome"); // Pass the URL parameter to the initialize method
        Reporter.log("Browser open",true);
        Reporter.log("Enter URL",true);
		
		In = new IndexPage(driver);
		LP = new LoginPage(driver);
		LG = new Logout(driver);
		Pone = new FirstPageProduct(driver);	
		PSecond =new SecondPageProduct(driver);
		PP = new ProductPage(driver);
		CRT = new Cart_Page(driver);
		SelPage = new Select_Page(driver);
		utility= new utilityclass(driver);
		
		
		In.Close_PopUp();
		In.Click_On_LoginBtn();
		LP.Validate_Mobile_no("9890502710");
		LP.Validate__Password_btn("Saurabh@3182");
		LP.Click_On_SubmitBtn();    	
		Reporter.log("Login Successfull",true);
		
	}


	@Test(priority=1)
	public void Imagic36_Eyeshadow() throws InterruptedException
	{
		System.out.println("************************Testing Imagic36_Eyeshadow Product*********************************");
		
		SelPage.Second_Page();
		utility.Actionclass(PSecond.Imagic36_Eyeshadow());
	//	PSecond.Matt_Lipstick();

		String stock=PP.verifyproductInStock();
	    Assert.assertEquals( "In Stock" ,stock );
		System.out.println("Imagic36_Eyeshadow Product in stock");

	//	PP.SelectGram("30");
		PP.Clickon_AddTo_CartBtn();
		PP.Clickon_GoTo_CartBtn();
		
		String Product_price=CRT.Product_price1();
		String Prod_quantity=CRT.Product_quantity1();
		 String total =CRT.total();
		 
		 String price = Product_price.replaceAll("[^\\d]", "");
		 int Price1 = Integer.parseInt(price);
		 System.out.println("Product Imagic36_Eyeshadow Price : " + Price1);
//		 Assert.assertEquals( "550" , Price1);

		 String quantity = Prod_quantity.replaceAll("[^\\d]", "");
		 int quantity1 = Integer.parseInt(quantity);
		 System.out.println("Product Imagic36_Eyeshadow Quantity : " + quantity1);
		 
//		 String total1 = total.replaceAll("[^\\d]", "");
//		 int Total = Integer.parseInt(total1);
//		 System.out.println("Total : " + Total);
		 
		 System.out.println("Total Imagic36_Eyeshadow selected quantity : "+ quantity1);
		 System.out.println("Total Product price : "+ Price1*quantity1);
 
	}	

	
	@Test(priority=2)
	public void DElanciTenderPalette() throws InterruptedException
	{
		System.out.println("************************Testing DElanciTenderPalette Product*********************************");

		SelPage.Second_Page();
		utility.Actionclass(PSecond.DElanciTenderPalette());


		String stock=PP.verifyproductInStock();
	    Assert.assertEquals( "In Stock" ,stock );
		System.out.println("Product DElanciTenderPalette in stock");

	//	PP.SelectGram("24");
		PP.Clickon_AddTo_CartBtn();
		PP.Clickon_GoTo_CartBtn();
		
		String Product_price=CRT.Product_price2();
		String Prod_quantity=CRT.Product_quantity2();
		 String total =CRT.total();
		 
		 String price = Product_price.replaceAll("[^\\d]", "");
		 int Price1 = Integer.parseInt(price);
		 System.out.println("Product DElanciTenderPalette Price : " + Price1);
//		 Assert.assertEquals( "550" , Price1);

		 String quantity = Prod_quantity.replaceAll("[^\\d]", "");
		 int quantity1 = Integer.parseInt(quantity);
	//	 System.out.println("Product Demo Quantity : " + quantity1);
		 
		 System.out.println("Total DElanciTenderPalette selected quantity :"+ quantity1);
		 System.out.println("Total Product price : "+ Price1*quantity1);  
		 
		 String total1 = total.replaceAll("[^\\d]", "");
		 int Total = Integer.parseInt(total1);
		 System.out.println("Sub Total : " + Total);
		
		 CRT.Remove_btn2();
	     CRT.Remove_btn1();
		 
	}	 
	
	@AfterMethod
	public void logout(ITestResult Result) throws IOException, InterruptedException
	{
		
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			utilityclass.takeScreenShot(driver, Testid);

		}

		Thread.sleep(5000);
		LG.Homebtn();
		LG.drop_down();
		LG.logout();
		
		Reporter.log("Log Out Account",true);
		Reporter.log("Browser Close",true);
		System.out.println("***********************Second_Page Testing Finish******************************************");

	}
	
	
	

}
