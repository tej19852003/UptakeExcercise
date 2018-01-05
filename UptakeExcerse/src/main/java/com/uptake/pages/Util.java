package com.uptake.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Util extends GlobalVariables {
	public static WebDriver driver = null;
	public static InputBrowserDetails inputBrowserDetails = new InputBrowserDetails(Browser);
	public static String timeStamp;
	public static String dateStamp;

	@SuppressWarnings("deprecation")
	public static WebDriver browser_setup(String browser) throws Exception{
		DesiredCapabilities capabilities;
		Map<String, Object> prefs;
		ChromeOptions options;
		switch (browser) {

		case "Firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Files\\geckodriver.exe");
			FirefoxProfile Profile = new FirefoxProfile();
//			Profile.setPreference("browser.download.dir",downloadFilepath);
			Profile.setPreference("browser.download.folderList",2);
			Profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv,application/excel,application/vnd.ms-excel,application/vnd.msexcel,text/anytext,text/comma-separated-values,text/csv,text/plain,text/x-csv,application/x-csv,text/x-comma-separated-values,text/tab-separated-values");
			Profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/xml,text/plain,text/xml,image/jpeg,application/octet-stream");
			Profile.setPreference("browser.download.manager.showWhenStarting",false);
			Profile.setPreference("browser.helperApps.neverAsk.openFile","application/csv,application/excel,application/vnd.ms-excel,application/vnd.msexcel,text/anytext,text/comma-separated-values,text/csv,text/plain,text/x-csv,application/x-csv,text/x-comma-separated-values,text/tab-separated-values");
			Profile.setPreference("browser.helperApps.neverAsk.openFile","application/xml,text/plain,text/xml,image/jpeg,application/octet-stream");
			Profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			driver = new FirefoxDriver(new FirefoxOptions().setProfile(Profile));
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Files\\chromedriver.exe");
	    	prefs =new HashMap<String, Object>();
	    	options = new ChromeOptions();
	    	options.addArguments("disable-extensions");
	    	prefs .put("credentials_enable_service", false);
	    	prefs .put("profile.password_manager_enabled", false);
//	    	prefs.put("download.default_directory", downloadFilepath);
	    	options.setExperimentalOption("prefs", prefs);
	    	capabilities = DesiredCapabilities.chrome();
	    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    	driver = new ChromeDriver(capabilities);
	    	break;
		case "IE":
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("EnableNativeEvents", false);
			capabilities.setCapability("requireWindowFocus ", true);
	    	System.setProperty("webdriver.ie.driver",  System.getProperty("user.dir") + "\\Files\\IEDriverServer.exe");
	        driver = new InternetExplorerDriver(capabilities);
	        break;
		case "Edge":
			capabilities = DesiredCapabilities.edge();
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("EnableNativeEvents", false);
			capabilities.setCapability("requireWindowFocus ", true);
	    	System.setProperty("webdriver.edge.driver",  System.getProperty("user.dir") + "\\Files\\MicrosoftWebDriver.exe");
	        driver = new EdgeDriver(capabilities);
	        break;
		default:
	    	System.out.println("Provided Browser detail is not correct, so using details Chrome Browser");
	    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Files\\chromedriver.exe");
	    	prefs =new HashMap<String, Object>();
	    	options = new ChromeOptions();
	    	options.addArguments("disable-extensions");
	    	prefs .put("credentials_enable_service", false);
	    	prefs .put("profile.password_manager_enabled", false);
//	    	prefs.put("download.default_directory", downloadFilepath);
	    	options.setExperimentalOption("prefs", prefs);
	    	capabilities = DesiredCapabilities.chrome();
	    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    	driver = new ChromeDriver(capabilities);
	    	break;
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    return driver;
	}

	public static void getTestCasesData(String moduleName) {
		try{
			FileInputStream fis = new FileInputStream(datapath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			//Getting Module Info

			String run = null;
			XSSFSheet worksheet = workbook.getSheet(moduleName);
			for (int row = 1; row < worksheet.getLastRowNum()+1; row++) {
				run = worksheet.getRow(row).getCell(4).getStringCellValue();
					if (run.equalsIgnoreCase("Y")) {
						listOfTestCases.add(worksheet.getRow(row).getCell(1).getStringCellValue());
				}
			}
//			System.out.println("List of Environments:"+listOfEnvironment);
	        workbook.close();
	        fis.close();
		}catch(FileNotFoundException e){
			System.out.println("Excel File Path Not Correct");
		}catch(Exception e){
			System.out.println("Exception e="+e);
		}
	}

	public static void getExcelEnvironmentData() {
		try{
			dateStamp= new SimpleDateFormat("yyyy_MMM_dd").format(new Date());
			timeStamp= new SimpleDateFormat("yyyy_MMM_dd@HH_mm_ss").format(new Date());
			System.out.println("Date & Time of Execution : " +timeStamp);
			FileInputStream fis = new FileInputStream(datapath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			//Getting Module Info
			XSSFSheet worksheet = workbook.getSheet("Module");

			String run = null;
	        for (int row = 1; row < worksheet.getLastRowNum()+1; row++) {
	        	run = worksheet.getRow(row).getCell(3).getStringCellValue();
	            if (run.equalsIgnoreCase("Y")) {
	            	listOfModule.add(worksheet.getRow(row).getCell(2).getStringCellValue());
	            }
	        }
			worksheet = workbook.getSheet("Browser");
	        for (int row = 1; row < worksheet.getLastRowNum()+1; row++) {
	        	run = worksheet.getRow(row).getCell(1).getStringCellValue();
	            if (run.equalsIgnoreCase("Y")) {
//	            	listOfBrowser.add(worksheet.getRow(row).getCell(0).getStringCellValue());
	            	Browser = worksheet.getRow(row).getCell(0).getStringCellValue();
	            	inputBrowserDetails.setBrowserName(Browser);
	            	System.out.println("Execution for Browser: "+Browser+ " selected");
	            	break;
	            }
	        }
	    	System.out.println("List of Modules:"+listOfModule);
			System.out.println("List of Browsers:"+Browser);
	        workbook.close();
	        fis.close();
		}catch(FileNotFoundException e){
			System.out.println("Excel File Path Not Correct");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
