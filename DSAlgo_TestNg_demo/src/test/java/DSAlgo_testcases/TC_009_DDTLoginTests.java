package DSAlgo_testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.DsAlgo.Homepage;
import pom.DsAlgo.Loginpage;
import pom.DsAlgo.userloggedinpage;
import utils.DsAlgo.TestBase_Dsalgo;
import utils.DsAlgo.Testutils;
import utils.DsAlgo.XLutils;

public class TC_009_DDTLoginTests extends TestBase_Dsalgo{
	

	public TC_009_DDTLoginTests() throws IOException {
		super();
	}
	
	Homepage homepg;
	Loginpage login;
	userloggedinpage usrpg;
		
	@Test(dataProvider = "data_fromexcel")
	public void signin(String username, String password, String status) throws IOException {
		
	System.out.println("Get details from Excel test data");
	
	login=new Loginpage();
	login.loginfromexceldata(username, password, status);
	// login.alertmessage();
	
	}

	@DataProvider(name = "data_fromexcel")
	
	public Object[][] XlData() throws IOException {

		String Xlfilepath = utils.DsAlgo.Testutils.excelFileLocation;//
		XLutils testdata = new XLutils(Xlfilepath);

		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		
		Object[][] testinputarray = null;
		try {
			testinputarray = testdata.getExcelData(Testutils.excelFileLocation, Testutils.Logindata);
		} catch (Exception e) {
		}
		return testinputarray;
	}
	
	@BeforeTest
	public void beforeTest() throws IOException {
		System.out.println("Before Test begins====>>> Open new chrome Browser");

		TestBase_Dsalgo.Intialization();
		driver.get(Testutils.Base_URL + Testutils.Base_path_home);
		System.out.println(driver.getTitle());

		assertEquals(driver.getTitle(), "NumpyNinja");
		System.out.println("Registration starts " + driver.getTitle());
		
try {	homepg = new Homepage();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(homepg.verifypagetitle());
		login = homepg.click_on_signin_link();

	//	assertTrue("Login", true);
		System.out.println("===========User on Login Page==========" + driver.getTitle());
		
			}

	@AfterTest

	public void afterTest() {

		driver.close();
		driver.quit();
		System.out.println("After Test ends====>>> Close chrome Browser");
		}
	}
