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

public class login_page_Test extends BaseClass
{
	IndexPage In ;
	int Testid; 
	LoginPage LP;
	Logout LG;
	FirstPageProduct Pone;


	@BeforeMethod
	public void login() throws InterruptedException, IOException
	{
		
		System.out.println("************************Login Page Test Start*********************************");
	//	initialize("chrome"); // Pass the URL parameter to the initialize method
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


	@Test(priority=1)
	public void Login_Page_Logo() throws InterruptedException
	{

		boolean result=LP.LoginPage_Logo();
		Assert.assertTrue(result);

		Reporter.log("Test case pass :  Validate Logo",true);

		
	}	


		@Test(priority=2)
		public void Verify_Title() throws InterruptedException
		{
			String Actual_title=driver.getTitle();		
		     String Expect= "Pumobeauty";
		     Assert.assertEquals( Actual_title ,Expect );
			Reporter.log("Test case pass :  Title is Correct and Successful login",true);
	
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
		System.out.println("***********************Login Page Test Finish******************************************");

	}

 
}

