package DSAlgo_testcases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.DsAlgo.Homepage;
import pom.DsAlgo.Loginpage;
import pom.DsAlgo.queuepage;
import utils.DsAlgo.TestBase_Dsalgo;
import utils.DsAlgo.Testutils;

public class TC_006_Queuepagetests extends TestBase_Dsalgo {
	public TC_006_Queuepagetests() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	queuepage qpage = new queuepage();
	Loginpage login;
	Homepage homepg;

	@BeforeTest
	public void beforeTest() throws Throwable {

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

		homepg = new Homepage();
		homepg.userlogin();
		System.out.println(driver.getCurrentUrl());
	}
	

	@Test(priority = 1, enabled = true)
	public void quepagegetstartedfunction() throws IOException {
		qpage = new queuepage();
		qpage.quepagefunction();
		
	}

	@Test(priority = 2, enabled = true)
	public void quepagefunction() throws IOException {
		qpage = new queuepage();
		qpage.implementationof_queue_in_pythonfunction();
		System.out.println(driver.getTitle());

	}

	@Test(priority = 3, enabled = true)
	public void quepagefunction2() throws IOException {
		qpage = new queuepage();
		qpage.PracticeQuestionsfunction();
		System.out.println(driver.getTitle());
	//	driver.navigate().back();
		//System.out.println(driver.getTitle());


	}

	@Test(priority = 4, enabled = true)
	public void quepagefunction3() throws IOException {
		qpage = new queuepage();	
		System.out.println(driver.getTitle());
		qpage.collections_implementationfunction()	;
		
		
		qpage.tryHerefunction();
		driver.navigate().back();
		System.out.println(driver.getTitle());

	}

	@Test(priority = 5, enabled = true)
	public void quepagefunction4() throws IOException {
		qpage = new queuepage();
		qpage.collectionsarrayfunction();

		qpage.tryHerefunction();
		driver.navigate().back();
		System.out.println(driver.getTitle());

	}

	@Test(priority = 6, enabled = true)
	public void quepagefunction5() throws IOException {

		qpage.queueoperationsfunction();

		qpage = new queuepage();
		qpage.tryHerefunction();
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