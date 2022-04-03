package DSAlgo_testcases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.DsAlgo.Assessmentpage;
import pom.DsAlgo.Homepage;
import pom.DsAlgo.Loginpage;
import pom.DsAlgo.PracticeQuestionspage;
import pom.DsAlgo.Stackpage;

import utils.DsAlgo.TestBase_Dsalgo;
import utils.DsAlgo.Testutils;

public class TC_005_Stackpagetest extends TestBase_Dsalgo {

	public TC_005_Stackpagetest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Stackpage  stpage=new Stackpage();
	Loginpage login;
	Homepage homepg;
	Assessmentpage as_page;
	PracticeQuestionspage pqpage;
	
	@BeforeTest
	public void beforeTest() throws Throwable{
		
		System.out.println("Before Test begins====>>> Open new chrome Browser");
		try {
				TestBase_Dsalgo.Intialization();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		driver.get(Testutils.Base_URL + Testutils.Base_path_home);
		
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "NumpyNinja");
		System.out.println("\n==============USER on HOMEPAGE ========>>>>  " + driver.getTitle());		
				
		homepg= new Homepage();
		homepg.userlogin();
		System.out.println(driver.getCurrentUrl());
		}
	//}
	@Test(priority = 1, enabled =true)
	public void Stackpagefunction1 () throws IOException {
	
		stpage = new Stackpage ();
		stpage.stackpage_getstartedfunction();
			}
				
	@Test(priority = 2, enabled = true)
	public void Stackpagefunction2 () throws IOException {
		stpage = new Stackpage ();
		stpage.operationslinkfunction();
		stpage.tryHere_btn();
			}
		
	
	@Test(priority = 3, enabled = true)
	public void Stackpagefunction3 () throws IOException{
		try {
			stpage.backtohomepage();
			stpage.implementationfunction();
			
			stpage=new Stackpage();
			stpage.tryHere_btn();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	@Test(priority =4 , enabled = true)
	public void Stackpagefunction4 () throws IOException  {
	
		try {
			stpage.backtohomepage();
			stpage.Applicationsfunction();
			stpage=new Stackpage();
			
			stpage.tryHere_btn();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		}
		
		
	@Test(priority =5 , enabled = true)
	public void Stackpagefunction5 () throws IOException{
	
		try {stpage.backtohomepage();
			stpage.PracticeQuestionsfunction();
			driver.navigate().back();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
	@AfterTest
	public void afterTest() {

		driver.close();
		driver.quit();
		System.out.println("After Test ends====>>> Close chrome Browser");
	}

	
}