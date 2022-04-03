package DSAlgo_testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pom.DsAlgo.Homepage;
import pom.DsAlgo.Loginpage;
import pom.DsAlgo.userloggedinpage;
import utils.DsAlgo.TestBase_Dsalgo;
import utils.DsAlgo.Testutils;



public class TC_001_signintest extends TestBase_Dsalgo {

	public TC_001_signintest() throws IOException {
		super();

	}
	
	Homepage homepg;
	Loginpage login = new Loginpage();
	userloggedinpage usrpg;

	@Test(priority=1)
	public void Signinfunction() throws IOException {
		System.out.println("My new test");
		driver.get(Testutils.Base_URL + Testutils.Base_path_home);
		System.out.println(driver.getTitle());
		assertEquals("NumpyNinja", driver.getTitle());
		System.out.println("USER on HOMEPAGE ========>>>>  " + driver.getTitle());
		try {
			homepg = new Homepage();
		} 
			catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(homepg.verifypagetitle());
		login = homepg.click_on_signin_link();
		assertTrue("Login", true);
		
		System.out.println("===========User on Login Page==========" + driver.getTitle());
		login.username();
		login.password();
		login.login();
		System.out.println("\nLogin completed\n");
		String newpgtitle = driver.getTitle();
		homepg.verify_Loggedin_username();
		System.out.println("User login successful");
	}
	
	@Test(priority=2)
	public void SignoutFunction() throws IOException {
		homepg= new Homepage();
		homepg.verify_Loggedin_username();
		//homepg.verify_messagealerts();
		System.out.println("\n============== User trying to log out===============\n)");
		homepg.signoutfunction();
		homepg.messagealerfunction();
				assertTrue("Logged out successfully", true);
		System.out.println("\n============ User Logged out======================\n");
		}

	@BeforeClass
	public void beforeTest() {
		System.out.println("Before Test begins====>>> Open new chrome Browser");
		TestBase_Dsalgo.Intialization();
		System.out.println("My new test");
		driver.get(Testutils.Base_URL + Testutils.Base_path_home);
		System.out.println(driver.getTitle());
		//assertEquals(driver.getTitle(), "NumpyNinja");
		
	}
	
	@AfterClass
	public void afterTest() {
		driver.close();
		driver.quit();
		System.out.println("After Test ends====>>> Close chrome Browser");
	}

}