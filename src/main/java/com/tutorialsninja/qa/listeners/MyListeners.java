package com.tutorialsninja.qa.listeners;

import org.testng.ITestListener;

public class MyListeners  implements ITestListener{

	@Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		
}		
Let’s modify the ‘ListenerTest’ class. In particular, we will modify following methods-

onTestFailure, onTestSkipped, onTestStart, onTestSuccess, etc.
The modification is simple. We just print the name of the Test.

Logs are created in the console. It is easy for the user to understand which test is a pass, fail, and skip status.

After modification, the code looks like-

package Listener_Demo;		

import org.testng.ITestContext;		
import org.testng.ITestListener;		
import org.testng.ITestResult;		

public class ListenerTest implements ITestListener						
{		

    @Override		
    public void onFinish(ITestContext Result) 					
    {		
                		
    }		

    @Override		
    public void onStart(ITestContext Result)					
    {		
            		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
    {		
    		
    }		

    // When Test case get failed, this method is called.		
    @Override		
    public void onTestFailure(ITestResult Result) 					
    {		
    System.out.println("The name of the testcase failed is :"+Result.getName());					
    }		

    // When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
    }		

    // When Test case get Started, this method is called.		
    @Override		
    public void onTestStart(ITestResult Result)					
    {		
    System.out.println(Result.getName()+" test case started");					
    }		

    // When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("The name of the testcase passed is :"+Result.getName());					
    }		

}			
	
	
	
	
	
	
	
	
	
}
