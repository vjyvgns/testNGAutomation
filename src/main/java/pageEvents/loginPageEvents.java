package main.java.pageEvents;
import main.java.pageObjects.loginPageElements;
import main.java.utils.fetchElement;
import org.testng.Assert;
import test.java.testData.constants;

public class loginPageEvents {
    fetchElement FetchElement = new fetchElement();

    public void verifyLoginPage(){
        Assert.assertTrue(FetchElement.getListWebElements("XPATH", loginPageElements.loginText).size()>0,"Login Page");
        int sizeOfElements = FetchElement.getListWebElements("XPATH", loginPageElements.loginText).size();
        System.out.println("Size of Elements: "+sizeOfElements);
    }

    public void verifyLoginPage2(){
        Assert.assertFalse(FetchElement.getListWebElements("XPATH", loginPageElements.loginText).size()>0,"Login Page");
        int sizeOfElements = FetchElement.getListWebElements("XPATH", loginPageElements.loginText).size();
        System.out.println("Size of Elements: "+sizeOfElements);
    }

    public void enterEmailAddress(String emailAddress){
        FetchElement.getWebElement("ID",loginPageElements.emailAddress).sendKeys(emailAddress);
    }
}