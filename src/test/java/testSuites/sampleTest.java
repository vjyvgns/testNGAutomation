package test.java.testSuites;

import com.aventstack.extentreports.Status;
import main.java.pageEvents.homePageEvents;
import main.java.pageEvents.loginPageEvents;
import main.java.utils.BaseTest;
import main.java.utils.propertiesReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class sampleTest extends BaseTest {

    @DataProvider(name="testData")
    public Object[][] getTestData(){
        String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
        return testRecords;
    }


    @Test(dataProvider = "testData")
    public void enterEmailAddress(String emailAddress, String password) throws IOException {
        homePageEvents HomePageEvents = new homePageEvents();
        loginPageEvents LoginPageEvents = new loginPageEvents();

        HomePageEvents.clickOnSignInButton();
        LoginPageEvents.verifyLoginPage();
        LoginPageEvents.enterEmailAddress(emailAddress);
        System.out.println("Email Address is: "+emailAddress + "Password is: "+password);
        logger.log(Status.PASS,"Passed");
    }

//    @Test(groups = {"Run"})
//    public void enterEmailAddress2(){
//        homePageEvents HomePageEvents = new homePageEvents();
//        loginPageEvents LoginPageEvents = new loginPageEvents();
//
//        HomePageEvents.clickOnSignInButton();
//        LoginPageEvents.verifyLoginPage();
//        LoginPageEvents.enterEmailAddress();
//    }
//
//    @Test
//    public void enterEmailAddress3(){
//        homePageEvents HomePageEvents = new homePageEvents();
//        loginPageEvents LoginPageEvents = new loginPageEvents();
//
//        HomePageEvents.clickOnSignInButton();
//        LoginPageEvents.verifyLoginPage2();
//        LoginPageEvents.enterEmailAddress();
//    }
//
//    @Test
//    public void enterEmailAddress4(){
//        homePageEvents HomePageEvents = new homePageEvents();
//        loginPageEvents LoginPageEvents = new loginPageEvents();
//
//        HomePageEvents.clickOnSignInButton();
//        LoginPageEvents.verifyLoginPage();
//        LoginPageEvents.enterEmailAddress();
//    }
}