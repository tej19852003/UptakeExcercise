/**
 *
 */
package com.uptake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.uptake.pages.MyEnums.TEXT;

/**
 * @author TPatel
 *
 */
public class HomePage {
	public static boolean verifyPageByScrollingDownAndUp(WebDriver driver) throws Exception {
		if(!Functions.jsScrollDown(driver, By.xpath("html/body"), TEXT.SCROLLUP)) {
			return false;
		}
		Thread.sleep(1000);
		if(!Functions.jsScrollDown(driver, By.xpath("html/body"), TEXT.SCROLLDOWN)) {
			return false;
		}
		Thread.sleep(1000);
		if(!Functions.jsScrollDown(driver, By.xpath("html/body"), TEXT.SCROLLUP)) {
			return false;
		}
		Thread.sleep(1000);
		return true;
	}


	public static boolean verifyLabelTextPresent (WebDriver driver, TEXT Text, String vtext) {
		try {
			if (Text.equals(Text.TEXT1)) {    //Verifying label text PRODUCTS
				By vxpath = By.xpath("//section//nav/ul/li[1]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT2)) {   //Verifying label text INDUSTRIEs
				By vxpath = By.xpath("//section//nav/ul/li[2]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT3)) {   //Verifying label text ABOUT
				By vxpath = By.xpath("//section//nav/ul/li[3]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT4)) {   //Verifying label text EXPERTISE
				By vxpath = By.xpath("//section//nav/ul/li[4]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT5)) {   //Verifying label text NEWS & INSIGHT
				By vxpath = By.xpath("//section//nav/ul/li[5]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT6)) {   //Verifying label text CAREERS
				By vxpath = By.xpath("//section//nav/ul/li[6]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT7)) {   //Verifying label text CONTACT
				By vxpath = By.xpath("//section//nav/ul/li[7]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT8)) {   //Verifying label text CONTACT
				By vxpath = By.xpath("//div[@class='l-site-footer__aside-cta']/a[@class='btn btn--large']");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			}
			return true;
		}catch (Exception e){
			System.out.println("Exception : " + e);
			return false;
		}
	}

	public static boolean verifyHeadingTextPresent (WebDriver driver, TEXT Text, String vtext) {
		try {
			if (Text.equals(Text.TEXT1)) {    //Verifying HEADING "MACHINES DONT HAVE TO BREAK"
				By vxpath = By.xpath("//div[@class='l-hero-header__content']//p[@class='hero-heading__heading']");
				return Functions.verifyTextElementAfterCleaningNonAlphaNumericChars(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT2)) {
				By vxpath = By.xpath("//div[@class='l-split__content']/div[@class='heading js-hero-heading heading--large is-in-viewport']/h2");
				Functions.jsScrollDownToElement(driver, vxpath);
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT3)) {
				By vxpath = By.xpath("//div[@class='l-site-footer__aside-content']/div[@class='label label--bold label--underlined']");
				Functions.jsScrollDownToElement(driver, vxpath);
				return Functions.verifyTextElement(driver, vxpath, vtext);
			}
			return true;
		}catch (Exception e){
			System.out.println("Exception : " + e);
			return false;
		}

	}
	public static boolean clickOnLabelText (WebDriver driver, TEXT Text, String vtext) {
		try {
			if (Text.equals(Text.TEXT1)) {    //Verifying label text PRODUCTS
				By vxpath = By.xpath("//section//nav/ul/li[1]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.jsClick(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT2)) {   //Verifying label text INDUSTRIEs
				By vxpath = By.xpath("//section//nav/ul/li[2]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.jsClick(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT3)) {   //Verifying label text ABOUT
				By vxpath = By.xpath("//section//nav/ul/li[3]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.jsClick(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT4)) {   //Verifying label text EXPERTISE
				By vxpath = By.xpath("//section//nav/ul/li[4]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.jsClick(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT5)) {   //Verifying label text NEWS & INSIGHT
				By vxpath = By.xpath("//section//nav/ul/li[5]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.jsClick(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT6)) {   //Verifying label text CAREERS
				By vxpath = By.xpath("//section//nav/ul/li[6]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.jsClick(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT7)) {   //Verifying label text CONTACT
				By vxpath = By.xpath("//section//nav/ul/li[7]/a[@class='site-nav__desktop-link js-ajax-listener']/span");
				return Functions.jsClick(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT8)) {   //Verifying label text CONTACT
				By vxpath = By.xpath("//div[@class='l-site-footer__aside-cta']/a[@class='btn btn--large']");
				return Functions.jsClick(driver, vxpath, vtext);
			}
			return true;
		}catch (Exception e){
			System.out.println("Exception : " + e);
			return false;
		}
	}
	public static boolean verifyChatPopUpLabelTextPresent (WebDriver driver, TEXT Text, String vtext) {
		try {
			if (Text.equals(Text.TEXT1)) {    //Verifying label text READY TO CHAT ?
				By vxpath = By.xpath("//div[@class='l-form-modal__header']/div[@class='h-type-h3']");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT2)) {   //Verifying label text First Name
				By vxpath = By.xpath("//label[contains(@id, 'label-firstname')]");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT3)) {   //Verifying label text First Name
				By vxpath = By.xpath("//label[contains(@id, 'label-lastname')]");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT4)) {   //Verifying label text First Name
				By vxpath = By.xpath("//label[contains(@id, 'label-email')]");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT5)) {   //Verifying label text First Name
				By vxpath = By.xpath("//label[contains(@id, 'label-phone')]");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT6)) {   //Verifying label text First Name
				By vxpath = By.xpath("(//label[contains(@id, 'label-lead')])[1]");
				return Functions.verifyTextElement(driver, vxpath, vtext);
			}
			return true;
		}catch (Exception e){
			System.out.println("Exception : " + e);
			return false;
		}
	}
	public static boolean supplyTextINTOChatPopUpTextBoxes (WebDriver driver, TEXT Text, String vtext) {
		try {
			if (Text.equals(Text.TEXT2)) {   //Verifying label text First Name
				By vxpath = By.xpath("//label[contains(@id, 'label-firstname')]/..//input[1]");
				return Functions.supplyText(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT3)) {   //Verifying label text First Name
				By vxpath = By.xpath("//label[contains(@id, 'label-lastname')]/..//input[1]");
				return Functions.supplyText(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT4)) {   //Verifying label text First Name
				By vxpath = By.xpath("//label[contains(@id, 'label-email')]/..//input[1]");
				return Functions.supplyText(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT5)) {   //Verifying label text First Name
				By vxpath = By.xpath("//label[contains(@id, 'label-phone')]/..//input[1]");
				return Functions.supplyText(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT6)) {   //Verifying label text First Name
				By vxpath = By.xpath(".//select[contains(@id, 'how_can_we_help_you')]");
				return Functions.selectDropdownByvalue(driver, vxpath, vtext);
			} else if (Text.equals(Text.TEXT7)) {   //Verifying label text First Name
				By vxpath = By.xpath("(//label[contains(@id, 'label-lead')])[1]/..//textarea[1]");
				return Functions.supplyText(driver, vxpath, vtext);
			}
			return true;
		}catch (Exception e){
			System.out.println("Exception : " + e);
			return false;
		}
	}

	public static boolean clickLetsTalkButton (WebDriver driver, String vtext) throws Exception {
		return Functions.jsClick(driver, By.xpath("//input[@class='hs-button primary large'][@type='submit']"), vtext);
	}


	public static boolean openURL(WebDriver driver) {
		try {
			driver.get("https://www.uptake.com/");
			return Functions.waitForElementToBeClickable(driver, By.xpath("html/body//h1[1]"), 30);
		} catch (Exception e){
			System.out.println("Exception : " + e);
			return false;
		}

	}


}
