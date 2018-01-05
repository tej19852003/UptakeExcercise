package com.uptake.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uptake.pages.MyEnums.TEXT;

public class Functions {
//	public static String csvFilename="";
	public static int timeout;
	public static boolean supplyText(WebDriver driver, By vxpath, String vtext){
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30, vtext)){
				return false;
			}
			String aAtrbt = null;
			for(int i=0;i<3; i++){
				driver.findElement(vxpath).clear();
				driver.findElement(vxpath).sendKeys(vtext);
				Thread.sleep(50);
				aAtrbt = driver.findElement(vxpath).getAttribute("value");
				if(aAtrbt.equals(vtext)){
					System.out.println("Verified TEXT Supplied as '" + vtext +"'");
					return true;
				}
			}
			if(aAtrbt.equals(vtext)){
				System.out.println("Verified TEXT Supplied as '" + vtext +"'");
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			System.out.println("Verified TEXT Supply Failed for '" + vtext + "'");
			return false;
		}
	}
	public static boolean supplyKeys(WebDriver driver, By vxpath, Keys enter){
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				throw new Exception("Element Not found for Xpath '"+ vxpath);
			}
			driver.findElement(vxpath).sendKeys(enter);
			return true;
		}catch(Exception e){
			System.out.println("Exception e="+e);
			return false;
		}
	}
	public static boolean waitForElementToBeClickable(WebDriver driver, By vxpath, int timeout) throws Exception {
		try{
//			if(!Functions.waitForPageLoad(driver, timeout)) {
//				System.out.println("WaitForPageLoad Method for JSLOAD & JQUERY Load Failed");
////				return false;
//			}
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(vxpath));
//			Thread.sleep(150);
			return true;
		}catch(Exception ex){
			System.out.println("No Element found while waiting " + timeout  + " sec");
			return false;
		}
	}
	public static boolean waitForElementToBeClickable(WebDriver driver, By vxpath, int timeout, String vtext) throws Exception {
		try{
//			if(!Functions.waitForPageLoad(driver, timeout)) {
//				System.out.println("WaitForPageLoad Method for JSLOAD & JQUERY Load Failed");
////				return false;
//			}
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(vxpath));
//			Thread.sleep(150);
			return true;
		}catch(Exception ex){
			System.out.println("Verified Element '"+vtext+"' Not found while waiting " + timeout  + " sec");
			return false;
		}
	}
	public static boolean waitForPageLoad (WebDriver driver, int overalltimeout) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("(.//body/div/div//a[contains(@id,'site_logo')])[1]")));
	    ExpectedCondition<Boolean> jsLoad  = new ExpectedCondition<Boolean>() {
	        @Override
			public Boolean apply(WebDriver driver) {
	            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	        }
	    };
	    ExpectedCondition<Boolean> jQueryLoad  = new ExpectedCondition<Boolean>() {
	        @Override
			public Boolean apply(WebDriver driver) {
	            return (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
	        }
	    };
	    return new WebDriverWait(driver, overalltimeout).until(jsLoad) && new WebDriverWait(driver, overalltimeout).until(jQueryLoad);
	}
	public static boolean verifyTextElement(WebDriver driver, By vxpath, String vtext){
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30, vtext)){
				return false;
			}
			String AText = driver.findElement(vxpath).getText().trim();
			if(AText.trim().equalsIgnoreCase(vtext.trim())){
				System.out.println("Verified AText:'"+ AText + "' & VText:'" + vtext + "' are equal");
				return true;
			} else {
				System.out.println("Verified AText:'"+ AText + "' & VText:'" + vtext + "' are NOT equal");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception= " + e);
			return false;
		}
	}
	public static boolean verifyTextElementAfterCleaningNonAlphaNumericChars(WebDriver driver, By vxpath, String vtext){
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30, "")){
				return false;
			}
			String AText = driver.findElement(vxpath).getText();
			AText = Functions.getNonAlphanumaticCharactersCleannedSentence(AText);
			if(AText.trim().equals(vtext.trim())){
				System.out.println("Verified AText:'"+ AText + "' & VText:'" + vtext + "' are equal");
				return true;
			} else {
				System.out.println("Verified AText:'"+ AText + "' & VText:'" + vtext + "' are NOT equal");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception e="+e);
			return false;
		}
	}

	public static boolean isElementDisplayed(WebDriver driver, By vxpath, String element){
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30, element)){
				return false;
			}
			if(driver.findElement(vxpath).isDisplayed()){
				System.out.println("Verified element '"+element+"' is Displayed");
				return true;
			}else {
				System.out.println("Verified element '"+element+"' is NOT Displayed");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception e="+e);
			return false;
		}
	}
	public static boolean isElementDisplayed(WebDriver driver, By vxpath, String element, int timeout){
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, timeout , element)){
				return false;
			}
			if(driver.findElement(vxpath).isDisplayed()){
				System.out.println("Verified element '"+element+"' is Displayed");
				return true;
			}else {
				System.out.println("Verified element '"+element+"' is NOT Displayed");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception e="+e);
			return false;
		}
	}

	public static boolean verifyTextAttribute(WebDriver driver, By vxpath, String value, String vattribute){
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30, vattribute)){
				return false;
			}
			String aAtrbt = driver.findElement(vxpath).getAttribute(value);
			if(aAtrbt.equalsIgnoreCase(vattribute)){
				System.out.println("AAttribute= '"+aAtrbt +"' matches with VAttribute="+vattribute);
				return true;
			} else {
				System.out.println("AAttribute= '"+aAtrbt +"' does not match with VAttribute="+vattribute);
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception e="+e);
			return false;
		}
	}
	public static String getTextAttribute(WebDriver driver, By vxpath) throws Exception{
		if(!Functions.waitForElementToBeClickable(driver, vxpath, 30, "Element")){
			throw new Exception("Element not found for xpath "+vxpath);
		}
		Functions.jsScrollDownToElement(driver, vxpath);
		return driver.findElement(vxpath).getAttribute("value").trim();
	}
	public static boolean jsClick(WebDriver driver, By vxpath, String name) throws Exception {
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30, name)){
				return false;
			}
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(vxpath));
			Thread.sleep(500);
			System.out.println("Verified '" + name + "' Clicked");
