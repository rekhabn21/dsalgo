package DSAlgo_testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.*;

import pom.DsAlgo.Homepage;
import pom.DsAlgo.Loginpage;
import pom.DsAlgo.RegisterPage;
import pom.DsAlgo.portalhomepage;
import pom.DsAlgo.userloggedinpage;

import utils.DsAlgo.TestBase_Dsalgo;
import utils.DsAlgo.Testutils;

public class TC_003_HomepageTest extends TestBase_Dsalgo {

	public TC_003_HomepageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void beforeTest() {
		System.out.println("Before Test begins====>>> Open new chrome Browser");
		TestBase_Dsalgo.Intialization();
	}
	// portalhomepage portal =new portalhomepage();;

	RegisterPage register;
	Homepage homepg = new Homepage();
	Loginpage login;

	@Test(priority = 1, enabled = true)
	public void getonhomepage() throws InterruptedException {

		driver.get(Testutils.Base_URL + Testutils.Base_path_home);
		System.out.println(driver.getTitle());

		assertEquals(driver.getTitle(), "NumpyNinja");
		System.out.println("USER on HOMEPAGE ========>>>>  " + driver.getTitle());
	}

	@Test(priority = 2, enabled = true)
	public void Databasegetstarted() {

		homepg.verifypagetitle();
		try {
			homepg = new Homepage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepg.verifyDatastructurebtn();
	}

	@Test(priority = 3, enabled = true)
	public void Databasedropdown() {
		try {
			homepg = new Homepage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepg.dropdown_click();
		homepg.selectmenuitem();
	}

	@Test(priority = 4, enabled = true)
	public void Signinlinkcheck() {

		try {
			homepg = new Homepage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			login = homepg.click_on_signin_link();
		} catch (IOException e) {

			e.printStackTrace();
		}

		assertEquals(driver.getTitle(), "Login");
		System.out.println("==========User navigated to Login Page==================");
		driver.navigate().back();
	}

	@Test(priority = 5, enabled = true)
	public void Register_link_check() {

		try {
			homepg = new Homepage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			register = homepg.click_on_Register_link();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// assertEquals(driver.getTitle(), "Registration");
		System.out.println("==========User navigated to Registration Page==================");
		driver.navigate().back();
	}

	@Test(priority = 6, enabled = true)
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
		homepg.signoutfunction();
		System.out.println("n===============User logged out successfully==================");
	}

	@AfterClass
	public void afterTest() {
		driver.close();
		driver.quit();
		System.out.println("After Test ends====>>> Close chrome Browser");
	}
}
