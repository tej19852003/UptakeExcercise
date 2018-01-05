package com.uptake.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.uptake.pages.HomePage;
import com.uptake.pages.ListenerClass;
import com.uptake.pages.MyEnums.TEXT;
import com.uptake.pages.Util;

import junit.framework.Assert;

//@Listeners(com.celltrak.jenkinsrun.ListenerClass.class)

public class HomePageTest extends ListenerClass {

	@BeforeSuite
	public static void beforeSuiteTest () throws java.lang.Exception {
		driver = Util.browser_setup(inputBrowserDetails.getBrowserName());
		Assert.assertTrue(HomePage.openURL(driver));
	}


	@Test (priority=1)
	public static void OpenUptakeURL () throws java.lang.Exception{

		Assert.assertTrue(HomePage.verifyPageByScrollingDownAndUp(driver));
		Assert.assertTrue(HomePage.verifyLabelTextPresent(driver, TEXT.TEXT1, "PRODUCTS"));
		Assert.assertTrue(HomePage.verifyLabelTextPresent(driver, TEXT.TEXT2, "INDUSTRIES"));
		Assert.assertTrue(HomePage.verifyLabelTextPresent(driver, TEXT.TEXT3, "ABOUT"));
		Assert.assertTrue(HomePage.verifyLabelTextPresent(driver, TEXT.TEXT4, "EXPERTISE"));
		Assert.assertTrue(HomePage.verifyLabelTextPresent(driver, TEXT.TEXT5, "NEWS & INSIGHTS"));
		Assert.assertTrue(HomePage.verifyLabelTextPresent(driver, TEXT.TEXT6, "CAREERS"));
		Assert.assertTrue(HomePage.verifyLabelTextPresent(driver, TEXT.TEXT7, "CONTACT"));
	}
	@Test (priority = 2)
	public static void VerifyHomePageElementsAndTextPresent () {
		Assert.assertTrue(HomePage.verifyHeadingTextPresent(driver, TEXT.TEXT1, "MACHINES DONT HAVETO BREAK"));
		Assert.assertTrue(HomePage.verifyHeadingTextPresent(driver, TEXT.TEXT2, "BUILT TO SCALE COST-SAVING INSIGHTS."));
		Assert.assertTrue(HomePage.verifyHeadingTextPresent(driver, TEXT.TEXT3, "Now Hiring"));
	}

	@Test (priority = 3)
	public static void ContactUptakeForJob () throws java.lang.Exception {
		Assert.assertTrue(HomePage.clickOnLabelText(driver, TEXT.TEXT7, "CONTACT"));
		Assert.assertTrue(HomePage.verifyChatPopUpLabelTextPresent(driver, TEXT.TEXT1, "READY TO CHAT?"));
		Assert.assertTrue(HomePage.verifyChatPopUpLabelTextPresent(driver, TEXT.TEXT2, "FIRST NAME*"));
		Assert.assertTrue(HomePage.verifyChatPopUpLabelTextPresent(driver, TEXT.TEXT3, "LAST NAME*"));
		Assert.assertTrue(HomePage.verifyChatPopUpLabelTextPresent(driver, TEXT.TEXT4, "EMAIL ADDRESS*"));
		Assert.assertTrue(HomePage.verifyChatPopUpLabelTextPresent(driver, TEXT.TEXT5, "PHONE NUMBER (OPTIONAL)"));
		Assert.assertTrue(HomePage.verifyChatPopUpLabelTextPresent(driver, TEXT.TEXT6, "Please include your message here (optional)"));

		Assert.assertTrue(HomePage.supplyTextINTOChatPopUpTextBoxes(driver, TEXT.TEXT2, "Tejas"));
		Assert.assertTrue(HomePage.supplyTextINTOChatPopUpTextBoxes(driver, TEXT.TEXT3, "Patel"));
		Assert.assertTrue(HomePage.supplyTextINTOChatPopUpTextBoxes(driver, TEXT.TEXT4, "tejaspatel.job@gmail.com"));
		Assert.assertTrue(HomePage.supplyTextINTOChatPopUpTextBoxes(driver, TEXT.TEXT5, "5127109812"));
		Assert.assertTrue(HomePage.supplyTextINTOChatPopUpTextBoxes(driver, TEXT.TEXT6, "I want to talk to another department"));
		Assert.assertTrue(HomePage.supplyTextINTOChatPopUpTextBoxes(driver, TEXT.TEXT7, "Job Search"));

		Assert.assertTrue(HomePage.clickLetsTalkButton(driver, "Let's talk Button"));

	}

	@AfterSuite
	public static void CloseApplication () {
		driver.quit();
	}












}
