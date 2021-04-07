package test.java.testSuites;

import main.java.pageEvents.homePageEvents;
import main.java.pageEvents.loginPageEvents;
import main.java.utils.BaseTest;
import org.testng.annotations.Test;

public class sampleTest extends BaseTest {


    @Test
    public void enterEmailAddress(){
        homePageEvents HomePageEvents = new homePageEvents();
        loginPageEvents LoginPageEvents = new loginPageEvents();

        HomePageEvents.clickOnSignInButton();
        LoginPageEvents.verifyLoginPage();
        LoginPageEvents.enterEmailAddress();
    }

    @Test
    public void enterEmailAddress2(){
        homePageEvents HomePageEvents = new homePageEvents();
        loginPageEvents LoginPageEvents = new loginPageEvents();

        HomePageEvents.clickOnSignInButton();
        LoginPageEvents.verifyLoginPage();
        LoginPageEvents.enterEmailAddress();
    }

    @Test
    public void enterEmailAddress3(){
        homePageEvents HomePageEvents = new homePageEvents();
        loginPageEvents LoginPageEvents = new loginPageEvents();

        HomePageEvents.clickOnSignInButton();
        LoginPageEvents.verifyLoginPage2();
        LoginPageEvents.enterEmailAddress();
    }

    @Test
    public void enterEmailAddress4(){
        homePageEvents HomePageEvents = new homePageEvents();
        loginPageEvents LoginPageEvents = new loginPageEvents();

        HomePageEvents.clickOnSignInButton();
        LoginPageEvents.verifyLoginPage();
        LoginPageEvents.enterEmailAddress();
    }
}