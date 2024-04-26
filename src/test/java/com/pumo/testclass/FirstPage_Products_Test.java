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
import com.pumo.utilityclass.BaseClass;
import com.pumo.utilityclass.utilityclass;

public class FirstPage_Products_Test extends BaseClass
{
	IndexPage In ;
	int Testid; 
	LoginPage LP;
	Logout LG;
	FirstPageProduct Pone;
    ProductPage PP;
    Cart_Page CRT;
	
	@BeforeMethod
	public void login() throws InterruptedException, IOException
	{
		
		System.out.println("************************First_Page Product Test Start*********************************");
	//	initialize("chrome"); // Pass the URL parameter to the initialize method
        Reporter.log("Browser open",true);
        Reporter.log("Enter URL",true);
		
		In = new IndexPage(driver);
		LP = new LoginPage(driver);
		LG = new Logout(driver);
		Pone = new FirstPageProduct(driver);	
		PP = new ProductPage(driver);
		CRT = new Cart_Page(driver);
		
		
		In.Close_PopUp();
		In.Click_On_LoginBtn();
		LP.Validate_Mobile_no("9890502710");
		LP.Validate__Password_btn("Saurabh@3182");
		LP.Click_On_SubmitBtn();    	
		Reporter.log("Login Successfull",true);
		
	}


	@Test(priority=1)
	public void Eyebrow_pencil() throws InterruptedException
	{
		System.out.println("************************Testing Eyebrow Pencil Product*********************************");
		Pone.Eyebrow_Pencil();

		String stock=PP.verifyproductInStock();
	    Assert.assertEquals( "In Stock" ,stock );
		System.out.println("Eyebrow_pencil Product in stock");

//		PP.SelectGram("10");
		PP.Clickon_AddTo_CartBtn();
		PP.Clickon_GoTo_CartBtn();
		CRT.Add_quantity();
		
		String Product_price=CRT.Product_price1();
		String Prod_quantity=CRT.Product_quantity1();
		 String total =CRT.total();
		 
		 String price = Product_price.replaceAll("[^\\d]", "");
		 int Price1 = Integer.parseInt(price);
		 System.out.println("Product Eyebrow_pencil Price : " + Price1);
//		 Assert.assertEquals( "550" , Price1);

		 String quantity = Prod_quantity.replaceAll("[^\\d]", "");
		 int quantity1 = Integer.parseInt(quantity);
		 System.out.println("Product Eyebrow_pencil Quantity : " + quantity1);
		 
//		 String total1 = total.replaceAll("[^\\d]", "");
//		 int Total = Integer.parseInt(total1);
//		 System.out.println("Total : " + Total);
		 
		 System.out.println("Total Eye_brow pencil selected quantity : "+ quantity1);
		 System.out.println("Total Product price : "+ Price1*quantity1);
 
	}	

	
	@Test(priority=2)
	public void Hair_Lacquer_Spray() throws InterruptedException
	{
		System.out.println("************************Testing Hair_Lacquer_Spray Product*********************************");

		Pone.Hair_Lacquer_Spray();

		String stock=PP.verifyproductInStock();
	    Assert.assertEquals( "In Stock" ,stock );
		System.out.println("Product Demo in stock");

	//	PP.SelectGram("10");
		PP.Clickon_AddTo_CartBtn();
		PP.Clickon_GoTo_CartBtn();
		
		String Product_price=CRT.Product_price2();
		String Prod_quantity=CRT.Product_quantity2();
		 String total =CRT.total();
		 
		 String price = Product_price.replaceAll("[^\\d]", "");
		 int Price1 = Integer.parseInt(price);
		 System.out.println("Product Demo Price : " + Price1);
//		 Assert.assertEquals( "550" , Price1);

		 String quantity = Prod_quantity.replaceAll("[^\\d]", "");
		 int quantity1 = Integer.parseInt(quantity);
	//	 System.out.println("Product Demo Quantity : " + quantity1);
		 
		 System.out.println("Total Eye_brow pencil selected quantity :"+ quantity1);
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
		System.out.println("***********************First_Page Testing Finish******************************************");

	}

	
}

/*
	 <class name="com.pumo.testclass.Search_Products_Test2"/>
  <class name="com.pumo.testclass.FirstPage_Products_Test"/>
    <class name="com.pumo.testclass.SecondPage_Product_Test"/>
  <class name="com.pumo.testclass.Thirdpage_products_Test"/>
  <class name="com.pumo.testclass.fourthpage_products_Test"/>
  <class name="com.pumo.testclass.fifthpage_product_Test"/>

*/




// ((//div[@class='row'])[14]//img[@src='https://zplusglobalmarketinsights.com/auctionBanksImages/WhatsApp Image 2023-12-01 at 6.26.40 PM.jpeg'])[1]

// (//div[@class='row'])[14]//img
// (//*[contains(text(),'INSHINE ORIGINALS Waterproof Eyebrow Pencil with Brush')])[3]

//<test name="Test1">
//<parameter name="browserName" value="chrome"/>
//<classes>
//  <class name="com.pumo.testclass.login_page_Test"/>
//</classes>
//</test> <!-- Test -->
//
//<test name="Test2">
//<parameter name="browserName" value="chrome"/>
//<classes>
//  <class name="com.pumo.testclass.HomepageTest"/>
//</classes>
//</test> <!-- Test -->

