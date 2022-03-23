package pom.DsAlgo;

import java.io.IOException;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.util.concurrent.ExecutionError;

import utils.DsAlgo.TestBase_Dsalgo;

public class DSintroductionpage  extends TestBase_Dsalgo{


	public DSintroductionpage() throws IOException {
		super();
		try {
		PageFactory.initElements(driver, this);
		}
		catch (ExecutionError e)
		{
			System.out.println(e.getMessage());
		}
		}
	

	@FindBy(xpath = "//a[@class='navbar-brand']")
	@CacheLookup
	WebElement NumpyNinja;
	
	@FindBy(xpath = "//body//div//ul//a[2]")
	@CacheLookup
	WebElement registereduser;
	
	@FindBy(xpath = "//a[normalize-space()='Sign out']")
	@CacheLookup
	WebElement Signout;

	
		
	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	@CacheLookup
	WebElement Ds_introduction;
	
	@FindBy(xpath="//body//div//h4")
	@CacheLookup
	WebElement DS_header;
	//=================================================
	@FindBy( css ="a[href='time-complexity']")
	@CacheLookup
	WebElement timecomplexity_link;
	
	@FindBy(xpath ="//body//div//div//div//strong//p")
	@CacheLookup
	WebElement timecomplexity_header;
	
	@FindBy( css ="a[href='/tryEditor']")
	@CacheLookup
	WebElement	tryHere_btn	;
	
	//===============================================
	
	//@FindBy(xpath ="a[href='/data-structures-introduction/practice']")
	@FindBy(linkText ="Practice Questions")
	@CacheLookup
	WebElement practiceQuestions_link;
	
	
	
	//Homepage homepg;
	//DSintroductionpage= new DSintorductionpage();	
	

	public DSintroductionpage   Ds_introduction() throws IOException {
		
		System.out.println(" user is on  Homepage   =======>" +driver.getTitle());
		
		Ds_introduction.click();
		driver.navigate();
			
		System.out.println("Header     :" +DS_header.getText());
		System.out.println(" user navigated to DatatstructuresS Introduction page   =======>" +driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new DSintroductionpage();
		
		}
	
		public TimeComplexitypage  timecomplexity_link() throws IOException{
		
		System.out.println(" user is on DatatstructuresS Introduction page");
		timecomplexity_link.click();
		driver.navigate();
		System.out.println(" user navigated to TimeComplexity page    " + driver.getTitle());
		System.out.println("Header     :" +timecomplexity_header.getText());
		System.out.println(driver.getCurrentUrl());
		return new TimeComplexitypage(); 
		 
	}
	
	
	public PracticeQuestionspage practiceQuestions_link () throws IOException{
		
		
		System.out.println(" user is on TimeComplexity page      ");
		practiceQuestions_link.click();
		
		driver.navigate();
		System.out.println(" user navigated to Practice Questions page ======>" +driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new PracticeQuestionspage();
			
	}
	
	public  Assessmentpage tryHere_btn() throws IOException{
		
		System.out.println(" user is on TimeComplexity page      ");
		tryHere_btn.click();
		
		driver.navigate();
		System.out.println(" user navigated to Assessment page ======>" +driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return new Assessmentpage();
	
	}
	
}
	
	
	
