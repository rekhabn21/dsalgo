package DSAlgo_testcases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.DsAlgo.Homepage;
import pom.DsAlgo.RegisterPage;
import utils.DsAlgo.TestBase_Dsalgo;
import utils.DsAlgo.Testutils;
import utils.DsAlgo.XLutils;

public class TC_008DDT_Registrationtests extends TestBase_Dsalgo {

	public TC_008DDT_Registrationtests() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	RegisterPage register;// = new RegisterPage();
	Homepage homepg;

	@Test(dataProvider = "data_fromexcel")
	public void registration(String username, String password1, String password2, String status) throws IOException {
		
		System.out.println("Get details from Excel test data");
		
		register=new  RegisterPage();
		homepg = new Homepage();
		
		register.validatingRegistrationpageTitle();
		 
		register.Registrationfromexceldata(username, password1, password2, status);
		//register.Alertmesage();
		//register.Alertmesage();
	}
	
	@DataProvider(name = "data_fromexcel")
	public Object[][] xlData() throws IOException {

		String Xlfilepath = utils.DsAlgo.Testutils.excelFileLocation;//
		XLutils testdata = new XLutils(Xlfilepath);

		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] testinputarray = null;
		try {
			testinputarray = testdata.getExcelData(Testutils.excelFileLocation, Testutils.Registrationdata);
		} catch (Exception e) {
		}
		return testinputarray;
	}

		
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test begins====>>> Open new chrome Browser");
		TestBase_Dsalgo.Intialization();
		driver.get(Testutils.Base_URL + Testutils.Base_path_register);
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "Registration");
		System.out.println("Registration starts " + driver.getTitle());
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
		System.out.println("After Test ends====>>> Close chrome Browser");
	}
}

/*JSONObject  registrationdata = new JSONObject();

//	HashMap<String, Object> ProgramData = new HashMap<String, Object>();
	
//	Programdata.put( "username",Username);
	 Programdata.put( "Password1",password);
	 Programdata.put("password2",password2);
	 Programdata.put("status",message);*/