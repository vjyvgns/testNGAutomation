package main.java.pageEvents;
import main.java.utils.fetchElement;
import main.java.pageObjects.homePageElements;

public class homePageEvents {

    public void clickOnSignInButton(){
        fetchElement FetchElement = new fetchElement();
        FetchElement.getWebElement( "ID", homePageElements.signInButton).click();

    }
}
