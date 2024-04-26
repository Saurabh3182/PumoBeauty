package com.pumo.testclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pumo.pomclass.Cart_Page;
import com.pumo.pomclass.IndexPage;
import com.pumo.pomclass.LoginPage;
import com.pumo.pomclass.Logout;
import com.pumo.pomclass.ProductPage;
import com.pumo.pomclass.Select_Page;
import com.pumo.pomclass.fifthpage_pom;
import com.pumo.pomclass.place_order;
import com.pumo.utilityclass.BaseClass;
import com.pumo.utilityclass.utilityclass;


public class fifthpage_product_Test extends BaseClass
{
	
	
	IndexPage In ;
	int Testid; 
	LoginPage LP;
	Logout LG;	
	ProductPage PP;
	Cart_Page CRT;
	fifthpage_pom Pagefive;
	Select_Page SelPage;
	utilityclass utility;
    place_order  Place_Order;

	@BeforeMethod
	public void Login() throws InterruptedException, IOException
	{

		System.out.println("************************Fifth_Page Product Testing Start*********************************");
		//	initialize("chrome"); // Pass the URL parameter to the initialize method
		Reporter.log("Browser open",true);
		Reporter.log("Enter URL",true);

		In = new IndexPage(driver);
		LP = new LoginPage(driver);
		LG = new Logout(driver);
		Pagefive = new fifthpage_pom(driver);
		PP = new ProductPage(driver);
		CRT = new Cart_Page(driver);
		SelPage = new Select_Page(driver);
		utility= new utilityclass(driver);
		Place_Order= new place_order(driver);

		In.Close_PopUp();
		In.Click_On_LoginBtn();
		LP.Validate_Mobile_no("9890502710");
		LP.Validate__Password_btn("Saurabh@3182");
		LP.Click_On_SubmitBtn();    	
		Reporter.log("Login Successfull",true);

	}


	@Test(priority=1)
	public void Forever_52() throws InterruptedException
	{
		System.out.println("************************Testing Forever_52 Product*********************************");

		SelPage.fifth_Page();
		utility.Actionclass(Pagefive.Forever_52());
		//	PSecond.Matt_Lipstick();

		String stock=PP.verifyproductInStock();
		Assert.assertEquals( "In Stock" ,stock );
		System.out.println("Forever_52 Product in stock");

//		PP.SelectGram("22");
		PP.Clickon_AddTo_CartBtn();
		PP.Clickon_GoTo_CartBtn();

		String Product_price=CRT.Product_price1();
		String Prod_quantity=CRT.Product_quantity1();
		String total =CRT.total();

		String price = Product_price.replaceAll("[^\\d]", "");
		int Price1 = Integer.parseInt(price);
		System.out.println("Product Forever_52 Price : " + Price1);
		//		 Assert.assertEquals( "550" , Price1);

		String quantity = Prod_quantity.replaceAll("[^\\d]", "");
		int quantity1 = Integer.parseInt(quantity);
		System.out.println("Product Forever_52 Quantity : " + quantity1);

		//		 String total1 = total.replaceAll("[^\\d]", "");
		//		 int Total = Integer.parseInt(total1);
		//		 System.out.println("Total : " + Total);

		System.out.println("Total Forever_52 selected quantity : "+ quantity1);
		System.out.println("Total Product price : "+ Price1*quantity1);

		
	}	


	@Test(priority=2)
	public void Shopaarel_miracle_foundation() throws InterruptedException
	{
		System.out.println("************************Testing Shopaarel_miracle_foundation Product*********************************");

		SelPage.fifth_Page();
		utility.Actionclass(Pagefive.Shopaarel_miracle_foundation());


		String stock=PP.verifyproductInStock();
		Assert.assertEquals( "In Stock" ,stock );
		System.out.println("Product Shopaarel_miracle_foundation in stock");

//		PP.SelectGram("30");
		PP.Clickon_AddTo_CartBtn();
		PP.Clickon_GoTo_CartBtn();

		String Product_price=CRT.Product_price2();
		String Prod_quantity=CRT.Product_quantity2();
		String total =CRT.total();

		String price = Product_price.replaceAll("[^\\d]", "");
		int Price1 = Integer.parseInt(price);
		System.out.println("Product Shopaarel_miracle_foundation Price : " + Price1);
		//		 Assert.assertEquals( "550" , Price1);

		String quantity = Prod_quantity.replaceAll("[^\\d]", "");
		int quantity1 = Integer.parseInt(quantity);
		//	 System.out.println("Product Demo Quantity : " + quantity1);

		System.out.println("Total Shopaarel_miracle_foundation selected quantity :"+ quantity1);
		System.out.println("Total Product price : "+ Price1*quantity1);  

		String total1 = total.replaceAll("[^\\d]", "");
		int Total = Integer.parseInt(total1);
		System.out.println("Sub Total : " + Total);

		
		CRT.Remove_btn2();
        CRT.Remove_btn1();
		
	}	 	
	
	@Test(priority=3)
	public void ForMatt_Look_Oil_Control_Waterproof_Pan_Cake() throws InterruptedException
	{
		System.out.println("************************Testing ForMatt_Look_Oil_Control_Waterproof_Pan_Cake Product*********************************");

		SelPage.fifth_Page();
		utility.Actionclass(Pagefive.ForMatt_Look_Oil_Control_Waterproof_Pan_Cake());


		String stock=PP.verifyproductInStock();
		Assert.assertEquals( "In Stock" ,stock );
	//	System.out.println("Product ForMatt_Look_Oil_Control_Waterproof_Pan_Cake in stock");

	//	PP.SelectGram("15.0");
		PP.Clickon_AddTo_CartBtn();
		PP.Clickon_GoTo_CartBtn();

		String Product_price=CRT.Product_price1();
		String Prod_quantity=CRT.Product_quantity1();
		String total =CRT.total();

		String price = Product_price.replaceAll("[^\\d]", "");
		int Price1 = Integer.parseInt(price);
		System.out.println("Product Forever_52 Price : " + Price1);
		//		 Assert.assertEquals( "550" , Price1);

		String quantity = Prod_quantity.replaceAll("[^\\d]", "");
		int quantity1 = Integer.parseInt(quantity);
		System.out.println("Product Forever_52 Quantity : " + quantity1);

		 String total1 = total.replaceAll("[^\\d]", "");
		 int Total = Integer.parseInt(total1);
		 System.out.println("Total : " + Total);

		System.out.println("Total Forever_52 selected quantity : "+ quantity1);
		System.out.println("Total Product price : "+ Price1*quantity1);

//		
//		utility.Actionclass(CRT.Proceed_to_checkout());
//		Place_Order.select_add();
//		Place_Order.Select_method_btn();
//		
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
		System.out.println("***********************Fifth_Page Testing Finish******************************************");

	}


	
	
	
	
	
	

}
