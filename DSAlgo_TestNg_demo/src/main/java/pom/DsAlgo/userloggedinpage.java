package pom.DsAlgo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DsAlgo.TestBase_Dsalgo;

public class userloggedinpage extends TestBase_Dsalgo {

	public userloggedinpage() throws IOException {
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
  }

	@FindBy(xpath = "//a[@class='navbar-brand']")
	@CacheLookup
	WebElement NumpyNinja;
	
	

	  @FindBy(linkText="Sign out")
	  @CacheLookup 
	  WebElement logout_btn;
	
	
	  @FindBy(xpath = "//div[@role='alert']")
		//@CacheLookup
		WebElement Messagebar;
	  
	  @FindBy(xpath = "//body//div//ul//a[2]")
		@CacheLookup
		WebElement registereduser;
	 
	  
	 			

		public void verify_messagealerts() throws IOException{
		    
			if (Messagebar.isDisplayed() ==true) {
			
		    String Alert = Messagebar.getText();
			System.out.println("Alert!        " +Alert);
		}
		else {
				System.out.println("no ALerts");
			}
		 }
		
			

		public boolean verify_Loggedin_username() {
		return registereduser.isDisplayed();      }

			
			
		public void logout_btn_click(){
			System.out.println("=== Entering logout_btn_click() ===");
			
			if(logout_btn.isDisplayed() && Messagebar.isDisplayed()) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",logout_btn);
				//String logoutmessage  = (String) js.executeScript("arguments[0].innerText;",Messagebar);
				assertEquals("Logged out successfully", Messagebar.getText());
				//System.out.println(logoutmessage);
				System.out.println(driver.getTitle());
			} else {
				System.out.println("Logout button not displayed");
			}

			System.out.println("=== Leaving logout_btn_click() ===");
		}	
			
			
			
			
			
			
			
		
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
