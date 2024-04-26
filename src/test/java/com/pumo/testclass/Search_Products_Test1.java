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
import com.pumo.pomclass.SearchProd_Pom;
import com.pumo.pomclass.Select_Page;
import com.pumo.pomclass.fifthpage_pom;
import com.pumo.utilityclass.BaseClass;
import com.pumo.utilityclass.utilityclass;

public class Search_Products_Test1 extends BaseClass
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
	SearchProd_Pom Search;


	@BeforeMethod
	public void Login() throws InterruptedException, IOException
	{

	//	System.out.println("************************Fifth_Page Product Testing Start*********************************");
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
		Search = new SearchProd_Pom(driver);

		In.Close_PopUp();
		In.Click_On_LoginBtn();
		LP.Validate_Mobile_no("9890502710");
		LP.Validate__Password_btn("Saurabh@3182");
		LP.Click_On_SubmitBtn();    	
		Reporter.log("Login Successfull",true);

	}


	@Test(priority=1)
	public void INSHINE_Lipstick() throws InterruptedException
	{
		System.out.println("************************Testing INSHINE_Lipstick Product *********************************");
       
	    Search.INSHINE_Lipstick();
	    Search.click_On_Search_Elements(Search.Prod_dyanamic_WebElements(),"INSHINE Absolute Matte No Transfer Lipstick");
	    	    			    
		String stock=PP.verifyproductInStock();
		Assert.assertEquals( "In Stock" ,stock );
		System.out.println("INSHINE_Lipstick Product -->"+ stock);


	//	PP.SelectGram("20");
		PP.Clickon_AddTo_CartBtn();
		PP.Clickon_GoTo_CartBtn();

		String Product_price=CRT.Product_price1();
		String Prod_quantity=CRT.Product_quantity1();
		String total =CRT.total();

		String price = Product_price.replaceAll("[^\\d]", "");
		int Price1 = Integer.parseInt(price);
		System.out.println("Product INSHINE_Lipstick Price : " + Price1);
		//		 Assert.assertEquals( "550" , Price1);

		String quantity = Prod_quantity.replaceAll("[^\\d]", "");
		int quantity1 = Integer.parseInt(quantity);
		System.out.println("Product INSHINE_Lipstick Quantity : " + quantity1);

		//		 String total1 = total.replaceAll("[^\\d]", "");
		//		 int Total = Integer.parseInt(total1);
		//		 System.out.println("Total : " + Total);

		System.out.println("Total INSHINE_Lipstick selected quantity : "+ quantity1);
		System.out.println("Total Product price : "+ Price1*quantity1);
	     CRT.Remove_btn1();


		System.out.println("************************ INSHINE_Lipstick Testing Finish *********************************");
	
	}	


	@Test(priority=2)
	public void lakyou_beauty_25() throws InterruptedException
	{
		System.out.println("************************Testing lakyou_beauty_25 Product *********************************");
      
   	    Search.lakyou_beauty_25();
	    Search.click_On_Search_Elements(Search.Prod_dyanamic_WebElements(),"lakyou beauty 25 Color Multi Lip Palette - 24g");
      
		String stock=PP.verifyproductInStock();
		Assert.assertEquals( "In Stock" ,stock );
		System.out.println("lakyou beauty 25 Color Multi Lip Palette - 24g -->"+ stock);

	//	PP.SelectGram("24");
		PP.Clickon_AddTo_CartBtn();
		PP.Clickon_GoTo_CartBtn();

		String Product_price=CRT.Product_price1();
		String Prod_quantity=CRT.Product_quantity1();
		String total =CRT.total();

		String price = Product_price.replaceAll("[^\\d]", "");
		int Price1 = Integer.parseInt(price);
		System.out.println("Product lakyou_beauty_25 Price : " + Price1);
		//		 Assert.assertEquals( "550" , Price1);

		String quantity = Prod_quantity.replaceAll("[^\\d]", "");
		int quantity1 = Integer.parseInt(quantity);
		System.out.println("Product lakyou_beauty_25 Quantity : " + quantity1);

		//		 String total1 = total.replaceAll("[^\\d]", "");
		//		 int Total = Integer.parseInt(total1);
		//		 System.out.println("Total : " + Total);

		System.out.println("Total lakyou_beauty_25 selected quantity : "+ quantity1);
		System.out.println("Total Product price : "+ Price1*quantity1);
	     CRT.Remove_btn1();


		System.out.println("************************ lakyou_beauty_25 Testing Finish *********************************");
	
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
//		System.out.println("***********************INSHINE_Lipstick Testing Finish******************************************");

	}
	
	

}
