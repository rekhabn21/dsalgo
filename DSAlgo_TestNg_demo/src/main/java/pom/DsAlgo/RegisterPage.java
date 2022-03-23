package pom.DsAlgo;

//import static org.testng.Assert.assertEquals;
import static org.junit.Assert.*;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DsAlgo.TestBase_Dsalgo;

public class RegisterPage extends TestBase_Dsalgo {

	//WebDriver driver;
	// find the webelements in the login page
	@FindBy(xpath ="//a[@class='navbar-brand']")
	@CacheLookup
	WebElement NumpyNinja;

	@FindBy(css="a[href='/register']")
	@CacheLookup
	WebElement Registerlink;
	
		
	@FindBy(linkText ="Sign in")
	@CacheLookup
	WebElement Signinlink;
	
	@FindBy(xpath ="//input[@name='username']")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password1")
	WebElement password1 ;
	
	@FindBy (name="password2")
	@CacheLookup
	WebElement password2;
	
	@FindBy(xpath="//input[@value='Register']")
	@CacheLookup
	WebElement Registerbtn;
	
	@FindBy(xpath="//div[@role='alert']")
	@CacheLookup
	WebElement Messagebar;
	
	
	@FindBy(css="div[role='alert']")			
	@CacheLookup
	WebElement Alert;
					
	@FindBy(xpath="//body//div//ul//a[2]")
	@CacheLookup
	WebElement registereduser;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/form[1]/input[1]")
//	[contains"Please fill out this field"]
	
	//@FindBy(xpath="//form[@method='post']//input[@value='0B4WQxVqmi3CA3ifoOZBHdJWmyuwv3wso0NJr4RrRUn59irrgYswG8iErHWnn4qe']")
	@CacheLookup
	WebElement username_hide;
	
		
	public RegisterPage () throws IOException {
	 try {
		
		PageFactory.initElements(driver, this);
	}
	 catch(Exception e) {
		 System.out.println(e.getMessage());
		 };
	 	}
		
	 // Actions or Methods on webelements
	
	//verify page title
	public  String validatingRegistrationpageTitle() {
	return driver.getTitle();
	}
	 
	//verify for numpyninja logo link
		public boolean validatelogolink() {
		return NumpyNinja.isDisplayed();
	 }
		
			
	// Register 
	public  String HomePageRegister() {
	//Registerlink.click()
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", Registerlink);
	
	
	System.out.println(driver.getTitle());
	assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/register");
	return driver.getCurrentUrl()	;
	}
	
	// registration of new user 
	public Homepage  registration( String un,String pn) throws IOException {
	System.out.println("=== Entering registration() ===");
	try {
		username.isDisplayed();
		System.out.println("USername textbox");
	
		username.sendKeys(un);
		password1.sendKeys(pn);
		password2.sendKeys(pn);
		
		//Registerbtn.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Registerbtn);
	 
		assertEquals(driver.getTitle(), "Registration");}
		catch(Exception e) {
		System.out.println("error in webelement invocation"  +e.getMessage());
	}
	
	
	 System.out.println("=== Leaving registration() ===");
	 return new Homepage();
		
	}
	
	public void registrationdetails( String un,String Pwd1, String Pwd2) throws IOException {
		
		System.out.println("=== Entering registration() ===");
		
		try {
		
		username.clear();
		username.sendKeys(un);
		System.out.println("username enetered is " +username);
		
		password1.clear();
		password1.sendKeys(Pwd1);
		System.out.println("Password1 enetered is " +password1);

		
		password2.clear();
		password2.sendKeys(Pwd2);
		System.out.println("Password2 enetered is " +password2);
				
		//Registerbtn.click();
		
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", Registerbtn);
			 
				assertEquals(driver.getTitle(), "Registration");
				}
	
				catch (NullPointerException e) {
				System.out.println("error in webelement invocation"  +e.getMessage());
				}
							}
	
	
		/*// identify element and click
      driver.findElement(By.id("hide-textbox")).click();
      // Javascript executor class with executeScript method
      JavascriptExecutor j = (JavascriptExecutor) driver;
      // identify element and set value
      j.executeScript ("document.getElementById('displayed-text').value='Selenium';");
      String s = (String) j.executeScript("return document.getElementById('displayed-text').value");
      System.out.print("Value entered in hidden field: " +s);
		 * */
	
public void Registrationfromexceldata(String un,String pwd1,String pwd2,String Status) throws IOException {
	
	System.out.println("\n=== Entering registration() ===");
	
	try {
	
	username.clear();
	username.sendKeys(un);
	System.out.println("username enetered is " +un);
	
	password1.clear();
	password1.sendKeys(pwd1);
	System.out.println("Password1 enetered is " +pwd1);

	
	password2.clear();
	password2.sendKeys(pwd2);
	System.out.println("Password2 enetered is " +pwd2);
			
	System.out.println("\n" +Status);
	
	//Registerbtn.click();
	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", Registerbtn);

			//	assertEquals(driver.getTitle(), "Registration", "Registration failed");
									
			validatingRegistrationpageTitle();
		
			if(driver.getTitle()=="NumpyNinja") {
				System.out.println(" Registration successful");				}
				
				else if (driver.getTitle()=="Registration") {
					System.out.println ("Registartion failure()");
			}
					
			 System.out.println("\n=== Leaving registration() ===");
			}

			catch (NullPointerException e) {
			System.out.println("error in webelement invocation"  +e.getMessage());
			}
					
						}

	
	public void Alertmesage()
	{		
		if (Alert.isDisplayed()) {
			System.out.println("Alert !     "  + Alert.getText());
		}
		else { System.out.println(" no Alerts");}
		
	}	
		public void registerbtnclick() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Registerbtn);
		System.out.println("\n Register button clicked .....wait for alert msg \n");
		
	}
	
	
	public String alertmessage() throws InterruptedException {
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Registerbtn);
		
	System.out.println(username_hide.isDisplayed()); // false 
	
	Actions action = new Actions(driver);
	action.moveToElement(username_hide).build().perform();
	
	String s =username_hide.getText();
	
	
	
	//String s =(String) ((JavascriptExecutor)js).executeScript("return document.username_hide.textContext"); 
	//String innerText = (String) ((JavascriptExecutor) js).executeScript("return arguments[0].innerhtml;".username_hide)
		//
	//	String s =	(String)((JavascriptExecutor) js).executeScript("return arguments[0].textContext;",username_hide);
		
		System.out.println("Alert! " +s);
		return s;
	
	}
		
	public String messagebar() throws IOException {
	
		
		System.out.println("AfterRegistration");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String message=   (String)((JavascriptExecutor) js).executeScript("return arguments[0].innerText",Messagebar);
		System.out.println(message);
		 		
		String user =  (String) ((JavascriptExecutor) js).executeScript("return arguments[0].innerText" ,registereduser);
		assertTrue(user,true);
		System.out.println("new registered user is " +user);
		
		return user;
				
	}




}