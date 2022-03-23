package pom.DsAlgo;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DsAlgo.TestBase_Dsalgo;

public class queuepage extends TestBase_Dsalgo {

	public queuepage() throws IOException {
		super();
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@FindBy(css = "a[href='queue']")
	@CacheLookup
	WebElement queue_getstarted;

	@FindBy(xpath = "//body//div//h4") 
	@CacheLookup
	WebElement queue_header;
	

	@FindBy(css = "a[href='implementation-lists']")
	@CacheLookup
	WebElement q_implementationinpython;
	
	@FindBy(css = "a[href='/queue/practice']")//a[href='/queue/practice']
	@CacheLookup
	WebElement practicequestionslink;
	
	//@FindBy(css = "a[href='/queue/implementation-collections/']")
	@FindBy(linkText ="Implementation using array")
	@CacheLookup//
	WebElement collections_implementation;

	@FindBy(css = "a[href='/queue/Implementation-array/']")
	@CacheLookup//
	WebElement collections_array;

	@FindBy(css = "a[href='/queue/QueueOp/']")
	@CacheLookup
	WebElement q_operations;

	@FindBy(css = "a[href='/tryEditor']")
	@CacheLookup
	WebElement tryHere_btn;

	/*public void queuegetstarted() {
		queue_getstarted.click();
	}

	public void queue_header() {
		queue_header.getText();
	}

	public void q_implementationinpython() {
		q_implementationinpython.click();
	}

	public void collections_implementation() {
		collections_implementation.click();
	}

	public void collections_array() {
		collections_array.click();
	}

	public void q_operations() {
		q_operations.click();
	}

	public void tryHere_btn() {
		tryHere_btn.click();
	}
*/
	public queuepage quepagefunction() throws IOException {

		System.out.println("n===============User is logged in on Homepage==================");

		queue_getstarted.click();
		driver.navigate();
		System.out.println("\n user navigated to  page  Queue Page  =======>" + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new queuepage();

		}
	
		public implementationof_queue_in_pythonpage implementationof_queue_in_pythonfunction() {
		System.out.println("n===============User is Queue page==================");
		q_implementationinpython.click();
		driver.navigate();
		System.out.println("\n user navigated to  page   =======>" + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new implementationof_queue_in_pythonpage();
	}
	
	public PracticeQuestionspage PracticeQuestionsfunction() throws IOException {

		System.out.println("\n================= user is on Implementation of queue in python page=============");
		practicequestionslink.isDisplayed();
		practicequestionslink.click();
		driver.navigate();
		System.out.println("\n user navigated to  Practice Questions   " + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new PracticeQuestionspage();
	}
	
	public implementation_using_collectionspage collections_implementationfunction() {
	System.out.println("n===============User is on Practice Questions page=================");
	driver.navigate().back();
		System.out.println(driver.getTitle());
		System.out.println("n===============User is on Implementation of queue in python page=================");

		collections_implementation.click();
				
		driver.navigate();
		System.out.println(" user navigated to  page   =======>" + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new implementation_using_collectionspage();
	}

	public implementationusingarrayPage collectionsarrayfunction() {
		System.out.println("n===============User is Implementation using collections page==================");
		collections_array.click();
		driver.navigate();
		System.out.println(" user navigated to  page   =======>" + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new implementationusingarrayPage();
	}

	public Queueoperationspage queueoperationsfunction() throws IOException {
		System.out.println("n===============collections using Arrays pagee==================");
		q_operations.click();
		driver.navigate();
		System.out.println(" user navigated to  page   =======>" + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new Queueoperationspage();
	}
		
	public Assessmentpage tryHerefunction() throws IOException {

		tryHere_btn.click();

		driver.navigate();
		System.out.println(" user navigated to Assessment page ======>" + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new Assessmentpage();
	}
	public Stackpage backtohomepage() throws IOException {
		driver.getTitle();
		System.out.println(driver.getTitle());
		//driver.navigate().back();
		driver.navigate().back();
		System.out.println("user back on the page   ==================" + driver.getTitle() );
		return new Stackpage();
		
	}
	
	
}