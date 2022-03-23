package pom.DsAlgo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DsAlgo.TestBase_Dsalgo;

public class Homepage extends TestBase_Dsalgo {

	// @FindBy(css = "#answer_form > div > div > div:nth-child(1) > textarea")
	// WebElement codearea1//

	@FindBy(xpath = "//a[@class='navbar-brand']")
	@CacheLookup
	WebElement NumpyNinja;

	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	@CacheLookup
	WebElement Signinlink;

	@FindBy(css = "a[href='/register']")
	@CacheLookup
	WebElement Registerlink;

	@FindBy(xpath = "//a[contains(text(), 'Data Structures')]")
	@CacheLookup
	WebElement DS_dropdown;

	// @FindBy(css="a[href='/array']")
	@FindBy(xpath = "//div[@class='dropdown menu show']/a")
	@CacheLookup
	List<WebElement> ds_menu_ARRAY;

	@FindBy(xpath = "//div[@role='alert']")
	@CacheLookup
	WebElement Messagebar;

	@FindBy(xpath = "//body//div//ul//a[2]")
	@CacheLookup
	WebElement registereduser;

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	@CacheLookup
	WebElement Datastructures_getstarted;

	@FindBy(xpath = "//a[@href='array']")
	@CacheLookup
	WebElement Array_getstartred;

	@FindBy(xpath = "//a[@href='linked-list']")
	@CacheLookup
	WebElement linkedlist_getstartred;

	@FindBy(xpath = "//a[@href='stack']")
	@CacheLookup
	WebElement stack_getstartred;

	@FindBy(xpath = "//a[@href='queue']")
	@CacheLookup
	WebElement queue_getstartred;

	@FindBy(xpath = "//a[@href='tree']")
	@CacheLookup
	WebElement Tree_getstartred;

	@FindBy(xpath = " //a[@href='graph']")
	@CacheLookup
	WebElement Graph_getstartred;

	@FindBy(css = "a[href='/logout']")
	@CacheLookup
	WebElement signoutbutton;

	
	public boolean verifydatastructurespane() {
		return Datastructures_getstarted.isDisplayed();
	}

	public boolean verifyarraypane() {
		return Array_getstartred.isDisplayed();
	}

	public boolean verifylinkedlistpane() {
		return linkedlist_getstartred.isDisplayed();
	}
	public boolean verifystackpane() {
		return stack_getstartred.isDisplayed();
	}
	public boolean verifyqueuepane() {
		return queue_getstartred.isDisplayed();
	}
	public boolean verifygraphpane() {
		return Graph_getstartred.isDisplayed();
	}
	public boolean verifyTreepane() {
		return Tree_getstartred.isDisplayed();
	}

		public Homepage() throws IOException {
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

		public void messagealerfunction() {
					
			if (Messagebar.isDisplayed()==true) {
				System.out.println("Alert !     "  + Messagebar.getText());
			}
			else { System.out.println(" no Alerts");}
			}	
		

		
		
	public String verifypagetitle() {
		String pgtitle = driver.getTitle();
		// assertEquals(pgtitle, "");
		System.out.println("We are on the page " + pgtitle);
		return pgtitle;
	}

	public Loginpage click_on_signin_link() throws IOException {
		try {

			Signinlink.isDisplayed();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", Signinlink);

			// driver.navigate().forward();

			String pgtitle = driver.getTitle();
			assertEquals(pgtitle, "Login");

			System.out.println("User is on loginpage" + pgtitle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new Loginpage();
	}

	public RegisterPage click_on_Register_link() throws IOException {
		try {

			System.out.println(Registerlink.isDisplayed());
			Registerlink.click();
			driver.navigate().forward();

			String pgtitle1 = driver.getTitle();
			System.out.println("User is on Registrationpage   " + pgtitle1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new RegisterPage();
	}

	public boolean verify_Loggedin_username() {
		return registereduser.isDisplayed();

	}

	public void dropdown_click() {
		System.out.println("=== In dropdown_click() ===");
		// WebElement DS_dropdown =//
		// driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", DS_dropdown);

		System.out.println("Datastructures dropdown menu clicked");

		System.out.println("\n=== Out dropdown_click() ===");
	}

	
	public String verifyDatastructurebtn() {
		Datastructures_getstarted.click();
		String Alert = Messagebar.getText();
		System.out.println(Alert);

		return Alert;
	}

	Loginpage login;
	Homepage homepg;

	public void userlogin() throws IOException {
		homepg = new Homepage();
		System.out.println(homepg.verifypagetitle());
		login = homepg.click_on_signin_link();
		login.SignIn();
		login.username();
		login.password();
		login.login();
		System.out.println("\nLogin completed\n");
		String newpgtitle = driver.getTitle();
		homepg.verify_Loggedin_username();
		System.out.println("n===============User login successful==================");

	}

	public void signoutfunction() {
		registereduser.isDisplayed();
		if (registereduser.isDisplayed() == true) {
			signoutbutton.click();
			
			if (Messagebar.isDisplayed() ==true) {
				System.out.println("Alert !     "  + Messagebar.getText());
			}		
		}
			else {
				System.out.println(driver.getTitle());
			
		}
	}

	public String selectmenuitem() {

		System.out.println("select from DS dropdown");
		System.out.println("\n select arrays from datastructures");

		Actions Act = new Actions(driver);
		Act.moveToElement(DS_dropdown).click().build().perform();

		
		 /* wait = new WebDriverWait(driver, 60);
		 * wait.until(ExpectedConditions.elementToBeSelected(ds_menu_ARRAY));}
		 */
		String newAlert = Messagebar.getText();
		System.out.println(newAlert);

		return newAlert;
	}
}

/*
 * public void dropdownselect() {
 * 
 * Select ds_drpdwn = new Select(DS_dropdown); List<WebElement> ds_list =
 * ds_drpdwn.getAllSelectedOptions(); int drp_dwnsize = ds_list.size();
 * System.out.println("The  Datastructures dropdown has items :" + drp_dwnsize);
 * 
 * for (WebElement dropdownoptions : ds_list) {
 * 
 * System.out.println(dropdownoptions.getText());
 * ds_drpdwn.selectByIndex(drp_dwnsize); }
 * 
 * }
 */