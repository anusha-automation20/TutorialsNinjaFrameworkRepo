package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() {

		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Tutorials Ninja Test Automation Results");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

		extentReport.attachReporter(sparkReporter);
		Properties configProperties = new Properties();
		File configPropertyFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		try {
			FileInputStream fisConfigProp = new FileInputStream(configPropertyFile);
			configProperties.load(fisConfigProp);
		} catch (Throwable e) {

			e.printStackTrace();
		}

		extentReport.setSystemInfo("Application URL", configProperties.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProperties.getProperty("browser"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
		extentReport.setSystemInfo("User Information", System.getProperty("user.name"));
		
		return extentReport ;
	}
}
