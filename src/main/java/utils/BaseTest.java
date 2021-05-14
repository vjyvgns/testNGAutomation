package main.java.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import test.java.testData.constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import main.java.utils.excelReader;
import main.java.utils.propertiesReader;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    excelReader excel;


    @BeforeTest
    public void beforeTest(){
        htmlReporter = new ExtentHtmlReporter( System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester","Vijay Vignesh");
    }

    @BeforeMethod
    @Parameters(value={"browserName"})
    public void beforeMethod(String browserName, Method testMethod) throws IOException {
        logger = extent.createTest(testMethod.getName());
        setUpDriver(browserName);
        driver.manage().window().maximize();
        String url = propertiesReader.getObject("url");
        System.out.println("URL in BaseTest is "+url);
        driver.get(url);
    }


    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + "Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        }
        else if (result.getStatus() == ITestResult.FAILURE){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " +methodName + "Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,m);
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest(){
        extent.flush();

    }


    public void setUpDriver(String browser){
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
            driver = new ChromeDriver();
        }
    }

    public String[][] getData(String excelName, String sheetName) {
        String path = System.getProperty("user.dir") + "/src/test/java/testData/"
                + excelName;
        excel = new excelReader(path);
        String[][] data = excel.getDataFromSheet(sheetName, excelName);
        return data;
    }
}
