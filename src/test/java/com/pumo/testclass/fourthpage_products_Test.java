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
import com.pumo.pomclass.fourthpage_pom;
import com.pumo.utilityclass.BaseClass;
import com.pumo.utilityclass.utilityclass;

public class fourthpage_products_Test extends BaseClass
{

	IndexPage In ;
	int Testid; 
	LoginPage LP;
	Logout LG;	
	ProductPage PP;
	Cart_Page CRT;
	fourthpage_pom Pagefour;
	Select_Page SelPage;
	utilityclass utility;


	@BeforeMethod
	public void Login() throws InterruptedException, IOException
	{

		System.out.println("************************Fourth_Page Product Testing Start*********************************");
		//	initialize("chrome"); // Pass the URL parameter to the initialize method
		Reporter.log("Browser open",true);
		Reporter.log("Enter URL",true);

		In = new IndexPage(driver);
		LP = new LoginPage(driver);
		LG = new Logout(driver);
		Pagefour = new fourthpage_pom(driver);
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
	public void SWISS_BEAUTY_Matte_Lip_Pallete() throws InterruptedException
	{
		System.out.println("************************Testing SWISS_BEAUTY_Matte_Lip_Pallete Product*********************************");

		SelPage.Fourth_Page();
		utility.Actionclass(Pagefour.SWISS_BEAUTY_Matte_Lip_Pallete());
		//	PSecond.Matt_Lipstick();

		String stock=PP.verifyproductInStock();
		Assert.assertEquals( "In Stock" ,stock );
		System.out.println("Europ_Girl Product in stock");

	//	PP.SelectGram("50");
		PP.Clickon_AddTo_CartBtn();
		PP.Clickon_GoTo_CartBtn();

		String Product_price=CRT.Product_price1();
		String Prod_quantity=CRT.Product_quantity1();
		String total =CRT.total();

		String price = Product_price.replaceAll("[^\\d]", "");
		int Price1 = Integer.parseInt(price);
		System.out.println("Product Europ_Girl Price : " + Price1);
		//		 Assert.assertEquals( "550" , Price1);

		String quantity = Prod_quantity.replaceAll("[^\\d]", "");
		int quantity1 = Integer.parseInt(quantity);
		System.out.println("Product Europ_Girl Quantity : " + quantity1);

		//		 String total1 = total.replaceAll("[^\\d]", "");
		//		 int Total = Integer.parseInt(total1);
		//		 System.out.println("Total : " + Total);

		System.out.println("Total Europ_Girl selected quantity : "+ quantity1);
		System.out.println("Total Product price : "+ Price1*quantity1);

	}	


	@Test(priority=2)
	public void HANDAIYAN_4_Colors_Matte() throws InterruptedException
	{
		System.out.println("************************Testing HANDAIYAN_4_Colors_Matte Product*********************************");

		SelPage.Fourth_Page();;
		utility.Actionclass(Pagefour.HANDAIYAN_4_Colors_Matte());


		String stock=PP.verifyproductInStock();
		Assert.assertEquals( "In Stock" ,stock );
		System.out.println("Product HANDAIYAN_4_Colors_Matte in stock");

//		PP.SelectGram("28");
		PP.Clickon_AddTo_CartBtn();
		PP.Clickon_GoTo_CartBtn();

		String Product_price=CRT.Product_price2();
		String Prod_quantity=CRT.Product_quantity2();
		String total =CRT.total();

		String price = Product_price.replaceAll("[^\\d]", "");
		int Price1 = Integer.parseInt(price);
		System.out.println("Product UCANBE Price : " + Price1);
		//		 Assert.assertEquals( "550" , Price1);

		String quantity = Prod_quantity.replaceAll("[^\\d]", "");
		int quantity1 = Integer.parseInt(quantity);
		//	 System.out.println("Product Demo Quantity : " + quantity1);

		System.out.println("Total UCANBE selected quantity :"+ quantity1);
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
		System.out.println("***********************Fourth_Page Testing Finish******************************************");

	}









}
