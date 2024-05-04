package com.pumo.utilityclass;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener
{
	
	ExtentHtmlReporter  htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport()
	{
		String timestamp = new SimpleDateFormat("dd.mm.yyyy.hh.mm.ss").format(new Date());
	//	String reportName = "Pumo" + timestamp + ".html";
	//	htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + reportName);
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtendReport/PumoBeauty-Test.html");

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		//add system information/environment info to reports
		reports.setSystemInfo("Machine:", "test-pumo");
		reports.setSystemInfo("OS", "windows 10");
		reports.setSystemInfo("browser:", "chrome");
		reports.setSystemInfo("user name:", "Saurabh");

		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("Pumo Test Report");
		htmlReporter.config().setTheme(Theme.DARK);


	}

	//OnStart method is called when any Test starts
    @Override
	public void onStart(ITestContext Result)					
	{		
		configureReport();
		System.out.println("Test case start....");  		
	}	

	//onFinish method is called after all Tests are executed
    @Override
	public void onFinish(ITestContext Result) 					
	{		
		System.out.println("Test case close....");  	
		reports.flush();//it is mandatory to call flush method to ensure information is written to the started reporter.

	}		



	// When Test case get failed, this method is called.		

/*	public void onTestFailure(ITestResult Result) 					
	{		
		System.out.println("Name of test method failed:" + Result.getName() );  		
		test = reports.createTest(Result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));

		String screenShotPath = System.getProperty( "D:\\TEstingSetUP\\EclipseWorkPlace\\final_pumo\\ScreenShots\\." + Result.getName() + ".png");

		
//	String screenShotPath = System.getProperty("user.dir") + "\\ScreenShot\\" + Result.getName() + ".png";

	File screenShotFile = new File(screenShotPath);

	if(screenShotFile.exists())
	{
		try {
			test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//	test.addScreenCaptureFromPath(null)

	}		
*/
    
    
	// When Test case get Skipped, this method is called.		
    @Override
	public void onTestSkipped(ITestResult Result)					
	{		
		System.out.println("Name of test method skipped:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() ,ExtentColor.YELLOW));
	}			

	// When Test case get Started, this method is called.		
    @Override
	public void onTestStart(ITestResult Result)					
	{		
		System.out.println("Name of test method started:" + Result.getName() );  		

	}		

	// When Test case get passed, this method is called.		
    @Override
	public void onTestSuccess(ITestResult Result)					
	{		
		System.out.println("Name of test method sucessfully executed:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{		

	}		

	
	
	

}
