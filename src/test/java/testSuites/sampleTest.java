package test.java.testSuites;

import main.java.pageEvents.homePageEvents;
import main.java.pageEvents.loginPageEvents;
import main.java.utils.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class sampleTest extends BaseTest {

    @DataProvider(name="testData")
    public Object[][] getTestData(){
        String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
        return testRecords;
    }


    @Test(dataProvider = "testData")
    public void enterEmailAddress(String emailAddress, String password){
        homePageEvents HomePageEvents = new homePageEvents();
        loginPageEvents LoginPageEvents = new loginPageEvents();

        HomePageEvents.clickOnSignInButton();
        LoginPageEvents.verifyLoginPage();
        LoginPageEvents.enterEmailAddress(emailAddress);
        System.out.println("Email Address is: "+emailAddress + "Password is: "+password);
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