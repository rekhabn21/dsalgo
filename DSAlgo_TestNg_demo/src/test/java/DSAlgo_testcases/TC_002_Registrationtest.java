package DSAlgo_testcases;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import pom.DsAlgo.Homepage;
import pom.DsAlgo.Loginpage;
import pom.DsAlgo.RegisterPage;
import pom.DsAlgo.portalhomepage;
import pom.DsAlgo.userloggedinpage;
import utils.DsAlgo.TestBase_Dsalgo;
import utils.DsAlgo.Testutils;


import utils.DsAlgo.TestBase_Dsalgo;

public class TC_002_Registrationtest extends TestBase_Dsalgo{

		public TC_002_Registrationtest() throws IOException {
				super();
	}
		RegisterPage register= new  RegisterPage(); ;//= new RegisterPage();
		Homepage homepg ;
@Test
public void user_opens_register_page() throws Throwable {
	register=new  RegisterPage();
		//homepg = new Homepage();
		homepg= register.registration(prop.getProperty("usrName"), prop.getProperty("pwdName"));
		System.out.println(" click on Registration button to complete");
		System.out.println(homepg.verifypagetitle());
			if (driver.getTitle()=="Registration") {
				System.out.println("Registration failed");}
			
			else if (driver.getTitle()=="NumpyNinja"){
				System.out.println("Registration successful");
				System.out.println(homepg.verify_Loggedin_username());
			}
				System.out.println(homepg.verify_Loggedin_username());
		}
		//assertEquals(driver.getTitle(), "NumpyNinja");
		
@BeforeTest
public void beforeTest() throws IOException {
	System.out.println("Before Test begins====>>> Open new chrome Browser");
	TestBase_Dsalgo.Intialization();
	driver.get(Testutils.Base_URL +Testutils.Base_path_register ) ;
	System.out.println(driver.getTitle());
	//assertEquals(driver.getTitle(), "Registration");
	System.out.println("Registration starts " + driver.getTitle());	
	}

@AfterTest
public void afterTest() throws IOException {
	register=new  RegisterPage();
	driver.close();
	driver.quit();
	System.out.println("After Test ends====>>> Close chrome Browser");
	}
}



