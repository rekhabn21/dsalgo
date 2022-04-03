package DSAlgo_testcases;

import static org.junit.Assert.*;

import java.io.IOException;
import org.testng.annotations.*;
import pom.DsAlgo.DSintroductionpage;
import pom.DsAlgo.Homepage;
import pom.DsAlgo.Loginpage;
import pom.DsAlgo.PracticeQuestionspage;

import utils.DsAlgo.TestBase_Dsalgo;
import utils.DsAlgo.Testutils;

public class TC_004_DSintroductionpgtest extends TestBase_Dsalgo {

	public TC_004_DSintroductionpgtest() throws IOException {
		super();
	}
	
	@BeforeTest
	public void beforeTest() throws Throwable {
		System.out.println("Before Test begins====>>> Open new chrome Browser");
		try {
				TestBase_Dsalgo.Intialization();
		} 
		catch (NullPointerException e) {
			System.out.println(e.getMessage());}
		
		driver.get(Testutils.Base_URL + Testutils.Base_path_home);
		
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "NumpyNinja");
		System.out.println("\n==============USER on HOMEPAGE ========>>>>  " + driver.getTitle());
				
		}
	Loginpage login;
	Homepage homepg;
	DSintroductionpage DSpage = new DSintroductionpage();
	PracticeQuestionspage pqpage;

	@Test(priority = 1, alwaysRun = true)
	public void signinuser() throws IOException {

		homepg=new Homepage();		
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

	@Test(priority = 2, enabled = true)
	public void Datastructure_intro() {
		try {
			DSpage=new DSintroductionpage();
			DSpage.Ds_introduction();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Test(priority = 3, enabled = true)
	public void Dspagetest1() {
		try {
			DSpage.timecomplexity_link() ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n================on DS introduction page=====================");
		
		}
	
	
	@Test(priority = 4, enabled = true)
	public void Dspagetest2 () {
		try {
			DSpage.practiceQuestions_link();
			System.out.println("\n================on PracticeQuestions page=====================");

		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
		System.out.println(driver.getTitle());			}
	
	@Test(priority = 5, enabled = true)
	public void Dspagetest3 () {
		
		try {
			DSpage.tryHere_btn();
			System.out.println("\n================Assessmentpage=====================");

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.navigate().back();
		System.out.println(driver.getTitle());

	}
		
	@AfterTest
	public void afterTest() {

		driver.close();
		driver.quit();
		System.out.println("After Test ends====>>> Close chrome Browser");
	}

	
	
}
