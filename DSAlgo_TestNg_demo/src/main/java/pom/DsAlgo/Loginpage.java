package pom.DsAlgo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DsAlgo.TestBase_Dsalgo;

public class Loginpage extends TestBase_Dsalgo {

	Homepage homepg=new Homepage();

	@FindBy(name="username")
	WebElement username;	
	
	@FindBy(id="id_password")
	WebElement password ;
	
	@FindBy(css="input[value='Login']")
	WebElement Loginbtn;
	
	@FindBy(linkText ="Sign in")
	@CacheLookup
	WebElement Signinlink;
	
	
	@FindBy(xpath ="//div[@role='alert']")
	@CacheLookup
	WebElement Alert;
	
		
	public Loginpage() throws IOException {
		 try {
			PageFactory.initElements(driver, this);
		}
		 catch(Exception e) {
			 System.out.println(e.getMessage());
			 }
		}
			
	public  String SignIn() {
		Signinlink.click();
		assertEquals(driver.getTitle(), "Login");
		System.out.println("LOGIN");
		return driver.getTitle();		
	}
		
	public void username() { 
		username.clear();
		username.sendKeys(prop.getProperty("usrName"));
		System.out.println("Username used     "  +prop.getProperty("usrName"));
	}
	
	public void password() {
		password.clear();
		password.sendKeys(prop.getProperty("pwdName"));
	}
	
	public void login() {
		
		Loginbtn.isDisplayed();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",Loginbtn) ;
		assertEquals(driver.getTitle(), "NumpyNinja");
		}
	
	public void loginfunction() {
	
		username.sendKeys(prop.getProperty("usrName"));
		password.sendKeys(prop.getProperty("pwdName"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",Loginbtn);
			
		if(driver.getTitle()=="NumpyNinja") {
			System.out.println("Login successful");
			homepg.signoutfunction();
		}
			else if (driver.getTitle()=="Login") {
				System.out.println ("login failure()");
		}
				
		 System.out.println("Login Function\n=== L===");
		}
	
	public void alertmessage() {
		{		
			if (Alert.isDisplayed()) {
				System.out.println("Alert !     "  + Alert.getText());
			}
			else { System.out.println(" no Alerts");}
			}	
		}
	
	public void  loginfromexceldata( String un, String pwd, String status) {
		System.out.println("\n=== Entering Login Details ===");
		
		try {
		username.clear();
		username.sendKeys(un);
		System.out.println("username enetered is " +un);
		
		password.clear();
		password.sendKeys(pwd);
		System.out.println("Password enetered is " +pwd);

		System.out.println("\n" +status);
		
		//Registerbtn.click();
		
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", Loginbtn);

				//assertEquals(driver.getTitle(), "Login", "Login failed");
					if(driver.getTitle()=="NumpyNinja") {
					System.out.println("Login successful");
					//homepg.signoutfunction();
				}
				 System.out.println("\n Login Function Ends======");
				}

				catch (NullPointerException e) {
				System.out.println("error in webelement invocation"  +e.getMessage());
				}
						
			}
	
	}
	
	
