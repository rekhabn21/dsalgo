package pom.DsAlgo;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DsAlgo.TestBase_Dsalgo;

public class Stackpage extends TestBase_Dsalgo {

	@FindBy(css = "a[href='stack']")
	@CacheLookup
	WebElement stack_link;

	@FindBy(xpath = "//body//div//h4")
	@CacheLookup
	WebElement stack_header;

	@FindBy(linkText = "Operations in Stack")
	@CacheLookup
	WebElement OperationsinStack_link;

	@FindBy(xpath = "//body//div//div//div//strong//p")
	@CacheLookup
	WebElement opertaions_header;

	@FindBy(css = "a[href='/tryEditor']")
	@CacheLookup
	WebElement tryHere_btn;

	@FindBy(linkText = "Implementation")
	@CacheLookup
	WebElement Implementation_link;

	@FindBy(xpath = "//body//div//div//div//strong//p")
	@CacheLookup
	WebElement impelementation_header;

	@FindBy(linkText = "Applications")
	@CacheLookup
	WebElement applications_link;

	@FindBy(xpath = "//body//div//div//div//strong//p")
	@CacheLookup
	WebElement applications_header;

	@FindBy(css ="a[href='/stack/practice']")
	@CacheLookup
	WebElement practicequestions_link ;
	
	

	
//======================================================================================

	public Stackpage() throws IOException {
		try {
			PageFactory.initElements(driver, this);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Stackpage stackpage_getstartedfunction() throws IOException {
		
		System.out.println("n===============User is logged in on Homepage==================");
		stack_link.click();
		driver.navigate();
		System.out.println("Header     :" + stack_header.getText());
		System.out.println(" user navigated to DatatstructuresS Introduction page   =======>" + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new Stackpage();

	}

	public operationsinstackpage operationslinkfunction() throws IOException {

		System.out.println("\n================= user is on Stack page=============");
		OperationsinStack_link.click();
		driver.navigate();
		System.out.println(" user navigated to    " + driver.getTitle());
		System.out.println(" Operations link page Header          :" + opertaions_header.getText());
		System.out.println(driver.getCurrentUrl());
		return new operationsinstackpage();

	}

	public Implementationpage implementationfunction() throws IOException {

		System.out.println("\n================= user is on Operations instack page============");
		Implementation_link.click();
		driver.navigate();
		System.out.println(" user navigated to  Implementation in Stack page" + driver.getTitle());
		System.out.println("Implementation page Header         :" + impelementation_header.getText());
		System.out.println(driver.getCurrentUrl());
		return new Implementationpage();

	}

	public Applicationspage Applicationsfunction() {

		System.out.println("\n================= user is on Implementation page=============");

		driver.navigate();
		System.out.println(" \n user navigated to  Applications   " + driver.getTitle());
		System.out.println("\nApplications page Header     :" + applications_header.getText());
		System.out.println(driver.getCurrentUrl());
		return new Applicationspage();

	}

	public PracticeQuestionspage PracticeQuestionsfunction() throws IOException {

		System.out.println("\n================= user is on Applications page=============");
		practicequestions_link.isDisplayed();
		practicequestions_link.click();
		driver.navigate();
		System.out.println("\n user navigated to  Practice Questions   " + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new PracticeQuestionspage();

	}

	public Assessmentpage tryHere_btn() throws IOException {

		tryHere_btn.click();

		driver.navigate();
		System.out.println(" user navigated to Assessment page ======>" + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new Assessmentpage();
	}

	public Stackpage backtohomepage() throws IOException {
		driver.getTitle();
		System.out.println(" user is on Assessment page ======>" );
		//driver.navigate().back();
		driver.navigate().back();
		System.out.println("user back on stack with user login");
		return new Stackpage();
		
	}
	
		
	
}
