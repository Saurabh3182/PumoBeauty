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
import com.pumo.pomclass.My_Orders_Page_Pom;
import com.pumo.pomclass.ProductPage;
import com.pumo.pomclass.place_order;
import com.pumo.utilityclass.BaseClass;
import com.pumo.utilityclass.utilityclass;

public class Product_review_test extends BaseClass
{ 
	
	IndexPage In ;
	int Testid; 
	LoginPage LP;
	Logout LG;
	FirstPageProduct Pone;
    ProductPage PP;
    Cart_Page CRT;
    place_order PO;
    My_Orders_Page_Pom MOP;
	
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
		PO = new place_order(driver);
		MOP = new My_Orders_Page_Pom(driver);
		
		
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
//		CRT.Add_quantity();
		
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
		 
		 CRT.Proceed_to_checkout();
		 PO.select_radio_btn();
		 PO.Select_payment_method();
		 PO.COD();
		 MOP.ClickOn_RATE_NOW();
		 MOP.Give_Rating();
		 MOP.Add_Description();
		 MOP.ClickOn_Add_Reviw();
 
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