//			Thread.sleep(Integer.valueOf((String.valueOf(waitafterclick) + "000")));
//			try{
//				return Functions.waitForPageLoad(driver, 30);
//			}catch(Exception e){
//				System.out.println("Waiting for PageLoad from JSLOAD & JQUERY Load");
//				Thread.sleep(5000);
//				return Functions.waitForPageLoad(driver, 30);
//			}
			return true;
		}catch(Exception e){
			System.out.println("Verified '" + name + "' Click Didn't Work");
			return false;
		}
	}

	public static boolean clickAndWait(WebDriver driver, By vxpath, int x, String name){
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30, name)){
				return false;
			}
	//		Functions.jsScrollDownToElement(driver, vxpath);
			driver.findElement(vxpath).click();
			System.out.println("Verified '" + name + "' Clicked");
//			Thread.sleep(Integer.valueOf((String.valueOf(waitafterclick) + "000")));
			try{
				return Functions.waitForPageLoad(driver, 30);
			}catch(Exception e){
				System.out.println("Waiting for PageLoad from JSLOAD & JQUERY Load");
				Thread.sleep(2000);
				return Functions.waitForPageLoad(driver, 30);
			}
		}catch(Exception e){
			System.out.println("Exception e="+e);
			return false;
		}
	}
	public static boolean jsCheckCheckBox(WebDriver driver, By vxpath, int waitafterclick, String name) throws Exception {
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30, name)){
				return false;
			}
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(vxpath));
			System.out.println("Verified Checkbox'" + name + "' Clicked");
			return true;
		}catch(Exception e){
			System.out.println("Verified Checkbox'" + name + "' Click Didn't Work");
			return false;
		}
	}
	public static boolean jsScrollDownToElement(WebDriver driver, By vxpath) throws Exception {
		try{
			WebElement element = driver.findElement(vxpath);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(100);
			return Functions.waitForElementToBeClickable(driver, vxpath, 30, "Element");
		}catch(Exception e){
			System.out.println("Exception e="+e);
			return false;
		}
	}
	public static boolean jsScrollDown(WebDriver driver, By vxpath, int vtext) throws Exception {
		try{
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, "+vtext+")", "");
			Thread.sleep(100);
			return Functions.waitForElementToBeClickable(driver, vxpath, 30, "Element");
		}catch(Exception e){
			System.out.println("Exception e="+e);
			return false;
		}
	}
	public static boolean jsScrollDown(WebDriver driver, By vxpath,  TEXT Text) throws Exception {
		try{
			if (Text.equals(Text.SCROLLDOWN)) {
				((JavascriptExecutor) driver)
			     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
			} else if (Text.equals(Text.SCROLLUP)){
			((JavascriptExecutor) driver)
		     .executeScript("window.scrollTo(0, 0)");
			}
			return Functions.waitForElementToBeClickable(driver, vxpath, 30, "Element");
		}catch(Exception e){
			System.out.println("Exception e="+e);
			return false;
		}
	}

	public static boolean hoverElement(WebDriver driver, By vxpath1, By vxpath2, String vtext) throws Exception {
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath1, 30, vtext)){
				return false;
			}
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(vxpath1);
			timeout = 3;
			do {
				action.moveToElement(we).build().perform();
				Thread.sleep(1000);
				timeout--;
			} while (timeout > 0 && !Functions.waitForElementToBeClickable(driver, vxpath2 , 1));

			if (Functions.waitForElementToBeClickable(driver, vxpath2, 2)){
				System.out.println("Verified Hover on Element '" + vtext +"' Performed");
				return true ;
			} else {
				return false ;
			}
		}catch(Exception e){
			System.out.println("Hover Didn't work on Element '" + vtext);
			return false;
		}
	}
	public static boolean hoverElementToGetToolTip(WebDriver driver, By vxpath, String vtext) throws Exception {
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				return false;
			}
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(vxpath);
			timeout = 3;
			do {
				action.moveToElement(we).build().perform();
				timeout--;
			} while (timeout > 0 && !Functions.waitForElementToBeClickable(driver, By.xpath(".//body/div[@class='tooltip_popup']"), 1));

			if (Functions.waitForElementToBeClickable(driver, By.xpath(".//body/div[@class='tooltip_popup']"), 2)){
				System.out.println("Verified Hover on Element '" + vtext +"' Performed");
				return true ;
			} else {
				return false ;
			}
		}catch(Exception e){
			System.out.println("Hover Didn't work on Element '" + vtext);
			return false;
		}
	}
	public static boolean jsVerifyTextElement(WebDriver driver, By vxpath, String vtext) throws Exception {
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
					return false;
			}
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			WebElement element = driver.findElement(vxpath);
			String AText = jse.executeScript("return arguments[0].text", element).toString().trim();
			if(AText.equalsIgnoreCase(vtext)){
				System.out.println("Verified AText:'"+ AText + "' & VText:'" + vtext + "' are equal");
				return true;
			} else {
				System.out.println("Verified AText:'"+ AText + "' & VText:'" + vtext + "' are NOT equal");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception e="+e.getMessage());
			return false;
		}
	}
	public static String getElementText(WebDriver driver, By vxpath) throws Exception{
		if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
			throw new Exception("Element not found for xpath "+vxpath);
		}
		String aText =  driver.findElement(vxpath).getText().trim();
		System.out.println("AText="+aText);
		return aText;
	}
	public static boolean ischeckboxchecked(WebDriver driver, By vxpath, String checkboxname) throws Exception{
		if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
			return false;
		}
		if(driver.findElement(vxpath).isSelected()){
			System.out.println("Checkbox "+ checkboxname +" is Checked");
			return true;
		}else{
			System.out.println("Checkbox "+ checkboxname +" is NOT Checked");
			return false;
		}
	}


	public static boolean verifymultiTextElements(WebDriver driver, By vxpath, String vtext) throws Exception{
		boolean flag = false;
		if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				return false;
			}
		List<WebElement> elements = driver.findElements(vxpath);
		String AElements[] = vtext.trim().split(",");
		System.out.println("AElements.length="+AElements.length);
		System.out.println("elements.size()="+elements.size());
		if(elements.size()>0){
			if (AElements.length != elements.size()) {
			    System.out.println("fail, wrong number of elements found");
			    return false;
			}
			for (int i = 0; i < AElements.length; i++) {
			    String element = elements.get(i).getText().trim();
			    if (element.equals(AElements[i].trim())) {
			        System.out.println("passed on: " + element);
			        flag=true;
			    } else {
			        System.out.println("failed on: " + element);
			        return false;
			    }
			}
		}else {
			System.out.println("No Element present");
		}
		return flag;
	}
	public static boolean ischeckboxNotchecked(WebDriver driver, By vxpath) throws Exception{
		if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				return false;
			}
		return !driver.findElement(vxpath).isSelected();
	}
	public static boolean setZoomToDefault(WebDriver driver, By vxpath) throws Exception{
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				return false;
			}
			driver.findElement(vxpath).sendKeys(Keys.chord(Keys.CONTROL, "0"));
			return true;
		}catch(Exception e){
			System.out.println("Exception=" + e);
			return false;
		}
	}
	public static boolean verifySelectedDropdown(WebDriver driver, By vxpath, String vtext) {
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				return false;
			}
			Select select = new Select(driver.findElement(vxpath));
			WebElement option = select.getFirstSelectedOption();
			String AText=option.getText().trim();
			if(AText.trim().equals(vtext.trim())){
				System.out.println("Verified AText:'"+ AText + "' & VText:'" + vtext + "' are equal");
				return true;
			}else{
				System.out.println("Verified AText:'"+ AText + "' & VText:'" + vtext + "' are NOT equal");
				return false;
			}
		}catch(Exception e){
			System.out.println("Exception=" + e);
			return false;
		}
	}
	public static boolean verifyAllValuesOfDropdownInOrder(WebDriver driver, By vxpath, String [] vtext) {
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				return false;
			}
			int count = 0;
			WebElement dropdown = driver.findElement(vxpath);
			Select select = new Select(dropdown);
			boolean match = false;
			List<WebElement> options = select.getOptions();
			for(WebElement we:options) {
				for (int i=count; i < vtext.length;){
					if (we.getText().trim().equals(vtext[i].trim())){
						System.out.println("Verified "+we.getText()+ " is matching with "+vtext[i]);
						count++;
						match = true;
						break;
					} else {
						System.out.println("Verified "+we.getText()+ " is not matching with "+vtext[i]);
						return false;
					}
				}
			}
			if (count == vtext.length) {
		        System.out.println("Total Count "+ count +" matched");
		    } else {
		        System.out.println("Total Count Not matched");
		        return false;
		    }
			return match;
		}catch(Exception e){
			System.out.println("Exception=" + e);
			return false;
		}
	}
	public static boolean verifyFewValuesOfDropdown(WebDriver driver, By vxpath, String [] vtext) {
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				return false;
			}
