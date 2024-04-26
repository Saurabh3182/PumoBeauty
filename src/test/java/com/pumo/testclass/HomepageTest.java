package com.pumo.testclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pumo.pomclass.FirstPageProduct;
import com.pumo.pomclass.IndexPage;
import com.pumo.pomclass.LoginPage;
import com.pumo.pomclass.Logout;
import com.pumo.utilityclass.BaseClass;
import com.pumo.utilityclass.utilityclass;



public class HomepageTest extends BaseClass
{
	IndexPage In ;
    int Testid; 
	LoginPage LP;
	Logout LG;
	FirstPageProduct Pone;

    

	@BeforeMethod
	public void login() throws InterruptedException, IOException
	{
		System.out.println("************************Home-Page Test Start*********************************");
//		initialize("edge"); // Pass the URL parameter to the initialize method
        Reporter.log("Browser open",true);
        Reporter.log("Enter URL",true);

		In = new IndexPage(driver);
		LP = new LoginPage(driver);
		Pone = new FirstPageProduct(driver);	
		
      In.Close_PopUp();
      In.Click_On_LoginBtn();
      LP.Validate_Mobile_no("9890502710");
      LP.Validate__Password_btn("Saurabh@3182");
      LP.Click_On_SubmitBtn();
      
      Reporter.log("Login Successfull",true);
	}
	
	
	
	@Test(priority=5)
	public void VerifyEmailid() throws InterruptedException
	{
		    String Actual =In.Verify_EmailId();
	        System.out.println(Actual);
			String Expected= "pumobeauty@gmail.com";
	        System.out.println(Expected);
			Assert.assertEquals(Actual, Expected);
			Reporter.log("Test case pass : website EmailId present on webpage",true);

	}	
	
	@Test(priority=4)
	public void verifyMobileno() throws InterruptedException
	{
		    String Actual =In.Verify_MobileNo();
	        System.out.println(Actual);
			String Expected= "9833115938";
	        System.out.println(Expected);
			Assert.assertEquals(Actual, Expected);
			Reporter.log("Test case pass : website mobile number present on webpage",true);

	}
	
	@Test(priority=2)
	public void Verify_Wishlist() throws InterruptedException
	{
		boolean result=In.Validate_Wishlist_btn();
		Assert.assertTrue(result);
		Reporter.log("Test case pass : Wishlist Btn Visible",true);
	}
	
	@Test(priority=1)
	public void Verify_Search_btn() throws InterruptedException
	{
		boolean result=In.Validate_Search_btn();
		Assert.assertTrue(result);
		Reporter.log("Test case pass : Search btn Is Present",true);
	}
		
	
	
	@Test(priority=3)
	public void Verifylogo() throws InterruptedException
	{
		boolean result=In.Validate_Logo();
		Assert.assertTrue(result);
		Reporter.log("Test case pass : Logo Is Present",true);
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
		System.out.println("***********************Home-Page Test Finish******************************************");

	}
	
}
