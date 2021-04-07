package test.java;

import main.java.utils.constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;

public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    public void beforeTest(){


    }

    @BeforeMethod
    @Parameters(value={"browserName"})
    public void beforeMethod(String browserName){
        setUpDriver(browserName);
        driver.manage().window().maximize();
        driver.get(constants.url);
    }


    @AfterMethod
    public void afterMethod(){


    }



    @AfterTest
    public void afterTest(){


    }


    public void setUpDriver(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver");
            driver = new ChromeDriver();
        }
    }
}
