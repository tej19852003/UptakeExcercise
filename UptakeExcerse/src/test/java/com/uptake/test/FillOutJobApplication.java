package com.uptake.test;

import org.testng.annotations.Test;

import com.uptake.pages.HomePage;
import com.uptake.pages.MyEnums.TEXT;
import com.uptake.pages.Util;

import junit.framework.Assert;

public class FillOutJobApplication extends Util {
//	@BeforeSuite
//	public static void beforeSuiteTest () throws java.lang.Exception {
//		driver = Util.browser_setup(inputBrowserDetails.getBrowserName());
//		Assert.assertTrue(HomePage.openURL(driver));
//	}
	@Test(priority = 1)
	public static void LocateAllJobOpeningAndClickLink () {
		Assert.assertTrue(HomePage.verifyLabelTextPresent(driver, TEXT.TEXT8, "ALL JOB OPENINGS"));
		Assert.assertTrue(HomePage.clickOnLabelText(driver, TEXT.TEXT8, "ALL JOB OPENINGS"));
	}
	@Test(priority = 2)
	public static void SwitchToOpenWindow () {
		Assert.assertTrue(HomePage.verifyLabelTextPresent(driver, TEXT.TEXT8, "ALL JOB OPENINGS"));
		Assert.assertTrue(HomePage.clickOnLabelText(driver, TEXT.TEXT8, "ALL JOB OPENINGS"));
	}

//	@AfterSuite
//	public static void CloseApplication () {
//		driver.quit();
//	}
}