//			WebElement dropdown = driver.findElement(vxpath);
//			Select select = new Select(dropdown);
			boolean match = false;
//			List<WebElement> options = select.getOptions();
			List<WebElement> options = driver.findElements(vxpath);
			for (int i=0; i < vtext.length; i++){
				for(WebElement we:options) {
					if (we.getText().trim().equals(vtext[i].trim())){
						System.out.println("Verified "+we.getText()+ " is matching with "+vtext[i]);
						match = true;
						break;
					} else {
						match = false;
					}
				}
				if (match == false){
					System.out.println("Verification failed for "+vtext[i]);
					return false;
				}
			}
			return match;

		}catch(Exception e){
			System.out.println("Exception=" + e);
			return false;
		}
	}

	public static boolean selectVisibleTextinDropdown(WebDriver driver, By vxpath, String vtext) throws Exception {
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				return false;
			}
			Select dropdown = new Select(driver.findElement(vxpath));
			dropdown.selectByVisibleText(vtext);
			Thread.sleep(500);
			int i=0;
			while (!Functions.verifySelectedDropdown(driver, vxpath, vtext) && i<5){
				Thread.sleep(500);
				i++;
			}
			if(!Functions.verifySelectedDropdown(driver, vxpath, vtext)){
				return false;
			} else {
				return true;
			}
		}catch(Exception e){
			System.out.println("Exception=" + e);
			return false;
		}
	}
	public static boolean selectIndexinDropdown(WebDriver driver, By vxpath, int index) throws Exception {
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				return false;
			}
			Select dropdown = new Select(driver.findElement(vxpath));
			dropdown.selectByIndex(index);
			Thread.sleep(500);
			return true;
		}catch(Exception e){
			System.out.println("Exception=" + e);
			return false;
		}
	}
	public static boolean selectDropdownByvalue(WebDriver driver, By vxpath, String value) throws Exception {
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				return false;
			}
			Select dropdown = new Select(driver.findElement(vxpath));
			dropdown.selectByValue(value);
			Thread.sleep(500);
			return true;
		}catch(Exception e){
			System.out.println("Exception=" + e);
			return false;
		}
	}

	public static ArrayList<String> getListofTextElements(WebDriver driver, By vxpath){
		ArrayList<String> myarraylist = new ArrayList<String>();
		try{
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				throw new Exception("Element not found for xpath "+vxpath);
			}
			for(WebElement element: driver.findElements(vxpath)){
				myarraylist.add(element.getText().toString());
			}
		}catch(Exception e){
			System.out.println("Exception=" + e);
		}
		return myarraylist;
	}
	public static boolean verifymultiTextElements3(WebDriver driver, By vxpath, String vtext) throws Exception{
		boolean flag = false;
		if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
			return false;
		}
		List<WebElement> elements = driver.findElements(vxpath);
		String AElements[] = vtext.trim().split("/");
		System.out.println("AElements.length="+AElements.length);
		System.out.println("elements.size()="+elements.size());
		if(elements.size()>0){
			if (AElements.length != elements.size()) {
			    System.out.println("fail, wrong number of elements found");
			    return flag=false;
			}
			for (int i = 0; i < AElements.length; i++) {
			    String element = elements.get(i).getText().trim();
			    if (element.equals(AElements[i].trim())) {
			        System.out.println("passed on: " + element);
			        flag=true;
			    } else {
			        System.out.println("failed on: " + element);
			        return flag=false;
			    }
			}
		}else {
			System.out.println("No Element present");
			return flag=false;

		}
		return flag;
	}

	public static boolean verifyFirstOutputText(WebDriver driver, By vxpath, String vtext){
		try {
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				return false;
			}
			WebElement element = null;
			String AText = null;
			timeout = 10;
			while(true && timeout > 0){
				try{
					element = driver.findElement(vxpath);
					AText = element.getText();
					break;
				}catch(StaleElementReferenceException e){
					System.out.println("Element is not visible in DOM");
					Thread.sleep(500);
					timeout -- ;
				}
			}
			for(WebElement child : element.findElements(By.xpath(".//*"))){
				AText = AText.replaceFirst(child.getText(), "").trim();
			}
			if(AText.trim().equals(vtext.trim())){
				System.out.println("Verified AText:'"+ AText + "' & VText:'" + vtext + "' are equal");
				return true;
			} else {
				System.out.println("Verified AText:'"+ AText + "' & VText:'" + vtext + "' are NOT equal");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Exception =" + e);
			return false;
		}
	}
	public static String getFirstOutputText(WebDriver driver, By vxpath){
		String text = "";
		try {
			if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
				throw new Exception("Element not found for xpath "+vxpath);
			}
			WebElement element = driver.findElement(vxpath);
			text = element.getText();
			for(WebElement child : element.findElements(By.xpath(".//*"))){
			    text = text.replaceFirst(child.getText(), "").trim();
			}
			System.out.println("AText="+text.trim());
		} catch (Exception e) {
			System.out.println("Exception =" + e);
		}
		return text;
	}
	public static String getDropdownSelectedValue(WebDriver driver, By vxpath) throws Exception {
		if(!Functions.waitForElementToBeClickable(driver, vxpath, 30)){
			throw new Exception("Element not found for xpath "+vxpath);
		}
		WebElement option = new Select(driver.findElement(vxpath)).getFirstSelectedOption();
		System.out.println(option.getText().trim());
		return option.getText().trim();
	}

	public static boolean supplyText_SelectOutput(WebDriver driver, By vxpath, String vtext1, String vtext2) throws Exception{
		try{
			Functions.supplyText(driver, vxpath, vtext1);
			int i=0;
			while(!Functions.waitForElementToBeClickable(driver, By.xpath("//body/ul/li"), 5) && i<4){
				Functions.supplyText(driver, vxpath, vtext1);
				i++;
			}
			int size = driver.findElements(By.xpath("//body/ul/li")).size();
			for(i=1; i<size+1;i++){
				if(driver.findElement(By.xpath("//body/ul/li["+i+"]")).getText().contains(vtext1) && driver.findElement(By.xpath("//body/ul/li["+i+"]")).getText().contains(vtext2)){
					driver.findElement(vxpath).sendKeys(Keys.ENTER);
					Thread.sleep(250);
					break;
				}else{
					driver.findElement(vxpath).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(50);
				}
			}
			return true;
		}catch(Exception e){
			System.out.println("Exception=" +e);
			return false;
		}
	}
	public static String getNonAlphanumaticCharactersCleannedSentence (String vtext1) {
		return vtext1.replaceAll("[^A-Za-z0-9 ]", "");

	}


}
