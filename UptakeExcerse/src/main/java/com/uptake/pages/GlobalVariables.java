package com.uptake.pages;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GlobalVariables {
	// Get Data From Excel
	public static final List<String> listOfModule = new ArrayList<String>();
//	public static final List<String> listOfBrowser = new ArrayList<String>();
	public static final List<String> listOfEnvironment = new ArrayList<String>();
	public static final List<String> listOfTestCases = new ArrayList<String>();
	public static String Browser="";
	public static final String datapath = System.getProperty("user.dir") + "\\TestData\\UptakeTestSuite.xlsx";
	public static final String downloadFilepath = System.getProperty("user.dir") + "\\DownloadedFiles";
	public static String Exception = "";
	public static String pcflag = "true";

	public static int timeout;

	// Info about  RestClient
	public static String uploadurl = "https://interface-stg.celltrak.net/upload?siteId=qa579";
	public static String user = "qa579";
	public static String authCode = "3RQoQH1WScM1IJp520pYPfxNMslzVLi0w5NUBMhwv1G932H5ud";

	//Info about Database
	public static final String HOSTNAME = "usadbstg.aws.db.east.us";
	public static final int PORTNUMBER = 3306;
	public static final String TRANS_DB = "transaction_qa579";
	public static final String USERNAME = "tpatel";
	public static final String PASSWORD = "Sriram143$";
	public static Statement smt = null ;





}


