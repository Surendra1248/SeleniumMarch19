package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	public static ExtentReports extentReport;
	public static ExtentReports getExtentReport() {
		String reportPath= System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(reportPath);
		
		reporter.config().setDocumentTitle("TestResults");
		reporter.config().setReportName("Atw frame Report"); 
		
		 extentReport= new ExtentReports(); 
		 extentReport.attachReporter(reporter);
		 extentReport.setSystemInfo("operating system", "Winows 11");
		 extentReport.setSystemInfo("Tester Name", "Surendra");
		 
		 return extentReport;
	}

}
