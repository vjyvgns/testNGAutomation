package test.java;

import main.java.pageEvents.homePageEvents;
import main.java.pageEvents.loginPageEvents;
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
}
